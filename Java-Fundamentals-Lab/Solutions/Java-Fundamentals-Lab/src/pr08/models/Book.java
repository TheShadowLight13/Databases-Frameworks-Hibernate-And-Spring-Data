package pr08.models;

import pr08.interfaces.IBook;

public class Book implements IBook {

    private String name;

    private String author;

    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
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
