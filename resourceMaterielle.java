public class resourceMaterielle extends resource{
    private double coutParUnite;

    public resourceMaterielle(String i, double cpu){
        super(i);
        cpu = coutParUnite;
    }

    public double getCPU(){
        return coutParUnite;
    }

    public String toString(){
        return "ResourceMaterielle : \n" + super.getIdentite() + "\n" + coutParUnite; 
    }
}
