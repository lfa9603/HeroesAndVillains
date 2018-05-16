package GUIPOC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import city.City;
import city.buildings.PowerUpDen;
import city.buildings.TypeBuildings;
import collectables.CollectableID;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;
import collectables.powerUp.PowerUp;

import javax.swing.JButton;


import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;

import javax.swing.JTextArea;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;


public class PowerUpDenWindow {

	private JFrame frame;
	
	private GameWindowManager manager;
	private MainGameWindow mainWindow;
	private PowerUpDen powerUpDenBuilding;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PowerUpDenWindow window = new PowerUpDenWindow();
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
	public PowerUpDenWindow(GameWindowManager incomingManager, PowerUpDen powerUpDenBuild, MainGameWindow mainWind) {
		manager = incomingManager;
		mainWindow = mainWind;
		powerUpDenBuilding = powerUpDenBuild;
		
		initialize();
		
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 787, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton backToMapBtn = new JButton("Back to the Map! ");
		backToMapBtn.setBounds(129, 452, 504, 35);
		frame.getContentPane().add(backToMapBtn);
		
		backToMapBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.closePowerUpDenWindow(PowerUpDenWindow.this, mainWindow);
			}
		});
		
		JTextArea txtrWelcomeToThe = new JTextArea();
		txtrWelcomeToThe.setEditable(false);
		txtrWelcomeToThe.setText("Welcome to the Power-Up den! Select a hero and a potion to apply on him!");
		txtrWelcomeToThe.setWrapStyleWord(true);
		txtrWelcomeToThe.setLineWrap(true);
		txtrWelcomeToThe.setBackground(SystemColor.menu);
		txtrWelcomeToThe.setBounds(91, 21, 584, 35);
		frame.getContentPane().add(txtrWelcomeToThe);
		
		
//		String[] heroesNames = new String[manager.getSquad().getHeroSquad().size()];
//		
//		for (int i=0; i < manager.getSquad().getHeroSquad().size(); i++) {
//			heroesNames[i] = manager.getSquad().getHeroSquad().get(i).getCharacterName();
//		}
		
		JComboBox<String> heroesComboBox = new JComboBox<String>();
		
		for (Hero hero : manager.getSquad().getHeroSquad()) {
			String isAlive = new String();
			if (hero.isAlive()) {
				isAlive = "Alive";
			} else {
				isAlive = "Dead";
			}
			//VERY IMPORTANT THIS FORMAT IS USED ALL THE TIME, IF CHANGED IT WILL CRASH, see applyPowerUpToHeroBtn.addActionListener 60 lines below.
			heroesComboBox.addItem(hero.getCharacterName() + "  (" + isAlive + ")");
		}
		heroesComboBox.setSelectedIndex(0);
		heroesComboBox.setMaximumRowCount(3);
		heroesComboBox.setBounds(32, 144, 180, 32);
		frame.getContentPane().add(heroesComboBox);
		
		//COMPLETE
		JComboBox<String> powerUpComboBox = new JComboBox<String>();
		powerUpComboBox.addItem("Armor");
		powerUpComboBox.addItem("Increase Max HP potion");
		powerUpComboBox.addItem("Game Chooser");
		powerUpComboBox.setSelectedIndex(0);
		powerUpComboBox.setMaximumRowCount(3);
		powerUpComboBox.setBounds(241, 144, 180, 32);
		frame.getContentPane().add(powerUpComboBox);
		
		//COMPLETE
		JLabel selectAHeroLabel = new JLabel("Select a hero");
		selectAHeroLabel.setBounds(32, 106, 180, 23);
		frame.getContentPane().add(selectAHeroLabel);
		
		//COMPLETE
		JLabel lblSelectAPowerup = new JLabel("Select a power-up");
		lblSelectAPowerup.setBounds(241, 106, 180, 23);
		frame.getContentPane().add(lblSelectAPowerup);
		
		//COMPLETE
		JTextArea heroesSquadPowerUpsTxtArea = new JTextArea();
		heroesSquadPowerUpsTxtArea.setWrapStyleWord(true);
		heroesSquadPowerUpsTxtArea.setText((String) null);
		heroesSquadPowerUpsTxtArea.setLineWrap(true);
		heroesSquadPowerUpsTxtArea.setEditable(false);
		heroesSquadPowerUpsTxtArea.setBackground(SystemColor.menu);
		heroesSquadPowerUpsTxtArea.setBounds(468, 67, 282, 346);
		heroesSquadPowerUpsTxtArea.setText(manager.getSquad().getBackPack().showPowerUpsInInventory());
		frame.getContentPane().add(heroesSquadPowerUpsTxtArea);
		
		JButton applyPowerUpToHeroBtn = new JButton("Apply power-up to the hero");
		applyPowerUpToHeroBtn.setBounds(32, 214, 389, 23);
		frame.getContentPane().add(applyPowerUpToHeroBtn);
		
		JTextArea showingPotionApplicationResultTxtArea = new JTextArea();
		showingPotionApplicationResultTxtArea.setWrapStyleWord(true);
		showingPotionApplicationResultTxtArea.setText((String) null);
		showingPotionApplicationResultTxtArea.setLineWrap(true);
		showingPotionApplicationResultTxtArea.setEditable(false);
		showingPotionApplicationResultTxtArea.setBackground(SystemColor.menu);
		showingPotionApplicationResultTxtArea.setBounds(32, 278, 389, 117);
		frame.getContentPane().add(showingPotionApplicationResultTxtArea);
		
		applyPowerUpToHeroBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// A bit of a nasty one-liner, selects the String at right index in heroesComboBox, splits the string in two parts (name and dead/alive) 
				// and then selects only the name part
				String nameHeroSelected = heroesComboBox.getItemAt(heroesComboBox.getSelectedIndex()).split(" ")[0];
				Hero heroToApplyPotionTo = manager.getSquad().getHeroByName(nameHeroSelected);
				
				PowerUp powerUp = powerUpDenBuilding.returnCorrectPowerUp(powerUpComboBox.getSelectedIndex());
//				PowerUp powerUpToApply = null;
//				switch (powerUpComboBox.getSelectedIndex()) {
//					case 0:
//						powerUpToApply = new Armor(CollectableID.Armor);
//						break;
//					case 1:
//						powerUpToApply = new IncreaseMaxLife(CollectableID.IncreaseMaxLife);
//						break;
//					case 2:
//						powerUpToApply = new GameChooser(CollectableID.GameChooser);
//						break;
//				}

				String resultFromPotionApplication = powerUpDenBuilding.applyPotionOrRejectIt(manager.getSquad(), heroToApplyPotionTo, powerUp);
				
				showingPotionApplicationResultTxtArea.setText(resultFromPotionApplication);
				
				//display updated inventory
				heroesSquadPowerUpsTxtArea.setText(manager.getSquad().getBackPack().showPowerUpsInInventory());
				
				//tidy up the combo boxes
				powerUpComboBox.setSelectedIndex(0);
				heroesComboBox.setSelectedIndex(0);
				
			}
		});
		
		
		
//		
//		JList<String> list = new JList<String>();
//		list.
//		list.setBounds(48, 77, 179, 35);
//		frame.getContentPane().add(list);

		
	}

	public void closeWindow() {
		frame.dispose();
	}
	
	public static void main(String[] args) {
		City city = new City();
		HeroesSquad squad = new HeroesSquad();
		squad.setHaveMap(true);
		squad.setCurrentCity(city);
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.betterOdds);
		Hero lorenzo1 = new Hero("Lorenzo1", Types.dog, Abilities.betterOdds);
		lorenzo.setisAlive(false);
		squad.addHero(lorenzo);
		squad.addHero(lorenzo1);
		squad.getBackPack().addItemToInventory(new Armor(CollectableID.Armor));
		squad.getBackPack().addItemToInventory(new GameChooser(CollectableID.GameChooser));
		
		GameWindowManager manager = new GameWindowManager();
		PowerUpDen pb = new PowerUpDen("Ciao", TypeBuildings.PowerUpDen); 
		MainGameWindow mw = new MainGameWindow(manager);
		PowerUpDenWindow win = new PowerUpDenWindow(manager, pb, mw);
	}
}
