package movie;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class movies extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					movies frame = new movies();
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
	public movies() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movies");
		lblNewLabel.setFont(new Font("Juice ITC", Font.BOLD, 45));
		lblNewLabel.setBounds(200, 29, 91, 54);
		contentPane.add(lblNewLabel);
		
		JRadioButton jRadioButton1 = new JRadioButton("Fighter");
		jRadioButton1.setBounds(62, 127, 103, 21);
		contentPane.add(jRadioButton1);
		
		JRadioButton jRadioButton2 = new JRadioButton("Wonder");
		jRadioButton2.setBounds(62, 162, 103, 21);
		contentPane.add(jRadioButton2);
		
		JRadioButton jRadioButton3 = new JRadioButton("Sleepless in Seatle");
		jRadioButton3.setBounds(62, 197, 134, 21);
		contentPane.add(jRadioButton3);
		
		JButton jButton1 = new JButton("Continue");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  if(jRadioButton1.isSelected()==true)
			        {
			            JOptionPane.showMessageDialog(rootPane,"You have selected Fighter");
			            this.setVisible(false);
			          fighter fg=new fighter();
			         fg.setVisible(true);
			        }
			        else if(jRadioButton2.isSelected()==true)
			        {
			            JOptionPane.showMessageDialog(rootPane,"You have selected Wonder");
			            this.setVisible(false);
			            wonder wn=new wonder();
			            wn.setVisible(true);
			        }
			        else if(jRadioButton3.isSelected()==true)
			        {
			            JOptionPane.showMessageDialog(rootPane,"You have selected Sleepless in Seatle");
			            this.setVisible(false);
	//		            sseatle ss=new sseatle();
	//		            ss.setVisible(true);
			        }
			      
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		jButton1.setBounds(212, 232, 85, 21);
		contentPane.add(jButton1);
		
		JButton jButton2 = new JButton("Back");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(jButton2, this);
		        this.setVisible(false);
		        Login lg = new Login();
		        lg.setVisible(true);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		jButton2.setBounds(68, 232, 85, 21);
		contentPane.add(jButton2);
		
		JButton jButton3 = new JButton("Exit");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jButton3.setBounds(341, 232, 85, 21);
		contentPane.add(jButton3);
	}
}
