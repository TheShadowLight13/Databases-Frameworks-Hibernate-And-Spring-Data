package pr06.models;

import pr06.interfaces.IPerson;
import pr06.interfaces.IProduct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements IPerson {

    private String name;

    private double money;

    private List<IProduct> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getMoney() {
        return this.money;
    }

    @Override
    public List<IProduct> getBagOfProducts() {
        return Collections.unmodifiableList(this.bagOfProducts);
    }

    @Override
    public void buyProduct(IProduct product) {
        if (product.getCost() > this.getMoney()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s",
                    this.getName(), product.getName()));
        }

        this.money = this.money - product.getCost();
        this.bagOfProducts.add(product);
    }
}
