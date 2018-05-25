package guiClassesAndManager;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import city.buildings.homeBase.Home;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

/**
 * 
 *
 */
public class HomeWindow {

	private JFrame frmHomeBase;
	private GameWindowManager manager;
	private MainGameWindow mainWindow;
	private Home home;

	/**
	 * Create the application.
	 */
	public HomeWindow(GameWindowManager incomingManager, Home homeBuilding, MainGameWindow incomingMainWindow) {
		
		manager = incomingManager;
		mainWindow = incomingMainWindow;
		home = homeBuilding;
		initialize();
		frmHomeBase.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomeBase = new JFrame();
		frmHomeBase.setTitle("Home Base");
		frmHomeBase.setResizable(false);
		frmHomeBase.setBounds(100, 100, 900, 840);
		frmHomeBase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomeBase.getContentPane().setLayout(null);
		
		JButton backToMainWindowButton = new JButton("Back to the map!");
		backToMainWindowButton.setBounds(271, 631, 337, 54);
		frmHomeBase.getContentPane().add(backToMainWindowButton);
		
		JButton btnCheckHeroesStatus = new JButton("Check Heroes Status");
		btnCheckHeroesStatus.setToolTipText("Click to see your team members status");
		btnCheckHeroesStatus.setBounds(43, 266, 286, 32);
		frmHomeBase.getContentPane().add(btnCheckHeroesStatus);
		
		JButton btnCheckMap = new JButton("Check Map");
		btnCheckMap.setToolTipText("Check where the building you are after is");
		btnCheckMap.setBounds(530, 266, 286, 32);
		frmHomeBase.getContentPane().add(btnCheckMap);
		
		JTextArea displayStolenOrGiftedItemsTxtArea = new JTextArea();
		displayStolenOrGiftedItemsTxtArea.setEditable(false);
		displayStolenOrGiftedItemsTxtArea.setBackground(UIManager.getColor("Label.background"));
		displayStolenOrGiftedItemsTxtArea.setLineWrap(true);
		displayStolenOrGiftedItemsTxtArea.setWrapStyleWord(true);
		displayStolenOrGiftedItemsTxtArea.setBounds(330, 66, 347, 179);
		frmHomeBase.getContentPane().add(displayStolenOrGiftedItemsTxtArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 344, 409, 265);
		frmHomeBase.getContentPane().add(scrollPane);
		
		JTextArea heroesStatusTxtArea = new JTextArea();
		heroesStatusTxtArea.setForeground(Color.WHITE);
		heroesStatusTxtArea.setEditable(false);
		scrollPane.setViewportView(heroesStatusTxtArea);
		heroesStatusTxtArea.setWrapStyleWord(true);
		heroesStatusTxtArea.setLineWrap(true);
		heroesStatusTxtArea.setBackground(UIManager.getColor("Button.background"));
		
		JTextArea showMapTxtArea = new JTextArea();
		showMapTxtArea.setWrapStyleWord(true);
		showMapTxtArea.setLineWrap(true);
		showMapTxtArea.setBackground(UIManager.getColor("Button.background"));
		showMapTxtArea.setBounds(530, 344, 286, 265);
		frmHomeBase.getContentPane().add(showMapTxtArea);
		
		JLabel welcomeToBaseLabel = new JLabel("Welcome to your HomeBase");
		welcomeToBaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeToBaseLabel.setBounds(43, 12, 773, 25);
		frmHomeBase.getContentPane().add(welcomeToBaseLabel);
		
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
		frmHomeBase.dispose();
		
	}
}
