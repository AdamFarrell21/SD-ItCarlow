 import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(162, 100, 90, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(162, 169, 90, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(303, 85, 226, 44);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					 String query="select * from EmployeeInfo where Username=? and password=? ";
					 PreparedStatement pst=connection.prepareStatement(query);
					 pst.setString(1, textField.getText() );
					 pst.setString(2, passwordField.getText() );
					 
					 ResultSet rs=pst.executeQuery();
					 int count =0;
					 while(rs.next()) {
						 count=count+1;
					 
					 }
					 if(count ==1)
					 {
						 JOptionPane.showMessageDialog(null, "Username and password is correct");
					 }
					 else if (count>1)
					 {
						 JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					 }
					 else {
						 JOptionPane.showMessageDialog(null, "Username and password is not correct Try Again...");
					 }
					 
				//	 rs.close();
				//	 pst.close();
				}catch(Exception e)
					 
				{
					JOptionPane.showMessageDialog(null, e);
					
			  
				}
			  
		 	}
		});
		btnLogin.setBounds(203, 279, 208, 44);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(303, 156, 226, 44);
		frame.getContentPane().add(passwordField);
	}
}
