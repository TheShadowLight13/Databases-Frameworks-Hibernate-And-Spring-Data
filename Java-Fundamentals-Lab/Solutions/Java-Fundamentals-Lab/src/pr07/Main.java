package pr07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = buffReader.readLine().split("\\s+");
        int lowerBound = Math.min(Integer.valueOf(line[0]), Integer.valueOf(line[1]));
        int upperBound = Math.max(Integer.valueOf(line[0]), Integer.valueOf(line[1]));

        int[] boundedNumbers = Arrays.stream(buffReader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .filter(n -> n >= lowerBound && n <= upperBound)
                .toArray();

        Arrays.stream(boundedNumbers).forEach(n -> System.out.printf("%d ", n));
    }
}
