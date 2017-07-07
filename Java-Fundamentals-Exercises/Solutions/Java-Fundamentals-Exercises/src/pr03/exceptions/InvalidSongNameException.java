package pr03.exceptions;

import pr03.constants.Constants;

public class InvalidSongNameException extends InvalidSongException{

    public InvalidSongNameException() {
        super(Constants.INVALID_SONG_NAME);
    }
}
