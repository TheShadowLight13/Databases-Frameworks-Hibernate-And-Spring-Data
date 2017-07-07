package pr03.factories;

import pr03.SongLength;
import pr03.exceptions.InvalidSongLengthException;
import pr03.interfaces.Factory;
import pr03.interfaces.ISong;
import pr03.interfaces.ISongLength;
import pr03.models.Song;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongFactory implements Factory<ISong> {

    @Override
    public ISong createObject(String objectData) throws InvalidSongLengthException {
        String songRegex = "(.*?);(.*?);((\\d+):(\\d+))";
        Pattern songPattern = Pattern.compile(songRegex);
        Matcher songMatcher = songPattern.matcher(objectData);

        if (songMatcher.find()) {
            String artistName = songMatcher.group(1);
            String songName = songMatcher.group(2);
            int minutes = Integer.valueOf(songMatcher.group(4));
            int seconds = Integer.valueOf(songMatcher.group(5));
            ISongLength songLength = new SongLength(minutes, seconds);

            return new Song(artistName, songName, songLength);
        } else {
            throw new InvalidSongLengthException();
        }
    }
}
