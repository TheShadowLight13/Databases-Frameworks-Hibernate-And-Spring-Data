package pr05.interfaces;

public interface Factory<T> {

    T createObject(String[] objectData);
}
