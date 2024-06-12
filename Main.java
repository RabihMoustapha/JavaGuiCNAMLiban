import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable from Text File");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        } catch (IOException e) {
            e.printStackTrace();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        // Create JScrollPane and add JTable to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Add JScrollPane to the frame
        frame.add(scrollPane);

        frame.pack();
        frame.setVisible(true);
    }
}
