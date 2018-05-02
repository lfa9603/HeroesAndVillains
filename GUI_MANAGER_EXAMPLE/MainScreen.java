import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MainScreen {

	private JFrame frmRocketManagerMain;
	private RocketManager manager;
//	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainScreen window = new MainScreen();
//					window.frmRocketManagerMain.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public MainScreen(RocketManager incomeManager) {
		
		manager = incomeManager;
		initialize();
		frmRocketManagerMain.setVisible(true);
	}
	
	public void closeWindow() {
		frmRocketManagerMain.dispose();
	}
	
	public void finishedWindow() {
		manager.closeMainScreen(this);
	}

	/**
	 * Create the application.
	 */
//	public MainScreen() {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRocketManagerMain = new JFrame();
		frmRocketManagerMain.setTitle("Rocket Manager Main Screen");
		frmRocketManagerMain.setBounds(100, 100, 761, 650);
		frmRocketManagerMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRocketManagerMain.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello StarMan!");
		lblNewLabel.setBounds(21, 21, 302, 44);
		frmRocketManagerMain.getContentPane().add(lblNewLabel);
		
		JToggleButton toggleButton_2 = new JToggleButton("");
		toggleButton_2.setBounds(249, 106, 207, 179);
		frmRocketManagerMain.getContentPane().add(toggleButton_2);
		
		JToggleButton toggleButton_1 = new JToggleButton("");
		toggleButton_1.setBounds(21, 106, 207, 179);
		frmRocketManagerMain.getContentPane().add(toggleButton_1);
		
		JToggleButton toggleButton_3 = new JToggleButton("");
		toggleButton_3.setBounds(477, 106, 207, 179);
		frmRocketManagerMain.getContentPane().add(toggleButton_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(21, 307, 207, 179);
		frmRocketManagerMain.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(21, 21, 58, 26);
		panel.add(lblName);
		
		JLabel lblFuel = new JLabel("Fuel:");
		lblFuel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFuel.setBounds(21, 55, 58, 26);
		panel.add(lblFuel);
		
		JLabel lblCleanliness = new JLabel("Cleanliness:");
		lblCleanliness.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCleanliness.setBounds(21, 91, 89, 26);
		panel.add(lblCleanliness);
		
		JLabel labelGiveName = new JLabel("");
		labelGiveName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelGiveName.setBounds(76, 21, 58, 26);
		panel.add(labelGiveName);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(67, 55, 98, 26);
		panel.add(label);
		
		JLabel label_1labelCleanlinessToGive = new JLabel("");
		label_1labelCleanlinessToGive.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1labelCleanlinessToGive.setBounds(117, 90, 69, 26);
		panel.add(label_1labelCleanlinessToGive);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(249, 307, 207, 179);
		frmRocketManagerMain.getContentPane().add(panel_1);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(21, 21, 58, 26);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Fuel:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(21, 55, 58, 26);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Cleanliness:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_3.setBounds(21, 91, 89, 26);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_4.setBounds(76, 21, 58, 26);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_5.setBounds(67, 55, 98, 26);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_6.setBounds(117, 90, 69, 26);
		panel_1.add(label_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(477, 307, 207, 179);
		frmRocketManagerMain.getContentPane().add(panel_2);
		
		JLabel label_7 = new JLabel("Name:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_7.setBounds(21, 21, 58, 26);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Fuel:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_8.setBounds(21, 55, 58, 26);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Cleanliness:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_9.setBounds(21, 91, 89, 26);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_10.setBounds(76, 21, 58, 26);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_11.setBounds(67, 55, 98, 26);
		panel_2.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_12.setBounds(117, 90, 69, 26);
		panel_2.add(label_12);
		
		JButton btnCleanRocket = new JButton("Clean Rocket");
		btnCleanRocket.setBounds(21, 508, 207, 35);
		frmRocketManagerMain.getContentPane().add(btnCleanRocket);
		
		JButton btnRefuelrocket = new JButton("Refuel Rocket");
		btnRefuelrocket.setBounds(249, 508, 207, 35);
		frmRocketManagerMain.getContentPane().add(btnRefuelrocket);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(477, 508, 207, 35);
		frmRocketManagerMain.getContentPane().add(btnQuit);
		
		btnQuit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				
			}
		});
	}

}
