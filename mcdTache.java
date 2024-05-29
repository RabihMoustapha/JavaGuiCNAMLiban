import javax.swing.*;
import java.awt.*;

public class mcdTache extends JFrame {
    // TextField fonts
    Font f, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12;

    private JButton nextPage, lastPage;// Button to the next page

    // Tache
    private JPanel PLT;
    private JLabel PJLT, PIT, PRAT, PDT, PET, PPT, PCT;
    private JTextField PT;// Processus tache
    private JTextField IT;// Identite tache
    private JTextField RAT;// Resource affectee tache
    private JTextField CT;// Cout tache
    private JTextField ET;// Etat tache
    private JTextField DT;// Duree tache

    public mcdTache(){
        super("Tache");
        setLayout(new BorderLayout());

        // Tache

        PLT = new JPanel();// Another divsion

        // Headers
        PJLT = new JLabel();
        //PLP.setLayout(new BorderLayout());
        PIT = new JLabel("IT");
        PIT.setLayout(new BorderLayout());
        PRAT = new JLabel("RAT");
        PRAT.setLayout(new BorderLayout());
        PCT = new JLabel("CT");
        PCT.setLayout(new BorderLayout());
        PET = new JLabel("ET");
        PET.setLayout(new BorderLayout());
        PDT = new JLabel("DT");
        PDT.setLayout(new BorderLayout());
        PPT = new JLabel("PT");
        PPT.setLayout(new BorderLayout());

        // Font sets to the panels
        f5 = PLT.getFont();
        PLT.setFont(f5.deriveFont(Font.BOLD, 22));
        getContentPane().add(PLT, BorderLayout.CENTER);

        f8 = PLT.getFont();
        PIT.setFont(f8.deriveFont(Font.BOLD, 22));
        getContentPane().add(PIT, BorderLayout.CENTER);

        f9 = PRAT.getFont();
        PRAT.setFont(f9.deriveFont(Font.BOLD, 22));
        getContentPane().add(PRAT, BorderLayout.CENTER);

        f10 = PCT.getFont();
        PCT.setFont(f10.deriveFont(Font.BOLD, 22));
        getContentPane().add(PCT, BorderLayout.CENTER);

        f11 = PDT.getFont();
        PDT.setFont(f11.deriveFont(Font.BOLD, 22));
        getContentPane().add(PDT, BorderLayout.CENTER);

        f12 = PET.getFont();
        PET.setFont(f12.deriveFont(Font.BOLD, 22));
        getContentPane().add(PET, BorderLayout.CENTER);

        // Inputs with place holder
        IT = new JTextField("Enter your identite");
        f = IT.getFont();
        IT.setFont(f.deriveFont(Font.BOLD, 22));

        RAT = new JTextField("Enter your resource affectee");
        f1 = RAT.getFont();
        RAT.setFont(f1.deriveFont(Font.BOLD, 22));

        CT = new JTextField("Enter your cout");
        f2 = CT.getFont();
        CT.setFont(f2.deriveFont(Font.BOLD, 22));

        ET = new JTextField("Enter your etat");
        f3 = ET.getFont();
        ET.setFont(f3.deriveFont(Font.BOLD, 22));

        DT = new JTextField("Enter your duree");
        f4 = DT.getFont();
        DT.setFont(f4.deriveFont(Font.BOLD, 22));

        PT = new JTextField("Enter your Processus");
        f4 = PT.getFont();
        PT.setFont(f4.deriveFont(Font.BOLD, 22));

        nextPage = new JButton("Next");
        f6 = nextPage.getFont();
        nextPage.setFont(f6.deriveFont(Font.BOLD, 22));

        lastPage = new JButton("Last");
        f7 = lastPage.getFont();
        lastPage.setFont(f7.deriveFont(Font.BOLD, 22));

        // Add componets to JLabel
        PIT.add(IT);
        PRAT.add(RAT);
        PCT.add(CT);
        PDT.add(DT);
        PET.add(ET);

        // ADD componets to PJLT
        PJLT.setLayout(new GridLayout(20, 20));
        PJLT.add(PIT);
        PJLT.add(PCT);
        PJLT.add(PET);
        PJLT.add(PDT);
        PJLT.add(PRAT);
        PJLT.add(PT);
        PJLT.add(nextPage);
        // End Tache

        add(PJLT);
    }
}
