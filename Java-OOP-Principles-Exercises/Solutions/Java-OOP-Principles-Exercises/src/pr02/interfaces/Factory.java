package pr02.interfaces;

public interface Factory<T> {

    T createObject(String input);
}
