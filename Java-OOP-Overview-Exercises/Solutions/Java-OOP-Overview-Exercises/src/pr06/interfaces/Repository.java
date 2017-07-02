package pr06.interfaces;

import java.util.List;

public interface Repository<T> extends Iterable<T>{
    void addEntry(T entry);

    List<T> getEntries();

    T getEntryByName(String name);
}
