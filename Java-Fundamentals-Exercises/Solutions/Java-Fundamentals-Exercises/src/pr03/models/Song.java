package pr03.models;

import pr03.exceptions.*;
import pr03.interfaces.ISong;
import pr03.interfaces.ISongLength;

public class Song implements ISong {

    private static final int MIN_ARTIST_NAME_LEN = 3;
    private static final int MAX_ARTIST_NAME_LEN = 20;
    private static final int MIN_SONG_NAME_LEN = 3;
    private static final int MAX_SONG_NAME_LEN = 30;
    private static final int MIN_SONG_LEN_IN_SECONDS = 0;
    private static final int MAX_SONG_LEN_IN_SECONDS = 899;
    private static final int MIN_SONG_MINUTES = 0;
    private static final int MAX_SONG_MINUTES = 14;
    private static final int MIN_SONG_SECONDS = 0;
    private static final int MAX_SONG_SECONDS = 59;

    private String artistName;

    private String songName;

    private ISongLength songLength;

    public Song(String artistName, String songName, ISongLength songLength) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setSongLength(songLength);
    }

    private void setArtistName(String artistName) {
        if (!(artistName.length() >= MIN_ARTIST_NAME_LEN &&
                artistName.length() <= MAX_ARTIST_NAME_LEN)) {
            throw new InvalidArtistNameException();
        }

        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (!(songName.length() >= MIN_SONG_NAME_LEN && songName.length() <= MAX_SONG_NAME_LEN)) {
            throw new InvalidSongNameException();
        }

        this.songName = songName;
    }

    private void setSongLength(ISongLength songLength) {
        int songMinutes = songLength.getMinutes();
        if (!(songMinutes >= MIN_SONG_MINUTES && songMinutes <= MAX_SONG_MINUTES)) {
            throw new InvalidSongMinutesException();
        }

        int songSeconds = songLength.getSeconds();
        if (!(songSeconds >= MIN_SONG_SECONDS && songSeconds <= MAX_SONG_SECONDS)) {
            throw new InvalidSongSecondsException();
        }

        this.songLength = songLength;
    }

    @Override
    public String getArtistName() {
        return this.artistName;
    }

    @Override
    public String getSongName() {
        return this.songName;
    }

    @Override
    public ISongLength getSongLength() {
        return this.songLength;
    }
}
