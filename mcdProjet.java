import javax.swing.*;
import java.awt.*;

public class mcdProjet extends JFrame {
    // TextField fonts
    Font f, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12;

    private JButton nextPage, lastPage;// Button to the next page

     // Projet
     private JPanel PJLPR;// Panel processus

     // Labels projet
     private JLabel PLPR, PIPR, PRAPR, PCPR, PEPR, PDPR;
 
     private JTextField IPR; // Identite projet
     private JTextField RAPR;// Resource affectee projet
     private JTextField CPR;// Cout projet
     private JTextField EPR;// Etat projet
     private JTextField DPR;// Duree projet

    public mcdProjet(){
        super("Projet");
        setLayout(new BorderLayout());

        // Projet

        PJLPR = new JPanel();// Another divsion

        // Headers
        PLPR = new JLabel();
        PLPR.setLayout(new BorderLayout());
        PIPR = new JLabel("IT");
        PIPR.setLayout(new BorderLayout());
        PRAPR = new JLabel("RAT");
        PRAPR.setLayout(new BorderLayout());
        PCPR = new JLabel("CT");
        PCPR.setLayout(new BorderLayout());
        PEPR = new JLabel("ET");
        PEPR.setLayout(new BorderLayout());
        PDPR = new JLabel("DT");
        PDPR.setLayout(new BorderLayout());
        PLPR = new JLabel();
        PLPR.setLayout(new BorderLayout());

        // Font sets to the panels
        f5 = PLPR.getFont();
        PLPR.setFont(f5.deriveFont(Font.BOLD, 22));
        getContentPane().add(PLPR, BorderLayout.CENTER);

        f8 = PLPR.getFont();
        PIPR.setFont(f8.deriveFont(Font.BOLD, 22));
        getContentPane().add(PIPR, BorderLayout.CENTER);

        f9 = PRAPR.getFont();
        PRAPR.setFont(f9.deriveFont(Font.BOLD, 22));
        getContentPane().add(PRAPR, BorderLayout.CENTER);

        f10 = PCPR.getFont();
        PCPR.setFont(f10.deriveFont(Font.BOLD, 22));
        getContentPane().add(PCPR, BorderLayout.CENTER);

        f11 = PDPR.getFont();
        PDPR.setFont(f11.deriveFont(Font.BOLD, 22));
        getContentPane().add(PDPR, BorderLayout.CENTER);

        f12 = PEPR.getFont();
        PEPR.setFont(f12.deriveFont(Font.BOLD, 22));
        getContentPane().add(PEPR, BorderLayout.CENTER);

        // Inputs with place holder
        IPR = new JTextField("Enter your identite");
        f = IPR.getFont();
        IPR.setFont(f.deriveFont(Font.BOLD, 22));

        RAPR = new JTextField("Enter your resource affectee");
        f1 = RAPR.getFont();
        RAPR.setFont(f1.deriveFont(Font.BOLD, 22));

        CPR = new JTextField("Enter your cout");
        f2 = CPR.getFont();
        CPR.setFont(f2.deriveFont(Font.BOLD, 22));

        EPR = new JTextField("Enter your etat");
        f3 = EPR.getFont();
        EPR.setFont(f3.deriveFont(Font.BOLD, 22));

        DPR = new JTextField("Enter your duree");
        f4 = DPR.getFont();
        DPR.setFont(f4.deriveFont(Font.BOLD, 22));

        nextPage = new JButton("Next");
        f6 = nextPage.getFont();
        nextPage.setFont(f6.deriveFont(Font.BOLD, 22));

        lastPage = new JButton("Last");
        f7 = lastPage.getFont();
        lastPage.setFont(f7.deriveFont(Font.BOLD, 22));

        // Add componets to JLabel
        PIPR.add(IPR);
        PRAPR.add(RAPR);
        PCPR.add(CPR);
        PDPR.add(DPR);
        PEPR.add(EPR);

        // ADD componets to PJLP
        PJLPR.setLayout(new GridLayout(20, 20));
        PJLPR.add(PIPR);
        PJLPR.add(PCPR);
        PJLPR.add(PEPR);
        PJLPR.add(PDPR);
        PJLPR.add(PRAPR);
        PJLPR.add(nextPage);
        // End projet

        add(PJLPR);
    }
}
