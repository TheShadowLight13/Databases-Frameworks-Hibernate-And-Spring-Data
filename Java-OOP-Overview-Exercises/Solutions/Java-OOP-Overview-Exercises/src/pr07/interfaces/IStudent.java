package pr07.interfaces;

import java.util.List;

public interface IStudent {

    String getName();

    void addMark(Double mark);

    void addMarks(List<Double> marks);

    double getAverageGrade();
}
