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

public class Invoice extends JFrame {
	
	

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
					Product frame = new Product();
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
	
	/**
	 * Create the frame.
	 */
	public Invoice() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Show Product Table");
		btnLoadTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
						String query="select ID,customerID,productID,quantity from Invoice";
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
		
		lblEID = new JLabel("ID");
		lblEID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEID.setBounds(652, 53, 89, 24);
		contentPane.add(lblEID);
		
		textFieldEID = new JTextField();
		textFieldEID.setBounds(784, 48, 131, 29);
		contentPane.add(textFieldEID);
		textFieldEID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(784, 88, 131, 29);
		contentPane.add(textFieldName);
		
		lblName = new JLabel("custoemrID");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(652, 93, 89, 24);
		contentPane.add(lblName);
		
		lblSurname = new JLabel("productID");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSurname.setBounds(652, 133, 89, 24);
		contentPane.add(lblSurname);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(784, 128, 131, 29);
		contentPane.add(textFieldSurname);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(784, 173, 131, 29);
		contentPane.add(textFieldAge);
		
		lblAge = new JLabel("quantity");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAge.setBounds(652, 176, 89, 26);
		contentPane.add(lblAge);
		
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="insert into Invoice (ID,customerID,productID,quantity) values (?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldEID.getText ());
					pst.setString(2, textFieldName.getText ());
					pst.setString(3, textFieldSurname.getText ());
					pst.setString(4, textFieldAge.getText ());
					
					
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
					String query="Update Invoice set ID = '"+textFieldEID.getText()+"' , customerID ='"+textFieldName.getText()+"' , productID = '"+textFieldSurname.getText()+"' , quantity = '"+textFieldAge.getText()+"' where ID = '"+textFieldEID.getText()+"' ";
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
					String query="delete from Invoice where ID='"+textFieldEID.getText()+"'";
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
				
				Employeeinfo employee = new Employeeinfo ();
				employee.setVisible(true);
				
				
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Customer");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Customer customer = new Customer ();
					customer.setVisible(true);
					
					
					
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Product");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {
					
					Product product = new Product ();
					product.setVisible(true);
					
					
					
					} catch (Exception e) {
						e.printStackTrace();
					}
				
			}
		});
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