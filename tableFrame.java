import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class tableFrame extends JFrame{
    private JTable t;
    private Object[][] data;
    private String[] colsName;
    private DefaultTableModel model;
    private JScrollPane j;

    public tableFrame(Object[][] d, String[] col){
        d = data;
        col = colsName;
        
        model = new DefaultTableModel(data, colsName);
        t = new JTable(model);
        j = new JScrollPane(t);
        add(j);
    }
}