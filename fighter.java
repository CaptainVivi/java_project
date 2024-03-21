package movie;

import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class fighter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTextField1;
	private JTextField jTextField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fighter frame = new fighter();
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
	public fighter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fighter");
		lblNewLabel.setFont(new Font("NSimSun", Font.BOLD, 28));
		lblNewLabel.setBounds(150, 10, 107, 34);
		contentPane.add(lblNewLabel);
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(306, 66, 96, 19);
		contentPane.add(jTextField1);
		jTextField1.setColumns(10);
		
		jTextField2 = new JTextField();
		jTextField2.setBounds(306, 114, 96, 19);
		contentPane.add(jTextField2);
		jTextField2.setColumns(10);
		
		JComboBox JComboBox1 = new JComboBox();
		JComboBox1.setModel(new DefaultComboBoxModel(new String[] {"-selection-", "Gold", "Silver", "Platinum"}));
		JComboBox1.setBounds(306, 156, 96, 21);
		contentPane.add(JComboBox1);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(43, 80, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("No of Seats");
		lblNewLabel_2.setBounds(43, 117, 85, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton jButton1 = new JButton("Book");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = jTextField1.getText();
				int b = Integer.parseInt(jTextField2.getText());
				String c = (String)JComboBox1.getSelectedItem(); // Using getSelectedItem() instead of getSelectedIndex()
				try {
				    Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","HR","hr"); // Removed space after "HR"
				    Statement stmt = con.createStatement();
				    
				    String query = "INSERT INTO book VALUES('" + a + "'," + b + ",'" + c + "')"; // Fixed query construction
				    System.out.println(query);
				    stmt.executeUpdate(query); // Removed quotes around query
				    
				    stmt.close();
				    con.close();
				    
				    JOptionPane.showMessageDialog(null, "Proceeding to Confirmation", "Confirm", JOptionPane.ERROR_MESSAGE);

				    this.setVisible(false);
				    booking fb = new booking();
				    fb.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}

			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
			
		});
		jButton1.setBounds(317, 232, 85, 21);
		contentPane.add(jButton1);
		
		JButton jButton2 = new JButton("Back");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movies mv=new movies();
				mv.setVisible(true);
			}
		});
		jButton2.setBounds(43, 232, 85, 21);
		contentPane.add(jButton2);
		
		JLabel lblNewLabel_3 = new JLabel("Seat type");
		lblNewLabel_3.setBounds(43, 160, 45, 13);
		contentPane.add(lblNewLabel_3);
	}
}
