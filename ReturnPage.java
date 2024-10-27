package bank;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ReturnPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField rid;
    private JTable Custable;
    private JComboBox<String> jComboBox;

    
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
   
   
    public ReturnPage() {

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
        	RentV v = new RentV();
        	v.setName(namedata);
        	v.setVisible(true);
        	dispose();
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

        JLabel lblPrice = new JLabel("Rental ID");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrice.setBounds(31, 40, 87, 14);
        panel_2.add(lblPrice);

        rid = new JTextField();
        rid.setBounds(128, 36, 188, 23);
        panel_2.add(rid);
        rid.setColumns(10);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		updateCarInDatabase();
        	}
        });
        btnUpdate.setBounds(183, 110, 133, 35);
      
        panel_2.add(btnUpdate);

        

        JButton delebtn = new JButton("Delete");
        delebtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deleteCarFromDatabase();	
        	}
        });
        delebtn.setBounds(456, 110, 126, 35);
      
        panel_2.add(delebtn);
        
        JLabel lblFees = new JLabel("Status");
        lblFees.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblFees.setBounds(440, 40, 87, 14);
        panel_2.add(lblFees);
        
        Custable = new JTable();
        Custable.setBackground(new Color(128, 255, 128));
        JScrollPane ScrollPane_1 = new JScrollPane(Custable);
        ScrollPane_1.setBounds(10, 224, 923, 354);
        panel_2.add(ScrollPane_1);
        
        JLabel lblNewLabel_2_1 = new JLabel("Car Return Dashborad");
        lblNewLabel_2_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_2_1.setBounds(363, 182, 137, 14);
        panel_2.add(lblNewLabel_2_1);
        
        String[] items = {"Status", "Return", "Not Return"};
        jComboBox = new JComboBox<>(items);
        jComboBox.setBounds(558, 36, 217, 22);
        panel_2.add(jComboBox);

        JLabel lblNewLabel = new JLabel("Cars Return Statis");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
        lblNewLabel.setBounds(10, -4, 1072, 28);
        contentPane.add(lblNewLabel);

        // Load data from database into JTable
   
        loadCarListData2();
    }



/// on rent table operations
    
    
    private void loadCarListData2() {
        String[] columns = {"Rent_ID","Reg_Id", "Customer_Name", "Rent_Date", "Return_Date", "Rent_Fees","Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, Regid, CusName, rentdate, returndate,rentfees,retrunstatus FROM Canrent")) {

            while (rs.next()) {
                String ID = rs.getString("id");
                String eid = rs.getString("Regid");
                String name = rs.getString("CusName");
                String rdate = rs.getString("rentdate");
                String ddate = rs.getString("returndate");
                int fees = rs.getInt("rentfees");
                String status = rs.getString("retrunstatus");

                Object[] row = {ID,eid, name, rdate, ddate, fees,status};
                tableModel.addRow(row);
            }

            Custable.setModel(tableModel);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void updateCarInDatabase() {
        int selectedRow = Custable.getSelectedRow(); // Get the selected row indexid
 
       
        if (selectedRow >= 0) { // Check if a row is selected
        	int regId = Integer.parseInt(Custable.getValueAt(selectedRow, 0).toString());



            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement("UPDATE Canrent SET retrunstatus=? WHERE id = ?")) {
            	
            	  String status = (jComboBox.getSelectedItem() != null) ? jComboBox.getSelectedItem().toString() : "";

                  pstmt.setString(1, status);
                pstmt.setInt(2, regId); // Use the Reg_Id to identify which record to update
                
                int rowsAffected = pstmt.executeUpdate(); // Execute the update operation

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Car updated successfully!");
                     // Reload the table data
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
    
        loadCarListData2();
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
                    loadCarListData2(); // Reload the table data
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
  
    private void clearFields() {
    	rid.setText("");       // Clear Registration Number field
    	
    }
}
