package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {
        // Step 1: Load the MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Step 2: Establish a connection to the database
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Crud", "root", "abhijeet@2002")) {
            System.out.println("Connection is established.");
            
            // Step 3: Create a statement for SELECT query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM stu");
            
            // Step 4: Process the ResultSet for SELECT query
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
            }
            
            // Step 5: Prepare and execute an INSERT query
            PreparedStatement psInsert = con.prepareStatement("INSERT INTO stu VALUES (?, ?, ?);");
            psInsert.setInt(1, 5);  // Assuming you are inserting a new row with ID 4
            psInsert.setString(2, "Sanuli");
            psInsert.setInt(3, 55);
            int insertResult = psInsert.executeUpdate();
            
            if (insertResult > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                System.out.println("Record insertion failed.");
            }
            
            // Step 6: Prepare and execute an UPDATE query
            PreparedStatement psUpdate = con.prepareStatement("UPDATE stu SET age = ? WHERE id = ?;");
            psUpdate.setInt(1, 160); // Updating the marks
            psUpdate.setInt(2, 4);  // For student with ID 3
            int updateResult = psUpdate.executeUpdate();
            
            if (updateResult > 0) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("Record update failed.");
            }
        }
    }
    }