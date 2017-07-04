package pr05.factories;

import pr05.interfaces.Factory;
import pr05.interfaces.IHuman;
import pr05.models.Student;

public class StudentFactory implements Factory<IHuman> {

    @Override
    public IHuman createObject(String[] objectData) {
        String firstName = objectData[0];
        String lastName = objectData[1];
        String facultyNumber = objectData[2];

        return new Student(firstName, lastName, facultyNumber);
    }
}
