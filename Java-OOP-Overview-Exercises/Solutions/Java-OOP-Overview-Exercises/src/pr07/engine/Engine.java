package pr07.engine;

import pr07.interfaces.IStudent;
import pr07.interfaces.Reader;
import pr07.interfaces.Repository;
import pr07.interfaces.Writer;
import pr07.models.Student;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private Reader reader;

    private Writer writer;

    private Repository studentsRepository;

    public Engine(Reader reader, Writer writer, Repository studentsRepository) {
        this.reader = reader;
        this.writer = writer;
        this.studentsRepository = studentsRepository;
    }

    @Override
    public void run() {
        try {
            int studentsCount = Integer.valueOf(this.reader.readLine());

            for (int i = 0; i < studentsCount; i++) {
                List<String> studentData = Arrays.asList(this.reader.readLine().split("\\s+"));
                String studentName = studentData.get(0);
                List<Double> marks = studentData.subList(1, studentData.size())
                        .stream().map(Double::valueOf).collect(Collectors.toList());

                IStudent student = new Student(studentName);
                student.addMarks(marks);
                this.studentsRepository.addStudent(student);
            }

            // Get all students with average grade above 5.00
            List<IStudent> students = new ArrayList<>(this.studentsRepository.getStudents())
                    .stream().filter(s -> s.getAverageGrade() >= 5.00)
                    .collect(Collectors.toList());

            // Sort above students ordered by name ascending, then by average grade descending
            sortStudents(students);

            // Print above sorted students
            printStudents(students);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printStudents(List<IStudent> students) {
        StringBuilder result = new StringBuilder();

        for (IStudent student : students) {
            result.append(String.format("%s -> %.2f%n",
                    student.getName(), student.getAverageGrade()));
        }

        this.writer.printOnNewLine(result.toString());
    }

    private void sortStudents(List<IStudent> students) {
        Comparator<IStudent> orderByName = (s1, s2) -> s1.getName().compareTo(s2.getName());
        Comparator<IStudent> orderByNameAndAvgGrade = orderByName.thenComparing((s1, s2) ->
                Double.compare(s2.getAverageGrade(), s1.getAverageGrade()));

        students.sort(orderByNameAndAvgGrade);
    }
}
