package pr04.interfaces;

public interface Factory<T> {

    T createObject(String[] objectData);
}
