package pr03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.asList(buffReader.readLine().split(" "));
        char letter = buffReader.readLine().toUpperCase().charAt(0);

        Optional<String> firstName = names.stream()
                .filter(n -> n.toUpperCase().charAt(0) == letter)
                .sorted().findFirst();

        if (firstName.isPresent()) {
            System.out.println(firstName.get());
        } else {
            System.out.println("No match");
        }
    }
}