package pr02.factories;

import pr02.interfaces.Factory;
import pr02.interfaces.IPerson;
import pr02.models.Person;

public class PersonFactory implements Factory<IPerson> {

    @Override
    public IPerson createObject(String[] objectData) {
        String firstName = objectData[0];
        String lastName = objectData[1];
        String fullName = firstName + " " + lastName;
        int group = Integer.valueOf(objectData[2]);
        return new Person(fullName, group);
    }
}
