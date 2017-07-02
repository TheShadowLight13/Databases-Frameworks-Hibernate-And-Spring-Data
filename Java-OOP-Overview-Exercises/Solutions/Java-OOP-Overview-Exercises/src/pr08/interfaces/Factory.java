package pr08.interfaces;

public interface Factory<T> {

    T createObject(String[] objectInfo);
}
