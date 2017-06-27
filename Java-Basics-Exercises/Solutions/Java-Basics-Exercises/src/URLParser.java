import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLParser {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String url = buffReader.readLine().trim();
        String urlRegex = "(.*?://)?(.*)";
        Pattern urlPattern = Pattern.compile(urlRegex);
        Matcher urlMatcher = urlPattern.matcher(url);

        if (urlMatcher.find()) {
            String protocol = urlMatcher.group(1) == null ? "" :
                    urlMatcher.group(1).replace("://", "");
            String server = urlMatcher.group(2).contains("/") ?
                    urlMatcher.group(2).replaceAll("/.*", "") : urlMatcher.group(2);
            String resource = urlMatcher.group(2).contains("/") ?
                    urlMatcher.group(2).substring(urlMatcher.group(2).indexOf("/") + 1) : "";
            System.out.printf("[protocol] = \"%s\"%n", protocol);
            System.out.printf("[server] = \"%s\"%n", server);
            System.out.printf("[resource] = \"%s\"%n", resource);
        }
    }
}
