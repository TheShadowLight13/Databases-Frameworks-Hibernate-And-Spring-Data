package pr02.models;

import pr02.interfaces.IPerson;

public class Person implements IPerson {

    private String name;

    private int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getGroup() {
        return this.group;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
