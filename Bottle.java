public class Bottle {

    private Beer beer;
    private double price;
    private double volume;

    public Bottle(Beer beer, double price){
        this.beer = beer;
        this.price = price;
    }

    public String getBrandName(){
        return beer.getBrandName();
    }

    public Strength getStrength(){
        return beer.getStrength();
    }

    public Double getPrice(){
        return price;
    }
}