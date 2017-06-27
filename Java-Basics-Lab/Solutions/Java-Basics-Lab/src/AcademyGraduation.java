import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AcademyGraduation {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfStudents = Integer.valueOf(buffReader.readLine());
        TreeMap<String, StudentInfo> students = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String studentName = buffReader.readLine();
            students.putIfAbsent(studentName, new StudentInfo(studentName));
            List<Double> marks = Arrays.stream(buffReader.readLine().split(", "))
                    .map(Double::valueOf).collect(Collectors.toList());
            students.get(studentName).addMarks(marks);
        }

        for (String studentName : students.keySet()) {
            double averageMark = students.get(studentName).getAverageMark();
            System.out.printf("Average mark for %s - %s%n",
                    studentName, new DecimalFormat("0.###").format(averageMark));
        }
    }
}
