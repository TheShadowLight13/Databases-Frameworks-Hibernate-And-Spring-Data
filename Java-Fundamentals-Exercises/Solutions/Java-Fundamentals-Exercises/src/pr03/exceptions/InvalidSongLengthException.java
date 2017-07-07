package pr03.exceptions;

import pr03.constants.Constants;

public class InvalidSongLengthException extends InvalidSongException {

    public InvalidSongLengthException(String message) {
        super(message);
    }

    public InvalidSongLengthException() {
        super(Constants.INVALID_SONG_LENGTH);
    }
}
