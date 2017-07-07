package pr03.interfaces;

import pr03.exceptions.InvalidSongLengthException;

public interface Factory<T> {

    T createObject(String objectData) throws InvalidSongLengthException;
}
