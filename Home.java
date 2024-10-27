package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.Authentication;
import Database.Employee;
import Database.EmployeeDAO;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UName;
	private JPasswordField JPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 429);
		 setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 11, 255, 369);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 36, 235, 28);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.ITALIC, 30));
		panel.add(lblNewLabel);
		
		JLabel lblCarRentSystem = new JLabel("Car Rent System");
		lblCarRentSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarRentSystem.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
		lblCarRentSystem.setBounds(10, 224, 235, 28);
		panel.add(lblCarRentSystem);
		
		JLabel Jlogo = new JLabel("");
		Jlogo.setIcon(new ImageIcon(Home.class.getResource("/Images/car.PNG")));
		Jlogo.setBounds(-45, 98, 334, 113);
		panel.add(Jlogo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(275, 11, 350, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Jlogin = new JLabel("Log In");
		Jlogin.setHorizontalAlignment(SwingConstants.CENTER);
		Jlogin.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 31));
		Jlogin.setBounds(65, 43, 235, 46);
		panel_1.add(Jlogin);
		
		JLabel JUsername = new JLabel("UserName : ");
		JUsername.setHorizontalAlignment(SwingConstants.CENTER);
		JUsername.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
		JUsername.setBounds(10, 135, 121, 28);
		panel_1.add(JUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
		lblPassword.setBounds(10, 194, 121, 28);
		panel_1.add(lblPassword);
		
		Authentication auth = new Authentication(); 	
		 JButton Submitbtn = new JButton("Submit");
		 Submitbtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String Iname = UName.getText();
	                char[] password = JPass.getPassword(); // Get password (as char array)
	                String passwordString = new String(password);
	                
	                // Create an instance of EmployeeDAO
	                EmployeeDAO employeeDAO = new EmployeeDAO();
	                
	                boolean isAuthenticated = employeeDAO.loginAuthentication(Iname, passwordString); // Ensure this method exists
	                
	                String name = Iname;
	                if (isAuthenticated) {
	                    // Close the current frame
	                  //  System.out.print(name);
	                    // Open the new welcome frame
	                    dashboard ds = new dashboard();
	                    ds.setName(name);
	                    dispose();
	                    
	                    
	                    ds.setVisible(true);
	                } else {
	                    // Handle invalid login
	                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
	                    UName.setText("");
	                   JPass.setText("");
	                }

	                // Optionally, retrieve all employees and display them (for admin use)
	               
	            }
	        });
		Submitbtn.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		Submitbtn.setBounds(40, 266, 280, 46);
		panel_1.add(Submitbtn);
		
		UName = new JTextField();
		UName.setBounds(127, 135, 193, 28);
		panel_1.add(UName);
		UName.setColumns(10);
		
		JPass = new JPasswordField();
		JPass.setBounds(127, 194, 193, 28);
		panel_1.add(JPass);
	}
}
