import java.util.Date;

public class processus {
    private String identite;
    private String resourceAffecte;
    private double cout;
    private String etat;
    private Date duree;

    public processus(String i, double c, String e, Date d, String rA){
        i = identite;
        cout = c;
        etat = e;
        duree = d;
        rA = resourceAffecte;
    }

    public String getIdentite(){
        return identite;
    }

    public String getResource(){
        return resourceAffecte;
    }

    public double getCout(){
        return cout;
    }

    public String getEtat(){
        return etat;
    }

    public Date getDuree(){
        return duree;
    }


    public String toString(){
        return "Processus : \n" + identite + "\n" + resourceAffecte + "\n" + cout + "\n" + etat + "\n" + duree; 
    }
}
