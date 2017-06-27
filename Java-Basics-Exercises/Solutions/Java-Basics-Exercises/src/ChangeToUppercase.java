import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeToUppercase {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(<upcase>(.*?)<\\/upcase>)";
        Pattern pattern = Pattern.compile(regex);

        String text = buffReader.readLine();
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String currMatch = matcher.group();
            text = text.replace(currMatch, matcher.group(2).toUpperCase());
        }

        System.out.println(text);
    }
}
