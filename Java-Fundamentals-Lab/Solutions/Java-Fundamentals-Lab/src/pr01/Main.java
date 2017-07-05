package pr01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(buffReader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .filter(n -> n >= 10 && n <= 20)
                .distinct()
                .limit(2)
                .toArray();

        Arrays.stream(numbers).forEach(n -> System.out.printf("%d ", n));
    }
}
