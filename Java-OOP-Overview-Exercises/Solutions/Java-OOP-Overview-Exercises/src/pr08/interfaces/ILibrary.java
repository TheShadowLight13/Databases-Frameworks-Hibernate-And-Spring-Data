package pr08.interfaces;

import java.util.LinkedHashMap;

public interface ILibrary {

    LinkedHashMap<String, Double> getBooksPriceByAuthor();

    void addBook(IBook book);
}
