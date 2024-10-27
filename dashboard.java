package bank;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class dashboard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable Jtable;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JComboBox<String> comboBox;  // Make comboBox a class variable

    // JDBC details
    static final String DB_URL = "jdbc:mysql://localhost:3306/crudapp";
    static final String USER = "root";
    static final String PASS = "abhijeet@2002";
    JPanel panel_1 = new JPanel();
    private String namedata;
   public void setName(String name) {
	namedata = name;
	   JLabel Juser = new JLabel(name);
       Juser.setForeground(new Color(0, 255, 255));
       Juser.setHorizontalAlignment(SwingConstants.CENTER);
       Juser.setBounds(10, 397, 104, 14);
       panel_1.add(Juser);
   }
   
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                dashboard frame = new dashboard();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public dashboard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 953, 495);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 21, 917, 435);
        contentPane.add(panel);
        panel.setLayout(null);
        
        
        panel_1.setBackground(Color.RED);
        panel_1.setBounds(0, -21, 124, 456);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("CAR RENTAL");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 54, 104, 24);
        panel_1.add(lblNewLabel_1);
        
     
        
        JLabel lblRentCar = new JLabel("Rent Car");
        lblRentCar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	dispose();
        	RentV v =new RentV();
        	v.setName(namedata);
        	v.setVisible(true);
        	}
        });
        lblRentCar.setForeground(new Color(255, 255, 255));
        lblRentCar.setHorizontalAlignment(SwingConstants.CENTER);
        lblRentCar.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
        lblRentCar.setBounds(10, 196, 104, 14);
        panel_1.add(lblRentCar);
        
        JLabel JCus_1_1 = new JLabel("Customer");
        JCus_1_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Customer ce = new Customer();
        		ce.setName(namedata);
        		ce.setVisible(true);
        		dispose();
        	}
        });
        JCus_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        JCus_1_1.setForeground(Color.WHITE);
        JCus_1_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
        JCus_1_1.setBounds(10, 150, 104, 14);
        panel_1.add(JCus_1_1);
        
        JLabel JCus_1_2 = new JLabel("Return Car");
        JCus_1_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	dispose();
        	ReturnPage r = new ReturnPage();
        	r.setName(namedata);
        	r.setVisible(true);
        	}
        });
        JCus_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        JCus_1_2.setForeground(Color.WHITE);
        JCus_1_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
        JCus_1_2.setBounds(10, 247, 104, 14);
        panel_1.add(JCus_1_2);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(124, 0, 793, 435);
        panel.add(panel_2);
        panel_2.setLayout(null);

        // Initialize the JTable with a DefaultTableModel
        Jtable = new JTable();
        JScrollPane ScrollPane = new JScrollPane(Jtable);
        ScrollPane.setBounds(10, 224, 773, 178);
        panel_2.add(ScrollPane);

        JLabel lblNewLabel_2 = new JLabel("Cars List");
        lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_2.setBounds(10, 199, 71, 14);
        panel_2.add(lblNewLabel_2);

        JLabel RegNum = new JLabel("Registration No");
        RegNum.setBounds(31, 40, 87, 14);
        panel_2.add(RegNum);

        JLabel lblBrand = new JLabel("Brand");
        lblBrand.setBounds(31, 74, 87, 14);
        panel_2.add(lblBrand);

        JLabel lblModel = new JLabel("Model");
        lblModel.setBounds(31, 113, 87, 14);
        panel_2.add(lblModel);

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setBounds(341, 40, 87, 14);
        panel_2.add(lblStatus);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(351, 87, 87, 14);
        panel_2.add(lblPrice);

        textField = new JTextField();
        textField.setBounds(128, 36, 188, 23);
        panel_2.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(128, 70, 188, 23);
        panel_2.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(128, 104, 188, 23);
        panel_2.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(448, 84, 164, 20);
        panel_2.add(textField_3);
        textField_3.setColumns(10);

        // Initialize comboBox
        String[] items = {"choice", "Booked", "Available"};
        comboBox = new JComboBox<>(items);  // Use the class variable
        comboBox.setBounds(464, 38, 124, 22);
        panel_2.add(comboBox);

        JButton savebtn = new JButton("Save");
        savebtn.addActionListener(e -> addCarToDatabase());
        savebtn.setBounds(105, 158, 89, 23);
        panel_2.add(savebtn);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(227, 158, 89, 23);
        btnUpdate.addActionListener(e -> updateCarInDatabase()); // Add action listener
        panel_2.add(btnUpdate);

        

        JButton delebtn = new JButton("Delete");
        delebtn.setBounds(339, 158, 89, 23);
        delebtn.addActionListener(e -> deleteCarFromDatabase()); // Add action listener
        panel_2.add(delebtn);

        JLabel lblNewLabel = new JLabel("Manage Vehicles");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
        lblNewLabel.setBounds(10, -4, 917, 28);
        contentPane.add(lblNewLabel);

        // Load data from database into JTable
        loadCarListData();
    }

    // Method to load car data from the database
    private void loadCarListData() {
        String[] columns = {"Reg_Id", "Brand", "Model", "Sta", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT Reg_Id, Brand, Model, Sta, Price FROM carlist")) {

            while (rs.next()) {
                String regId = rs.getString("Reg_Id");
                String brand = rs.getString("Brand");
                String model = rs.getString("Model");
                String sta = rs.getString("Sta");
                int price = rs.getInt("Price");

                Object[] row = {regId, brand, model, sta, price};
                tableModel.addRow(row);
            }

            Jtable.setModel(tableModel);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new car to the database
    private void addCarToDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO carlist (Reg_Id, Brand, Model, Sta, Price) VALUES (?, ?, ?, ?, ?)")) {

            // Set values from text fields and combo box
            pstmt.setString(1, textField.getText());
            pstmt.setString(2, textField_1.getText());
            pstmt.setString(3, textField_2.getText());
            pstmt.setString(4, comboBox.getSelectedItem().toString()); // Get selected status
            pstmt.setInt(5, Integer.parseInt(textField_3.getText()));

            // Execute the update (insert the data)
            pstmt.executeUpdate();

            // Show confirmation message
            JOptionPane.showMessageDialog(this, "Car added successfully!");

            // Clear fields after saving
            clearFields();

            // Reload data into the JTable
            loadCarListData();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while adding the car: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price must be a number.");
        }
    }

    // Method to clear the input fields
    private void clearFields() {
        textField.setText("");       // Clear Registration Number field
        textField_1.setText("");     // Clear Brand field
        textField_2.setText("");     // Clear Model field
        comboBox.setSelectedIndex(0); // Reset the combo box
        textField_3.setText("");     // Clear Price field
    }


 // Method to delete a car from the database
    private void deleteCarFromDatabase() {
        int selectedRow = Jtable.getSelectedRow(); // Get the selected row index

        if (selectedRow >= 0) { // Check if a row is selected
            String regId = Jtable.getValueAt(selectedRow, 0).toString(); // Get the Reg_Id from the selected row

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement("DELETE FROM carlist WHERE Reg_Id = ?")) {

                pstmt.setString(1, regId); // Set the registration ID for the query
                int rowsAffected = pstmt.executeUpdate(); // Execute the delete operation

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Car deleted successfully!");
                    loadCarListData(); // Reload the table data
                } else {
                    JOptionPane.showMessageDialog(this, "No car found with the given Registration ID.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while deleting the car: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a car to delete.");
        }
        clearFields();
    }   
    
 // Method to update a car in the database
    private void updateCarInDatabase() {
        int selectedRow = Jtable.getSelectedRow(); // Get the selected row index

        if (selectedRow >= 0) { // Check if a row is selected
            String regId = Jtable.getValueAt(selectedRow, 0).toString(); // Get the Reg_Id from the selected row

            // Get the updated values from the input fields
            String brand = textField_1.getText();
            String model = textField_2.getText();
            String status = comboBox.getSelectedItem().toString(); // Get selected status from the combo box
            int price = Integer.parseInt(textField_3.getText()); // Get price

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement("UPDATE carlist SET Brand = ?, Model = ?, Sta = ?, Price = ? WHERE Reg_Id = ?")) {

                // Set the values for the prepared statement
                pstmt.setString(1, brand);
                pstmt.setString(2, model);
                pstmt.setString(3, status);
                pstmt.setInt(4, price);
                pstmt.setString(5, regId); // Use the Reg_Id to identify which record to update

                int rowsAffected = pstmt.executeUpdate(); // Execute the update operation

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Car updated successfully!");
                    loadCarListData(); // Reload the table data
                } else {
                    JOptionPane.showMessageDialog(this, "No car found with the given Registration ID.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while updating the car: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a car to update.");
        }
        clearFields();
    }
}
