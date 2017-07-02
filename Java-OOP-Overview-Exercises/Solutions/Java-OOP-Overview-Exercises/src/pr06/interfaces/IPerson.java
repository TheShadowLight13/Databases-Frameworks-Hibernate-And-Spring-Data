package pr06.interfaces;

import java.util.List;

public interface IPerson {

    String getName();

    double getMoney();

    List<IProduct> getBagOfProducts();

    void buyProduct(IProduct product);
}
