package pr09.engine;

import pr09.interfaces.Reader;
import pr09.interfaces.Writer;
import pr09.models.Student;

import java.io.IOException;

public class Engine implements Runnable {

    private static final String TERMINATION_COMMAND = "End";

    private Reader reader;

    private Writer writer;

    public Engine(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String input = this.reader.readLine();
                if (input.equals(TERMINATION_COMMAND)) {
                    break;
                }

                Student student = new Student(input);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.writer.printOnNewLine(String.valueOf(Student.studentsCount));
    }
}
