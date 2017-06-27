import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberConverter {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        int decimalNum = Integer.valueOf(buffReader.readLine());
        String hexaNum = Integer.toHexString(decimalNum).toUpperCase();
        String binaryNum = Integer.toBinaryString(decimalNum);
        System.out.println(hexaNum);
        System.out.println(binaryNum);
    }
}
