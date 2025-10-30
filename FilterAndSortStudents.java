import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return name + " - " + marks;
    }
}

public class FilterAndSortStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Sambhav", 82.5),
            new Student("Aditi", 74.0),
            new Student("Rohan", 90.0),
            new Student("Meera", 69.5),
            new Student("Karan", 78.0)
        );

        System.out.println("=== Students Scoring Above 75% (Sorted by Marks Desc) ===");
        students.stream()
                .filter(s -> s.getMarks() > 75) // Filter condition
                .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks())) // Sort descending
                .forEach(s -> System.out.println(s.getName() + " - " + s.getMarks()));
    }
}
