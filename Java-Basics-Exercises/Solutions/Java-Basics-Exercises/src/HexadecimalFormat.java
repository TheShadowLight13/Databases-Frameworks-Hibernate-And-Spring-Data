import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HexadecimalFormat {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        String hexadecimalNum = buffReader.readLine();
        int decimalNum = Integer.parseInt(hexadecimalNum, 16);
        System.out.println(decimalNum);
    }
}
