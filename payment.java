package movie;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
public class payment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JPasswordField jPasswordField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment frame = new payment();
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
	public payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payment");
		lblNewLabel.setFont(new Font("Juice ITC", Font.BOLD, 49));
		lblNewLabel.setBounds(113, 10, 164, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bank");
		lblNewLabel_1.setBounds(41, 72, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cust Name");
		lblNewLabel_2.setBounds(41, 114, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("A/c No");
		lblNewLabel_3.setBounds(41, 150, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(41, 189, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(243, 111, 96, 19);
		contentPane.add(jTextField1);
		jTextField1.setColumns(10);
		
		jTextField2 = new JTextField();
		jTextField2.setBounds(243, 147, 96, 19);
		contentPane.add(jTextField2);
		jTextField2.setColumns(10);
		
		JButton jButton1 = new JButton("Pay");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox jComboBox1 = null;
				String a = String.valueOf(jComboBox1.getSelectedIndex());
				String b = jTextField1.getText();
				double c = Double.parseDouble(jTextField2.getText());
				char[] d = jPasswordField1.getPassword();
				try {
				    Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "HR", "hr");
				    Statement stmt = con.createStatement();
				    String query = "insert into amount values('" + a + "','" + b + "'," + c + ",'" + String.valueOf(d) + "')";
				    stmt.executeUpdate(query);
				    JOptionPane.showMessageDialog(rootPane, this, "Successfully reserved", getState(), null);
				    movies mv=new movies();
				    mv.setVisible(true);
				} catch (Exception e1) {
				    JOptionPane.showMessageDialog(rootPane, this, e1.getMessage(), getDefaultCloseOperation());
				}
			}
		});
		jButton1.setBounds(303, 232, 85, 21);
		contentPane.add(jButton1);
		
		JButton jButton2 = new JButton("Back");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, this);
		        this.setVisible(false);
		        booking bk=new booking();
		        bk.setVisible(true);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		jButton2.setBounds(20, 232, 85, 21);
		contentPane.add(jButton2);
		
		JComboBox jComboBox1 = new JComboBox();
		jComboBox1.setModel(new DefaultComboBoxModel(new String[] {"---select---", "sbi", "icici", "federal", "vijaya", "bank of baroda"}));
		jComboBox1.setBounds(243, 68, 96, 21);
		contentPane.add(jComboBox1);
		
		jPasswordField1 = new JPasswordField();
		jPasswordField1.setBounds(243, 186, 96, 19);
		contentPane.add(jPasswordField1);
	}

}
