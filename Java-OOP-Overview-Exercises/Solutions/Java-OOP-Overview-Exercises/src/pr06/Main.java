package pr06;

import pr06.engine.Engine;
import pr06.interfaces.*;
import pr06.io.ConsoleReader;
import pr06.io.OutputWriter;
import pr06.repository.PersonsRepository;
import pr06.repository.ProductsRepository;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new OutputWriter();
        Repository<IPerson> personsRepository = new PersonsRepository();
        Repository<IProduct> productsRepository = new ProductsRepository();
        Runnable engine = new Engine(reader, writer, personsRepository, productsRepository);
        engine.run();
    }
}
