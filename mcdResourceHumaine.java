import javax.swing.*;
import java.awt.*;

public class mcdResourceHumaine extends JFrame {
    // TextField fonts
    Font f, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12;

    private JButton saveResourceHumaine;// Button to the next page

     // Resouce humaine
    private JPanel PJLRH;

    // Labels resource humaine
    private JLabel PLRHF, PLRHS, PLRHTPH;
    private JTextField FRH, SRH, TPH;

    public mcdResourceHumaine(){
        super("Resource Humaine");
        setLayout(new BorderLayout());

        // Resource humaine
        PJLRH = new JPanel();// Another divsion

        // Headers
        PLRHS = new JLabel("Specialite");
        PLRHS.setLayout(new BorderLayout());
        PLRHTPH = new JLabel("TPH");
        PLRHTPH.setLayout(new BorderLayout());
        PLRHF = new JLabel("Fonction");
        PLRHF.setLayout(new BorderLayout());

        // Font sets to the panels
        f5 = PLRHS.getFont();
        PLRHS.setFont(f5.deriveFont(Font.BOLD, 22));
        getContentPane().add(PLRHS, BorderLayout.CENTER);

        f8 = PLRHTPH.getFont();
        PLRHTPH.setFont(f8.deriveFont(Font.BOLD, 22));
        getContentPane().add(PLRHTPH, BorderLayout.CENTER);

        f9 = PLRHF.getFont();
        PLRHF.setFont(f9.deriveFont(Font.BOLD, 22));
        getContentPane().add(PLRHF, BorderLayout.CENTER);

        // Inputs with place holder
        SRH = new JTextField("Enter your Specialite");
        f = SRH.getFont();
        SRH.setFont(f.deriveFont(Font.BOLD, 22));

        TPH = new JTextField("Enter your tarif par heure");
        f1 = TPH.getFont();
        TPH.setFont(f1.deriveFont(Font.BOLD, 22));

        FRH = new JTextField("Enter your fonction");
        f2 = FRH.getFont();
        FRH.setFont(f2.deriveFont(Font.BOLD, 22));

        saveResourceHumaine = new JButton("Save");
        f6 = saveResourceHumaine.getFont();
        saveResourceHumaine.setFont(f6.deriveFont(Font.BOLD, 22));

        // Add componets to JLabel
        PLRHS.add(SRH);
        PLRHTPH.add(TPH);
        PLRHF.add(FRH);

        // ADD componets to PJLRH
        PJLRH.setLayout(new GridLayout(20, 20));
        PJLRH.setVisible(false);
        PJLRH.add(PLRHS);
        PJLRH.add(PLRHTPH);
        PJLRH.add(PLRHF);
        PJLRH.add(saveResourceHumaine);
        // End resource humaine

        add(PJLRH);
    }
}
