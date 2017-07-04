package pr05.models;

public final class Student extends Human {

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        if (!(facultyNumber.length() >= 5 && facultyNumber.length() <= 10)) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("First Name: %s%n", this.getFirstName()));
        info.append(String.format("Last Name: %s%n", this.getLastName()));
        info.append(String.format("Faculty number: %s%n", this.getFacultyNumber()));
        return info.toString();
    }
}
