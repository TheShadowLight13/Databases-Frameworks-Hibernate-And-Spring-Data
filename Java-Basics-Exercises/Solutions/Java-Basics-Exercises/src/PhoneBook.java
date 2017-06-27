import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PhoneBook {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> phoneNumberByName = new HashMap<>();

        while (true) {
            String input = buffReader.readLine().trim();
            if (input.equals("END")) {
                break;
            }

            String[] tokens = input.split(" ");
            String command = tokens[0];
            String name = tokens[1];

            if (command.equals("A")) {
                String phoneNumber = tokens[2];
                phoneNumberByName.put(name, phoneNumber);
            } else if (command.equals("S")) {
                if (phoneNumberByName.containsKey(name)) {
                    System.out.printf("%s -> %s%n", name, phoneNumberByName.get(name));
                }else {
                    System.out.printf("Contact %s does not exist.%n", name);
                }
            }
        }
    }
}
