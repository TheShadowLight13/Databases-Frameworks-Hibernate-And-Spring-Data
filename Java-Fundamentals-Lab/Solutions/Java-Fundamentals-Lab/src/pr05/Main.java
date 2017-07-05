package pr05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        OptionalDouble smallestEvenNumber = Arrays.stream(buffReader.readLine().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::valueOf)
                .filter(n -> n % 2 == 0)
                .min();

        if (smallestEvenNumber.isPresent()) {
            System.out.printf("%.2f", smallestEvenNumber.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
