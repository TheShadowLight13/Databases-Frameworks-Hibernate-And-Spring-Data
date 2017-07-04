package pr06.models;

public class Truck extends BaseVehicle {

    private static final double AC_FUEL_CONSUMPTION = 1.6;
    private static final double REFUEL_RATE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption, AC_FUEL_CONSUMPTION, REFUEL_RATE);
    }
}
