package pr06.engine;

import pr06.interfaces.Factory;
import pr06.interfaces.IVehicle;
import pr06.interfaces.Reader;
import pr06.interfaces.Writer;
import java.io.IOException;

public class Engine implements Runnable {

    private Reader reader;

    private Writer writer;

    private Factory<IVehicle> carFactory;

    private Factory<IVehicle> truckFactory;

    public Engine(Reader reader, Writer writer, Factory<IVehicle> carFactory,
                  Factory<IVehicle> truckFactory) {
        this.reader = reader;
        this.writer = writer;
        this.carFactory = carFactory;
        this.truckFactory = truckFactory;
    }

    @Override
    public void run() {
        try {
            String[] carData = this.reader.readLine().split("\\s+");
            String[] truckData = this.reader.readLine().split("\\s+");

            IVehicle car = this.carFactory.createObject(carData);
            IVehicle truck = this.truckFactory.createObject(truckData);

            int commandsCount = Integer.valueOf(this.reader.readLine());
            for (int i = 0; i < commandsCount; i++) {
                String[] tokens = this.reader.readLine().split("\\s+");
                String command = tokens[0] + tokens[1];

                switch (command) {
                    case "DriveCar":
                        driveVehicle(car, tokens);
                        break;
                    case "DriveTruck":
                        driveVehicle(truck, tokens);
                        break;
                    case "RefuelCar":
                        refuelVehicle(car, tokens);
                        break;
                    case "RefuelTruck":
                        refuelVehicle(truck, tokens);
                        break;
                }
            }

            this.writer.printOnNewLine(String.format("Car: %.2f", car.getFuelQuantity()));
            this.writer.printOnNewLine(String.format("Truck: %.2f", truck.getFuelQuantity()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void refuelVehicle(IVehicle vehicle, String[] tokens) {
        double liters = Double.valueOf(tokens[2]);
        vehicle.refuel(liters);
    }

    private void driveVehicle(IVehicle vehicle, String[] tokens) {
        double distance = Double.valueOf(tokens[2]);
        this.writer.printOnNewLine(vehicle.drive(distance));
    }
}
