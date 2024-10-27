package Database; // Update this to your preferred package structure

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Authentication {

    // Existing methods (loginAuthentication and registerUser)

	
	
	public boolean loginAuthentication(String username, String password) {
        String selectQuery = "SELECT * FROM employee WHERE username = ? AND password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psSelect = connection.prepareStatement(selectQuery)) {
             
            psSelect.setString(1, username);
            psSelect.setString(2, password); // Ideally, use hashed passwords in a real application

            try (ResultSet rs = psSelect.executeQuery()) {
                return rs.next(); // If a record is found, the user is authenticated
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if authentication fails
    }
	
	
    // Method to retrieve all employees from the employee table
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String selectQuery = "SELECT * FROM employee"; // Adjust this according to your table structure

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psSelect = connection.prepareStatement(selectQuery);
             ResultSet rs = psSelect.executeQuery()) {

            while (rs.next()) {
                // Assuming your employee table has columns id, username, and password
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password"); // Ideally, don't retrieve password in a real application

                // Create an Employee object and add it to the list
                Employee employee = new Employee(id, username, password);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
