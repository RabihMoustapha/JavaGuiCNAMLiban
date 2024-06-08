import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class mcdProjet extends JFrame {
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

    public mcdProjet() {
        super("mcdProjet");
        setLayout(new BorderLayout());
        p5 = new JPanel(new GridLayout(5, 2));
        p6 = new JPanel(new GridLayout(5, 2));
        p7 = new JPanel();
        p8 = new JPanel();

        // Labels
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

        // TextFields
        id1 = new JTextField();
        pid = new JTextField();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        rA1 = new JComboBox<String>(model);
        rA1.addItem("Resource Humaine");
        rA1.addItem("Resource materielle");
        JScrollPane rAs1 = new JScrollPane(rA1);

        DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
        prA = new JComboBox<String>(model1);
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

        //JTable componets
        String[] columnNames = { "Identité", "Resource Affectée", "Cout", "Durée", "État" };
        DefaultTableModel model2 = new DefaultTableModel(columnNames, 0);
        table1 = new JTable(model2);
        scrollPane1 = new JScrollPane(table1);

        //List
        listModel1 = new DefaultListModel<String>();
        list1 = new JList<String>(listModel1);
        list1.setVisibleRowCount(5);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pane1 = new JScrollPane(list1);

        //Add componets to the panels
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

        p6.add(pidL);
        p6.add(pid);

        p6.add(prL);
        p6.add(prAS);

        p6.add(pcL);
        p6.add(pc);

        p6.add(peL);
        p6.add(pe);

        p6.add(pdL);
        p6.add(pd);

        //p6
        p7.add(add1);
        p7.add(reload1);
        p7.add(reset1);

        //p8
        p8.add(pane1);
        p8.add(scrollPane1);

        add(p5, BorderLayout.NORTH);
        add(p6, BorderLayout.CENTER);
        add(p7, BorderLayout.SOUTH);
        add(p8, BorderLayout.SOUTH);

        //reset
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
                if (id2.isEmpty() || c2.isEmpty() || e3.isEmpty() || d2.isEmpty()) {;
                    JOptionPane.showMessageDialog(null, "ID, etat, rA, duree and cout cannot be empty.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // "Identité", "Resource Affectée", "Cout","Durée", "État"
                    data1 = new Object[] { id1, rA1.getSelectedItem(), c1, d1, e1 };
                    model2.addRow(data1);

                    //List add element
                    String ad = id1 + " " + c1 +" "+ e1 + " "+ d1;
                    //data1 = new String[]{id1 + " " + c1 +" "+ e1 + " "+ d1}; 
                    listModel1.addElement(ad);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Score must be an integer.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        list1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                int index = list1.getSelectedIndex();

                // "Identité", "Resource Affectée", "Cout","Durée", "État"
                String value = listModel1.getElementAt(index);
                model2.addRow(new Object[][]{{value}});
            }
        });
    }

    public static void main(String[] args) {
        mcdProjet p = new mcdProjet();
        p.setVisible(true);
        p.setSize(300, 300);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
