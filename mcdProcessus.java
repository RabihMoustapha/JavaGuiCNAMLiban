import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class mcdProcessus extends JFrame {
    private JPanel p1, p2, p3; // Panels
    private JLabel idL, raL, cL, dL, eL; // Labels
    private JTextField id, c, d, e; // TextFields
    private JButton reload, reset, add;
    private JTable table;
    private JScrollPane scrollPane;
    private JComboBox<String> rA;
    private Object[] data;

    public mcdProcessus() {
        super("Processus");
        setLayout(new BorderLayout());
        p1 = new JPanel(new GridLayout(5, 2));
        p2 = new JPanel();
        p3 = new JPanel();

        // Labels
        idL = new JLabel("Identité");
        raL = new JLabel("Resource Affectée");
        dL = new JLabel("Durée");
        cL = new JLabel("Cout");
        eL = new JLabel("État");

        // TextFields
        id = new JTextField();
        DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
        rA = new JComboBox<String>(model1);
        rA.addItem("Resource Humaine");
        rA.addItem("Resource materielle");
        JScrollPane rAs = new JScrollPane(rA);
        c = new JTextField();
        d = new JTextField();
        e = new JTextField();

        // Buttons
        reload = new JButton("Reload");
        reset = new JButton("Reset");
        add = new JButton("Add");

        String[] columnNames = { "Identité", "Resource Affectée", "Cout", "Durée", "État" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

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

        p3.add(scrollPane);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        // reset
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

        // reload
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all rows from the table
                model.setRowCount(0);
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
                if (id1.isEmpty() || c1.isEmpty() || e1.isEmpty() || d1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ID, etat, rA, duree and cout cannot be empty.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // "Identité", "Resource Affectée", "Cout","Durée", "État"
                    data = new Object[] { id1, rA.getSelectedItem(), c1, d1, e1 };
                    model.addRow(data);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Score must be an integer.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        mcdProcessus m = new mcdProcessus();
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.pack();
        m.setVisible(true);
    }
}