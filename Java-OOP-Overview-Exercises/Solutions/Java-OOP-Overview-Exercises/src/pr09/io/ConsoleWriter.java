package pr09.io;

import pr09.interfaces.Writer;

public class ConsoleWriter implements Writer{

    @Override
    public void printOnNewLine(String message) {
        System.out.println(message);
    }
}
