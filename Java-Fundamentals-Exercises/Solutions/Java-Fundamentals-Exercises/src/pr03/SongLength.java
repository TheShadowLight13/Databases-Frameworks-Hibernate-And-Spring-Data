package pr03;

import pr03.interfaces.ISongLength;

public class SongLength implements ISongLength {

    private static final int SECONDS_IN_MINUTE = 60;

    private int minutes;

    private int seconds;

    public SongLength(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public int getMinutes() {
        return this.minutes;
    }

    @Override
    public int getSeconds() {
        return this.seconds;
    }

    @Override
    public int getTotalLenInSeconds() {
        return (this.minutes * SECONDS_IN_MINUTE) + this.seconds;
    }
}
