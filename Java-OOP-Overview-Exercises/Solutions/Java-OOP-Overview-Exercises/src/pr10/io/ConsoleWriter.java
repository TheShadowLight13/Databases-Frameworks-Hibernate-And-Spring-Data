package pr10.io;

import pr10.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void printOnNewLine(String message) {
        System.out.println(message);
    }
}
