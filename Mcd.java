import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class Mcd extends JFrame {
    // Processus
    private JPanel PJP;// Panel processus

    // Labels processus
    private JLabel PLP;

    // TextField fonts
    Font f, f1, f2, f3, f4, f5, f6, f7;

    private JTextField IP; // Identite processus
    private JTextField RAP;// Resource affectee processus
    private JTextField CP;// Cout processus
    private JTextField EP;// Etat processus
    private JTextField DP;// Duree processus
    private JButton nextPage, lastPage;// Button to the next page

    public Mcd() {
        super("Modele de donnee");
        setLayout(new GridLayout(6, 10, 100, 100));
        // Processus

        PJP = new JPanel();// New division

        // Headers
        PLP = new JLabel("Processus");
        f5 = PLP.getFont();
        PLP.setFont(f5.deriveFont(Font.BOLD, 22));
        getContentPane().add(PLP, BorderLayout.CENTER);

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

        // Add the elements to the frame
        add(PJP);
        add(PLP);
        add(IP);
        add(RAP);
        add(CP);
        add(EP);
        add(DP);
        add(nextPage);
        add(lastPage);

        /*
         * nextPage.addActionListener(new ActionListener(){
         * 
         * @Override
         * public void actionPerformed(ActionEvent e) {
         * // Action to perform when the button is clicked
         * JOptionPane.showMessageDialog(null, "nextPage clicked!");
         * PJP.setVisible(true);
         * PJP1.setVisible(false);
         * }
         * });
         */

        /*
         * lastPage.addActionListener(new ActionListener(){
         * 
         * @Override
         * public void actionPerformed(ActionEvent e) {
         * // Action to perform when the button is clicked
         * JOptionPane.showMessageDialog(null, "lastPage clicked!");
         * PJP.setVisible(false);
         * PJP1.setVisible(true);
         * }
         * });
         */
    }

    public static void main(String[] args) {
        Mcd m = new Mcd();
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setSize(300, 300);
    }
}

// Tache
/*
 * PJT = new JPanel();//New division
 * PLT = new JLabel("Tache");//Header
 * //Inputs with place holder
 * IT = new JTextField("Enter your identite");
 * RAT = new JTextField("Enter your resource affectee");
 * CT = new JTextField("Enter your cout");
 * PT = new JButton("Enter your processus");
 * DT = new JTextField("Enter your duree");
 * add(PJT); add(PLT); add(IT);
 * add(RAT); add(CT); add(PT); add(DT);
 * 
 * //Resource
 * PJR = new JPanel();//New division
 * PLR = new JLabel("Resource");//Header
 * //Inputs with place holder
 * RS = new JTextField("Enter your identite");
 * RTPH = new JTextField("Enter your resource affectee");
 * RF = new JTextField("Enter your cout");
 * RI = new JTextField("Enter your processus");
 * RCPU = new JTextField("Enter your duree");
 * RH = new JRadioButton("test rh");
 * RM = new JRadioButton("test rm");
 * add(PJR); add(PLR); add(RS); add(RM); add(RH);
 * add(RTPH); add(RF); add(RI); add(RCPU);
 * 
 * //Project
 * saveProcessus = new JButton("savePR");
 * saveTache = new JButton("saveTache");
 * add(saveProcessus); add(saveTache);
 */

// Tache
/*
 * private JPanel PJT;//Panel tache
 * private JLabel PLT;//Label tache
 * private JTextField IT;//Identite tache
 * private JTextField RAT;//Resource affectee tache
 * private JTextField DT;//Duree tache
 * private JTextField CT;//Cout tache
 * private JButton PT;//Processus tache
 */

// Resources
/*
 * private JPanel PJR;//Panel resource
 * private JLabel PLR;//Label resource
 * JRadioButton RH;//Resource humaine
 * JRadioButton RM;//Resource Materielle
 * private JTextField RS;//Specialite resource
 * private JTextField RTPH;//TPH resource
 * private JTextField RF;//Fonction resource
 * private JTextField RI;//Identite resource
 * private JTextField RCPU;//CoutParUnite resource
 */

// Projet
/*
 * private JButton saveProcessus; //Entrer processus au projet
 * private JButton saveTache;//Entrer tache au projet
 */