package pr03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        int value = Integer.valueOf(buffReader.readLine());
        Number number = new Number(value);
        System.out.println(number.getLastDigitName());
    }
}
