package pr04.interfaces;

import java.util.List;

public interface Repository {

    void addMember(IBirthDate member);

    List<IBirthDate> getMembersByBirthYear(String birthYear);
}
