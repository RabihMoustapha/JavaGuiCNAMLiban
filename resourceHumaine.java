public class resourceHumaine extends resource{
    private String specialite;
    private double tarifParHeure;
    private String fonction;

    public resourceHumaine(String i, String s, double tph, String f){
        super(i);
        s = specialite;
        tph = tarifParHeure;
        f = fonction;
    }

    public String getSpecialite(){
        return specialite;
    }

    public double getTPH(){
        return tarifParHeure;
    }

    public String getFonction(){
        return fonction;
    }

    public String toString(){
        return "ResourceHumaine : \n" + super.getIdentite() + "\n" + specialite + "\n" + tarifParHeure + "\n" + fonction; 
    }
}
