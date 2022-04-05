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

public class Employeeinfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employeeinfo frame = new Employeeinfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField txtPasswordAndUsername;
	private JLabel lblNewLabel;
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
	/**
	 * Create the frame.
	 */
	public Employeeinfo() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Show Employee Table");
		btnLoadTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
						String query="select EID,name,surname,age from EmployeeInfo";
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
		btnLoadTable.setBounds(10, 351, 175, 29);
		contentPane.add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 443, 306);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtPasswordAndUsername = new JTextField();
		txtPasswordAndUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPasswordAndUsername.setText("      Password and Username not shown Above for privacy reasons");
		txtPasswordAndUsername.setBounds(186, 401, 408, 29);
		contentPane.add(txtPasswordAndUsername);
		txtPasswordAndUsername.setColumns(10);
		
		lblNewLabel = new JLabel("Note");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(134, 398, 68, 29);
		contentPane.add(lblNewLabel);
		
		lblEID = new JLabel("EID");
		lblEID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEID.setBounds(485, 10, 46, 14);
		contentPane.add(lblEID);
		
		textFieldEID = new JTextField();
		textFieldEID.setBounds(463, 24, 131, 29);
		contentPane.add(textFieldEID);
		textFieldEID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(463, 78, 131, 29);
		contentPane.add(textFieldName);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(485, 64, 46, 14);
		contentPane.add(lblName);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSurname.setBounds(485, 118, 68, 14);
		contentPane.add(lblSurname);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(463, 133, 131, 29);
		contentPane.add(textFieldSurname);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(463, 192, 131, 29);
		contentPane.add(textFieldAge);
		
		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAge.setBounds(485, 173, 46, 19);
		contentPane.add(lblAge);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(485, 232, 68, 14);
		contentPane.add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(463, 249, 131, 29);
		contentPane.add(textFieldUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(485, 289, 68, 14);
		contentPane.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(463, 311, 131, 29);
		contentPane.add(textFieldPassword);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="insert into EmployeeInfo (EID,name,username,password,surname,age) values (?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldEID.getText ());
					pst.setString(2, textFieldName.getText ());
					pst.setString(3, textFieldUsername.getText ());
					pst.setString(4, textFieldPassword.getText ());
					pst.setString(5, textFieldSurname.getText ());
					pst.setString(6, textFieldAge.getText ());
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");
					pst.close();
					
					
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			}
		});
		btnSave.setBounds(200, 374, 89, 23);
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="Update EmployeeInfo set EID = '"+textFieldEID.getText()+"' , name ='"+textFieldName.getText()+"' , surname = '"+textFieldSurname.getText()+"' , age = '"+textFieldAge.getText()+"' where EID = '"+textFieldEID.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		btnUpdate.setBounds(327, 374, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="delete from EmployeeInfo where EID='"+textFieldEID.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted");
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnDelete.setBounds(447, 374, 89, 23);
		contentPane.add(btnDelete);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 443, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Open");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Company");
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
