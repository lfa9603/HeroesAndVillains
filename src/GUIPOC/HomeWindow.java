package GUIPOC;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import city.buildings.homeBase.Home;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class HomeWindow {

	private JFrame frame;
	private GameWindowManager manager;
	private MainGameWindow mainWindow;
	private Home home;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeWindow window = new HomeWindow();
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
	public HomeWindow(GameWindowManager incomingManager, Home homeBuilding, MainGameWindow incomingMainWindow) {
		
		manager = incomingManager;
		mainWindow = incomingMainWindow;
		home = homeBuilding;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 877, 723);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton backToMainWindowButton = new JButton("Back to the map!");
		backToMainWindowButton.setBounds(271, 631, 337, 54);
		frame.getContentPane().add(backToMainWindowButton);
		
		JButton btnCheckHeroesStatus = new JButton("Check Heroes Status");
		btnCheckHeroesStatus.setBounds(43, 266, 286, 32);
		frame.getContentPane().add(btnCheckHeroesStatus);
		
		JButton btnCheckMap = new JButton("Check Map");
		btnCheckMap.setBounds(530, 266, 286, 32);
		frame.getContentPane().add(btnCheckMap);
		
		JTextArea displayStolenOrGiftedItemsTxtArea = new JTextArea();
		displayStolenOrGiftedItemsTxtArea.setEditable(false);
		displayStolenOrGiftedItemsTxtArea.setBackground(UIManager.getColor("Label.background"));
		displayStolenOrGiftedItemsTxtArea.setLineWrap(true);
		displayStolenOrGiftedItemsTxtArea.setWrapStyleWord(true);
		displayStolenOrGiftedItemsTxtArea.setBounds(261, 61, 347, 179);
		frame.getContentPane().add(displayStolenOrGiftedItemsTxtArea);
		
		JTextArea heroesStatusTxtArea = new JTextArea();
		heroesStatusTxtArea.setWrapStyleWord(true);
		heroesStatusTxtArea.setLineWrap(true);
		heroesStatusTxtArea.setBackground(UIManager.getColor("Button.background"));
		heroesStatusTxtArea.setBounds(43, 344, 286, 265);
		frame.getContentPane().add(heroesStatusTxtArea);
		
		JTextArea showMapTxtArea = new JTextArea();
		showMapTxtArea.setWrapStyleWord(true);
		showMapTxtArea.setLineWrap(true);
		showMapTxtArea.setBackground(UIManager.getColor("Button.background"));
		showMapTxtArea.setBounds(530, 344, 286, 265);
		frame.getContentPane().add(showMapTxtArea);
		
		JLabel welcomeToBaseLabel = new JLabel("Welcome to your HomeBase");
		welcomeToBaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeToBaseLabel.setBounds(43, 12, 773, 25);
		frame.getContentPane().add(welcomeToBaseLabel);
		
		displayStolenOrGiftedItemsTxtArea.setText(home.checkingSomeoneRobbedOrDonated(manager.getSquad()));
		
		btnCheckHeroesStatus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				heroesStatusTxtArea.setText(home.showHeroesStatus(manager.getSquad()));
				
			}
		});
		
		
		btnCheckMap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showMapTxtArea.setText(home.showMap(manager.getSquad()));
			}
		});
		
		
		backToMainWindowButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				manager.closeHomeBaseWindow(HomeWindow.this, mainWindow);
				
			}
		});
	}
	
	public void closeWindow() {
		frame.dispose();
		
	}
}
