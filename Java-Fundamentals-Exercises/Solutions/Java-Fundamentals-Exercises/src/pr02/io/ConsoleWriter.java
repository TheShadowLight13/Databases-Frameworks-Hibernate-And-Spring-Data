package pr02.io;

import pr02.interfaces.Writer;

public class ConsoleWriter implements Writer{

    @Override
    public void printOnNewLine(String output) {
        System.out.println(output);
    }
}
