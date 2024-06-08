import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class Filter extends JFrame {
    private JPanel p1, p2, p3;
    public Object[][] data = { { 1, "Employee", 200 }, { 2, "Employee", 400.30 } };
    private String[] colsName = { "ID", "Job", "Salary" };
    private JComboBox<String> comboBox;
    private DefaultComboBoxModel<String> model;
    private JScrollPane pane, tablePane;
    private JTable table;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> sorter;
    private JTextField filterText;

    public Filter() {
        super("Filter");
        setLayout(new BorderLayout());
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        // ComboBox filter
        model = new DefaultComboBoxModel<String>();
        comboBox = new JComboBox<String>(model);
        comboBox.addItem("Id");
        comboBox.addItem("Job");
        comboBox.addItem("Salary");
        pane = new JScrollPane(comboBox);

        // Example table
        tableModel = new DefaultTableModel(data, colsName);
        table = new JTable(tableModel);
        tablePane = new JScrollPane(table);

        // Sorter
        sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);

        // Filter text field
        filterText = new JTextField(20);
        filterText.setToolTipText("Filter");

        p1.add(pane);
        p2.add(tablePane);
        p3.add(filterText);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        filterText.addActionListener(new ActionListener() {
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
        Filter f = new Filter();
        f.setVisible(true);
        f.setSize(200, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}