package pr06.repository;

import pr06.interfaces.IProduct;
import pr06.interfaces.Repository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProductsRepository implements Repository<IProduct> {

    private List<IProduct> products;

    public ProductsRepository() {
        this.products = new ArrayList<>();
    }

    @Override
    public void addEntry(IProduct product) {
        this.products.add(product);
    }

    @Override
    public List<IProduct> getEntries() {
        return Collections.unmodifiableList(this.products);
    }

    @Override
    public IProduct getEntryByName(String name) {
        if (this.getEntries().stream().anyMatch(e -> e.getName().equals(name))) {
            return this.getEntries().stream().filter(e -> e.getName().equals(name)).findFirst().get();
        }

        return null;
    }

    @Override
    public Iterator<IProduct> iterator() {
        return this.getEntries().iterator();
    }
}
