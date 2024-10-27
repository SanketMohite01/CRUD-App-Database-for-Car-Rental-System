package bank;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Customer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable Jtable;
    private JTextField cid;
    private JTextField cadd;
    private JTextField ccon;
    private JTextField cname;

    // JDBC details
    static final String DB_URL = "jdbc:mysql://localhost:3306/crudapp";
    static final String USER = "root";
    static final String PASS = "abhijeet@2002";

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

    public Customer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 953, 495);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 21, 917, 435);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
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
        	RentV v =new RentV();
        	v.setName(namedata);
        	dispose();
        	v.setVisible(true);
        	}
        });
        lblRentCar.setForeground(new Color(255, 255, 255));
        lblRentCar.setHorizontalAlignment(SwingConstants.CENTER);
        lblRentCar.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
        lblRentCar.setBounds(10, 196, 104, 14);
        panel_1.add(lblRentCar);
        
        JLabel JCus_1_1 = new JLabel("Cars");
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

        JLabel RegNum = new JLabel("Customer Id");
        RegNum.setBounds(31, 40, 87, 14);
        panel_2.add(RegNum);

        JLabel lblBrand = new JLabel("Customer Address");
        lblBrand.setHorizontalAlignment(SwingConstants.CENTER);
        lblBrand.setBounds(10, 91, 118, 14);
        panel_2.add(lblBrand);

        JLabel lblModel = new JLabel("Customer Phone");
        lblModel.setBounds(326, 91, 105, 14);
        panel_2.add(lblModel);

        JLabel lblPrice = new JLabel("Customer Name");
        lblPrice.setBounds(326, 40, 105, 14);
        panel_2.add(lblPrice);

        cid = new JTextField();
        cid.setBounds(128, 36, 188, 23);
        panel_2.add(cid);
        cid.setColumns(10);

        cadd = new JTextField();
        cadd.setBounds(128, 87, 188, 23);
        panel_2.add(cadd);
        cadd.setColumns(10);

        ccon = new JTextField();
        ccon.setBounds(441, 87, 188, 23);
        panel_2.add(ccon);
        ccon.setColumns(10);

        cname = new JTextField();
        cname.setBounds(443, 37, 186, 20);
        panel_2.add(cname);
        cname.setColumns(10);

        // Initialize comboBox
      
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

        JLabel lblNewLabel = new JLabel("Manage Customer");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
        lblNewLabel.setBounds(10, -4, 917, 28);
        contentPane.add(lblNewLabel);

        // Load data from database into JTable
        loadCarListData();
    }

    // Method to load car data from the database
    private void loadCarListData() {
        String[] columns = {"Customer_ID", "Customer_Name", "Customer_Address", "Customer_Contact"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT Cus_Id, Cust_Name, Cus_address, Cus_Contact FROM Customers")) {

            while (rs.next()) {
               
                String name = rs.getString("Cust_Name");
                String address = rs.getString("Cus_address");
                String constact = rs.getString("Cus_Contact");
                int Cusid = rs.getInt("Cus_Id");

                Object[] row = {Cusid, name, address, constact};
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
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Customers(Cus_Id, Cust_Name, Cus_address, Cus_Contact) VALUES ( ?, ?, ?, ?)")) {

        	
            // Set values from text fields and combo box
        	    pstmt.setInt(1, Integer.parseInt(cid.getText()));
            pstmt.setString(2, cname.getText());
            pstmt.setString(3, cadd.getText());
            pstmt.setString(4, ccon.getText());

            // Execute the update (insert the data)
            pstmt.executeUpdate();

            // Show confirmation message
            JOptionPane.showMessageDialog(this, "Customer added successfully!");

            // Clear fields after saving
            clearFields();

            // Reload data into the JTable
            loadCarListData();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while adding the Customer: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Contact must be a number.");
        }
    }

    // Method to clear the input fields
    private void clearFields() {
        cid.setText("");       // Clear Registration Number field
        cadd.setText("");     // Clear Brand field
        ccon.setText("");
        cname.setText("");     // Clear Price field
    }


 // Method to delete a car from the database
    private void deleteCarFromDatabase() {
        int selectedRow = Jtable.getSelectedRow(); // Get the selected row index

        if (selectedRow >= 0) { // Check if a row is selected
            // Get the Cus_Id from the selected row and convert it to an integer
            int regId = Integer.parseInt(Jtable.getValueAt(selectedRow, 0).toString());

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Customers WHERE Cus_Id = ?")) {

                pstmt.setInt(1, regId); // Set the integer registration ID for the query
                int rowsAffected = pstmt.executeUpdate(); // Execute the delete operation

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Customer deleted successfully!");
                    loadCarListData(); // Reload the table data
                } else {
                    JOptionPane.showMessageDialog(this, "No Customer found with the given Registration ID.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while deleting the Customer: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Customer Id to delete.");
        }
        clearFields();
    }
 // Method to update a car in the database
    private void updateCarInDatabase() {
        int selectedRow = Jtable.getSelectedRow(); // Get the selected row index
 
        if (selectedRow >= 0) { // Check if a row is selected
        	int regId = Integer.parseInt(Jtable.getValueAt(selectedRow, 0).toString());

//            private JTextField cadd;
//            private JTextField ccon;
//            private JTextField cname;

            // Get the updated values from the input fields
            String name = cname.getText();
            String contact = ccon.getText();
            String address = cadd.getText();
           


            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement("UPDATE Customers SET Cust_Name = ?,  Cus_address= ?,  Cus_Contact = ? WHERE Cus_Id = ?")) {

                // Set the values for the prepared statement
                pstmt.setString(1, name);
                pstmt.setString(2, address);
                
                pstmt.setString(3, contact);
                pstmt.setInt(4, regId); // Use the Reg_Id to identify which record to update

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
