public class Beer {

    private String brandName;
    private double strength;

    Beer(String brandName, double strength){
        this.brandName = brandName;
        this.strength = strength;
    }

    public double getStrength(){
        return this.strength;
    }

    public String getBrandName(){
        return this.brandName;
    }

    public String toString(){
        return "Beer{brandName:"+brandName+",strength:"+strength+"}";
    }
}