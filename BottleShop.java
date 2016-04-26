import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.stream.Collectors;

// Collection of Bottles
public class BottleShop {

    private ArrayList<Bottle> bottles;

    // creates the bottleshop
    public BottleShop(){
        bottles = new ArrayList<Bottle>();
    }

    public static void printBottles(List<Bottle> bottles){
        String str = bottles.stream()
            .map(bottle -> bottle.toString())
            .collect(Collectors.joining("\n"))
        ;
        System.out.println(str);
   }

    public int getBrandCount(Class<? extends Beer> brand){
        return bottles.stream()
            .filter(
                b -> b.getBrand() == brand
            )
            .mapToInt( b -> b.getQuantity() )
            .sum()
        ;
    }

    public double getStockTotalValue(){
        return bottles.stream()
            .mapToDouble( b -> b.getPrice() * b.getQuantity() )
            .sum()
        ;
    }

    public BottleShop add(Bottle bottle){
        bottles.add(bottle);
        return this;
    }


    public List<Bottle> sortBy( Function<Bottle, Comparable> f ){
        return bottles.stream()
            .sorted(
                (b1, b2) -> f.apply(b1).compareTo( f.apply(b2) )
            )
            .collect(
                Collectors.toList()
            )
        ;
    }

    // runs the program
    public static void main(String[] args){
        // Write a client program which uses the BottleShop collection
        // this can be done via inclusion the main() method in the BottleShop.java
        BottleShop shop = new BottleShop()
            .add( new Bottle( new Lager(), 3.50, 350.0, 10) )
            .add( new Bottle( new Duff(), 7.50, 500.0, 30) )
            .add( new Bottle( new Carlton(), 4.50, 450.0, 20, Bottle.GlassColour.RED) )
        ;

        // etc, etc, etc, let you practical fantasy flow...
        assert shop
            .sortBy( Bottle::getBrandName )
            .get(0)
            .getBrandName() == "Carlton"
        ;

        System.out.println("Sort by Brand");
        BottleShop.printBottles(
             shop.sortBy( Bottle::getBrandName )
        );

        assert shop
            .sortBy( Bottle::getStrength )
            .get(0)
            .getStrength() == 3.0;
        ;

        System.out.println("Sort by Strength");
        BottleShop.printBottles(
             shop.sortBy( Bottle::getStrength )
        );


        assert shop
            .sortBy( Bottle::getPrice )
            .get(0)
            .getPrice() == 3.50
        ;

        System.out.println("Sort by Price");
        BottleShop.printBottles(
             shop.sortBy( Bottle::getPrice )
        );

        assert shop
            .sortBy( Bottle::getGlassColour )
            .get(0)
            .getGlassColour() == Bottle.GlassColour.RED
        ;

        System.out.println("Sort by Color");
        BottleShop.printBottles(
             shop.sortBy( Bottle::getGlassColour )
        );

        // calculating the number of bottles of a given beer brand

        assert shop
            .getBrandCount( Duff.class ) == 30
        ;

        // price of the whole stock
        assert shop
            .getStockTotalValue() == 350.0
        ;

        // computed alcohol content
        assert new Bottle( new Lager(), 3.50, 350.0, 1)
            .getAlcoholContent() == 12.25
        ;

        //  and also standard methods (toString() etc).
        assert (new Lager()+"").equals(
            "Beer{brandName:Lager,strength:3.5}"
        );

        //  and also standard methods (toString() etc).
        assert (new Bottle(new Lager(), 3.50, 350.0, 1 )+"" ).equals(
            "Bottle:{Beer{brandName:Lager,strength:3.5},price:3.5,volume:350.0,quantity:1,alcoholContent:12.25}"
        );
    }
}