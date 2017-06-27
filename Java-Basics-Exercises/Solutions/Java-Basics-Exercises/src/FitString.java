import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FitString {

    private static final int TARGET_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String input = buffReader.readLine();
        StringBuilder result = new StringBuilder();

        if (input.length() < TARGET_LENGTH || input.length() == TARGET_LENGTH) {
            result.append(input);
            String[] asterisksArray = new String[TARGET_LENGTH - input.length()];
            Arrays.fill(asterisksArray, "*");
            String asterisks = String.join("", asterisksArray);
            result.append(asterisks);
        } else {
            result.append(input.substring(0, TARGET_LENGTH));
        }

        System.out.println(result);
    }
}
