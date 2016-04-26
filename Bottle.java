public class Bottle {

    private Beer beer;
    private double price;
    private double volume;
    private double alcoholContent;
    private int quantity;
    private static enum glassColor { GREEN, RED, BLUE };

    public Bottle(Beer beer, double price, double volume, int quantity){
        this.beer = beer;
        this.price = price;
        this.volume = volume;
        this.quantity = quantity;
        this.alcoholContent =
            volume * beer.getStrength() / 100
        ;
    }

    public Class<? extends Beer> getBrand(){
        return beer.getClass();
    }

    public int getQuantity(){
        return quantity;
    }

    public double getAlcoholContent(){
        return alcoholContent;
    }

    public String getBrandName(){
        return beer.getBrandName();
    }

    public Double getStrength(){
        return beer.getStrength();
    }

    public Double getPrice(){
        return price;
    }

    public String toString(){
        return
            "Bottle:{" +
            beer +
            ",price:" + price +
            ",volume:" + volume +
            ",quantity:" + quantity +
            ",alcoholContent:" + alcoholContent +
            "}"
        ;
    }
}