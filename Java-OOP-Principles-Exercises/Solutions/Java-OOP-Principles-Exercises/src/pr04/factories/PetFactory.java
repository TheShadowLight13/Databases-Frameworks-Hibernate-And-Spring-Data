package pr04.factories;

import pr04.BirthDate;
import pr04.interfaces.Factory;
import pr04.interfaces.IBirthDate;
import pr04.models.Pet;

public class PetFactory implements Factory<IBirthDate> {

    @Override
    public IBirthDate createObject(String[] objectData) {
        String name = objectData[1];
        String birthDateInfo = objectData[2];
        IBirthDate birthDate = new BirthDate(birthDateInfo);
        return new Pet(name, birthDate);
    }
}
