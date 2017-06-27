import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String input = buffReader.readLine();
        String reversedInput = new StringBuilder(input).reverse().toString();
        System.out.println(reversedInput);
    }
}
