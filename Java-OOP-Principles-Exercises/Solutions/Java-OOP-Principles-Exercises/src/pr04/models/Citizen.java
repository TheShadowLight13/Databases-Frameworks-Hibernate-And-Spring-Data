package pr04.models;

import pr04.interfaces.IBirthDate;

public class Citizen implements IBirthDate {

    private String name;

    private int age;

    private String id;

    private IBirthDate birthDate;

    public Citizen(String name, int age, String id, IBirthDate birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getDay() {
        return this.birthDate.getDay();
    }

    @Override
    public String getMonth() {
        return this.birthDate.getMonth();
    }

    @Override
    public String getYear() {
        return this.birthDate.getYear();
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s",
                this.getDay(), this.getMonth(), this.getYear());
    }
}
