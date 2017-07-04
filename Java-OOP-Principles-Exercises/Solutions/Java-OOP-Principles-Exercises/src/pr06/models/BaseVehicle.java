package pr06.models;

import pr06.interfaces.IVehicle;
import java.text.DecimalFormat;

public abstract class BaseVehicle implements IVehicle {

    private double fuelQuantity;

    private double fuelConsumption;

    private double ACFuelConsumption;

    private double refuelRate;

    protected BaseVehicle(double fuelQuantity, double fuelConsumption,
                          double ACFuelConsumption, double refuelRate) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.ACFuelConsumption = ACFuelConsumption;
        this.refuelRate = refuelRate;
    }

    @Override
    public String drive(double distance) {
        double fuelToBeUsed = (this.getFuelConsumption() + this.ACFuelConsumption) * distance;
        if (fuelToBeUsed > this.getFuelQuantity()) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        } else {
            this.reduceFuelQuantity(fuelToBeUsed);
            return String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),
                    new DecimalFormat("0.######").format(distance));
        }
    }

    @Override
    public void refuel(double quantity) {
        this.fuelQuantity = this.fuelQuantity + (quantity * refuelRate);
    }

    @Override
    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    @Override
    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    @Override
    public void reduceFuelQuantity(double quantity) {
        this.fuelQuantity = this.fuelQuantity - quantity;
    }
}
