package pr08.models;

import pr08.interfaces.IBook;
import pr08.interfaces.ILibrary;
import java.util.*;

public class Library implements ILibrary {

    private static final String DEFAULT_LIBRARY_NAME = "MyLibrary";

    private String name;

    private LinkedHashMap<String, List<IBook>> booksByAuthor;

    private LinkedHashMap<String, Double> booksPriceByAuthor;

    public Library() {
        this.name = DEFAULT_LIBRARY_NAME;
        this.booksByAuthor = new LinkedHashMap<>();
        this.booksPriceByAuthor = new LinkedHashMap<>();
    }

    @Override
    public LinkedHashMap<String, Double> getBooksPriceByAuthor() {
        return new LinkedHashMap<>(this.booksPriceByAuthor);
    }

    @Override
    public void addBook(IBook book) {
        this.booksByAuthor.putIfAbsent(book.getAuthor(), new ArrayList<>());
        this.booksByAuthor.get(book.getAuthor()).add(book);
        this.booksPriceByAuthor.putIfAbsent(book.getAuthor(), 0D);
        double newBooksTotalPrice = this.booksPriceByAuthor.get(book.getAuthor()) + book.getPrice();
        this.booksPriceByAuthor.put(book.getAuthor(), newBooksTotalPrice);
    }
}
