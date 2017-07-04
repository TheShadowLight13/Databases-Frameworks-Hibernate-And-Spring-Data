package pr02;

import pr02.interfaces.Car;
import pr02.interfaces.Rentable;
import pr02.interfaces.Sellable;
import pr02.models.Audi;
import pr02.models.Seat;

public class Main {

    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Rentable audi = new Audi("TT", "Black", 310, "Germany", 3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(car.toString());
    }
}
