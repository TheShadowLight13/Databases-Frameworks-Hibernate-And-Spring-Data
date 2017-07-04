package pr05;

import pr05.engine.Engine;
import pr05.factories.StudentFactory;
import pr05.factories.WorkerFactory;
import pr05.interfaces.Factory;
import pr05.interfaces.IHuman;
import pr05.interfaces.Reader;
import pr05.interfaces.Writer;
import pr05.io.ConsoleReader;
import pr05.io.ConsoleWriter;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Factory<IHuman> studentFactory = new StudentFactory();
        Factory<IHuman> workerFactory = new WorkerFactory();
        Runnable engine = new Engine(reader, writer, studentFactory, workerFactory);
        engine.run();
    }
}
