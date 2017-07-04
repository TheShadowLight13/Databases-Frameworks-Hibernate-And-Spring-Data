package pr05.io;

import pr05.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void printOnNewLine(String output) {
        System.out.println(output);
    }
}
