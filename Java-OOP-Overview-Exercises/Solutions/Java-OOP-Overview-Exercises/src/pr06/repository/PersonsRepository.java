package pr06.repository;

import pr06.interfaces.IPerson;
import pr06.interfaces.Repository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PersonsRepository implements Repository<IPerson> {

    private List<IPerson> persons;

    public PersonsRepository() {
        this.persons = new ArrayList<>();
    }

    @Override
    public void addEntry(IPerson person) {
        this.persons.add(person);
    }

    @Override
    public List<IPerson> getEntries() {
        return Collections.unmodifiableList(this.persons);
    }

    @Override
    public IPerson getEntryByName(String name) {
        if (this.getEntries().stream().anyMatch(e -> e.getName().equals(name))) {
            return this.getEntries().stream().filter(e -> e.getName().equals(name)).findFirst().get();
        }

        return null;
    }

    @Override
    public Iterator<IPerson> iterator() {
        return this.getEntries().iterator();
    }
}
