package movie;
import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Login {

	private JFrame frame;
	private JTextField JTextField1;
	private JPasswordField JPasswordField1;

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

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(680,395);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Juice ITC", Font.BOLD, 50));
		lblNewLabel.setBounds(151, 15, 134, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JTextField1 = new JTextField();
		JTextField1.setBounds(279, 74, 96, 19);
		frame.getContentPane().add(JTextField1);
		JTextField1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(73, 77, 59, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(73, 118, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton b2 = new JButton("Exit");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(b2, this,"Do you want to exit?", 0);
		        System.exit(0);
			}
		});
		b2.setBounds(47, 198, 85, 21);
		frame.getContentPane().add(b2);
		
		JButton b1 = new JButton("Login");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=JTextField1.getText();
		        String p= new String(JPasswordField1.getPassword());
		        if(name.equals("danny234")&&p.equals("shadowhunters"))    
		        {
		            JOptionPane.showMessageDialog(b1, this, "Welcome", 0);
		            this.setVisible(false);
		            movies mv = new movies();
		            mv.setVisible(true);
		        } 
		        else
		        {
		            JOptionPane.showMessageDialog(null, "Invalid user");
		        }
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		b1.setBounds(300, 198, 85, 21);
		frame.getContentPane().add(b1);
		
		JPasswordField1 = new JPasswordField();
		JPasswordField1.setBounds(278, 115, 97, 19);
		frame.getContentPane().add(JPasswordField1);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
