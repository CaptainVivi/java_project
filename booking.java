package movie;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import java.sql.*;

public class booking extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JTextField jTextField4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booking frame = new booking();
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
	public booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton jButton1 = new JButton("View");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "HR", "hr");
				    Statement stmt = con.createStatement();
				    String q = "select name,number_of_seats,type from book";
				    ResultSet rs = stmt.executeQuery(q);
				    while (rs.next()) {
				        jTextField1.setText(rs.getString("name"));
				        jTextField2.setText(rs.getString("number_of_seats"));
				        jTextField3.setText(rs.getString("type"));
				        int s = Integer.parseInt(jTextField2.getText());
				        int d = Integer.parseInt(jTextField3.getText());
				        if (d == 0) {
				            int amt = 250;
				            int tot = amt * s;
				            jTextField4.setText("" + tot);
				        } else if (d == 1) {
				            int amt = 100;
				            int tot = amt * s;
				            jTextField4.setText("" + tot);
				        } else if (d == 2) {
				            int amt = 200;
				            int tot = amt * s;
				            jTextField4.setText("" + tot);
				        } else if (d == 3) {
				            int amt = 300;
				            int tot = amt * s;
				            jTextField4.setText("" + tot);
				        }
				    }
				} catch (Exception e1) {
				    JOptionPane.showMessageDialog(rootPane, e1.getMessage());
				}
			}
		});
		jButton1.setBounds(178, 211, 85, 21);
		contentPane.add(jButton1);
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(294, 45, 96, 19);
		contentPane.add(jTextField1);
		jTextField1.setColumns(10);
		
		jTextField2 = new JTextField();
		jTextField2.setBounds(294, 85, 96, 19);
		contentPane.add(jTextField2);
		jTextField2.setColumns(10);
		
		jTextField3 = new JTextField();
		jTextField3.setBounds(294, 125, 96, 19);
		contentPane.add(jTextField3);
		jTextField3.setColumns(10);
		
		jTextField4 = new JTextField();
		jTextField4.setBounds(294, 153, 96, 19);
		contentPane.add(jTextField4);
		jTextField4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Book Ticket");
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 30));
		lblNewLabel.setBounds(140, 10, 144, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(38, 48, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("No of seats");
		lblNewLabel_2.setBounds(38, 88, 97, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Seat Type");
		lblNewLabel_3.setBounds(38, 128, 59, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Amount");
		lblNewLabel_4.setBounds(38, 156, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JButton jButton2 = new JButton("Proceed to payment");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = jTextField1.getText();
			    int b = Integer.parseInt(jTextField2.getText());
			    int c = Integer.parseInt(jTextField3.getText());
			    double d = Double.parseDouble(jTextField4.getText());
			    try {
			        Class.forName("oracle.jdbc.driver.OracleDriver");
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "HR", "hr");
			        Statement stmt = con.createStatement();
			        String query = "insert into movie values('" + a + "'," + b + "," + c + "," + d + ");";
			        stmt.executeUpdate(query);
			        JOptionPane.showMessageDialog(rootPane, "SUCCESS!! PROCEED TO PAYMENT");
			        this.setVisible(false);
			        payment p = new payment();
			        p.setVisible(true);
			    } catch (Exception d11) {
			        JOptionPane.showMessageDialog(rootPane, d11.getMessage());
			    }
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}

			

			
		});
		jButton2.setBounds(10, 211, 125, 21);
		contentPane.add(jButton2);
		
		JButton jButton3 = new JButton("Back");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.setVisible(false);
				movies mv=new movies();
				mv.setVisible(true);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		jButton3.setBounds(293, 211, 85, 21);
		contentPane.add(jButton3);
	}

}

