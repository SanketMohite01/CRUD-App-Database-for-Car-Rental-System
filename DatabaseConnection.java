package Database; // Ensure the package is correct

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Replace with your actual database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/crudapp"; // Ensure this matches your database name
            String user = "root"; // Your database username
            String password = "abhijeet@2002"; // Your database password

            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
