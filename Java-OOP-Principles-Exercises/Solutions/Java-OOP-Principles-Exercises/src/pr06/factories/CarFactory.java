package pr06.factories;

import pr06.interfaces.Factory;
import pr06.interfaces.IVehicle;
import pr06.models.Car;

public class CarFactory implements Factory<IVehicle>{

    @Override
    public IVehicle createObject(String[] objectData) {
        double fuelQuantity = Double.valueOf(objectData[1]);
        double fuelConsumption = Double.valueOf(objectData[2]);
        return new Car(fuelQuantity, fuelConsumption);
    }
}
