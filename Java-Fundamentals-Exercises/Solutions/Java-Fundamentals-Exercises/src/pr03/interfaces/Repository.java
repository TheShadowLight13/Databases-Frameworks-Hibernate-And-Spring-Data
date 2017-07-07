package pr03.interfaces;

public interface Repository<T> {

    void addObject(T object);

    int getObjectsCount();

    String getTotalSongsLenInfo();
}
