import com.sun.jdi.connect.Connector;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class testMcd extends JFrame {

    private JTabbedPane demo;

    // Filter
    private JLabel filterLabel;
    private TableRowSorter<DefaultTableModel> sorter;
    private JTextField filterText;
    private JButton filterButton;

    // Processus
    private JPanel p1, p2, p3, p4; // Panels
    private JLabel idL, raL, cL, dL, eL; // Labels
    private JTextField id, c, d, e; // TextFields
    private JButton reset, add, read;
    private JTable table;
    private JScrollPane scrollPane;
    private JComboBox<String> rA;

    // Projet
    // Filter
    private JLabel filterLabel2;
    private TableRowSorter<DefaultTableModel> sorter2;
    private JTextField filterText2;
    private JButton filterButton2;

    private JPanel p5, p6, p7, p8; // Panels
    private JLabel idL1, raL1, cL1, dL1, eL1; // Labels
    private JTextField id1, c1, d1, e1; // TextFields
    private JButton addTache, reset1, add1, read1;
    private JTable table1;
    private JScrollPane scrollPane1;
    private DefaultTableModel model4;

    // Tache
    // Filter
    private JLabel filterLabel1;
    private TableRowSorter<DefaultTableModel> sorter1;
    private JTextField filterText1;
    private JButton filterButton1;

    private JPanel p9, p10, p11, p12;
    private JLabel idL2, cL2, dL2, eL2;
    private JTextField id2, c2, d2, e2;
    private JButton reset2, add2, read2, addProcessus;
    private JTable table2;
    private JScrollPane scrollPane2;

    public testMcd() {
        // Processus
        demo = new JTabbedPane();
        p1 = new JPanel(new GridLayout(7, 2));
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel(new BorderLayout());

        // Labels
        idL = new JLabel("Identité");
        raL = new JLabel("Resource Affectée");
        dL = new JLabel("Durée");
        cL = new JLabel("Cout");
        eL = new JLabel("État");
        filterLabel = new JLabel("Filter");

        // TextFields
        id = new JTextField();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        rA = new JComboBox<String>(model);
        rA.addItem("");
        rA.addItem("Resource Humaine");
        rA.addItem("Resource Materielle");
        JScrollPane rAs = new JScrollPane(rA);
        c = new JTextField();
        d = new JTextField();
        e = new JTextField();

        // Processus Buttons
        reset = new JButton("Reset");
        add = new JButton("Add");
        read = new JButton("ReadData");
        filterButton = new JButton("Filter");

        // Processus JTable componets
        String[] columnNames = { "Identité", "Resource Affectée", "Cout", "Durée", "État" };
        DefaultTableModel model2 = new DefaultTableModel(columnNames, 0);
        table = new JTable(model2);
        scrollPane = new JScrollPane(table);

        // Filter componets
        sorter = new TableRowSorter<>(model2);
        table.setRowSorter(sorter);
        filterText = new JTextField();
        filterText.setToolTipText("Filter");

        p1.add(idL);
        p1.add(id);

        p1.add(raL);
        p1.add(rAs);

        p1.add(cL);
        p1.add(c);

        p1.add(eL);
        p1.add(e);

        p1.add(dL);
        p1.add(d);
        p1.add(filterLabel);
        p1.add(filterText);

        p2.add(add);
        p2.add(reset);
        p2.add(read);
        p2.add(filterButton);

        p3.add(scrollPane);
        p4.add(p1, BorderLayout.NORTH);
        p4.add(p2, BorderLayout.CENTER);
        p4.add(p3, BorderLayout.SOUTH);
        demo.add("Processus", p4);
        add(demo);
        // Reset
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                // Clear the text fields
                c.setText("");
                d.setText("");
                id.setText("");
                e.setText("");
            }
        });

        // Add
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                String id1 = id.getText();
                String c1 = c.getText();
                String e1 = e.getText();
                String d1 = d.getText();

                if (id1 != null && c1 != null && e1 != null && d1 != null) {
                    try {
                        FileWriter w = new FileWriter("data.txt", true);
                        BufferedWriter bw = new BufferedWriter(w);
                        String data = id1 + ", " + rA.getSelectedItem() + ", " + c1 + ", " + e1 + ", " + d1;
                        bw.write(data);
                        bw.newLine();
                        bw.close();
                        JOptionPane.showMessageDialog(null, "DataAdded");
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });

        // Read data
        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader reader = new FileReader("data.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] elt = line.split(",");
                        model2.addRow(elt);
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });

        // Filter action listner
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter = filterText.getText();
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.regexFilter(filter);
                sorter.setRowFilter(rf);
                table.setRowSorter(sorter);
            }
        });

        // comboBox action
        rA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) rA.getSelectedItem();
                if (selected.equals("Resource Humaine")) {
                    new ResourceHumaine();
                }

                if (selected.equals("Resource Materielle")) {
                    new ResourceMaterielle();
                }
            }
        });

        // Projet
        p5 = new JPanel(new GridLayout(5, 2));
        p6 = new JPanel();
        p7 = new JPanel();
        p8 = new JPanel(new BorderLayout());

        // Projet Labels
        idL1 = new JLabel("Identité");
        raL1 = new JLabel("Resource Affectée");
        dL1 = new JLabel("Durée");
        cL1 = new JLabel("Cout");
        eL1 = new JLabel("État");
        filterLabel2 = new JLabel("Filter");

        // Projet TextFields
        id1 = new JTextField();
        c1 = new JTextField();
        d1 = new JTextField();
        e1 = new JTextField();

        // Buttons
        reset1 = new JButton("Reset");
        add1 = new JButton("Add");
        addTache = new JButton("Add tache");
        read1 = new JButton("Read data");
        filterButton2 = new JButton("Filter");

        // JTable componets
        String[] columnNames1 = { "Identité", "Cout", "Durée", "État" };
        model4 = new DefaultTableModel(columnNames1, 0);
        table1 = new JTable(model4);
        scrollPane1 = new JScrollPane(table1);

        // Filter componets
        sorter2 = new TableRowSorter<>(model4);
        table1.setRowSorter(sorter2);
        filterText2 = new JTextField();
        filterText2.setToolTipText("Filter");

        // Add componets to the panels
        p5.add(idL1);
        p5.add(id1);

        p5.add(cL1);
        p5.add(c1);

        p5.add(eL1);
        p5.add(e1);

        p5.add(dL1);
        p5.add(d1);

        p5.add(filterLabel2);
        p5.add(filterText2);

        // p6
        p6.add(add1);
        p6.add(reset1);
        p6.add(addTache);
        p6.add(read1);
        p6.add(filterButton2);

        // p7
        p7.add(scrollPane1);

        p8.add(p5, BorderLayout.NORTH);
        p8.add(p6, BorderLayout.CENTER);
        p8.add(p7, BorderLayout.SOUTH);
        demo.add("Projet", p8);

        // reset
        reset1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                // Clear the text fields
                c1.setText("");
                d1.setText("");
                id1.setText("");
                e1.setText("");
            }
        });

        addTache.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tache();
            }
        });

        read1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader reader = new FileReader("Projet.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] elt = line.split(",");
                        model4.addRow(elt);
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });

        add1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id2 = id1.getText();
                String c2 = c1.getText();
                String e2 = e1.getText();
                String d2 = d1.getText();

                if (id2 != null && c2 != null && e2 != null && d2 != null) {
                    try {
                        FileWriter w = new FileWriter("Projet.txt", true);
                        BufferedWriter bw = new BufferedWriter(w);
                        String data = id2 + ", " + c2 + ", " + e2 + ", " + d2;
                        bw.write(data);
                        bw.newLine();
                        bw.close();
                        JOptionPane.showMessageDialog(null, "DataAdded");
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });

        filterButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter = filterText2.getText();
                sorter2 = new TableRowSorter<>(model4);
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.regexFilter(filter);
                sorter2.setRowFilter(rf);
                table1.setRowSorter(sorter2);
            }
        });

        // Tache
        p9 = new JPanel(new GridLayout(6, 2));
        p10 = new JPanel();
        p11 = new JPanel();
        p12 = new JPanel(new BorderLayout());

        // Labels
        filterLabel1 = new JLabel("Filter");
        idL2 = new JLabel("Identité");
        cL2 = new JLabel("Cout");
        dL2 = new JLabel("Durée");
        eL2 = new JLabel("Etat");

        // TextFields
        filterText1 = new JTextField();
        id2 = new JTextField();
        e2 = new JTextField();
        d2 = new JTextField();
        c2 = new JTextField();

        // Buttons
        reset2 = new JButton("Reset");
        add2 = new JButton("Add");
        filterButton1 = new JButton("Filter");
        addProcessus = new JButton("Add Processus");
        read2 = new JButton("Read data");

        // Table
        String[] columnNames2 = { "Identité", "Cout", "Durée", "État" };
        model4 = new DefaultTableModel(columnNames2, 0);
        table2 = new JTable(model4);
        scrollPane2 = new JScrollPane(table2);

        // Add componets
        p9.add(idL2);
        p9.add(id2);

        p9.add(cL2);
        p9.add(c2);

        p9.add(eL2);
        p9.add(e2);

        p9.add(dL2);
        p9.add(d2);

        p9.add(filterLabel1);
        p9.add(filterText1);
        p10.add(add2);
        p10.add(reset2);
        p10.add(filterButton1);
        p10.add(addProcessus);
        p10.add(read2);
        p11.add(scrollPane2);
        // Add panels to the main panel
        p12.add(p9, BorderLayout.NORTH);
        p12.add(p10, BorderLayout.CENTER);
        p12.add(p11, BorderLayout.SOUTH);

        demo.add("Tache", p12);

        addProcessus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Processus();
            }
        });

        read2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader reader = new FileReader("Tache.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] elt = line.split(",");
                        model4.addRow(elt);
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });

        add2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id3 = id2.getText();
                String c3 = c2.getText();
                String e3 = e2.getText();
                String d3 = d2.getText();

                if (id2 != null && c2 != null && e2 != null && d2 != null) {
                    try {
                        FileWriter w = new FileWriter("Tache.txt", true);
                        BufferedWriter bw = new BufferedWriter(w);
                        String data = id3 + ", " + c3 + ", " + e3 + ", " + d3;
                        bw.write(data);
                        bw.newLine();
                        bw.close();
                        JOptionPane.showMessageDialog(null, "DataAdded");
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });

        reset2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                id2.setText("");
                d2.setText("");
                c2.setText("");
                e2.setText("");
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(testMcd::new);
    }
}

class ResourceHumaine extends JFrame {

    // Filter
    private JLabel filterLabel;
    private TableRowSorter<DefaultTableModel> sorter;
    private JTextField filterText;
    private JButton filterButton;

    // Resource Humaine
    private JPanel p1, p2, p3, p4; // Panels
    private JLabel idL, spL, fL, tphL; // Labels
    private JTextField id, sp, f, tph; // TextFields
    private JButton reset, add, read;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultComboBoxModel<String> model;
    private DefaultTableModel model2;

    public ResourceHumaine() {
        super("Resurce huamine");

        p1 = new JPanel(new GridLayout(5, 2));
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel(new BorderLayout());

        // Resource Humaine Labels
        idL = new JLabel("Identité");
        spL = new JLabel("Spécialité");
        fL = new JLabel("Fonction");
        tphL = new JLabel("Tarif Par Heure");
        filterLabel = new JLabel("Filter");

        // Resource Humaine TextFields
        id = new JTextField();
        model = new DefaultComboBoxModel<String>();
        sp = new JTextField();
        f = new JTextField();
        tph = new JTextField();
        filterText = new JTextField();

        // Resource Humaine Buttons
        reset = new JButton("Reset");
        add = new JButton("Add");
        read = new JButton("ReadData");
        filterButton = new JButton("Filter");

        // Resource Humaine JTable componets
        String[] columnNames = { "Identité", "Spécialité", "Fonction", "TPH" };
        model2 = new DefaultTableModel(columnNames, 0);
        table = new JTable(model2);
        scrollPane = new JScrollPane(table);

        // Filter componets
        sorter = new TableRowSorter<>(model2);
        table.setRowSorter(sorter);
        filterText = new JTextField();
        filterText.setToolTipText("Filter");

        p1.add(idL);
        p1.add(id);

        p1.add(spL);
        p1.add(sp);

        p1.add(fL);
        p1.add(f);

        p1.add(tphL);
        p1.add(tph);

        p1.add(filterLabel);
        p1.add(filterText);

        p2.add(add);
        p2.add(reset);
        p2.add(read);
        p2.add(filterButton);

        p3.add(scrollPane);
        p4.add(p1, BorderLayout.NORTH);
        p4.add(p2, BorderLayout.CENTER);
        p4.add(p3, BorderLayout.SOUTH);
        add(p4);

        // Reset
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                // Clear the text fields
                id.setText("");
                f.setText("");
                sp.setText("");
                tph.setText("");
            }
        });

        // Filter action listner
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter = filterText.getText();
                sorter = new TableRowSorter<>(model);
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.regexFilter(filter);
                sorter.setRowFilter(rf);
                table.setRowSorter(sorter);
            }
        });
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id1 = id.getText();
                String sp1 = sp.getText();
                String tph1 = tph.getText();
                String f1 = f.getText();

                if (id1 != null && sp1 != null && tph1 != null && f1 != null) {
                    try {
                        FileWriter w = new FileWriter("ResourceHumaine.txt", true);
                        BufferedWriter bw = new BufferedWriter(w);
                        String data = id1 + ", " + sp1 + ", " + tph1 + ", " + f1;
                        bw.write(data);
                        bw.newLine();
                        bw.close();
                        JOptionPane.showMessageDialog(null, "DataAdded");
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });

        // Read data
        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader reader = new FileReader("ResourceHumaine.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] elt = line.split(",");
                        model2.addRow(elt);
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });

        setVisible(true);
        setSize(300, 300);
    }
}

class ResourceMaterielle extends JFrame {

    private JPanel p1, p2, p3, p4;
    private JLabel idL, spL, fL, tphL, filterLabel;
    private JTextField id, sp, f, tph, filterText;
    private JButton add, filterButton, reset, read;
    private JTable table;
    private JScrollPane scrollPane;
    private TableRowSorter<DefaultTableModel> sorter;

    public ResourceMaterielle() {
        super("Resource Materielle");
        p1 = new JPanel(new GridLayout(5, 2));
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel(new BorderLayout());

        // Resource Humaine Labels
        idL = new JLabel("Identité");
        spL = new JLabel("Spécialité");
        fL = new JLabel("Fonction");
        tphL = new JLabel("Tarif Par Heure");
        filterLabel = new JLabel("Filter");

        // Resource Humaine TextFields
        id = new JTextField();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        sp = new JTextField();
        f = new JTextField();
        tph = new JTextField();
        filterText = new JTextField();

        // Resource Humaine Buttons
        reset = new JButton("Reset");
        add = new JButton("Add");
        read = new JButton("ReadData");
        filterButton = new JButton("Filter");

        // Resource Humaine JTable componets
        String[] columnNames = { "Identité", "Spécialité", "Fonction", "TPH" };
        DefaultTableModel model2 = new DefaultTableModel(columnNames, 0);
        table = new JTable(model2);
        scrollPane = new JScrollPane(table);

        // Filter componets
        sorter = new TableRowSorter<>(model2);
        table.setRowSorter(sorter);
        filterText = new JTextField();
        filterText.setToolTipText("Filter");

        p1.add(idL);
        p1.add(id);

        p1.add(spL);
        p1.add(sp);

        p1.add(fL);
        p1.add(f);

        p1.add(tphL);
        p1.add(tph);

        p1.add(filterLabel);
        p1.add(filterText);

        p2.add(add);
        p2.add(reset);
        p2.add(read);
        p2.add(filterButton);

        p3.add(scrollPane);
        p4.add(p1, BorderLayout.NORTH);
        p4.add(p2, BorderLayout.CENTER);
        p4.add(p3, BorderLayout.SOUTH);
        add(p4);
        // Reset
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                // Clear the text fields
                id.setText("");
                f.setText("");
                sp.setText("");
                tph.setText("");
            }
        });

        // Filter action listner
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter = filterText.getText();
                // sorter = new TableRowSorter<>(model);
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.regexFilter(filter);
                sorter.setRowFilter(rf);
                table.setRowSorter(sorter);
            }
        });

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                String id1 = id.getText();
                String sp1 = sp.getText();
                String tph1 = tph.getText();
                String f1 = f.getText();

                if (id1 != null && sp1 != null && tph1 != null && f1 != null) {
                    try {
                        FileWriter w = new FileWriter("ResourceMaterielle.txt", true);
                        BufferedWriter bw = new BufferedWriter(w);
                        String data = id1 + ", " + sp1 + ", " + tph1 + ", " + f1;
                        bw.write(data);
                        bw.newLine();
                        bw.close();
                        JOptionPane.showMessageDialog(null, "DataAdded");
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });

        // Read data
        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader reader = new FileReader("ResourceMaterielle.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] elt = line.split(",");
                        model2.addRow(elt);
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });
        setVisible(true);
        setSize(300, 300);

    }
}

class Processus extends JFrame {
    // Filter

    private JLabel filterLabel;
    private TableRowSorter<DefaultTableModel> sorter;
    private JTextField filterText;
    private JButton filterButton;

    // Processus
    private JPanel p1, p2, p3, p4; // Panels
    private JLabel idL, raL, cL, dL, eL; // Labels
    private JTextField id, c, d, e; // TextFields
    private JButton reset, add, read;
    private JTable table;
    private JComboBox<String> rA;
    private JScrollPane scrollPane;

    public Processus() {
        super("Processus");
        p1 = new JPanel(new GridLayout(7, 2));
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel(new BorderLayout());

        // Labels
        idL = new JLabel("Identité");
        raL = new JLabel("Resource Affectée");
        dL = new JLabel("Durée");
        cL = new JLabel("Cout");
        eL = new JLabel("État");
        filterLabel = new JLabel("Filter");

        // TextFields
        id = new JTextField();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        rA = new JComboBox<String>(model);
        rA.addItem("");
        rA.addItem("Resource Humaine");
        rA.addItem("Resource Materielle");
        JScrollPane rAs = new JScrollPane(rA);
        c = new JTextField();
        d = new JTextField();
        e = new JTextField();

        // Processus Buttons
        reset = new JButton("Reset");
        add = new JButton("Add");
        read = new JButton("ReadData");
        filterButton = new JButton("Filter");

        // Processus JTable componets
        String[] columnNames = { "Identité", "Resource Affectée", "Cout", "Durée", "État" };
        DefaultTableModel model2 = new DefaultTableModel(columnNames, 0);
        table = new JTable(model2);
        scrollPane = new JScrollPane(table);

        // Filter componets
        sorter = new TableRowSorter<>(model2);
        table.setRowSorter(sorter);
        filterText = new JTextField();
        filterText.setToolTipText("Filter");

        p1.add(idL);
        p1.add(id);

        p1.add(raL);
        p1.add(rAs);

        p1.add(cL);
        p1.add(c);

        p1.add(eL);
        p1.add(e);

        p1.add(dL);
        p1.add(d);
        p1.add(filterLabel);
        p1.add(filterText);

        p2.add(add);
        p2.add(reset);
        p2.add(read);
        p2.add(filterButton);

        p3.add(scrollPane);
        p4.add(p1, BorderLayout.NORTH);
        p4.add(p2, BorderLayout.CENTER);
        p4.add(p3, BorderLayout.SOUTH);
        add(p4);
        // Reset
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                // Clear the text fields
                c.setText("");
                d.setText("");
                id.setText("");
                e.setText("");
            }
        });

        // Add
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                String id1 = id.getText();
                String c1 = c.getText();
                String e1 = e.getText();
                String d1 = d.getText();

                if (id1 != null && c1 != null && e1 != null && d1 != null) {
                    try {
                        FileWriter w = new FileWriter("Processus.txt", true);
                        BufferedWriter bw = new BufferedWriter(w);
                        String data = id1 + ", " + rA.getSelectedItem() + ", " + c1 + ", " + e1 + ", " + d1;
                        bw.write(data);
                        bw.newLine();
                        bw.close();
                        JOptionPane.showMessageDialog(null, "DataAdded");
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });

        // Read data
        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    FileReader reader = new FileReader("Processus.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (!line.isEmpty()) {
                            String[] elt = line.split(",");
                            model2.addRow(elt);
                        }
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        // Filter action listner
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter = filterText.getText();
                sorter = new TableRowSorter<>(model2);
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.regexFilter(filter);
                sorter.setRowFilter(rf);
                table.setRowSorter(sorter);
            }
        });

        // comboBox action
        rA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) rA.getSelectedItem();
                if (selected.equals("Resource Humaine")) {
                    new ResourceHumaine();
                }

                if (selected.equals("Resource Materielle")) {
                    new ResourceMaterielle();
                }
            }
        });
        setVisible(true);
        setSize(300, 300);
    }
}

class Projet extends JFrame {
    // Filter
    private JLabel filterLabel;
    private TableRowSorter<DefaultTableModel> sorter;
    private JTextField filterText;
    private JButton filterButton;

    // Projet
    private JPanel p1, p2, p3, p4; // Panels
    private JLabel idL, cL, dL, eL; // Labels
    private JTextField id, c, d, e; // TextFields
    private JButton reset, add, read, addTache;
    private JTable table;
    private JScrollPane scrollPane;

    public Projet() {
        super("Projet");
        p1 = new JPanel(new GridLayout(7, 2));
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel(new BorderLayout());

        // Labels
        idL = new JLabel("Identité");
        dL = new JLabel("Durée");
        cL = new JLabel("Cout");
        eL = new JLabel("État");
        filterLabel = new JLabel("Filter");

        // TextFields
        id = new JTextField();
        c = new JTextField();
        d = new JTextField();
        e = new JTextField();

        // Projet Buttons
        reset = new JButton("Reset");
        add = new JButton("Add");
        read = new JButton("ReadData");
        filterButton = new JButton("Filter");
        addTache = new JButton("Add tache");

        // Projet JTable componets
        String[] columnNames = { "Identité", "Cout", "Durée", "État" };
        DefaultTableModel model2 = new DefaultTableModel(columnNames, 0);
        table = new JTable(model2);
        scrollPane = new JScrollPane(table);

        // Filter componets
        sorter = new TableRowSorter<>(model2);
        table.setRowSorter(sorter);
        filterText = new JTextField();
        filterText.setToolTipText("Filter");

        p1.add(idL);
        p1.add(id);

        p1.add(cL);
        p1.add(c);

        p1.add(eL);
        p1.add(e);

        p1.add(dL);
        p1.add(d);
        p1.add(filterLabel);
        p1.add(filterText);

        p2.add(add);
        p2.add(addTache);
        p2.add(reset);
        p2.add(read);
        p2.add(filterButton);

        p3.add(scrollPane);
        p4.add(p1, BorderLayout.NORTH);
        p4.add(p2, BorderLayout.CENTER);
        p4.add(p3, BorderLayout.SOUTH);
        add(p4);
        // Reset
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                // Clear the text fields
                c.setText("");
                d.setText("");
                id.setText("");
                e.setText("");
            }
        });

        // Add
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                String id1 = id.getText();
                String c1 = c.getText();
                String e1 = e.getText();
                String d1 = d.getText();

                if (id1 != null && c1 != null && e1 != null && d1 != null) {
                    try {
                        FileWriter w = new FileWriter("Projet.txt", true);
                        BufferedWriter bw = new BufferedWriter(w);
                        String data = id1 + ", " + ", " + c1 + ", " + e1 + ", " + d1;
                        bw.write(data);
                        bw.newLine();
                        bw.close();
                        JOptionPane.showMessageDialog(null, "DataAdded");
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });

        // Read data
        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    FileReader reader = new FileReader("Projet.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (!line.isEmpty()) {
                            String[] elt = line.split(",");
                            model2.addRow(elt);
                        }
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });
        // Filter action listner
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter = filterText.getText();
                sorter = new TableRowSorter<>(model2);
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.regexFilter(filter);
                sorter.setRowFilter(rf);
                table.setRowSorter(sorter);
            }
        });

        // Add tache
        addTache.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tache();
            }
        });

        setVisible(true);
        setSize(300, 300);
    }
}

class Tache extends JFrame {
    // Filter
    private JLabel filterLabel;
    private TableRowSorter<DefaultTableModel> sorter;
    private JTextField filterText;
    private JButton filterButton;

    // Tache
    private JPanel p1, p2, p3, p4; // Panels
    private JLabel idL, cL, dL, eL; // Labels
    private JTextField id, c, d, e; // TextFields
    private JButton reset, add, read, addProcessus;
    private JTable table;
    private JScrollPane scrollPane;

    public Tache() {
        super("Tache");
        p1 = new JPanel(new GridLayout(5, 2));
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel(new BorderLayout());

        // Labels
        idL = new JLabel("Identité");
        dL = new JLabel("Durée");
        cL = new JLabel("Cout");
        eL = new JLabel("État");
        filterLabel = new JLabel("Filter");

        // TextFields
        id = new JTextField();
        c = new JTextField();
        d = new JTextField();
        e = new JTextField();

        // Tache Buttons
        reset = new JButton("Reset");
        add = new JButton("Add");
        read = new JButton("ReadData");
        filterButton = new JButton("Filter");
        addProcessus = new JButton("Add processus");

        // Tache JTable componets
        String[] columnNames = { "Identité", "Cout", "Durée", "État" };
        DefaultTableModel model2 = new DefaultTableModel(columnNames, 0);
        table = new JTable(model2);
        scrollPane = new JScrollPane(table);

        // Filter componets
        sorter = new TableRowSorter<>(model2);
        table.setRowSorter(sorter);
        filterText = new JTextField();
        filterText.setToolTipText("Filter");

        p1.add(idL);
        p1.add(id);

        p1.add(cL);
        p1.add(c);

        p1.add(eL);
        p1.add(e);

        p1.add(dL);
        p1.add(d);
        p1.add(filterLabel);
        p1.add(filterText);

        p2.add(add);
        p2.add(addProcessus);
        p2.add(reset);
        p2.add(read);
        p2.add(filterButton);

        p3.add(scrollPane);
        p4.add(p1, BorderLayout.NORTH);
        p4.add(p2, BorderLayout.CENTER);
        p4.add(p3, BorderLayout.SOUTH);
        add(p4);
        // Reset
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                // Clear the text fields
                c.setText("");
                d.setText("");
                id.setText("");
                e.setText("");
            }
        });

        // Add
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                String id1 = id.getText();
                String c1 = c.getText();
                String e1 = e.getText();
                String d1 = d.getText();

                if (id1 != null && c1 != null && e1 != null && d1 != null) {
                    try {
                        FileWriter w = new FileWriter("Tache.txt", true);
                        BufferedWriter bw = new BufferedWriter(w);
                        String data = id1 + ", " + ", " + c1 + ", " + e1 + ", " + d1;
                        bw.write(data);
                        bw.newLine();
                        bw.close();
                        JOptionPane.showMessageDialog(null, "DataAdded");
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });

        // Read data
        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    FileReader reader = new FileReader("Tache.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (!line.isEmpty()) {
                            String[] elt = line.split(",");
                            model2.addRow(elt);
                        }
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });
        // Filter action listner
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter = filterText.getText();
                sorter = new TableRowSorter<>(model2);
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.regexFilter(filter);
                sorter.setRowFilter(rf);
                table.setRowSorter(sorter);
            }
        });

        // Add processus
        addProcessus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Processus();
            }
        });

        setVisible(true);
        setSize(300, 300);
    }
}