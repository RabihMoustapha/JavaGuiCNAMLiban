import javax.swing.*;

public class testMcd {

    public static void main(String[] args) {

        mcdProcessus p = new mcdProcessus();
        p.setVisible(true);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setSize(300, 300);

        mcdTache t = new mcdTache();
        t.setVisible(true);
        t.setSize(300,300);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mcdProjet pr = new mcdProjet();
        pr.setVisible(true);
        pr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pr.setSize(300, 300);

        mcdResourceHumaine rh = new mcdResourceHumaine();
        rh.setVisible(true);
        rh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rh.setSize(300, 300);

        mcdResourceMaterielle rm = new mcdResourceMaterielle();
        rm.setVisible(true);
        rm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rm.setSize(300, 300);
    }
}