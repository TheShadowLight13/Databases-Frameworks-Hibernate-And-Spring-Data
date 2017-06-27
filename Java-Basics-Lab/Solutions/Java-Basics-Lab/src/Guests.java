import comparators.GuestComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Guests {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> guestInvitations = new HashSet<>();
        readGuestsData(buffReader, guestInvitations, "PARTY");
        HashSet<String> actualGuests = new HashSet<>();
        readGuestsData(buffReader, actualGuests, "END");

        TreeSet<String> absentGuests = getAbsentGuests(guestInvitations, actualGuests);
        printAbsentGuestsInfo(absentGuests);
    }

    private static void printAbsentGuestsInfo(TreeSet<String> absentGuests) {
        StringBuilder result = new StringBuilder();
        result.append(String.format(" Count of Absent Guests: %d%n", absentGuests.size()));
        result.append("Absent Guests: ");
        absentGuests.forEach(ag -> result.append(String.format("%s, ", ag)));
        result.setLength(result.length() - 2);
        System.out.println(result);
    }

    private static TreeSet<String> getAbsentGuests(HashSet<String> guestInvitations,
                                                   HashSet<String> actualGuests) {
        TreeSet<String> absentGuests = new TreeSet<>(new GuestComparator());

        for (String guest : guestInvitations) {
            if (!actualGuests.contains(guest)) {
                absentGuests.add(guest);
            }
        }

        return absentGuests;
    }

    private static void readGuestsData(BufferedReader buffReader, HashSet<String> targetSet,
                                       String terminateCommand) throws IOException {
        while (true) {
            String input = buffReader.readLine();
            if (input.equals(terminateCommand)) {
                break;
            }

            targetSet.add(input);
        }
    }
}
