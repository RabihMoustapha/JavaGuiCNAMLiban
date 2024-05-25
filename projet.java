import java.util.Date;

public class projet {
    private String identite;
    private Date duree;
    private tache t;
    private double coutProgressif;
    private String etat;
    private String resourceAffectee;
    private processus p;

    public projet(String i, Date d, double cp, String e, String rA){
        e = etat;
        i = identite;
        d = duree;
        cp = coutProgressif;
        p = new processus(i, cp, e, d, rA);
        t = new tache(i, p, cp, e, d, rA);
    }

    public String getIdentite(){
        return identite;
    }

    public Date getDuree(){
        return duree;
    }

    public String getResource(){
        return resourceAffectee;
    }

    public String getEtat(){
        return etat;
    }

    public tache getTache(){
        return t;
    }

    public processus getProcessus(){
        return p;
    }

    public double getCP(){
        return coutProgressif;
    }

    public String toString(){
        return "Projet : \n" + identite + "\n" + resourceAffectee + "\n" + coutProgressif + "\n" + etat + "\n" + duree + "\n" + p.toString() + "\n" + t.toString(); 
    }
}