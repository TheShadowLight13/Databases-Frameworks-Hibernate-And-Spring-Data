package pr02.models;

import pr02.interfaces.Car;

public class Ferrari implements Car {

    private static final String DEFAULT_MODEL = "488-Spider";

    private String model;

    private String driverName;

    public Ferrari(String driverName) {
        this.model = DEFAULT_MODEL;
        this.driverName = driverName;
    }

    @Override
    public String pushBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.getModel(), this.pushBrakes(), this.pushGasPedal(), this.getDriverName());
    }
}
