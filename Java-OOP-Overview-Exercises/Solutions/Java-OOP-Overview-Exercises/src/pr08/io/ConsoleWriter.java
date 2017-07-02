package pr08.io;

import pr08.interfaces.Writer;
import java.util.LinkedHashMap;

public class ConsoleWriter implements Writer {

    @Override
    public void printResultOnNewLine(LinkedHashMap<String, Double> booksPriceByAuthor) {
        StringBuilder result = new StringBuilder();

        for (String author : booksPriceByAuthor.keySet()) {
            double booksPrice = booksPriceByAuthor.get(author);
            result.append(String.format("%s -> %.2f%n", author, booksPrice));
        }

        System.out.println(result);
    }
}
