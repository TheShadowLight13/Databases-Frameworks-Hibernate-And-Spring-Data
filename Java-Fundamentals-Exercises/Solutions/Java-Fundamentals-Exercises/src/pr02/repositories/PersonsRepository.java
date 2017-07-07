package pr02.repositories;

import pr02.interfaces.IPerson;
import pr02.interfaces.Repository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonsRepository implements Repository<IPerson>{

    private List<IPerson> persons;

    public PersonsRepository() {
        this.persons = new ArrayList<>();
    }

    @Override
    public void add(IPerson person) {
        this.persons.add(person);
    }

    @Override
    public List<IPerson> getAllObjects() {
        return Collections.unmodifiableList(this.persons);
    }
}
