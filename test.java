import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable with User Input Example");

        // Create a table model
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Name", "Value"}, 0);

        // Create a JTable with the model
        JTable table = new JTable(model);

        // Set a custom cell editor for the "Value" column
        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JTextField()));

        // Add some data to the table
        model.addRow(new Object[]{"Parameter 1", ""});
        model.addRow(new Object[]{"Parameter 2", ""});
        model.addRow(new Object[]{"Parameter 3", ""});

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
