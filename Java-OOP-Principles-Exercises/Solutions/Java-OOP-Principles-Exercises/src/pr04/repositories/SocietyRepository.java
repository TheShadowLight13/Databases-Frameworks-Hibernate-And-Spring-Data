package pr04.repositories;

import pr04.interfaces.IBirthDate;
import pr04.interfaces.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SocietyRepository implements Repository {

    private List<IBirthDate> society;
    public SocietyRepository() {
        this.society = new ArrayList<>();
    }

    @Override
    public void addMember(IBirthDate member) {
        this.society.add(member);
    }

    @Override
    public List<IBirthDate> getMembersByBirthYear(String birthYear) {
        return this.society.stream().filter(s -> s.getYear().equals(birthYear))
                .collect(Collectors.toList());
    }
}
