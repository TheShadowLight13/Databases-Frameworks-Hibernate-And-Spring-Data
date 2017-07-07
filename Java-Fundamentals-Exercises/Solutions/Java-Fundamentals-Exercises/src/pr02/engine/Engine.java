package pr02.engine;

import pr02.interfaces.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private static final String TERMINATION_COMMAND = "END";

    private Reader reader;

    private Writer writer;

    private Factory<IPerson> personFactory;

    private Repository<IPerson> personRepository;

    public Engine(Reader reader, Writer writer,
                  Factory<IPerson> personFactory, Repository<IPerson> personRepository) {
        this.reader = reader;
        this.writer = writer;
        this.personFactory = personFactory;
        this.personRepository = personRepository;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String input = this.reader.readLine();
                if (input.equals(TERMINATION_COMMAND)) {
                    break;
                }

                String[] personData = input.split("\\s+");
                IPerson person = this.personFactory.createObject(personData);
                this.personRepository.add(person);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Map<Integer, List<IPerson>> personsByGroup = groupPersonsByGroup();
        printPersonsByGroup(personsByGroup);
    }

    private void printPersonsByGroup(Map<Integer, List<IPerson>> personsByGroup) {
        StringBuilder result = new StringBuilder();

        for (int group : personsByGroup.keySet()) {
            List<IPerson> persons = personsByGroup.get(group);
            result.append(String.format("%d - ", group));

            for (IPerson person : persons) {
                result.append(String.format("%s, ", person));
            }

            result.setLength(result.length() - 2);
            result.append("\n");
        }

        this.writer.printOnNewLine(result.toString());
    }

    private Map<Integer,List<IPerson>> groupPersonsByGroup() {
        Map<Integer, List<IPerson>> personsByGroup =
                this.personRepository.getAllObjects().stream()
                .collect(Collectors.groupingBy(IPerson::getGroup));
        return personsByGroup;
    }
}
