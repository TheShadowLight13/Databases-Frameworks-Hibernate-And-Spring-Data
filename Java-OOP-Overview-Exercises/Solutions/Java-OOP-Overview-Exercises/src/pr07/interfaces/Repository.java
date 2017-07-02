package pr07.interfaces;

import java.util.List;

public interface Repository {

    void addStudent(IStudent student);

    List<IStudent> getStudents();

}
