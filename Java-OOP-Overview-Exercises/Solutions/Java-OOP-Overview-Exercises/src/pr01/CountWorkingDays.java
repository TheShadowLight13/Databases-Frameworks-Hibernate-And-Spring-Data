package pr01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CountWorkingDays {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = dateFormat.parse(buffReader.readLine());
        Date endDate = dateFormat.parse(buffReader.readLine());
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        int workingDays = 0;

        for (Calendar currCal = startCal; currCal.compareTo(endCal) <= 0; currCal.add(Calendar.DATE, 1)) {
            if (isDateWeekend(currCal) || isDateHoliday(currCal)) {
                continue;
            }

            workingDays++;
        }

        System.out.println(workingDays);
    }

    private static boolean isDateHoliday(Calendar currCal) {
        String dayMonth = String.format("%s-%s",
                currCal.get(Calendar.DAY_OF_MONTH), currCal.get(Calendar.MONTH) + 1);

        switch (dayMonth) {
            case "1-1":
            case "3-3":
            case "1-5":
            case "6-5":
            case "24-5":
            case "6-9":
            case "22-9":
            case "1-10":
            case "24-12":
            case "25-12":
            case "26-12":
                return true;
            default: return false;
        }
    }

    private static boolean isDateWeekend(Calendar cal) {
        if ((cal.get(Calendar.DAY_OF_WEEK)) == Calendar.SATURDAY ||
                cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        }

        return false;
    }
}
