package pr02.engines;

import pr02.interfaces.Car;
import pr02.interfaces.Factory;
import pr02.interfaces.Reader;
import pr02.interfaces.Writer;

import java.io.IOException;

public class Engine implements Runnable {

    private Reader reader;

    private Writer writer;

    private Factory<Car> carFactory;

    public Engine(Reader reader, Writer writer, Factory<Car> carFactory) {
        this.reader = reader;
        this.writer = writer;
        this.carFactory = carFactory;
    }

    @Override
    public void run() {
        try {
            String carName = this.reader.readLine();
            Car car = this.carFactory.createObject(carName);
            this.writer.printCarInfoOnNewLine(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
