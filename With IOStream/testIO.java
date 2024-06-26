import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class testIO extends JFrame {
    private JPanel p, p1, p2, p3;
    private JLabel nameLbl, passLbl, idLbl, costLbl;
    private JButton add, read, reset;
    private JTextField name, id, password, cost;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane pane;

    public testIO() {
        super("testIO");
        p = new JPanel(new GridLayout(5, 2));
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel(new BorderLayout());

        nameLbl = new JLabel("name");
        passLbl = new JLabel("password");
        idLbl = new JLabel("ID");
        costLbl = new JLabel("cost");

        name = new JTextField();
        password = new JTextField();
        id = new JTextField();
        cost = new JTextField();

        add = new JButton("ADD");
        read = new JButton("Read");
        reset = new JButton("reset");

        String[] col = { "Name", "Password", "ID", "Cost" };
        model = new DefaultTableModel(col, 0);
        table = new JTable(model);
        pane = new JScrollPane(table);

        p.add(nameLbl);
        p.add(name);
        p.add(passLbl);
        p.add(password);
        p.add(idLbl);
        p.add(id);
        p.add(costLbl);
        p.add(cost);

        p1.add(read);
        p1.add(add);
        p1.add(reset);

        p2.add(pane);

        p3.add(p, BorderLayout.NORTH);
        p3.add(p1, BorderLayout.CENTER);
        p3.add(p2, BorderLayout.SOUTH);

        add(p3);

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOutputStream f = new FileOutputStream("data.dat", true);
                    DataOutputStream data = new DataOutputStream(f);

                    String nameValue = name.getText();
                    String passwordValue = password.getText();
                    double costValue = Double.parseDouble(cost.getText());
                    int IDvalue = Integer.parseInt(id.getText());

                    while (nameValue != null && passwordValue != null && costValue >= 0.0 && IDvalue >= 0) {
                        data.writeUTF(nameValue);
                        data.writeUTF(passwordValue);
                        data.writeInt(IDvalue);
                        data.writeDouble(costValue);
                        data.close();
                        JOptionPane.showMessageDialog(null, "Data Added");
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });

        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileInputStream f = null;
                DataInputStream data = null;
                try {
                    f = new FileInputStream("data.dat");
                    data = new DataInputStream(f);
                    while (data.available() > 0) {
                        model.addRow(
                                new Object[] { data.readUTF(), data.readUTF(), data.readInt(), data.readDouble() });
                        data.close();
                    }
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "Error");
                } finally {
                    try {
                        if (data != null) {
                            data.close();
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                password.setText("");
                id.setText("");
                cost.setText("");
            }
        });
    }

    public static void main(String[] args) {
        testIO t = new testIO();
        t.setVisible(true);
        t.setSize(300, 300);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}