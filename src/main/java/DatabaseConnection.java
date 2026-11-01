
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";

    private static final String USERNAME = System.getenv("DB_USERNAME");

    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {

        if (USERNAME == null || PASSWORD == null) {
            throw new SQLException(
                    "Database environment variables are not set!");
        }

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
