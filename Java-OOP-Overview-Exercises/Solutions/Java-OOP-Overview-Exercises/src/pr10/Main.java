package pr10;

import pr10.engine.Engine;
import pr10.interfaces.Reader;
import pr10.interfaces.Writer;
import pr10.io.ConsoleReader;
import pr10.io.ConsoleWriter;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Runnable engine = new Engine(reader, writer);
        engine.run();
    }
}
