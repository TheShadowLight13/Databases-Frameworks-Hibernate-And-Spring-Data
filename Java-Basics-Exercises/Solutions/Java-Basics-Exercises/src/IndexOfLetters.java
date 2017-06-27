import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IndexOfLetters {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String word = buffReader.readLine().toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            System.out.printf("%s -> %d%n", currChar, currChar - 'a');
        }
    }
}
