package pr04.factories;

import pr04.BirthDate;
import pr04.interfaces.Factory;
import pr04.interfaces.IBirthDate;
import pr04.models.Citizen;

public class CitizenFactory implements Factory<IBirthDate> {

    @Override
    public IBirthDate createObject(String[] objectData) {
        String name = objectData[1];
        int age = Integer.valueOf(objectData[2]);
        String id = objectData[3];
        String birthDateInfo = objectData[4];
        IBirthDate birthDate = new BirthDate(birthDateInfo);
        return new Citizen(name, age, id, birthDate);
    }
}
