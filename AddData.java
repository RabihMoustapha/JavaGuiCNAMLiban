import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddData extends JFrame{
    private JTextField f1, f2, f3;
    private JButton save;

    public AddData(){
        super("AddData");
        setLayout(new GridLayout(4,2));

        //TextFields
        f1 = new JTextField("Name");
        f2 = new JTextField("Job");
        f3 = new JTextField("Salary");

        //Button
        save = new JButton("SAVE");

        add(f1);
        add(f2);
        add(f3);
        add(save);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = f1.getText();
                String job = f2.getText();
                String salary = f3.getText();

                while(name != null && job != null && salary!=null){
                    try {
                        FileWriter f = new FileWriter("data.txt", true);
                        f.write("\n"+name + ", "+ job + ", "+ salary);
                        f.close();
                        JOptionPane.showMessageDialog(null, "Accepted");
                        setVisible(false);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "Unaccepted");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        AddData d = new AddData();
        d.setVisible(true);
    }
}