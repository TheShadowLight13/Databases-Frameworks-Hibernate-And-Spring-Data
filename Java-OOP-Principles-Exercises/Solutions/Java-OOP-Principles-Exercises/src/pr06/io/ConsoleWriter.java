package pr06.io;

import pr06.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void printOnNewLine(String output) {
        System.out.println(output);
    }
}
