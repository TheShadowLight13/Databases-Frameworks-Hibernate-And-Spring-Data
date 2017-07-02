package pr08.engine;

import pr08.interfaces.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private Reader reader;

    private Writer writer;

    private ILibrary library;

    private Factory<IBook> bookFactory;

    public Engine(Reader reader, Writer writer, ILibrary library, Factory<IBook> bookFactory) {
        this.reader = reader;
        this.writer = writer;
        this.library = library;
        this.bookFactory = bookFactory;
    }

    @Override
    public void run() {
        try {
            int booksCount = Integer.valueOf(this.reader.readLine());

            for (int i = 0; i < booksCount; i++) {
                String[] booksInfo = this.reader.readLine().split(" ");
                IBook book = this.bookFactory.createObject(booksInfo);
                this.library.addBook(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinkedHashMap<String, Double> sortedBooksPriceByAuthor = sortBooksPriceByAuthor(
                this.library.getBooksPriceByAuthor());
        this.writer.printResultOnNewLine(sortedBooksPriceByAuthor);
    }

    private LinkedHashMap<String,Double> sortBooksPriceByAuthor(
            LinkedHashMap<String, Double> booksPriceByAuthor) {

        Comparator<Map.Entry<String, Double>> orderByPriceDescending = (e1, e2) ->
                Double.compare(e2.getValue(), e1.getValue());
        Comparator<Map.Entry<String, Double>> orderByPriceDescendingAndAuthorAscending =
                orderByPriceDescending.thenComparing((e1, e2) -> e1.getKey().compareTo(e2.getKey()));

        LinkedHashMap<String, Double> sortedBooksPriceByAuthor =
                booksPriceByAuthor.entrySet().stream()
                        .sorted(orderByPriceDescendingAndAuthorAscending)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (x, y) -> {throw new AssertionError();},
                                LinkedHashMap::new));
        return sortedBooksPriceByAuthor;
    }
}
