package setupGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import city.City;
import city.WorldBuilder;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class setupTeamAndWorld {

	private JFrame TeamAndWorldSetup;
	private static SetupManager manager;
	private JTextField textField;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					setupTeamAndWorld window = new setupTeamAndWorld();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public setupTeamAndWorld(SetupManager incomingManager) {
		manager = incomingManager;
		initialize();
		TeamAndWorldSetup.setVisible(true);
	}
	
	public void closeWindow() {
		TeamAndWorldSetup.dispose();
	}
	
	public void finishedWindow() {
		manager.closeSetupTeamAndWorld(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TeamAndWorldSetup = new JFrame();
		TeamAndWorldSetup.setBounds(100, 100, 703, 421);
		TeamAndWorldSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TeamAndWorldSetup.getContentPane().setLayout(null);
		
		JLabel lblSetup = new JLabel("Setup");
		lblSetup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetup.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblSetup.setBounds(10, 11, 572, 49);
		TeamAndWorldSetup.getContentPane().add(lblSetup);
		
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(1);
		slider.setToolTipText("Slide to select number of cities");
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinimum(3);
		slider.setMaximum(6);
		slider.setSnapToTicks(true);
		slider.setBounds(312, 72, 343, 49);
		TeamAndWorldSetup.getContentPane().add(slider);
		
		JLabel lblNewLabel = new JLabel("Number of cities to explore:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(40, 71, 230, 50);
		TeamAndWorldSetup.getContentPane().add(lblNewLabel);
		
		JLabel lblSelectTheName = new JLabel("Select the name of your Team:");
		lblSelectTheName.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectTheName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectTheName.setBounds(40, 204, 257, 50);
		TeamAndWorldSetup.getContentPane().add(lblSelectTheName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setToolTipText("Type in the name of your team");
		textField.setBounds(312, 204, 343, 50);
		TeamAndWorldSetup.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel TeamNameConfirmation = new JLabel("");
		TeamNameConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		TeamNameConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TeamNameConfirmation.setBounds(139, 265, 383, 24);
		TeamAndWorldSetup.getContentPane().add(TeamNameConfirmation);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnContinue.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnContinue.setBounds(445, 293, 187, 50);
		TeamAndWorldSetup.getContentPane().add(btnContinue);
		
		JLabel WorldCreationLabel = new JLabel("");
		WorldCreationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WorldCreationLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		WorldCreationLabel.setBounds(139, 146, 383, 24);
		TeamAndWorldSetup.getContentPane().add(WorldCreationLabel);
		
		JButton btnApplyTeamName = new JButton("Apply Team Name");
		btnApplyTeamName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teamName = textField.getText();
				if (2 < teamName.length() && teamName.length() < 10) {
					manager.getSquad().setTeamName(teamName);
					TeamNameConfirmation.setText("Your team is called " + textField.getText());
				}
				else {
					TeamNameConfirmation.setText("Your teams name must be between 2 and 10 characters long");
				}
				
			}
		});
		btnApplyTeamName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnApplyTeamName.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnApplyTeamName.setBounds(51, 293, 187, 50);
		TeamAndWorldSetup.getContentPane().add(btnApplyTeamName);
		
		JButton btnConfirmWorldSize = new JButton("Confirm World Size");
		btnConfirmWorldSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ArrayList<City> world = new ArrayList<City>();
				ArrayList<City> world = manager.getWorld();
				int numberCities = slider.getValue();
				world.removeAll(world);
				for (int i = 0; i < numberCities; i++) {
					City city = new City();
					world.add(city);
				WorldCreationLabel.setText("A World of " + world.size() + " cities has been created.");
				}
			}
		});
		btnConfirmWorldSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirmWorldSize.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnConfirmWorldSize.setBounds(248, 293, 187, 50);
		TeamAndWorldSetup.getContentPane().add(btnConfirmWorldSize);
		
		

	}
}
