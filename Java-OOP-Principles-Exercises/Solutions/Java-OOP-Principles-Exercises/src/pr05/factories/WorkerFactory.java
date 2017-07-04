package pr05.factories;

import pr05.interfaces.Factory;
import pr05.interfaces.IHuman;
import pr05.models.Worker;

public class WorkerFactory implements Factory<IHuman> {

    @Override
    public IHuman createObject(String[] objectData) {
        String firstName = objectData[0];
        String lastName = objectData[1];
        double weekSalary = Double.valueOf(objectData[2]);
        double hoursPerDay = Double.valueOf(objectData[3]);
        return new Worker(firstName, lastName, weekSalary, hoursPerDay);
    }
}
