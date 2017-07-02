package pr02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class AdvertisementMessage {

    public static void main(String[] args) throws IOException {

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String[] phrases = new String[]{
                "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."
        };

        String[] events = new String[]{
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"
        };

        String[] author = new String[]{
                "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"
        };

        String[] cities = new String[]{
                "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"
        };

        int messagesToBeGenerated = Integer.valueOf(buffReader.readLine());
        Random rnd = new Random();

        for (int i = 0; i < messagesToBeGenerated; i++) {
            String rndPhrase = phrases[rnd.nextInt(phrases.length)];
            String rndEvent = events[rnd.nextInt(events.length)];
            String rndAuthor = author[rnd.nextInt(author.length)];
            String rndCity = cities[rnd.nextInt(cities.length)];

            System.out.printf("%s %s %s - %s%n",
                    rndPhrase, rndEvent, rndAuthor, rndCity);
        }
    }
}
