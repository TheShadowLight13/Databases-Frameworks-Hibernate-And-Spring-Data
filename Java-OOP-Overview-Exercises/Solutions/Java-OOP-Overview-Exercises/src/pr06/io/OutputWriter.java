package pr06.io;

import pr06.interfaces.Writer;

public class OutputWriter implements Writer {

    @Override
    public void printMessageOnNewLine(String message) {
        System.out.println(message);
    }
}
