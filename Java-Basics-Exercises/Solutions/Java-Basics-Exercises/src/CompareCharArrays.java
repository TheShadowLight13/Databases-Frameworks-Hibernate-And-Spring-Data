import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareCharArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String firstInput = buffReader.readLine().replace(" ", "");
        String secondInput = buffReader.readLine().replace(" ", "");

        if (firstInput.compareTo(secondInput) > 1) {
            System.out.println(secondInput);
            System.out.println(firstInput);
        }else if (firstInput.compareTo(secondInput) < 1) {
            System.out.println(firstInput);
            System.out.println(secondInput);
        }else {
            System.out.println(firstInput);
            System.out.println(secondInput);
        }
    }
}
