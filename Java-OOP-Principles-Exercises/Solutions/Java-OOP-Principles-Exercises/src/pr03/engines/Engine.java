package pr03.engines;

import pr03.interfaces.ISmartPhone;
import pr03.interfaces.Reader;
import pr03.interfaces.Writer;
import java.io.IOException;

public class Engine implements Runnable {

    private Reader reader;

    private Writer writer;

    private ISmartPhone smartPhone;

    public Engine(Reader reader, Writer writer, ISmartPhone smartPhone) {
        this.reader = reader;
        this.writer = writer;
        this.smartPhone = smartPhone;
    }

    @Override
    public void run() {
        String[] numbers = null;
        String[] URLs = null;

        try {
            numbers = this.reader.readLine().split("\\s+");
            URLs = this.reader.readLine().split("\\s+");

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String number : numbers) {
            try {
                this.writer.printOnNewLine(this.smartPhone.callNumber(number));
            }catch (IllegalArgumentException iae) {
                this.writer.printOnNewLine(iae.getMessage());
            }
        }

        for (String url : URLs) {
            try {
                this.writer.printOnNewLine((this.smartPhone.browseURL(url)));
            }catch (IllegalArgumentException iae) {
                this.writer.printOnNewLine(iae.getMessage());
            }
        }
    }
}
