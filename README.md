- [ ] Create the Bottle class with the field attributes: beer, volume (double), alcoholContent(double), glassColour (use enum type), price (this can be an object of Price class, in which case define this as well; or it can be plain double), quantity (plain int will do unless you are a heavy drinker in which case use long type). The beer field should be an object of the Beer class which has fields — brandName (String), strength (double value for the amount of alcohol per unit volume), and perhaps few others (if you are a beer drinker you will think of something, surely), and also standard methods (toString() etc).

- [ ] Use the value of Beer.strength to determine the value of bottle.alcoholContent field (also using the value bottle.volume). The filed alcoholContent is an example of the so called derived attribute — it has no independently set value, rather values of other object fields determine it.

- [ ] Then write the BottleShop class which allows to store a number of bottles of various kind. Include a number of methods needed to manage this inventory, like calculating the number of bottles of a given beer brand, price of the whole stock, etc.



- [X] Also define some methods to sort and print the collection. Sorting can be various: by the beer brand name, by the alcohol strength or alcohol content of the single bottle (in some countries, the regulation limits the hours when strong alcoholic beverages can be sold), by the colour of the bottle glass (for recycling purposes), etc, etc, etc, let you practical fantasy flow...


- [X] Write a client program which uses the BottleShop collection (this can be done via inclusion the main() method in the BottleShop.java).