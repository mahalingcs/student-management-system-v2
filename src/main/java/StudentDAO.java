
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    public boolean addStudent(int rollNo, String name, int age) {
        String sql = "INSERT INTO students (roll_no, name, age) VALUES (?, ?, ?)";

        // We'll implement the database operation here.

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rollNo);
            ps.setString(2, name);
            ps.setInt(3, age);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Failed to add student: " + e.getMessage());
            return false;
        }
    }

    public void viewStudents() {
        String sql = "SELECT * FROM students";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int rollNo = rs.getInt("roll_no");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("Roll No: " + rollNo);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("----------------");
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve students: " + e.getMessage());
        }
    }

    public void searchStudent(int rollNo) {
        String sql = "SELECT * FROM students WHERE roll_no = ?";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rollNo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Roll No: " + rs.getInt("roll_no"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Age: " + rs.getInt("age"));
                } else {
                    System.out.println("Student not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to search student: " + e.getMessage());
        }
    }

    public void updateStudent(int rollNo, String name, int age) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE roll_no = ?";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, rollNo);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update student: " + e.getMessage());
        }
    }

    public void deleteStudent(int rollNo) {
        String sql = "DELETE FROM students WHERE roll_no = ?";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rollNo);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Failed to delete student: " + e.getMessage());
        }
    }
}
