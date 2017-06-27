package comparators;

import java.util.Comparator;

public class GuestComparator implements Comparator<String>{

    @Override
    public int compare(String g1, String g2) {
        if (Character.isDigit(g1.charAt(0))) {
            return -1;
        }else if (Character.isDigit(g2.charAt(0))) {
            return 1;
        }

        return g1.compareTo(g2);
    }
}
