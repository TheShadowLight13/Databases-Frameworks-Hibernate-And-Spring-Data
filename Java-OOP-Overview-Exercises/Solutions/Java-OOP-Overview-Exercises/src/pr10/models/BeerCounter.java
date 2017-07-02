package pr10.models;

public class BeerCounter {

    public static int beerInStock = 0;

    public static int beersDrankCount = 0;

    public static void buyBeer(int bottlesCount) {
        beerInStock = beerInStock + bottlesCount;
    }

    public static void drinkBeer(int bottlesCount) {
        beersDrankCount = beersDrankCount + bottlesCount;
        beerInStock = beerInStock - bottlesCount;
    }
}
