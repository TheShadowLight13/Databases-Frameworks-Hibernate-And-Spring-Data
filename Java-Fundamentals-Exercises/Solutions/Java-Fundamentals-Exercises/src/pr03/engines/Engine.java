package pr03.engines;

import pr03.exceptions.InvalidSongException;
import pr03.interfaces.*;
import java.io.IOException;

public class Engine implements Runnable {

    private Reader reader;

    private Writer writer;

    private Factory<ISong> songFactory;

    private Repository<ISong> songRepository;

    public Engine(Reader reader, Writer writer,
                  Factory<ISong> songFactory, Repository<ISong> songRepository) {
        this.reader = reader;
        this.writer = writer;
        this.songFactory = songFactory;
        this.songRepository = songRepository;
    }

    @Override
    public void run() {
        int songsToBeAdded = 0;
        try {
            songsToBeAdded = Integer.valueOf(this.reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < songsToBeAdded; i++) {
            try {
                String songData = this.reader.readLine();
                ISong song = this.songFactory.createObject(songData);
                this.songRepository.addObject(song);
                this.writer.printOnNewLine("Song added.");
            } catch (IOException | InvalidSongException e) {
                this.writer.printOnNewLine(e.getMessage());
            }
        }

        this.writer.printOnNewLine(String.format("Songs added: %d",
                this.songRepository.getObjectsCount()));
        this.writer.printOnNewLine(this.songRepository.getTotalSongsLenInfo());
    }
}
