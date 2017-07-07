package pr01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = buffReader.readLine();
                if (input.equals("END")) {
                    break;
                }

                String[] studentInfo = input.split("\\s+");
                String facultyNumber = studentInfo[0];
                List<Integer> marks = Arrays.asList(studentInfo)
                        .subList(1, studentInfo.length)
                        .stream()
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());

                students.add(new Student(facultyNumber, marks));
            }
        }

        students.stream().filter(s -> s.getFacultyNumber().endsWith("14") ||
                s.getFacultyNumber().endsWith("15"))
                .forEach(System.out::println);
    }
}

class Student {

    private String facultyNumber;

    private List<Integer> marks;

    public Student(String facultyNumber, List<Integer> marks) {
        this.facultyNumber = facultyNumber;
        this.marks = marks;
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }

    private List<Integer> getMarks() {
        return Collections.unmodifiableList(this.marks);
    }

    @Override
    public String toString() {
        StringBuilder marks = new StringBuilder();
        this.getMarks().forEach(m -> marks.append(String.format("%d ", m)));
        return marks.toString();
    }
}
