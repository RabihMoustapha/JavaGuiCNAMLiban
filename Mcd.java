import javax.swing.*;
import java.awt.*;

public class Mcd extends JFrame {
    // Processus
    private JPanel PJLP;// Panel processus

    // Labels processus
    private JLabel PLP, PIP, PRAP, PCP, PEP, PDP;

    // TextField fonts
    Font f, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12;

    private JTextField IP; // Identite processus
    private JTextField RAP;// Resource affectee processus
    private JTextField CP;// Cout processus
    private JTextField EP;// Etat processus
    private JTextField DP;// Duree processus
    private JButton nextPage, lastPage;// Button to the next page

    JTabbedPane demo;

    // Tache
    private JPanel PLT;
    private JLabel PJLT, PIT, PRAT, PDT, PET, PPT, PCT;
    private JTextField PT;// Processus tache
    private JTextField IT;// Identite tache
    private JTextField RAT;// Resource affectee tache
    private JTextField CT;// Cout tache
    private JTextField ET;// Etat tache
    private JTextField DT;// Duree tache

    // Projet
    private JPanel PJLPR;// Panel processus

    // Labels projet
    private JLabel PLPR, PIPR, PRAPR, PCPR, PEPR, PDPR;

    private JTextField IPR; // Identite projet
    private JTextField RAPR;// Resource affectee projet
    private JTextField CPR;// Cout projet
    private JTextField EPR;// Etat projet
    private JTextField DPR;// Duree projet

    //Resouce humaine
    private JPanel PJLRH;

    //Labels resource humaine
    private JLabel PLRHF, PLRHS, PLRHTPH, PLRRH, PLRRM;
    private JTextField FRH, SRH, TPH;

    // Tjrbe
    private JRadioButton RH;
    private JRadioButton RM;

    public Mcd() {
        super("Modele de donnee");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        // Processus

        PJLP = new JPanel();// Another divsion

        // Headers
        PLP = new JLabel("Processus");
        PLP.setLayout(new BorderLayout());
        PIP = new JLabel("IP");
        PIP.setLayout(new BorderLayout());
        PRAP = new JLabel("RAP");
        PRAP.setLayout(new BorderLayout());
        PCP = new JLabel("CP");
        PCP.setLayout(new BorderLayout());
        PEP = new JLabel("EP");
        PEP.setLayout(new BorderLayout());
        PDP = new JLabel("DP");
        PDP.setLayout(new BorderLayout());

        // Font sets to the panels
        f5 = PLP.getFont();
        PLP.setFont(f5.deriveFont(Font.BOLD, 22));
        getContentPane().add(PLP, BorderLayout.CENTER);

        f8 = PLP.getFont();
        PIP.setFont(f8.deriveFont(Font.BOLD, 22));
        getContentPane().add(PIP, BorderLayout.CENTER);

        f9 = PRAP.getFont();
        PRAP.setFont(f9.deriveFont(Font.BOLD, 22));
        getContentPane().add(PRAP, BorderLayout.CENTER);

        f10 = PCP.getFont();
        PCP.setFont(f10.deriveFont(Font.BOLD, 22));
        getContentPane().add(PCP, BorderLayout.CENTER);

        f11 = PDP.getFont();
        PDP.setFont(f11.deriveFont(Font.BOLD, 22));
        getContentPane().add(PDP, BorderLayout.CENTER);

        f12 = PEP.getFont();
        PEP.setFont(f12.deriveFont(Font.BOLD, 22));
        getContentPane().add(PEP, BorderLayout.CENTER);

        // Inputs with place holder
        IP = new JTextField("Enter your identite");
        f = IP.getFont();
        IP.setFont(f.deriveFont(Font.BOLD, 22));

        RAP = new JTextField("Enter your resource affectee");
        f1 = RAP.getFont();
        RAP.setFont(f1.deriveFont(Font.BOLD, 22));

        CP = new JTextField("Enter your cout");
        f2 = CP.getFont();
        CP.setFont(f2.deriveFont(Font.BOLD, 22));

        EP = new JTextField("Enter your etat");
        f3 = EP.getFont();
        EP.setFont(f3.deriveFont(Font.BOLD, 22));

        DP = new JTextField("Enter your duree");
        f4 = DP.getFont();
        DP.setFont(f4.deriveFont(Font.BOLD, 22));

        nextPage = new JButton("Next");
        f6 = nextPage.getFont();
        nextPage.setFont(f6.deriveFont(Font.BOLD, 22));

        lastPage = new JButton("Last");
        f7 = lastPage.getFont();
        lastPage.setFont(f7.deriveFont(Font.BOLD, 22));

        // Add componets to JLabel
        PIP.add(IP);
        PRAP.add(RAP);
        PCP.add(CP);
        PDP.add(DP);
        PEP.add(EP);

        // ADD componets to PJLP
        PJLP.setLayout(new GridLayout(20, 20));
        PJLP.add(PIP);
        PJLP.add(PCP);
        PJLP.add(PEP);
        PJLP.add(PDP);
        PJLP.add(PRAP);
        PJLP.add(nextPage);
        // End processus

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

        // Tache

        PLT = new JPanel();// Another divsion

        // Headers
        PJLT = new JLabel();
        PLP.setLayout(new BorderLayout());
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

        // Resource humaine

        PJLRH = new JPanel();// Another divsion

        // Headers
        PLRHS = new JLabel("Specialite");
        PLRHS.setLayout(new BorderLayout());
        PLRHTPH = new JLabel("TPH");
        PLRHTPH.setLayout(new BorderLayout());
        PLRHF = new JLabel("Fonction");
        PLRHF.setLayout(new BorderLayout());
        PLRRH = new JLabel("Resource humaine");
        PLRRH.setLayout(new BorderLayout());
        PLRRM = new JLabel("Resource materielle");
        PLRRM.setLayout(new BorderLayout());


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

        nextPage = new JButton("Next");
        f6 = nextPage.getFont();
        nextPage.setFont(f6.deriveFont(Font.BOLD, 22));

        // Add componets to JLabel
        PLRHS.add(SRH);
        PLRHTPH.add(TPH);
        PLRHF.add(FRH);

        // ADD componets to PJLP
        PJLRH.setLayout(new GridLayout(20, 20));
        PJLRH.add(PLRHS);
        PJLRH.add(PLRHTPH);
        PJLRH.add(PLRHF);
        PJLRH.add(PLRRH);
        PJLRH.add(PLRRM);
        PJLRH.add(nextPage);
        // End resource humaine

        RH = new JRadioButton("Resource humaine");
        RM = new JRadioButton("Resource materielle");
        PLRRM.add(RM);
        PLRRH.add(RH);

        // Demo
        demo = new JTabbedPane();
        demo.setTabPlacement(JTabbedPane.TOP);
        demo.add("Processus", PJLP);
        demo.add("Tache", PJLT);
        demo.add("Projet", PJLPR);
        demo.add("Radio", RM);
        demo.add("Resource humaine", RH);
        demo.add("Resource humaine 1", PJLRH);
        add(demo, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Mcd m = new Mcd();
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setSize(300, 300);
    }
}