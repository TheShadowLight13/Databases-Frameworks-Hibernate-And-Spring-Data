package pr06.interfaces;

public interface Factory<T> {

    T createObject(String[] objectData);
}
