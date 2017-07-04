package pr02.models;

import pr02.interfaces.Rentable;

public final class Audi extends AbstractCar implements Rentable {

    private int minRentDays;

    private double pricePerDay;

    public Audi(String model, String color, int horsePower,
                String countryProduced, int minRentDays, double pricePerDay) {

        super(model, color, horsePower, countryProduced);
        this.minRentDays = minRentDays;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDays;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
    }
}
