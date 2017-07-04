package pr02.io;

import pr02.interfaces.Car;
import pr02.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void printCarInfoOnNewLine(Car car) {
        System.out.println(car);
    }
}
