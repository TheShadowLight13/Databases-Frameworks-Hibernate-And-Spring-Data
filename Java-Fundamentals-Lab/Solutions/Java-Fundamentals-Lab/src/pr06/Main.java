package pr06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        OptionalInt sum = Arrays.stream(buffReader.readLine().split("\\s+"))
                .filter(Main::isNumeric)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::valueOf)
                .reduce((x, y) -> x + y);

        if (sum.isPresent()) {
            System.out.println(sum.getAsInt());
        } else {
            System.out.println("No match");
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
