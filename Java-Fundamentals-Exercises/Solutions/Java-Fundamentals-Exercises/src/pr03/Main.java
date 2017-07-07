package pr03;

import pr03.engines.Engine;
import pr03.factories.SongFactory;
import pr03.interfaces.*;
import pr03.io.ConsoleReader;
import pr03.io.ConsoleWriter;
import pr03.repositories.SongRepository;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Factory<ISong> songFactory = new SongFactory();
        Repository<ISong> songRepository = new SongRepository();
        Runnable engine = new Engine(reader, writer, songFactory, songRepository);
        engine.run();
    }
}
