package movie;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class sseatle extends JFrame {

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
					sseatle frame = new sseatle();
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
	public sseatle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sleepless in Seatle");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 28));
		lblNewLabel.setBounds(118, 25, 199, 34);
		contentPane.add(lblNewLabel);
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(285, 84, 96, 19);
		contentPane.add(jTextField1);
		jTextField1.setColumns(10);
		
		jTextField2 = new JTextField();
		jTextField2.setBounds(285, 113, 96, 19);
		contentPane.add(jTextField2);
		jTextField2.setColumns(10);
		
		JComboBox jComboBox1 = new JComboBox();
		jComboBox1.setModel(new DefaultComboBoxModel(new String[] {"-selection-", "Gold", "Silver", "Platinum"}));
		jComboBox1.setBounds(285, 144, 96, 21);
		contentPane.add(jComboBox1);
		
		JButton jButton1 = new JButton("Book");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String a = jTextField1.getText();
		        int b = Integer.parseInt(jTextField2.getText());
		        String c = (String)jComboBox1.getSelectedItem(); // Using getSelectedItem() instead of getSelectedIndex()
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
		        } catch (Exception e1) {
		            JOptionPane.showMessageDialog(rootPane, this, e1.getMessage(), b);
		        }
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		jButton1.setBounds(296, 209, 85, 21);
		contentPane.add(jButton1);
		
		JButton jButton2 = new JButton("Back");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.setVisible(false);
		        movies mv= new movies();
		        mv.setVisible(true);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		jButton2.setBounds(33, 209, 85, 21);
		contentPane.add(jButton2);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(33, 87, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("No of seats");
		lblNewLabel_2.setBounds(33, 116, 69, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Seat type");
		lblNewLabel_3.setBounds(33, 152, 45, 13);
		contentPane.add(lblNewLabel_3);
	}

}
