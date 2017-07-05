package pr04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        OptionalDouble average = Arrays.stream(buffReader.readLine().split("\\s+"))
                .filter(n -> !n.isEmpty())
                .mapToDouble(Double::valueOf).average();

        if (average.isPresent()) {
            System.out.printf("%.2f", average.getAsDouble());
        }else {
            System.out.println("No match");
        }
    }
}
