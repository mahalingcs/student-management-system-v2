
public class DBConnection {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        boolean result = dao.addStudent(107, "Priya", 22);

        if (result) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student was not added.");
        }
    }
}
