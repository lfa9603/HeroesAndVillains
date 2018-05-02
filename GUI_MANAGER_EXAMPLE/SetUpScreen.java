import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import javax.swing.JButton;

public class SetUpScreen {

	private JFrame frame;
	private JTextField textField;
	private RocketManager manager;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SetUpScreen window = new SetUpScreen();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public SetUpScreen(RocketManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeSetUpScreen(this);
	}
	
//	/**
//	 * Create the application.
//	 */
//	public SetUpScreen() {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 915, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Rocket Manager!");
		lblNewLabel.setBounds(21, 44, 278, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("What's your name?");
		lblNewLabel_1.setBounds(21, 101, 264, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(429, 98, 331, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("How many rockets do you want?");
		lblNewLabel_2.setBounds(21, 173, 336, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSlider slider = new JSlider();
		slider.setValue(3);
		slider.setMinimum(1);
		slider.setMaximum(3);
		slider.setBounds(429, 173, 331, 26);
		frame.getContentPane().add(slider);
		
		JToggleButton rocket1Button = new JToggleButton("Rocket 1");
		rocket1Button.setBounds(21, 260, 125, 96);
		frame.getContentPane().add(rocket1Button);
		
		JToggleButton rocket2Button = new JToggleButton("Rocket 2");
		rocket2Button.setBounds(167, 260, 125, 96);
		frame.getContentPane().add(rocket2Button);
		
		JToggleButton rocket3Button = new JToggleButton("Rocket 3");
		rocket3Button.setBounds(313, 260, 125, 96);
		frame.getContentPane().add(rocket3Button);
		
		JToggleButton rocket4Button = new JToggleButton("Rocket 4");
		rocket4Button.setBounds(21, 377, 125, 96);
		frame.getContentPane().add(rocket4Button);
		
		JToggleButton rocket5Button = new JToggleButton("Rocket 5");
		rocket5Button.setBounds(167, 377, 125, 96);
		frame.getContentPane().add(rocket5Button);
		
		JToggleButton rocket6Button = new JToggleButton("Rocket 6");
		rocket6Button.setBounds(313, 377, 125, 96);
		frame.getContentPane().add(rocket6Button);
		
		JLabel lblSelectedRockets = new JLabel("Selected Rockets");
		lblSelectedRockets.setBounds(21, 494, 165, 26);
		frame.getContentPane().add(lblSelectedRockets);
		
		JToggleButton toggleButtonSelectedRocket1 = new JToggleButton("");
		toggleButtonSelectedRocket1.setBounds(207, 503, 130, 60);
		frame.getContentPane().add(toggleButtonSelectedRocket1);
		
		JToggleButton toggleButtonSelectedRocket2 = new JToggleButton("");
		toggleButtonSelectedRocket2.setBounds(346, 503, 130, 60);
		frame.getContentPane().add(toggleButtonSelectedRocket2);
		
		JToggleButton toggleButtonSelectedRocket3 = new JToggleButton("");
		toggleButtonSelectedRocket3.setBounds(485, 503, 130, 60);
		frame.getContentPane().add(toggleButtonSelectedRocket3);
		
		JPanel panel = new JPanel();
		panel.setBounds(493, 232, 375, 241);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(187, 5, 0, 0);
		panel.add(label);
		
		JLabel lblRocketStats = new JLabel("Rocket Stats");
		lblRocketStats.setBounds(127, 21, 129, 26);
		panel.add(lblRocketStats);
		
		JLabel constantNameLabel = new JLabel("Name");
		constantNameLabel.setBounds(21, 62, 92, 26);
		panel.add(constantNameLabel);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(137, 62, 217, 26);
		panel.add(nameLabel);
		
		JLabel fuelConstantLabel = new JLabel("Fuel");
		fuelConstantLabel.setBounds(21, 104, 92, 26);
		panel.add(fuelConstantLabel);
		
		JLabel fuelLabel = new JLabel("");
		fuelLabel.setBounds(135, 104, 92, 26);
		panel.add(fuelLabel);
		
		JLabel labelCleanlinessConstant = new JLabel("Cleanliness");
		labelCleanlinessConstant.setBounds(21, 161, 103, 26);
		panel.add(labelCleanlinessConstant);
		
		JLabel labelCleanliness = new JLabel("");
		labelCleanliness.setBounds(137, 161, 203, 26);
		panel.add(labelCleanliness);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(681, 512, 141, 35);
		frame.getContentPane().add(btnAccept);
		
		btnAccept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
	}
}
