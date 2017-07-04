package pr06.models;

public class Car extends BaseVehicle {

    private static final double AC_FUEL_CONSUMPTION = 0.9;
    private static final double REFUEL_RATE = 1;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption, AC_FUEL_CONSUMPTION, REFUEL_RATE);
    }
}
