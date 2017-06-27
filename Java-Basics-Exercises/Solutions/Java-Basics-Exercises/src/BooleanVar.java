import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BooleanVar {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        boolean boolVar = Boolean.valueOf(buffReader.readLine());
        System.out.println(boolVar ? "Yes" : "No");
    }
}
