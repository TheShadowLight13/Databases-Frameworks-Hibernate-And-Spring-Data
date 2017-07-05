package pr09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isFilePrinted = false;
        String input;

        try {
            do {
                System.out.print("Enter path of the file which want to be printed: ");
                input = buffReader.readLine();
                try {
                    printFile(input);
                    isFilePrinted = true;
                    System.out.println("File has been printed successfully");
                }catch (IOException e) {
                    System.out.print("File do not exist. Do you want to enter other path of file?(y or no) ");
                    input = buffReader.readLine();
                }
            } while (!isFilePrinted && input.equals("y"));
        }finally {
            buffReader.close();
        }
    }

    private static void printFile(String filePath) throws IOException {
        try (BufferedReader buffReader = new BufferedReader(new FileReader(filePath))) {
            while (true) {
                String line = buffReader.readLine();
                if (line == null) {
                    break;
                }

                System.out.println(line);
            }
        }
    }
}
