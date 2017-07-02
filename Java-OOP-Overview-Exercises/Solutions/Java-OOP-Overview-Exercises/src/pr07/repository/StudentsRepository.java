package pr07.repository;

import pr07.interfaces.IStudent;
import pr07.interfaces.Repository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentsRepository implements Repository {

    private List<IStudent> students;

    public StudentsRepository() {
        this.students = new ArrayList<>();
    }

    @Override
    public void addStudent(IStudent student) {
        this.students.add(student);
    }

    @Override
    public List<IStudent> getStudents() {
        return Collections.unmodifiableList(this.students);
    }
}
