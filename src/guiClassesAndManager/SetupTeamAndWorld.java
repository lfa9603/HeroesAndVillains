package guiClassesAndManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import city.City;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SetupTeamAndWorld {

	private JFrame teamAndWorldSetup;
	private static GameWindowManager manager;
	private JTextField textField;
	private boolean worldCreated = false;
	private boolean nameApplied  = false;

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
	public SetupTeamAndWorld(GameWindowManager gameWindowManager) {
		manager = gameWindowManager;
		initialize();
//		teamAndWorldSetupDialog.setModal(true);
		teamAndWorldSetup.setVisible(true);
	}
	
	public void closeWindow() {
		teamAndWorldSetup.dispose();
	}
	
	public void finishedWindow() {
		manager.closeSetupTeamAndWorld(this);
	}
	

	/**
	 * @return the worldCreated
	 */
	public boolean isWorldCreated() {
		return worldCreated;
	}

	/**
	 * @param worldCreated the worldCreated to set
	 */
	public void setWorldCreated(boolean worldCreated) {
		this.worldCreated = worldCreated;
	}

	/**
	 * @return the nameApplied
	 */
	public boolean isNameApplied() {
		return nameApplied;
	}

	/**
	 * @param nameApplied the nameApplied to set
	 */
	public void setNameApplied(boolean nameApplied) {
		this.nameApplied = nameApplied;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		teamAndWorldSetup = new JFrame();
		teamAndWorldSetup.setBounds(100, 100, 900, 582);
		teamAndWorldSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		teamAndWorldSetup.getContentPane().setLayout(null);
		
		JLabel lblSetup = new JLabel("Setup Team and World");
		lblSetup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetup.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblSetup.setBounds(10, 11, 790, 49);
		teamAndWorldSetup.getContentPane().add(lblSetup);
		
		JSlider slider = new JSlider();
		slider.setFont(new Font("Tahoma", Font.PLAIN, 14));
		slider.setMajorTickSpacing(1);
		slider.setToolTipText("Slide to select number of cities");
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinimum(3);
		slider.setMaximum(6);
		slider.setSnapToTicks(true);
		slider.setBounds(455, 72, 398, 49);
		teamAndWorldSetup.getContentPane().add(slider);
		
		JLabel lblNewLabel = new JLabel("Number of cities to explore:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(88, 72, 230, 50);
		teamAndWorldSetup.getContentPane().add(lblNewLabel);
		
		JLabel lblSelectTheName = new JLabel("Select the name of your Team:");
		lblSelectTheName.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectTheName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectTheName.setBounds(88, 259, 257, 50);
		teamAndWorldSetup.getContentPane().add(lblSelectTheName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setToolTipText("Type in the name of your team");
		textField.setBounds(455, 259, 398, 50);
		teamAndWorldSetup.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel ErrorMessage = new JLabel("");
		ErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorMessage.setForeground(Color.RED);
		ErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		ErrorMessage.setBounds(116, 413, 571, 24);
		teamAndWorldSetup.getContentPane().add(ErrorMessage);
		
		JLabel TeamNameConfirmation = new JLabel("");
		TeamNameConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		TeamNameConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TeamNameConfirmation.setBounds(212, 318, 383, 24);
		teamAndWorldSetup.getContentPane().add(TeamNameConfirmation);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (worldCreated && nameApplied) {
					finishedWindow();
				}
				else {
					ErrorMessage.setText("You must set the world size and create a name for your team.");
				}
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnContinue.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnContinue.setBounds(137, 458, 533, 50);
		teamAndWorldSetup.getContentPane().add(btnContinue);
		
		JLabel WorldCreationLabel = new JLabel("");
		WorldCreationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WorldCreationLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		WorldCreationLabel.setBounds(212, 143, 383, 24);
		teamAndWorldSetup.getContentPane().add(WorldCreationLabel);
		
		JButton btnApplyTeamName = new JButton("Apply Team Name");
		btnApplyTeamName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teamName = textField.getText();
				if (2 <= teamName.length() && teamName.length() <= 10) {
					manager.getSquad().setTeamName(teamName);
					TeamNameConfirmation.setText("Your team is called " + textField.getText());
					setNameApplied(true);
				}
				else {
					TeamNameConfirmation.setText("Your teams name must be between 2 and 10 characters long");
				}
				
			}
		});
		btnApplyTeamName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnApplyTeamName.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnApplyTeamName.setBounds(306, 347, 187, 50);
		teamAndWorldSetup.getContentPane().add(btnApplyTeamName);
		
		JButton btnConfirmWorldSize = new JButton("Confirm World Size");
		btnConfirmWorldSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ArrayList<City> world = new ArrayList<City>();
//				ArrayList<City> world = manager.getWorld();
//				int numberCities = slider.getValue();
//				world.removeAll(world);
//				for (int i = 0; i < numberCities; i++) {
//					City city = new City();
//					world.add(city);
				manager.setWorldSize(slider.getValue());
				int worldSize = manager.getWorldSize();
				WorldCreationLabel.setText("A World of " + worldSize + " cities has been created.");
				setWorldCreated(true);
			}
		});
		btnConfirmWorldSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirmWorldSize.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnConfirmWorldSize.setBounds(306, 176, 187, 50);
		teamAndWorldSetup.getContentPane().add(btnConfirmWorldSize);
		

		
		

	}
}
