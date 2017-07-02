package pr07.models;

import pr07.interfaces.IStudent;
import java.util.ArrayList;
import java.util.List;

public class Student implements IStudent {

    private String name;

    private List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMark(Double mark) {
        this.grades.add(mark);
    }

    @Override
    public void addMarks(List<Double> marks) {
        this.grades.addAll(marks);
    }

    @Override
    public double getAverageGrade() {
        if (!this.grades.isEmpty()) {
            return this.grades.stream().mapToDouble(Double::valueOf).average().getAsDouble();
        }

        return 0;
    }
}
