package pr08.factories;

import pr08.interfaces.Factory;
import pr08.interfaces.IBook;
import pr08.models.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookFactory implements Factory<IBook> {

    @Override
    public IBook createObject(String[] objectInfo) {
        IBook book = null;

        try {
            String title = objectInfo[0];
            String author = objectInfo[1];
            String publisher = objectInfo[2];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date releaseDate = dateFormat.parse(objectInfo[3]);
            String ISBN = objectInfo[4];
            double price = Double.valueOf(objectInfo[5]);
            book = new Book(title, author, publisher, releaseDate, ISBN, price);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return book;
    }
}
