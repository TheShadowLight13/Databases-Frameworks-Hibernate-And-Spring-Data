package pr05.engine;

import pr05.interfaces.Factory;
import pr05.interfaces.IHuman;
import pr05.interfaces.Reader;
import pr05.interfaces.Writer;

import java.io.IOException;

public class Engine implements Runnable{

    private Reader reader;

    private Writer writer;

    private Factory<IHuman> studentFactory;

    private Factory<IHuman> workerFactory;

    public Engine(Reader reader, Writer writer,
                  Factory<IHuman> studentFactory, Factory<IHuman> workerFactory) {
        this.reader = reader;
        this.writer = writer;
        this.studentFactory = studentFactory;
        this.workerFactory = workerFactory;
    }

    @Override
    public void run() {
        try {
            String[] studentInfo = this.reader.readLine().split("\\s+");
            String[] workerInfo = this.reader.readLine().split("\\s+");

            IHuman student = this.studentFactory.createObject(studentInfo);
            IHuman worker = this.workerFactory.createObject(workerInfo);
            this.writer.printOnNewLine(student.toString());
            this.writer.printOnNewLine(worker.toString());

        } catch (IOException | IllegalArgumentException e) {
            this.writer.printOnNewLine(e.getMessage());
        }
    }
}
