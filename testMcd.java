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
        p1 = new JPanel(new GridLayout(6, 2));
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
        rA.addItem("Resource Humaine");
        rA.addItem("Resource materielle");
        JScrollPane rAs = new JScrollPane(rA);
        c = new JTextField();
        d = new JTextField();
        e = new JTextField();

        // Processus Buttons
        reload = new JButton("Reload");
        reset = new JButton("Reset");
        add = new JButton("Add");
        read = new JButton("ReadData");

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
        filterButton = new JButton("Filter");

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
        p2.add(filterButton);
        p2.add(read);

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
            @Override
            public void actionPerformed(ActionEvent e2) {
                String id1 = id.getText();
                String c1 = c.getText();
                String e1 = e.getText();
                String d1 = d.getText();
                Vector<Vector<String>> data = new Vector<>();
                if (id1.isEmpty() || c1.isEmpty() || e1.isEmpty() || d1.isEmpty()) {
                    ;
                    JOptionPane.showMessageDialog(null, "ID, etat, rA, duree and cout cannot be empty.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
                    Vector<String> row = new Vector<>();
                    String line;
                    while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    for(String value : values){
                    model2.addRow(new Object[]{id1, rA.getSelectedItem(), c1, e1, d1});
                    } data.add(row);
                }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Score must be an integer.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Read data
        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Read data from text file
                Vector<Vector<String>> data = new Vector<>();
                String line;
                try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
                    while ((line = br.readLine()) != null) {
                        Vector<String> row = new Vector<>();
                        String[] values = line.split(",");
                        for (String value : values) {
                            row.add(value);
                        }
                        data.add(row);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                // Create TableModel and JTable
                Vector<String> columnNames = new Vector<>();

                // Assuming the first line in the file contains column names
                try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
                    if ((line = br.readLine()) != null) {
                        String[] columnValues = line.split(",");
                        for (String columnValue : columnValues) {
                            columnNames.add(columnValue);
                        }
                    }
                    model2.addRow(columnNames);
                } catch (IOException e2) {
                    e2.printStackTrace();
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
        String[] columnNames1 = { "Identité", "Resource Affectée", "Cout", "Durée", "État" };
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

        // add
        add1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                String id2 = id1.getText();
                String c2 = c1.getText();
                String e3 = e1.getText();
                String d2 = d1.getText();
                if (id2.isEmpty() || c2.isEmpty() || e3.isEmpty() || d2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ID, etat, rA, duree and cout cannot be empty.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // "Identité", "Resource Affectée", "Cout","Durée", "État"
                    model2.addRow(new Object[] { id1, rA1.getSelectedItem(), c1, d1, e1 });

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Score must be an integer.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = filterText.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });
    }

    public static void main(String[] args) {

        testMcd mcd = new testMcd();
        mcd.setVisible(true);
        mcd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mcd.setSize(300, 300);
    }
}