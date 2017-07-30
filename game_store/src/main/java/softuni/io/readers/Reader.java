package softuni.io.readers;

import java.io.IOException;

public interface Reader {

    String readLine() throws IOException;

    void close() throws IOException;
}
