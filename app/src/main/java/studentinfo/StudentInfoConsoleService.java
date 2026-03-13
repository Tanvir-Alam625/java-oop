package studentinfo;

import java.util.Scanner;

public class StudentInfoConsoleService {

    public void run() {
        StudentInfoService service = new StudentInfoService();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            StudentInfo result = service.getResultById(id);
            if (result == null) {
                System.out.println("No student found for ID=" + id);
                return;
            }

            System.out.println("Student Found Id: " + result.getId());
            System.out.println("Student Found Name: " + result.getName());
            System.out.println("Student Found Grade: " + result.getGrade());
            System.out.println("Student Found Department: " + result.getDep());
        }
    }
}
