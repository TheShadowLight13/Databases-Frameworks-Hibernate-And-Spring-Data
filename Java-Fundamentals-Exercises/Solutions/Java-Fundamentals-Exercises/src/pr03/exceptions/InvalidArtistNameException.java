package pr03.exceptions;

import pr03.constants.Constants;

public class InvalidArtistNameException extends InvalidSongException {

    public InvalidArtistNameException() {
        super(Constants.INVALID_ARTIST_NAME);
    }
}
