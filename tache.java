import java.util.Date;

public class tache {
    private String identite;
    private processus p;
    private double cout;
    private String etat;
    private Date duree;
    private String resourceAffectee;

    public tache(String i, processus p,double c, String e, Date d, String rA){
        i = identite;
        c = cout;
        e = etat;
        d = duree;
        rA = resourceAffectee;
        this.p = new processus(identite, cout, etat, duree, resourceAffectee);
    }

    public String getIdentite(){
        return identite;
    }

    public String getResource(){
        return resourceAffectee;
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

    public processus getProcessus(){
        return p;
    }

    public String toString(){
        return "Tache : \n" + identite + "\n" + resourceAffectee + "\n" + cout + "\n" + etat + "\n" + duree + "\n" + p.toString(); 
    }
}
