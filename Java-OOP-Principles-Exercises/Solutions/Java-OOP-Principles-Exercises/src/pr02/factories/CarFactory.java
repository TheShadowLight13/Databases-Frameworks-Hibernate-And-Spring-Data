package pr02.factories;

import pr02.interfaces.Car;
import pr02.interfaces.Factory;
import pr02.models.Ferrari;

public class CarFactory implements Factory<Car>{

    @Override
    public Car createObject(String input) {
        return new Ferrari(input);
    }
}
