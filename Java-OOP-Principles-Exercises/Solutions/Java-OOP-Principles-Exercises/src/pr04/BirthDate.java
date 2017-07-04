package pr04;

import pr04.interfaces.IBirthDate;

public class BirthDate implements IBirthDate {

    private String day;

    private String month;

    private String year;

    public BirthDate(String birthDate) {
        initializeBirthDate(birthDate);
    }

    private void setDay(String day) {
        this.day = day;
    }

    private void setMonth(String month) {
        this.month = month;
    }

    private void setYear(String year) {
        this.year = year;
    }

    private void initializeBirthDate(String birthDateStr) {
        String[] birthDateInfo = birthDateStr.split("/");
        String day = birthDateInfo[0];
        String month = birthDateInfo[1];
        String year = birthDateInfo[2];

        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }

    @Override
    public String getDay() {
        return this.day;
    }

    @Override
    public String getMonth() {
        return this.month;
    }

    @Override
    public String getYear() {
        return this.year;
    }
}
