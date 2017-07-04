package pr05.models;

import pr05.interfaces.IHuman;

public abstract class Human implements IHuman {

    private String firstName;

    private String lastName;

    protected Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    protected String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        char firstLetter = firstName.charAt(0);
        if (!Character.isUpperCase(firstLetter)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }

        if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }

        this.firstName = firstName;
    }

    protected String getLastName() {
        return this.lastName;
    }

    protected void setLastName(String lastName) {
        char firstLetter = lastName.charAt(0);
        if (!Character.isUpperCase(firstLetter)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }

        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName ");
        }

        this.lastName = lastName;
    }
}
