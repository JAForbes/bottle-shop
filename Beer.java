public class Beer {

    private String brandName;
    private Strength strength;

    Beer(String brandName, Strength strength){
        this.brandName = brandName;
        this.strength = strength;
    }

    public Strength getStrength(){
        return this.strength;
    }

    public String getBrandName(){
        return this.brandName;
    }
}