package pr03.io;

import pr03.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void printOnNewLine(String output) {
        System.out.println(output);
    }
}
