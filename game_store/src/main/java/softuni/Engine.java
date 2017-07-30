package softuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.io.interpreters.Interpreter;
import softuni.io.readers.Reader;
import softuni.io.writers.Writer;
import softuni.staticData.SessionData;

import java.io.IOException;

@Component
public class Engine implements CommandLineRunner {

    private static final String EXIT_COMMAND = "exit";

    private final Reader consoleReader;

    private final Writer outputWriter;

    private final Interpreter commandInterpreter;

    @Autowired
    public Engine(Reader consoleReader, Writer outputWriter,
                  Interpreter commandInterpreter) {
        this.consoleReader = consoleReader;
        this.outputWriter = outputWriter;
        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run(String... strings) {
        try {
            while (true) {
                this.outputWriter.print(String.format("%s> ", SessionData.currentPath));
                try {
                    String line = this.consoleReader.readLine();
                    if (line == null || line.isEmpty() ||
                            line.toLowerCase().equals(EXIT_COMMAND)) {
                        break;
                    }

                    String message = this.commandInterpreter.interpretCommand(line);
                    this.outputWriter.printOnNewLine(message);
                } catch (Exception e) {
                    this.outputWriter.printOnNewLine(e.getMessage());
                }
            }
        } finally {
            try {
                this.consoleReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
