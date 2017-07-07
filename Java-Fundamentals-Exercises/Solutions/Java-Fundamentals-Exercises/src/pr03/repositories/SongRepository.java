package pr03.repositories;

import pr03.interfaces.ISong;
import pr03.interfaces.Repository;
import java.util.ArrayList;
import java.util.List;

public class SongRepository implements Repository<ISong>{

    private List<ISong> songs;

    public SongRepository() {
        this.songs = new ArrayList<>();
    }

    @Override
    public void addObject(ISong song) {
        this.songs.add(song);
    }

    @Override
    public int getObjectsCount() {
        return this.songs.size();
    }

    @Override
    public String getTotalSongsLenInfo() {
        long totalSongsLenInSeconds = this.songs.stream().
                mapToLong(s -> s.getSongLength().getTotalLenInSeconds()).sum();
        long hours = totalSongsLenInSeconds / 3600L;
        long minutes = (totalSongsLenInSeconds - (hours * 3600L)) / 60L;
        long seconds = (totalSongsLenInSeconds - (hours * 3600L)) - (minutes * 60L);

        return String.format("Playlist length: %dh %dm %ss",
                hours, minutes, seconds);
    }
}
