package pr04.engines;

import pr04.interfaces.*;
import java.io.IOException;
import java.util.List;

public class Engine implements Runnable {

    private static final String TERMINATION_COMMAND = "End";

    private Reader reader;

    private Writer writer;

    private Factory<IBirthDate> citizenFactory;

    private Factory<IBirthDate> petFactory;

    private Repository societyRepository;

    public Engine(Reader reader, Writer writer, Factory<IBirthDate> citizenFactory,
                  Factory<IBirthDate> petFactory, Repository societyRepository) {
        this.reader = reader;
        this.writer = writer;
        this.citizenFactory = citizenFactory;
        this.petFactory = petFactory;
        this.societyRepository = societyRepository;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String input = this.reader.readLine();
                if (input.equals(TERMINATION_COMMAND)) {
                    break;
                }

                String[] tokens = input.split("\\s+");
                String memberType = tokens[0];

                IBirthDate member;

                switch (memberType) {
                    case "Citizen":
                        member = this.citizenFactory.createObject(tokens);
                        this.societyRepository.addMember(member);
                        break;

                    case "Pet":
                        member = this.petFactory.createObject(tokens);
                        this.societyRepository.addMember(member);
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String targetYear = null;
        try {
            targetYear = this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<IBirthDate> members = this.societyRepository.getMembersByBirthYear(targetYear);
        printMembers(members);
    }

    private void printMembers(List<IBirthDate> members) {
        for (IBirthDate member : members) {
            this.writer.printBirthDateOnNewLine(member);
        }
    }
}
