package softuni.io.writers;

import org.springframework.stereotype.Component;

@Component
public class OutputWriter implements Writer {

    @Override
    public void printOnNewLine(String s) {
        System.out.println(s);
    }

    @Override
    public void print(String s) {
        System.out.print(s);
    }
}
