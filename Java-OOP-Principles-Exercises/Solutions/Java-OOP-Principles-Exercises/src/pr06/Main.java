package pr06;

import pr06.engine.Engine;
import pr06.factories.CarFactory;
import pr06.factories.TruckFactory;
import pr06.interfaces.Factory;
import pr06.interfaces.IVehicle;
import pr06.interfaces.Reader;
import pr06.interfaces.Writer;
import pr06.io.ConsoleReader;
import pr06.io.ConsoleWriter;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Factory<IVehicle> carFactory = new CarFactory();
        Factory<IVehicle> truckFactory = new TruckFactory();
        Runnable engine = new Engine(reader, writer, carFactory, truckFactory);
        engine.run();
    }
}
