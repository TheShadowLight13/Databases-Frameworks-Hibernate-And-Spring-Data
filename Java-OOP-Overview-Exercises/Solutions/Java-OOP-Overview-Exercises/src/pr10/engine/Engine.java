package pr10.engine;

import pr10.interfaces.Reader;
import pr10.interfaces.Writer;
import pr10.models.BeerCounter;

public class Engine implements Runnable {

    private static final String TERMINATION_COMMAND = "End";

    private Reader reader;

    private Writer writer;

    public Engine(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String input = this.reader.readLine();
                if (input == null || input.equals(TERMINATION_COMMAND)) {
                    break;
                }

                String[] tokens = input.split("\\s+");
                int beersToBuy = Integer.valueOf(tokens[0]);
                int beersToDrink = Integer.valueOf(tokens[1]);
                BeerCounter.buyBeer(beersToBuy);
                BeerCounter.drinkBeer(beersToDrink);

            } catch (Exception e) {
                break;
            }
        }

        // Print beersInStock count and beersDrank count
       this.writer.printOnNewLine(String.format("%d %d",
               BeerCounter.beerInStock, BeerCounter.beersDrankCount));
    }
}
