import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CensorEmail {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String email = buffReader.readLine();
        String text = buffReader.readLine();

        String emailRegex = "(.*?)(@.*)";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        String censorEmail = "";

        if (emailMatcher.find()) {
            String username = emailMatcher.group(1);
            String[] asterisks = new String[username.length()];
            Arrays.fill(asterisks, "*");
            String domain = emailMatcher.group(2);
            censorEmail = String.join("", asterisks) + domain;
        }

        String censorText = text.replace(email, censorEmail);
        System.out.println(censorText);
    }
}
