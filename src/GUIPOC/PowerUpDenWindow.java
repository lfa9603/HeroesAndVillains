package GUIPOC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import city.City;
import city.buildings.PowerUpDen;
import city.buildings.TypeBuildings;
import collectables.CollectableID;
import collectables.healingItem.HealingItem;
import collectables.powerUp.Armor;

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
			heroesComboBox.addItem(hero.getCharacterName());
		}
		heroesComboBox.setSelectedIndex(0);
		heroesComboBox.setMaximumRowCount(3);
		heroesComboBox.setBounds(32, 94, 180, 32);
		frame.getContentPane().add(heroesComboBox);
		
		JComboBox<String> powerUpComboBox = new JComboBox<String>();
		powerUpComboBox.addItem("Armor");
		powerUpComboBox.addItem("Increase Max HP potion");
		powerUpComboBox.addItem("Game Chooser");
		
		powerUpComboBox.setSelectedIndex(0);
		powerUpComboBox.setMaximumRowCount(3);
		powerUpComboBox.setBounds(241, 94, 180, 32);
		frame.getContentPane().add(powerUpComboBox);
		
		JLabel selectAHeroLabel = new JLabel("Select a hero");
		selectAHeroLabel.setBounds(32, 69, 180, 14);
		frame.getContentPane().add(selectAHeroLabel);
		
		JLabel lblSelectAPowerup = new JLabel("Select a power-up");
		lblSelectAPowerup.setBounds(241, 67, 180, 14);
		frame.getContentPane().add(lblSelectAPowerup);
		
		JTextArea heroesSquadPowerUpsTxtArea = new JTextArea();
		heroesSquadPowerUpsTxtArea.setWrapStyleWord(true);
		heroesSquadPowerUpsTxtArea.setText((String) null);
		heroesSquadPowerUpsTxtArea.setLineWrap(true);
		heroesSquadPowerUpsTxtArea.setEditable(false);
		heroesSquadPowerUpsTxtArea.setBackground(SystemColor.menu);
		heroesSquadPowerUpsTxtArea.setBounds(468, 67, 282, 346);
		heroesSquadPowerUpsTxtArea.setText(manager.getSquad().getBackPack().showPowerUpsInInventory());
		frame.getContentPane().add(heroesSquadPowerUpsTxtArea);
		
		
		
		
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
		squad.addHero(lorenzo);
		squad.addHero(lorenzo1);
		squad.getBackPack().addItemToInventory(new Armor(CollectableID.Armor));
		squad.getBackPack().addItemToInventory(new HealingItem(CollectableID.GoodHealingItem));
		
		GameWindowManager manager = new GameWindowManager(city, squad);
		PowerUpDen pb = new PowerUpDen("Ciao", TypeBuildings.PowerUpDen); 
		MainGameWindow mw = new MainGameWindow(manager);
		PowerUpDenWindow win = new PowerUpDenWindow(manager, pb, mw);
	}
}
