package pr02;

import pr02.engines.Engine;
import pr02.factories.CarFactory;
import pr02.interfaces.Car;
import pr02.interfaces.Factory;
import pr02.interfaces.Reader;
import pr02.interfaces.Writer;
import pr02.io.ConsoleReader;
import pr02.io.ConsoleWriter;
import pr02.models.Ferrari;

import java.lang.instrument.IllegalClassFormatException;

public class Main {

    public static void main(String[] args) throws IllegalClassFormatException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Factory<Car> carFactory = new CarFactory();
        Runnable engine = new Engine(reader, writer, carFactory);
        engine.run();

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }
}
