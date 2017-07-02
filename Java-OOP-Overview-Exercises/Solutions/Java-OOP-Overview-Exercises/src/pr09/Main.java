package pr09;

import pr09.engine.Engine;
import pr09.interfaces.Reader;
import pr09.interfaces.Writer;
import pr09.io.ConsoleReader;
import pr09.io.ConsoleWriter;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Runnable engine = new Engine(reader, writer);
        engine.run();
    }
}
