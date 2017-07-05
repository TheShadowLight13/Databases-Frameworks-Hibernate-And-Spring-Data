package pr02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = Arrays.stream(buffReader.readLine().split(" "))
                .map(String::toUpperCase).collect(Collectors.toList());
        words.forEach(w -> System.out.printf("%s ", w));
    }
}
