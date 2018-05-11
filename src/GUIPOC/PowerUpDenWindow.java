package GUIPOC;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import city.City;
import city.buildings.PowerUpDen;
import city.buildings.TypeBuildings;
import city.buildings.homeBase.Home;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;

import javax.swing.JTextArea;
import javax.swing.ListModel;

import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;


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
		
		
		String[] heroesNames = new String[manager.getSquad().getHeroSquad().size()];
		
		for (int i=0; i < manager.getSquad().getHeroSquad().size(); i++) {
			heroesNames[i] = manager.getSquad().getHeroSquad().get(i).getCharacterName();
		}
		
		JComboBox<String> comboBox = new JComboBox<String>(heroesNames);
		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(101, 94, 137, 32);
		frame.getContentPane().add(comboBox);
		
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
		GameWindowManager manager = new GameWindowManager(city, squad);
		PowerUpDen pb = new PowerUpDen("Ciao", TypeBuildings.PowerUpDen); 
		MainGameWindow mw = new MainGameWindow(manager);
		PowerUpDenWindow win = new PowerUpDenWindow(manager, pb, mw);
	}
}
