package pr08;

import pr08.engine.Engine;
import pr08.factories.BookFactory;
import pr08.interfaces.*;
import pr08.io.ConsoleReader;
import pr08.io.ConsoleWriter;
import pr08.models.Library;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ILibrary library = new Library();
        Factory<IBook> bookFactory = new BookFactory();
        Runnable engine = new Engine(reader, writer, library, bookFactory);
        engine.run();
    }
}
