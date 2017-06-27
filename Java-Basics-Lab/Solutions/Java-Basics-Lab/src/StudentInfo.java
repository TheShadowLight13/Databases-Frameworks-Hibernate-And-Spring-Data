import java.util.ArrayList;
import java.util.List;

public class StudentInfo {

    private String studentName;
    private List<Double> marks;

    public StudentInfo(String studentName) {
        this.setStudentName(studentName);
        this.marks = new ArrayList<>();
    }

    public String getStudentName() {
        return this.studentName;
    }

    private void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void addMarks(List<Double> marks) {
        this.marks.addAll(marks);
    }

    public double getAverageMark() {
        return marks.stream().mapToDouble(Double::valueOf).average().getAsDouble();
    }
}
