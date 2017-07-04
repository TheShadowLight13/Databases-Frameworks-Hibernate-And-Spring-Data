package pr04.io;

import pr04.interfaces.IBirthDate;
import pr04.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void printBirthDateOnNewLine(IBirthDate member) {
        System.out.println(member);
    }
}
