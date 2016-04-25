public class Beer {

    private String brandName;
    private double strength;

    Beer(String brandName, double strength){
        this.brandName = brandName;
        this.strength = strength;
    }

    double getStrength(){
        return this.strength;
    }

    String getBrandName(){
        return this.brandName;
    }
}