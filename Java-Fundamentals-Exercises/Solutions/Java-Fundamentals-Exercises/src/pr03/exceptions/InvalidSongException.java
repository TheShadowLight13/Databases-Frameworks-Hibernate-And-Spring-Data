package pr03.exceptions;

import pr03.constants.Constants;

public class InvalidSongException extends RuntimeException {

    public InvalidSongException(String message) {
        super(message);
    }

    public InvalidSongException() {
        super(Constants.INVALID_SONG_FORMAT);
    }
}
