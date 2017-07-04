package pr06.interfaces;

public interface IVehicle {

    String drive(double distance);

    void refuel(double quantity);

    double getFuelQuantity();

    double getFuelConsumption();

    void reduceFuelQuantity(double quantity);
}
