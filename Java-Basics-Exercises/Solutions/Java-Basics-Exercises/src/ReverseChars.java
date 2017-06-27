import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseChars {

    private static final int LETTERS_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> letters = new ArrayDeque<>();
        for (int i = 0; i < LETTERS_COUNT; i++) {
            char letter = buffReader.readLine().charAt(0);
            letters.addFirst(letter);
        }

        printChars(letters);
    }

    private static void printChars(Deque<Character> letters) {
        for (Character letter : letters) {
            System.out.print(letter);
        }
    }
}
