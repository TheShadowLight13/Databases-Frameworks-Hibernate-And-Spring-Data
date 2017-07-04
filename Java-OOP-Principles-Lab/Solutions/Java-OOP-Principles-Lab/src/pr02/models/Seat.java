package pr02.models;

import pr02.interfaces.Sellable;

import java.io.Serializable;

public final class Seat extends AbstractCar implements Sellable, Serializable {

    private double price;

    public Seat(String model, String color, int horsePower,
                String countryProduced, double price) {

        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
