import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class testMcd extends JFrame {

    private JTabbedPane demo;

    // class mcdProcessus {
    private JPanel p1, p2, p3, p4; // Panels
    private JLabel idL, raL, cL, dL, eL; // Labels
    private JTextField id, c, d, e; // TextFields
    private JButton reload, reset, add;
    private JTable table;
    private JScrollPane scrollPane, pane;
    private JComboBox<String> rA;
    private Object[] data;
    private JList<String> list;
    // private String[] data1;
    private DefaultListModel<String> listModel;

    //Projet
    private JPanel p5, p6, p7, p8; // Panels
    private JLabel idL1, raL1, cL1, dL1, eL1, pidL, prL, pcL, peL, pdL; // Labels
    private JTextField id1, c1, d1, e1, pid, pc, pe, pd; // TextFields
    private JButton reload1, reset1, add1;
    private JTable table1;
    private JScrollPane scrollPane1, pane1;
    private JComboBox<String> rA1, prA;
    private Object[] data1;
    private JList<String> list1;
    //private String[] data1;
    private DefaultListModel<String> listModel1;

    //Tache 
    private JPanel p9, p10, p11, p12; // Panels
    private JLabel idL2, raL2, cL2, dL2, eL2, pidL2, prL2, peL2, pdL2, pcL2; // Labels
    private JTextField id2, c2, d2, e2, pid2, pe2, pc2, pd2; // TextFields
    private JButton reload2, reset2, add2;
    private JTable table2;
    private JScrollPane scrollPane2, pane2;
    private JComboBox<String> rA2, prA2;
    private Object[] data2;
    private JList<String> list2;
    //private String[] data1;
    private DefaultListModel<String> listModel2;

    public testMcd() {
        //Mcd Processus
        demo = new JTabbedPane();
        p1 = new JPanel(new GridLayout(5, 2));
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel(new BorderLayout());

        // Processus Labels
        idL = new JLabel("Identité");
        raL = new JLabel("Resource Affectée");
        dL = new JLabel("Durée");
        cL = new JLabel("Cout");
        eL = new JLabel("État");

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

        // Processus JTable componets
        String[] columnNames = { "Identité", "Resource Affectée", "Cout", "Durée", "État" };
        DefaultTableModel model2 = new DefaultTableModel(columnNames, 0);
        table = new JTable(model2);
        scrollPane = new JScrollPane(table);

        // Processus List
        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        list.setVisibleRowCount(5);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pane = new JScrollPane(list);

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

        p2.add(add);
        p2.add(reload);
        p2.add(reset);

        p3.add(pane);
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
                if (id1.isEmpty() || c1.isEmpty() || e1.isEmpty() || d1.isEmpty()) {
                    ;
                    JOptionPane.showMessageDialog(null, "ID, etat, rA, duree and cout cannot be empty.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // "Identité", "Resource Affectée", "Cout","Durée", "État"
                    data = new Object[] { id1, rA.getSelectedItem(), c1, d1, e1 };
                    model2.addRow(data);

                    // List add element
                    String ad = id1 + " " + c1 + " " + e1 + " " + d1;
                    // data1 = new String[]{id1 + " " + c1 +" "+ e1 + " "+ d1};
                    listModel.addElement(ad);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Score must be an integer.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();

                // "Identité", "Resource Affectée", "Cout","Durée", "État"
                String value = listModel.getElementAt(index);
                model2.addRow(new Object[][] {{value}});
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

        // List
        listModel1 = new DefaultListModel<String>();
        list1 = new JList<String>(listModel1);
        list1.setVisibleRowCount(5);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pane1 = new JScrollPane(list1);

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
        p7.add(pane1);
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
            @Override
            public void actionPerformed(ActionEvent e2) {
                String id2 = id1.getText();
                String c2 = c1.getText();
                String e3 = e1.getText();
                String d2 = d1.getText();
                if (id2.isEmpty() || c2.isEmpty() || e3.isEmpty() || d2.isEmpty()) {
                    ;
                    JOptionPane.showMessageDialog(null, "ID, etat, rA, duree and cout cannot be empty.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // "Identité", "Resource Affectée", "Cout","Durée", "État"
                    data1 = new Object[] { id1, rA1.getSelectedItem(), c1, d1, e1 };
                    model2.addRow(data1);

                    // List add element
                    String ad = id1 + " " + c1 + " " + e1 + " " + d1;
                    // data1 = new String[]{id1 + " " + c1 +" "+ e1 + " "+ d1};
                    listModel1.addElement(ad);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Score must be an integer.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        list1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = list1.getSelectedIndex();

                // "Identité", "Resource Affectée", "Cout","Durée", "État"
                String value = listModel1.getElementAt(index);
                model2.addRow(new Object[][]{{value}});
            }
        });

        //Mcd tache
            p9 = new JPanel(new GridLayout(5, 2));
            p10 = new JPanel();
            p11 = new JPanel();
            p12 = new JPanel(new BorderLayout());
    
            // Labels
            idL2 = new JLabel("Identité");
            raL2 = new JLabel("Resource Affectée");
            dL2 = new JLabel("Durée");
            cL2 = new JLabel("Cout");
            eL2 = new JLabel("État");
    
            // TextFields
            id2 = new JTextField();
            DefaultComboBoxModel<String> model5 = new DefaultComboBoxModel<String>();
            rA2 = new JComboBox<String>(model5);
            rA2.addItem("Resource Humaine");
            rA2.addItem("Resource materielle");
            JScrollPane rAs2 = new JScrollPane(rA2);
            c2 = new JTextField();
            d2 = new JTextField();
            e2 = new JTextField();
    
            //Processus
            pidL2 = new JLabel("Identité Processus");
            prL2 = new JLabel("Resource Affectée Processus");
            pdL2 = new JLabel("Durée Processus");
            pcL2 = new JLabel("Cout Procesuss");
            peL2 = new JLabel("État Processus");
    
            pid2 = new JTextField();
            DefaultComboBoxModel<String> model6 = new DefaultComboBoxModel<String>();
            prA2 = new JComboBox<String>(model6);
            prA2.addItem("Resource Humaine");
            prA2.addItem("Resource materielle");
            JScrollPane prAs2 = new JScrollPane(prA2);
            pc2 = new JTextField();
            pd2 = new JTextField();
            pe2 = new JTextField();
    
            // Buttons
            reload2 = new JButton("Reload");
            reset2 = new JButton("Reset");
            add2 = new JButton("Add");
    
            //JTable componets
            String[] columnNames2 = { "Identité", "Resource Affectée", "Cout", "Durée", "État" };
            DefaultTableModel model7 = new DefaultTableModel(columnNames2, 0);
            table2 = new JTable(model7);
            scrollPane2 = new JScrollPane(table2);
    
            //List
            listModel2 = new DefaultListModel<String>();
            list2 = new JList<String>(listModel);
            list2.setVisibleRowCount(5);
            list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            pane2 = new JScrollPane(list2);
    
            p9.add(idL2);
            p9.add(id2);
    
            p9.add(raL2);
            p9.add(rAs2);
    
            p9.add(cL2);
            p9.add(c2);
    
            p9.add(eL2);
            p9.add(e2);
    
            p9.add(dL2);
            p9.add(d2);
    
            p9.add(pidL2);
            p9.add(pid2);
    
            p9.add(prL2);
            p9.add(prAs2);
    
            p9.add(pcL2);
            p9.add(pc2);
    
            p9.add(peL2);
            p9.add(pe2);
    
            p9.add(pdL2);
            p9.add(pd2);
    
            p10.add(add2);
            p10.add(reload2);
            p10.add(reset2);
    
            p11.add(pane2);
            p11.add(scrollPane2);
    
    
            // reset
            reset2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e1) {
                    // Clear the text fields
                    c2.setText("");
                    d2.setText("");
                    id2.setText("");
                    e2.setText("");
                    pc2.setText("");
                    pd2.setText("");
                    pid2.setText("");
                    pe2.setText("");
                }
            });
    
            // reload
            reload2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Clear all rows from the table
                    model7.setRowCount(0);
                }
            });
    
            // add
            add2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e1) {
                    String id2 = id.getText();
                    String c2 = c.getText();
                    String e2 = e.getText();
                    String d2 = d.getText();
                    if (id2.isEmpty() || c2.isEmpty() || e2.isEmpty() || d2.isEmpty()) {;
                        JOptionPane.showMessageDialog(null, "ID, etat, rA, duree and cout cannot be empty.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
    
                    try {
                        // "Identité", "Resource Affectée", "Cout","Durée", "État"
                        data2 = new Object[] { id1, rA.getSelectedItem(), c1, d1, e1 };
                        model7.addRow(data2);
    
                        //List add element
                        String ad2 = id2 + " " + c2 +" "+ e2 + " "+ d2;
                        //data1 = new String[]{id1 + " " + c1 +" "+ e1 + " "+ d1}; 
                        listModel.addElement(ad2);
    
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Score must be an integer.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
    
            list2.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e){
                    int index = list.getSelectedIndex();
    
                    // "Identité", "Resource Affectée", "Cout","Durée", "État"
                    String value = listModel.getElementAt(index);
                    model2.addRow(new Object[][]{{value}});
                }
            });

            p12.add(p9, BorderLayout.NORTH);
            p12.add(p10, BorderLayout.CENTER);
            p12.add(p11, BorderLayout.SOUTH);
            demo.add("Tache", p12);
    }


    public static void main(String[] args) {

        testMcd mcd = new testMcd();
        mcd.setVisible(true);
        mcd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mcd.setSize(300, 300);
    }
}