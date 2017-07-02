package pr08.models;

import pr08.interfaces.IBook;
import java.util.Date;

public class Book implements IBook {

    private String title;

    private String author;

    private String publisher;

    private Date releaseDate;

    private String ISBN;

    private double price;

    public Book(String title, String author, String publisher,
                Date releaseDate, String ISBN, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.ISBN = ISBN;
        this.price = price;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
