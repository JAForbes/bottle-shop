import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

// Collection of Bottles
public class BottleShop {

    enum SortProperties { BRAND, PRICE, STRENGTH }

    private ArrayList<Bottle> bottles;

    // creates the bottleshop
    public BottleShop(){
        bottles = new ArrayList<Bottle>();
    }

    public List<Bottle> sortBy( BiFunction<Bottle, Bottle, Integer> f){

        return bottles.stream()
            .sorted(f::apply)
            .collect(
                Collectors.toList()
            )
        ;

    }

    public List<Bottle> sortBy(SortProperties property){

        return sortBy(
            property == SortProperties.BRAND
                ? (b1,b2) -> b1.getBrandName().compareTo(b2.getBrandName())
            : property == SortProperties.PRICE
                ? (b1,b2) -> b1.getPrice().compareTo(b2.getPrice())
            : property == SortProperties.STRENGTH
                ? (b1,b2) -> b1.getStrength().compareTo(b2.getStrength())
            :
                (b1,b2) -> -1
        );

    }

    public BottleShop add(Bottle bottle){
        bottles.add(bottle);
        return this;
    }

    // runs the program
    public static void main(String[] args){
        // Write a client program which uses the BottleShop collection
        // this can be done via inclusion the main() method in the BottleShop.java
        BottleShop shop = new BottleShop()
            .add( new Bottle( new Lager(), 3.50) )
            .add( new Bottle( new Duff(), 7.50) )
            .add( new Bottle( new Carlton(), 4.50) )
        ;

        // etc, etc, etc, let you practical fantasy flow...
        assert shop
            .sortBy( SortProperties.BRAND )
            .get(0)
            .getBrandName() == "Carlton"
        ;

        assert shop
            .sortBy( SortProperties.STRENGTH )
            .get(0)
            .getStrength() == 4;
        ;

        assert shop
            .sortBy( SortProperties.PRICE )
            .get(0)
            .getPrice() == 3.50
        ;

        System.out.println("Everything is working fine");
    }
}