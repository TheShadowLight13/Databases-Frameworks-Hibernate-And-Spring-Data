package pr03;

import pr03.engines.Engine;
import pr03.interfaces.ISmartPhone;
import pr03.interfaces.Reader;
import pr03.interfaces.Writer;
import pr03.io.ConsoleReader;
import pr03.io.ConsoleWriter;
import pr03.models.SmartPhone;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ISmartPhone smartPhone = new SmartPhone();
        Runnable engine = new Engine(reader, writer, smartPhone);
        engine.run();
    }
}
