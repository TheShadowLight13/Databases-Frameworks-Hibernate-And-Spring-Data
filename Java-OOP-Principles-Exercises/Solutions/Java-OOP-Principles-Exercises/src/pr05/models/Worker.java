package pr05.models;

public final class Worker extends Human {

    private static final int WORKING_DAYS_IN_WEEK = 7;

    private double weekSalary;

    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    public double getWeekSalary() {
        return this.weekSalary;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }

        this.weekSalary = weekSalary;
    }

    public double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (!(workHoursPerDay >= 1 && workHoursPerDay <= 12)) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }

        this.workHoursPerDay = workHoursPerDay;
    }

    public double getSalaryPerHour() {
        return this.getWeekSalary() / (this.getWorkHoursPerDay() * WORKING_DAYS_IN_WEEK);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }

        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("First Name: %s%n", this.getFirstName()));
        info.append(String.format("Last Name: %s%n", this.getLastName()));
        info.append(String.format("Week Salary: %.2f%n", this.getWeekSalary()));
        info.append(String.format("Hours per day: %.2f%n", this.getWorkHoursPerDay()));
        info.append(String.format("Salary per hour: %.2f%n", this.getSalaryPerHour()));
        return info.toString();
    }
}
