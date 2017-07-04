package pr04;

import pr04.engines.Engine;
import pr04.factories.CitizenFactory;
import pr04.factories.PetFactory;
import pr04.interfaces.*;
import pr04.io.ConsoleReader;
import pr04.io.ConsoleWriter;
import pr04.repositories.SocietyRepository;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Factory<IBirthDate> citizenFactory = new CitizenFactory();
        Factory<IBirthDate> petFactory = new PetFactory();
        Repository societyRepository = new SocietyRepository();
        Runnable engine = new Engine(reader, writer, citizenFactory,
                petFactory, societyRepository);
        engine.run();
    }
}
