import javax.swing.*;
import java.awt.*;

public class mcdResourceMaterielle extends JFrame {
    // TextField fonts
    Font f5, f6;

    private JButton saveResourceMaterielle;// Button to the next page

    // Resouce materielle
    private JPanel PJLRM;

    // Labels resource materielle
    private JLabel PLRCPU;
    private JTextField CPU;

    public mcdResourceMaterielle() {
        super("Resource Materielle");
        setLayout(new BorderLayout());

        // Resource materielle

        PJLRM = new JPanel();// Another divsion

        // Headers
        CPU = new JTextField("Enter CPU");
        PLRCPU = new JLabel("Cout par unite");
        saveResourceMaterielle = new JButton("Save");

        // Font sets to the panels
        f5 = PLRCPU.getFont();
        PLRCPU.setFont(f5.deriveFont(Font.BOLD, 22));
        getContentPane().add(PLRCPU, BorderLayout.CENTER);

        f6 = saveResourceMaterielle.getFont();
        saveResourceMaterielle.setFont(f6.deriveFont(Font.BOLD, 22));
        getContentPane().add(saveResourceMaterielle, BorderLayout.CENTER);

        // Add componets to JLabel
        PLRCPU.add(CPU);

        // ADD componets to PJLRM
        PJLRM.setLayout(new GridLayout(20, 20));
        PJLRM.setVisible(true);
        PJLRM.add(PLRCPU);
        PJLRM.add(saveResourceMaterielle);
        // End resource materielle

        add(PJLRM);
    }
}
