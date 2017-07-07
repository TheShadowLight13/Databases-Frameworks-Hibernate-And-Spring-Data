package pr02.interfaces;

import java.util.List;

public interface Repository<T> {

    void add(T object);

    List<T> getAllObjects();
}
