package movie;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
public class wonder extends JFrame {

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
					wonder frame = new wonder();
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
	public wonder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Wonder");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 31));
		lblNewLabel.setBounds(146, 29, 138, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(55, 81, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("No of Seats");
		lblNewLabel_2.setBounds(55, 104, 69, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Seat type");
		lblNewLabel_3.setBounds(55, 133, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       
		        String a = jTextField1.getText();
		int b = Integer.parseInt(jTextField2.getText());
		JComboBox JComboBox1 = null;
		String c = (String)JComboBox1.getSelectedItem(); // Using getSelectedItem() instead of getSelectedIndex()
		try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "HR", "hr"); // Removed space after "HR"
		    Statement stmt = con.createStatement();
		    
		    String query = "INSERT INTO book VALUES('" + a + "'," + b + ",'" + c + "')"; // Fixed query construction
		    stmt.executeUpdate(query); // Removed quotes around query
		    
		    stmt.close();
		    con.close();
		    
		    JOptionPane.showMessageDialog(null, "Proceeding to Confirmation", "Confirm", JOptionPane.ERROR_MESSAGE);
		    this.setVisible(false);
		    booking fb = new booking();
		    fb.setVisible(true);
		} catch (Exception d) {
		    JOptionPane.showMessageDialog(rootPane, this, d.getMessage(), b, null);
		}
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBounds(315, 200, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.setVisible(false);
		        movies mv= new movies();
		        mv.setVisible(true);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_1.setBounds(10, 200, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JComboBox<?> jComboBox1 = new JComboBox();
		jComboBox1.setModel(new DefaultComboBoxModel(new String[] {"-selection-", "Gold", "Silver", "Platinum"}));
		jComboBox1.setBounds(315, 129, 85, 21);
		contentPane.add(jComboBox1);
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(304, 67, 96, 19);
		contentPane.add(jTextField1);
		jTextField1.setColumns(10);
		
		jTextField2 = new JTextField();
		jTextField2.setBounds(304, 101, 96, 19);
		contentPane.add(jTextField2);
		jTextField2.setColumns(10);
	}

}
