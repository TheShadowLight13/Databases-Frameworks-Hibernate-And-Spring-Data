package pr07;

import pr07.engine.Engine;
import pr07.interfaces.Reader;
import pr07.interfaces.Repository;
import pr07.interfaces.Writer;
import pr07.io.ConsoleReader;
import pr07.io.ConsoleWriter;
import pr07.repository.StudentsRepository;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Repository repository = new StudentsRepository();
        Runnable engine = new Engine(reader, writer, repository);
        engine.run();
    }
}
