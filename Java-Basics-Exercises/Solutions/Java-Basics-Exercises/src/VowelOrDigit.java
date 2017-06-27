import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VowelOrDigit {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u', 'y');

        char symbol = buffReader.readLine().toLowerCase().charAt(0);

        if (Character.isDigit(symbol)) {
            System.out.println("digit");
        } else if (vowels.contains(symbol)) {
            System.out.println("vowel");
        } else {
            System.out.println("other");
        }
    }
}
