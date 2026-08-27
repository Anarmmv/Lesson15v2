package Task2;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static List<String> findPassedStudents(List<Student> students) {
        return students.stream()
                .filter(s -> s.getScore() > 51)
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .map(Student::getName)
                .toList();
    }

    static void main(String[] args) {
        List<Student> students = List.of(
                new Student(1L, "Ali", 85),
                new Student(2L, "Murad", 42),
                new Student(3L, "Nicat", 71),
                new Student(4L, "Leyla ", 58),
                new Student(5L, "Kamran", 39)

        );


        List<String> result = findPassedStudents(students);

        System.out.println(result);

    }
}