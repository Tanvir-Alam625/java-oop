package studentinfo;

import java.util.List;

public class StudentInfoService {
    private final List<StudentInfo> students = List.of(
            new StudentInfo(1, "Ali", "A", "Computer Science"),
            new StudentInfo(2, "Sara", "B", "Mathematics"),
            new StudentInfo(3, "John", "A", "Physics")
    );

    public StudentInfo getResultById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }
}