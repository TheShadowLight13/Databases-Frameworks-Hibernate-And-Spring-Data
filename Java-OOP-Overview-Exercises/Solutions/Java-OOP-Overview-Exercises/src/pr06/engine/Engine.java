package pr06.engine;

import pr06.interfaces.*;
import pr06.models.Person;
import pr06.models.Product;
import pr06.repository.PersonsRepository;
import pr06.repository.ProductsRepository;

import java.io.IOException;
import java.util.List;

public class Engine implements Runnable {

    private static final String TERMINATION_COMMAND = "END";

    private Reader reader;

    private Writer writer;

    private Repository<IPerson> personsRepository;

    private Repository<IProduct> productsRepository;

    public Engine(Reader reader, Writer writer,
                  Repository<IPerson> personsRepository, Repository<IProduct> productsRepository) {
        this.reader = reader;
        this.writer = writer;
        this.personsRepository = personsRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public void run() {
        try {
            String[] personsData = this.reader.readLine().split(";");
            String[] productsData = this.reader.readLine().split(";");

            fillData(personsData, this.personsRepository);
            fillData(productsData, this.productsRepository);
        } catch (IOException | IllegalArgumentException e) {
            this.writer.printMessageOnNewLine(e.getMessage());
            return;
        }

        while (true) {
            try {
                String input = this.reader.readLine();
                if (input.equals(TERMINATION_COMMAND)) {
                    break;
                }

                String[] tokens = input.split("\\s+");
                String personName = tokens[0];
                String productName = tokens[1];

                IPerson person = this.personsRepository.getEntryByName(personName);
                IProduct product = this.productsRepository.getEntryByName(productName);

                person.buyProduct(product);
                this.writer.printMessageOnNewLine(String.format("%s bought %s",
                        person.getName(), product.getName()));

            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException iae) {
                this.writer.printMessageOnNewLine(iae.getMessage());
            }
        }

        printPersons(this.personsRepository);
    }

    private void printPersons(Repository<IPerson> personsRepository) {
        StringBuilder personsInfo = new StringBuilder();

        for (IPerson person : personsRepository) {
            personsInfo.append(String.format("%s - ", person.getName()));
            List<IProduct> products = person.getBagOfProducts();

            if (!products.isEmpty()) {
                products.forEach(p -> personsInfo.append(p.getName()).append(", "));
                personsInfo.setLength(personsInfo.length() - 2);
            } else {
                personsInfo.append("Nothing bought");
            }

            personsInfo.append("\n");
        }

        System.out.println(personsInfo);
    }

    private <T> void fillData(String[] data, Repository<T> repository) {
        for (int i = 0; i < data.length; i++) {
            String[] tokens = data[i].split("=");

            if (repository instanceof PersonsRepository) {
                String personName = tokens[0];
                double personMoney = Double.valueOf(tokens[1]);
                IPerson person = new Person(personName, personMoney);
                ((PersonsRepository) repository).addEntry(person);

            } else if (repository instanceof ProductsRepository) {
                String productName = tokens[0];
                double productCost = Double.valueOf(tokens[1]);
                IProduct product = new Product(productName, productCost);
                ((ProductsRepository) repository).addEntry(product);
            }
        }
    }
}
