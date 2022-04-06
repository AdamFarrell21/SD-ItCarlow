import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer extends JFrame {
	
	

	/**
	 * 
	 */
	
	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField txtPasswordAndUsername;
	private JLabel lblEID;
	private JTextField textFieldEID;
	private JTextField textFieldName;
	private JLabel lblName;
	private JLabel lblSurname;
	private JTextField textFieldSurname;
	private JTextField textFieldAge;
	private JLabel lblAge;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblUsername;
	private JTextField textFieldUsername;
	private JLabel lblPassword;
	private JTextField textFieldPassword;
	private JTextField textField;
	private JLabel lblGender;
	private JTextField textField_1;
	private JLabel lblAge_1;
	private JLabel lblAge_2;
	private JTextField textField_2;
	/**
	 * Create the frame.
	 */
	public Customer() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Show Employee Table");
		btnLoadTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
						String query="select CustomerID,email,firstName,lastName,address,country,phone,gender,age from Customer";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						pst.close();
						rs.close();
						
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnLoadTable.setBounds(10, 407, 175, 29);
		contentPane.add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 632, 366);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblEID = new JLabel("CustomerID");
		lblEID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEID.setBounds(652, 53, 89, 14);
		contentPane.add(lblEID);
		
		textFieldEID = new JTextField();
		textFieldEID.setBounds(784, 48, 131, 29);
		contentPane.add(textFieldEID);
		textFieldEID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(784, 88, 131, 29);
		contentPane.add(textFieldName);
		
		lblName = new JLabel("Email");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(652, 93, 46, 14);
		contentPane.add(lblName);
		
		lblSurname = new JLabel("firstName");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSurname.setBounds(652, 133, 68, 14);
		contentPane.add(lblSurname);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(784, 128, 131, 29);
		contentPane.add(textFieldSurname);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(784, 173, 131, 29);
		contentPane.add(textFieldAge);
		
		lblAge = new JLabel("lastName");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAge.setBounds(652, 176, 89, 19);
		contentPane.add(lblAge);
		
		lblUsername = new JLabel("Address");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(652, 215, 68, 24);
		contentPane.add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(784, 213, 131, 29);
		contentPane.add(textFieldUsername);
		
		lblPassword = new JLabel("country");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(652, 253, 68, 25);
		contentPane.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(784, 253, 131, 29);
		contentPane.add(textFieldPassword);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(784, 293, 131, 29);
		contentPane.add(textField);
		
		lblGender = new JLabel("Phone");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGender.setBounds(652, 297, 68, 25);
		contentPane.add(lblGender);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(784, 333, 131, 29);
		contentPane.add(textField_1);
		
		lblAge_1 = new JLabel("Gender");
		lblAge_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAge_1.setBounds(652, 333, 68, 25);
		contentPane.add(lblAge_1);
		
		lblAge_2 = new JLabel("Age");
		lblAge_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAge_2.setBounds(652, 369, 68, 24);
		contentPane.add(lblAge_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(784, 373, 131, 29);
		contentPane.add(textField_2);
		
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="insert into Customer (CustomerID,email,firstName,lastName,address,country,phone,gender,age) values (?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldEID.getText ());
					pst.setString(2, textFieldName.getText ());
					pst.setString(3, textFieldSurname.getText ());
					pst.setString(4, textFieldAge.getText ());
					pst.setString(5, textFieldUsername.getText ());
					pst.setString(6, textFieldPassword.getText ());
					pst.setString(7, textField.getText ());
					pst.setString(8, textField_1.getText ());
					pst.setString(9, textField_2.getText ());
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");
					pst.close();
					
					
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			}
		});
		btnSave.setBounds(467, 427, 89, 23);
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="Update Customer set CustomerID = '"+textFieldEID.getText()+"' , email ='"+textFieldName.getText()+"' , firstName = '"+textFieldSurname.getText()+"' , lastName = '"+textFieldAge.getText()+"', address ='"+textFieldUsername.getText()+"' , country = '"+textFieldPassword.getText()+"' , phone = '"+textField.getText()+"', gender = '"+textField_1.getText()+"', age = '"+textField_2.getText()+"' where CustomerID = '"+textFieldEID.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		btnUpdate.setBounds(596, 427, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="delete from Customer where CustomerID='"+textFieldEID.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted");
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnDelete.setBounds(734, 427, 89, 23);
		contentPane.add(btnDelete);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 2, 923, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Open");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Employee");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
				
				Customer company = new Customer ();
				company.setVisible(true);
				
				
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Product");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Invoice");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		
	
		
		
	}
}
