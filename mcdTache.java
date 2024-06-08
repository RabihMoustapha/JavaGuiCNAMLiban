import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class mcdTache extends JFrame{
    private JPanel p9, p10, p11; // Panels
    private JLabel idL, raL, cL, dL, eL, pidL, prL, peL, pdL, pcL; // Labels
    private JTextField id, c, d, e, pid, pe, pc, pd; // TextFields
    private JButton reload, reset, add;
    private JTable table;
    private JScrollPane scrollPane, pane;
    private JComboBox<String> rA, prA;
    private Object[] data;
    private JList<String> list;
    //private String[] data1;
    private DefaultListModel<String> listModel;

    public mcdTache() {
        p9 = new JPanel(new GridLayout(5, 2));
        p10 = new JPanel();
        p11 = new JPanel();

        // Labels
        idL = new JLabel("Identité");
        raL = new JLabel("Resource Affectée");
        dL = new JLabel("Durée");
        cL = new JLabel("Cout");
        eL = new JLabel("État");

        // TextFields
        id = new JTextField();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        rA = new JComboBox<String>(model);
        rA.addItem("Resource Humaine");
        rA.addItem("Resource materielle");
        JScrollPane rAs = new JScrollPane(rA);
        c = new JTextField();
        d = new JTextField();
        e = new JTextField();

        //Processus
        pidL = new JLabel("Identité Processus");
        prL = new JLabel("Resource Affectée Processus");
        pdL = new JLabel("Durée Processus");
        pcL = new JLabel("Cout Procesuss");
        peL = new JLabel("État Processus");

        pid = new JTextField();
        DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
        prA = new JComboBox<String>(model1);
        prA.addItem("Resource Humaine");
        prA.addItem("Resource materielle");
        JScrollPane prAs = new JScrollPane(prA);
        pc = new JTextField();
        pd = new JTextField();
        pe = new JTextField();

        // Buttons
        reload = new JButton("Reload");
        reset = new JButton("Reset");
        add = new JButton("Add");

        //JTable componets
        String[] columnNames = { "Identité", "Resource Affectée", "Cout", "Durée", "État" };
        DefaultTableModel model2 = new DefaultTableModel(columnNames, 0);
        table = new JTable(model2);
        scrollPane = new JScrollPane(table);

        //List
        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        list.setVisibleRowCount(5);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pane = new JScrollPane(list);

        p9.add(idL);
        p9.add(id);

        p9.add(raL);
        p9.add(rAs);

        p9.add(cL);
        p9.add(c);

        p9.add(eL);
        p9.add(e);

        p9.add(dL);
        p9.add(d);

        p9.add(pidL);
        p9.add(pid);

        p9.add(prL);
        p9.add(prAs);

        p9.add(pcL);
        p9.add(pc);

        p9.add(peL);
        p9.add(pe);

        p9.add(pdL);
        p9.add(pd);

        p10.add(add);
        p10.add(reload);
        p10.add(reset);

        p11.add(pane);
        p11.add(scrollPane);


        // reset
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                // Clear the text fields
                c.setText("");
                d.setText("");
                id.setText("");
                e.setText("");
                pc.setText("");
                pd.setText("");
                pid.setText("");
                pe.setText("");
            }
        });

        // reload
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all rows from the table
                model2.setRowCount(0);
            }
        });

        // add
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                String id1 = id.getText();
                String c1 = c.getText();
                String e1 = e.getText();
                String d1 = d.getText();
                if (id1.isEmpty() || c1.isEmpty() || e1.isEmpty() || d1.isEmpty()) {;
                    JOptionPane.showMessageDialog(null, "ID, etat, rA, duree and cout cannot be empty.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // "Identité", "Resource Affectée", "Cout","Durée", "État"
                    data = new Object[] { id1, rA.getSelectedItem(), c1, d1, e1 };
                    model2.addRow(data);

                    //List add element
                    String ad = id1 + " " + c1 +" "+ e1 + " "+ d1;
                    //data1 = new String[]{id1 + " " + c1 +" "+ e1 + " "+ d1}; 
                    listModel.addElement(ad);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Score must be an integer.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                int index = list.getSelectedIndex();

                // "Identité", "Resource Affectée", "Cout","Durée", "État"
                String value = listModel.getElementAt(index);
                model2.addRow(new Object[][]{{value}});
            }
        });

        add(p9, BorderLayout.NORTH);
        add(p10, BorderLayout.CENTER);
        add(p11, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        mcdTache t = new mcdTache();
        t.setVisible(true);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setSize(300, 300);
    }
}