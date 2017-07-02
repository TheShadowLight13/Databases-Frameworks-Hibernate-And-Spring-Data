package pr07.io;

import pr07.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void printOnNewLine(String message) {
        System.out.println(message);
    }
}
