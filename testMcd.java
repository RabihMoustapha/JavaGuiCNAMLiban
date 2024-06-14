
import com.sun.jdi.connect.Connector;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

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
    private JButton reload, reset, add;
    private JTable table;
    private JScrollPane scrollPane;
    private JComboBox<String> rA;

    // Projet
    private JPanel p5, p6, p7, p8; // Panels
    private JLabel idL1, raL1, cL1, dL1, eL1, pidL, prL, pcL, peL, pdL; // Labels
    private JTextField id1, c1, d1, e1, pid, pc, pe, pd; // TextFields
    private JButton reload1, reset1, add1, read;
    private JTable table1;
    private JScrollPane scrollPane1;
    private JComboBox<String> rA1, prA;

    public testMcd() {
        // Mcd Processus
        demo = new JTabbedPane();
        p1 = new JPanel(new GridLayout(7, 2));
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel(new BorderLayout());

        // Processus Labels
        idL = new JLabel("Identité");
        raL = new JLabel("Resource Affectée");
        dL = new JLabel("Durée");
        cL = new JLabel("Cout");
        eL = new JLabel("État");
        filterLabel = new JLabel("Filter");

        // Processus TextFields
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
        reload = new JButton("Reload");
        reset = new JButton("Reset");
        add = new JButton("Add");
        read = new JButton("ReadData");
        filterButton = new JButton("Filter");

        // Processus JTable componets
        String[] columnNames = {"Identité", "Resource Affectée", "Cout", "Durée", "État"};
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
        p2.add(reload);
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

        // Reload
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all rows from the table
                model2.setRowCount(0);
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
                        FileWriter w = new FileWriter("data.txt");
                        w.write(id1 + ", " + rA.getSelectedItem() + ", " + c1 + ", " + e1 + ", " + d1 + "\n");
                        w.close();
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

        //Filter action listner
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter = filterText.getText();
                //sorter = new TableRowSorter<>(model);
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.regexFilter(filter);
                sorter.setRowFilter(rf);
                table.setRowSorter(sorter);
            }
        });

        //comboBox action
        rA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) rA.getSelectedItem();
                if (selected.equals("Resource Humaine")) {
                    new ResourceHumaine();
                }

                if(selected.equals("Resource Materielle")){
                    new ResourceMaterielle();
                }
            }
        });

        // mcd Projet
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

        pidL = new JLabel("Processus Identité");
        prL = new JLabel("Processus Resource Affectée");
        pdL = new JLabel("Processus Durée");
        pcL = new JLabel("Processus Cout");
        peL = new JLabel("Processus État");

        // Projet TextFields
        id1 = new JTextField();
        pid = new JTextField();
        DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
        rA1 = new JComboBox<String>(model1);
        rA1.addItem("Resource Humaine");
        rA1.addItem("Resource materielle");
        JScrollPane rAs1 = new JScrollPane(rA1);

        DefaultComboBoxModel<String> model3 = new DefaultComboBoxModel<String>();
        prA = new JComboBox<String>(model3);
        prA.addItem("Resource Humaine");
        prA.addItem("Resource materielle");
        JScrollPane prAS = new JScrollPane(prA);

        c1 = new JTextField();
        d1 = new JTextField();
        e1 = new JTextField();

        pc = new JTextField();
        pd = new JTextField();
        pe = new JTextField();

        // Buttons
        reload1 = new JButton("Reload");
        reset1 = new JButton("Reset");
        add1 = new JButton("Add");

        // JTable componets
        String[] columnNames1 = {"Identité", "Resource Affectée", "Cout", "Durée", "État"};
        DefaultTableModel model4 = new DefaultTableModel(columnNames1, 0);
        table1 = new JTable(model4);
        scrollPane1 = new JScrollPane(table1);

        // Add componets to the panels
        p5.add(idL1);
        p5.add(id1);

        p5.add(raL1);
        p5.add(rAs1);

        p5.add(cL1);
        p5.add(c1);

        p5.add(eL1);
        p5.add(e1);

        p5.add(dL1);
        p5.add(d1);

        p5.add(pidL);
        p5.add(pid);

        p5.add(prL);
        p5.add(prAS);

        p5.add(pcL);
        p5.add(pc);

        p5.add(peL);
        p5.add(pe);

        p5.add(pdL);
        p5.add(pd);

        // p6
        p6.add(add1);
        p6.add(reload1);
        p6.add(reset1);

        // p7
        p7.add(scrollPane1);

        p8.add(p5, BorderLayout.NORTH);
        p8.add(p6, BorderLayout.CENTER);
        p8.add(p7, BorderLayout.SOUTH);
        demo.add("Projet", p8);

        // reset
        reset1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                // Clear the text fields
                c1.setText("");
                d1.setText("");
                id1.setText("");
                e1.setText("");
            }
        });

        // reload
        reload1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all rows from the table
                model2.setRowCount(0);
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
    private JButton reload, reset, add, read;
    private JTable table;
    private JScrollPane scrollPane;

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
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        sp = new JTextField();
        f = new JTextField();
        tph = new JTextField();
        filterText = new JTextField();

        // Resource Humaine Buttons
        reload = new JButton("Reload");
        reset = new JButton("Reset");
        add = new JButton("Add");
        read = new JButton("ReadData");
        filterButton = new JButton("Filter");

        // Resource Humaine JTable componets
        String[] columnNames = {"Identité", "Spécialité", "Fonction", "TPH"};
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
        p2.add(reload);
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

        // Reload
        reload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all rows from the table
                model2.setRowCount(0);
            }
        });

        //Filter action listner
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter = filterText.getText();
                //sorter = new TableRowSorter<>(model);
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.regexFilter(filter);
                sorter.setRowFilter(rf);
                table.setRowSorter(sorter);
            }
    });
    setVisible(true);
    }
}

class ResourceMaterielle extends JFrame {

    private JPanel p1, p2, p3, p4;
    private JLabel idL, spL, fL, tphL, filterLabel;
    private JTextField id, sp, f, tph, filterText;
    private JButton reload, add, filterButton, reset, read;
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
        reload = new JButton("Reload");
        reset = new JButton("Reset");
        add = new JButton("Add");
        read = new JButton("ReadData");
        filterButton = new JButton("Filter");

        // Resource Humaine JTable componets
        String[] columnNames = {"Identité", "Spécialité", "Fonction", "TPH"};
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
        p2.add(reload);
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

        // Reload
        reload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all rows from the table
                model2.setRowCount(0);
            }
        });

        //Filter action listner
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter = filterText.getText();
                //sorter = new TableRowSorter<>(model);
                RowFilter<DefaultTableModel, Object> rf = null;
                rf = RowFilter.regexFilter(filter);
                sorter.setRowFilter(rf);
                table.setRowSorter(sorter);
            }
        });
        setVisible(true);
    }
}