import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class PhoneBookUpgrade {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, String> phoneNumberByName = new TreeMap<>();

        while (true) {
            String input = buffReader.readLine().trim();
            if (input.equals("END")) {
                break;
            }

            String[] tokens = input.split(" ");
            String command = tokens[0];
            String name;
            String phoneNumber;

            if (command.equals("A")) {
                name = tokens[1];
                phoneNumber = tokens[2];
                phoneNumberByName.put(name, phoneNumber);
            } else if (command.equals("S")) {
                name = tokens[1];

                if (phoneNumberByName.containsKey(name)) {
                    phoneNumber = phoneNumberByName.get(name);
                    System.out.printf("%s -> %s%n", name, phoneNumber);
                } else {
                    System.out.printf("Contact %s does not exist.%n", name);
                }
            }else if (command.equals("ListAll")){
                printAllContacts(phoneNumberByName);
            }
        }
    }

    private static void printAllContacts(TreeMap<String, String> phoneNumberByName) {
        for (String name : phoneNumberByName.keySet()) {
            String phoneNumber = phoneNumberByName.get(name);
            System.out.printf("%s -> %s%n", name, phoneNumber);
        }
    }
}
