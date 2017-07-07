package pr02;

import pr02.engine.Engine;
import pr02.factories.PersonFactory;
import pr02.interfaces.*;
import pr02.io.ConsoleReader;
import pr02.io.ConsoleWriter;
import pr02.repositories.PersonsRepository;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Factory<IPerson> personFactory = new PersonFactory();
        Repository<IPerson> personRepository = new PersonsRepository();
        Runnable engine = new Engine(reader, writer, personFactory, personRepository);
        engine.run();
    }
}
