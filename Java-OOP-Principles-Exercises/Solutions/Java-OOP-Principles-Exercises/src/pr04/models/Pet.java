package pr04.models;

import pr04.interfaces.IBirthDate;

public class Pet implements IBirthDate {

    private String name;

    private IBirthDate birthDate;

    public Pet(String name, IBirthDate birthDate) {
        this.name = name;
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
