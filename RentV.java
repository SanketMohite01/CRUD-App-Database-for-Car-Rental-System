package bank;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RentV extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable Jtable;
    private JTextField rid;
    private JTextField regid;
    private JTextField sdate;
    private JTextField rentcust;
    private JTextField rdate;
    private JTextField rfees;
    private JTable Custable;

    
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
   
   
    public RentV() {

    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1108, 648);

        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 21, 1082, 588);
        contentPane.add(panel);
        panel.setLayout(null);

        panel_1.setBackground(Color.RED);
        panel_1.setBounds(0, -21, 124, 610);
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
        	new RentV();
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
        	r.setVisible(true);
        	}
        });
        JCus_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        JCus_1_2.setForeground(Color.WHITE);
        JCus_1_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
        JCus_1_2.setBounds(10, 247, 104, 14);
        panel_1.add(JCus_1_2);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(124, 0, 958, 589);
        panel.add(panel_2);
        panel_2.setLayout(null);

        // Initialize the JTable with a DefaultTableModel
        Jtable = new JTable();
        JScrollPane ScrollPane = new JScrollPane(Jtable);
        ScrollPane.setBounds(10, 192, 923, 178);
        panel_2.add(ScrollPane);

        JLabel lblNewLabel_2 = new JLabel("Cars List");
        lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_2.setBounds(10, 167, 71, 14);
        panel_2.add(lblNewLabel_2);

        JLabel RegNum = new JLabel("Registration No");
        RegNum.setBounds(342, 40, 87, 14);
        panel_2.add(RegNum);

        JLabel lblModel = new JLabel("Rent Date");
        lblModel.setBounds(31, 88, 87, 14);
        panel_2.add(lblModel);

        JLabel lblPrice = new JLabel("Rental ID");
        lblPrice.setBounds(31, 40, 87, 14);
        panel_2.add(lblPrice);

        rid = new JTextField();
        rid.setBounds(128, 36, 188, 23);
        panel_2.add(rid);
        rid.setColumns(10);

        regid = new JTextField();
        regid.setBounds(439, 36, 188, 23);
        panel_2.add(regid);
        regid.setColumns(10);

        sdate = new JTextField();
        sdate.setBounds(128, 84, 188, 23);
        panel_2.add(sdate);
        sdate.setColumns(10);

      
        JButton savebtn = new JButton("Save");
        savebtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		addCarToDatabase2();
        	}
        });
       
        savebtn.setBounds(273, 137, 118, 23);
        panel_2.add(savebtn);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		updateCarInDatabase();
        	}
        });
        btnUpdate.setBounds(439, 137, 118, 23);
      
        panel_2.add(btnUpdate);

        

        JButton delebtn = new JButton("Delete");
        delebtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deleteCarFromDatabase();
        	}
        });
        delebtn.setBounds(617, 137, 107, 23);
      
        panel_2.add(delebtn);
        
        rentcust = new JTextField();
        rentcust.setText("");
        rentcust.setColumns(10);
        rentcust.setBounds(734, 36, 188, 23);
        panel_2.add(rentcust);
        
        JLabel lblCustomerName = new JLabel("Customer Name");
        lblCustomerName.setBounds(637, 40, 87, 14);
        panel_2.add(lblCustomerName);
        
        rdate = new JTextField();
        rdate.setText("");
        rdate.setColumns(10);
        rdate.setBounds(439, 84, 188, 23);
        panel_2.add(rdate);
        
        JLabel lblReturnDate = new JLabel("Return Date");
        lblReturnDate.setBounds(341, 88, 87, 14);
        panel_2.add(lblReturnDate);
        
        rfees = new JTextField();
        rfees.setText("");
        rfees.setColumns(10);
        rfees.setBounds(734, 85, 188, 23);
        panel_2.add(rfees);
        
        JLabel lblFees = new JLabel("Fees");
        lblFees.setBounds(637, 88, 87, 14);
        panel_2.add(lblFees);
        
        Custable = new JTable();
        Custable.setBackground(new Color(128, 255, 128));
        JScrollPane ScrollPane_1 = new JScrollPane(Custable);
        ScrollPane_1.setBounds(10, 400, 923, 178);
        panel_2.add(ScrollPane_1);
        
        JLabel lblNewLabel_2_1 = new JLabel("Cars On Rent");
        lblNewLabel_2_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_2_1.setBounds(10, 381, 137, 14);
        panel_2.add(lblNewLabel_2_1);

        JLabel lblNewLabel = new JLabel("Cars Rental");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
        lblNewLabel.setBounds(10, -4, 1072, 28);
        contentPane.add(lblNewLabel);

        // Load data from database into JTable
        loadCarListData();
        loadCarListData2();
    }

    // Method to load car data from the database
    private void loadCarListData() {
        String[] columns = {"Reg_Id", "Brand", "Model", "Status", "Price"};
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
            pstmt.setString(1, rid.getText());
            pstmt.setString(2, regid.getText());
            pstmt.setString(3, sdate.getText());

            // Execute the update (insert the data)
            pstmt.executeUpdate();

            // Show confirmation message
            JOptionPane.showMessageDialog(this, "Car added successfully!");

           

            // Reload data into the JTable
            loadCarListData();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while adding the car: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price must be a number.");
        }
    }


/// on rent table operations
    
    
    private void loadCarListData2() {
        String[] columns = {"Rent_ID","Reg_Id", "Customer_Name", "Rent_Date", "Return_Date", "Rent_Fees"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, Regid, CusName, rentdate, returndate,rentfees FROM Canrent")) {

            while (rs.next()) {
                String ID = rs.getString("id");
                String eid = rs.getString("Regid");
                String name = rs.getString("CusName");
                String rdate = rs.getString("rentdate");
                String ddate = rs.getString("returndate");
                int fees = rs.getInt("rentfees");

                Object[] row = {ID,eid, name, rdate, ddate, fees};
                tableModel.addRow(row);
            }

            Custable.setModel(tableModel);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    ///adding car is on rent data into table 
    
    private void addCarToDatabase2() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Canrent (id, Regid, CusName, rentdate, returndate,rentfees) VALUES (?, ?,?, ?, ?, ?)")) {
        	 
        	
            // Set values from text fields and combo box
        	pstmt.setInt(1, Integer.parseInt(rid.getText()));
            pstmt.setString(2, regid.getText());
            pstmt.setString(3, rentcust.getText());
            pstmt.setString(4, sdate.getText());
            pstmt.setString(5, rdate.getText());
            pstmt.setString(6, rfees.getText());
           

            // Execute the update (insert the data)
            pstmt.executeUpdate();

            // Show confirmation message
            JOptionPane.showMessageDialog(this, "Car Rent detail added successfully!");

            // Clear fields after saving
            clearFields();

            // Reload data into the JTable
            loadCarListData2();

        } catch (SQLException e) {
        	
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while adding the car: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price must be a number.");
        }
    }
    
    private void deleteCarFromDatabase() {
        int selectedRow = Custable.getSelectedRow(); // Get the selected row index

        if (selectedRow >= 0) { // Check if a row is selected
            // Get the Cus_Id from the selected row and convert it to an integer
            int regId = Integer.parseInt(Custable.getValueAt(selectedRow, 0).toString());

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Canrent WHERE id = ?")) {

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
        loadCarListData2();
     

        }
    
    private void updateCarInDatabase() {
        int selectedRow = Custable.getSelectedRow(); // Get the selected row indexid
 
        if (selectedRow >= 0) { // Check if a row is selected
        	int regId = Integer.parseInt(Custable.getValueAt(selectedRow, 0).toString());



            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement("UPDATE Canrent SET Regid = ?,  CusName= ?,  rentdate = ?,returndate=?,rentfees=? WHERE id = ?")) {
            	String rid = regid.getText();
            	String rcust = rentcust.getText();
            	String sd = sdate.getText();
            	String rd = rdate.getText();
            	
            	pstmt.setString(1, rid);
                pstmt.setString(2,rcust);
                
                pstmt.setString(3, sd);
                pstmt.setString(4, rd);
              
                pstmt.setInt(5, Integer.parseInt(rfees.getText()));
                pstmt.setInt(6, regId); // Use the Reg_Id to identify which record to update
                
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
        loadCarListData2();
    }    
    
    
    private void clearFields() {
    	rid.setText("");       // Clear Registration Number field
    	regid.setText("");     // Clear Brand field
    	sdate.setText(""); 
    	rdate.setText("");// Clear Model field
    	rfees.setText("");
    	rentcust.setText("");
    	rentcust.setText("");     // Clear Price field
    	// Reset the combo box
    }
}
