
import java.util.Scanner;

public class StudentManagement {

    Scanner sc = new Scanner(System.in);
    private InputReader input = new InputReader(sc);
    private StudentDAO dao = new StudentDAO();

    public void addStudent() {
        String name = input.readRequiredText("Enter student name:");

        int age = input.readIntInRange(
                "Enter student age:", 1, 120);

        int rollNo = input.readIntInRange(
                "Enter roll number:", 1, Integer.MAX_VALUE);

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setrollNo(rollNo);

        boolean added = dao.addStudent(
                student.getrollNo(),
                student.getName(),
                student.getAge());

        if (added) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student could not be added.");
        }
    }

    public void viewStudents() {
        dao.viewStudents();

    }

    public void searchStudent(int rollNo) {
        dao.searchStudent(rollNo);

    }

    public void deleteStudent(int rollNo) {
        dao.deleteStudent(rollNo);
    }

    public void updateStudent(int rollNo) {
        String name = input.readRequiredText("Enter new name:");
        int age = input.readIntInRange("Enter new age:", 1, 120);

        dao.updateStudent(rollNo, name, age);
    }

    public static void main(String[] args) {

        StudentManagement obj = new StudentManagement();

        int choice;

        do {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. delete Student");
            System.out.println("5. Update student");
            System.out.println("6. Exit");

            choice = obj.input.readIntInRange(
                    "Enter your choice:", 1, 6);

            switch (choice) {

                case 1:
                    obj.addStudent();
                    break;

                case 2:
                    obj.viewStudents();
                    break;

                case 3:
                    int rollNo = obj.input.readIntInRange(
                            "Enter roll number to search:", 1, Integer.MAX_VALUE);
                    obj.searchStudent(rollNo);
                    break;
                case 4:
                    rollNo = obj.input.readIntInRange(
                            "Enter roll number to delete:", 1, Integer.MAX_VALUE);
                    obj.deleteStudent(rollNo);
                    break;
                case 5:
                    rollNo = obj.input.readIntInRange(
                            "Enter roll number to update:", 1, Integer.MAX_VALUE);
                    obj.updateStudent(rollNo);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Please enter a valid input.");
            }

        } while (choice != 6);

        obj.sc.close();
    }
}