package pr09.models;

public class Student {

    public static int studentsCount = 0;

    private String name;

    public Student(String name) {
        this.name = name;
        studentsCount++;
    }
}
