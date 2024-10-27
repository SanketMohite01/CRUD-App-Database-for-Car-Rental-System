package Database; // Ensure the package is correct

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO { // This class handles employee-related database operations

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String selectQuery = "SELECT id, username FROM employee"; // Adjusted to exclude password

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psSelect = connection.prepareStatement(selectQuery);
             ResultSet rs = psSelect.executeQuery()) {

            while (rs.next()) {
                // Assuming your employee table has columns id and username
                int id = rs.getInt("id");
                String username = rs.getString("username");
                // Omit password for security reasons

                // Create an Employee object and add it to the list
                Employee employee = new Employee(id, username, null); // Password is null
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public boolean loginAuthentication(String iname, String passwordString) {
        String selectQuery = "SELECT * FROM employee WHERE username = ? AND password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psSelect = connection.prepareStatement(selectQuery)) {

            psSelect.setString(1, iname); // Use the parameter instead of undefined variable
            psSelect.setString(2, passwordString); // Use the parameter instead of undefined variable

            try (ResultSet rs = psSelect.executeQuery()) {
                return rs.next(); // If a record is found, the user is authenticated
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Default return value if authentication fails
    }
}
