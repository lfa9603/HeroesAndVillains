package GUIPOC;

import java.awt.EventQueue;

import javax.swing.JFrame;

import city.City;
import city.buildings.TypeBuildings;
import city.buildings.hospital.Hospital;
import collectables.CollectableID;
import collectables.healingItem.HealingItem;

import javax.swing.JTextArea;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * @author LorenzoFasano
 *
 */
public class HospitalWindow {

	private JFrame frame;
	
	private GameWindowManager manager;
	private Hospital hospitalBuilding;
	private MainGameWindow mainWindow;
	
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HospitalWindow window = new HospitalWindow();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public HospitalWindow(GameWindowManager incomingManager, Hospital hospitalBuild, MainGameWindow mainWind) {
		
		manager = incomingManager;
		hospitalBuilding = hospitalBuild;
		mainWindow = mainWind;
		
		initialize();
		
		frame.setVisible(true);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 826, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea healingWardTxtArea = new JTextArea();
		healingWardTxtArea.setWrapStyleWord(true);
		healingWardTxtArea.setText((String) null);
		healingWardTxtArea.setLineWrap(true);
		healingWardTxtArea.setEditable(false);
		healingWardTxtArea.setBackground(SystemColor.menu);
		healingWardTxtArea.setBounds(20, 81, 338, 231);
		
		//
		healingWardTxtArea.setText(hospitalBuilding.getHealingWard().toString());
		
		frame.getContentPane().add(healingWardTxtArea);
		
		//Done
		JTextArea welcomeToHospitalTxtArea = new JTextArea();
		welcomeToHospitalTxtArea.setWrapStyleWord(true);
		welcomeToHospitalTxtArea.setText("Welcome to the Hospital! Select a Healing item and apply it to your hero!");
		welcomeToHospitalTxtArea.setLineWrap(true);
		welcomeToHospitalTxtArea.setEditable(false);
		welcomeToHospitalTxtArea.setBackground(SystemColor.menu);
		welcomeToHospitalTxtArea.setBounds(10, 11, 714, 35);
		frame.getContentPane().add(welcomeToHospitalTxtArea);
		
		
		JTextArea squadHealingItemsTxtArea = new JTextArea();
		squadHealingItemsTxtArea.setWrapStyleWord(true);
		squadHealingItemsTxtArea.setText((String) null);
		squadHealingItemsTxtArea.setLineWrap(true);
		squadHealingItemsTxtArea.setEditable(false);
		squadHealingItemsTxtArea.setBackground(SystemColor.menu);
		squadHealingItemsTxtArea.setBounds(396, 81, 338, 231);
		
		//
		squadHealingItemsTxtArea.setText(manager.getSquad().getBackPack().showHealingItemsInInventory());
		
		frame.getContentPane().add(squadHealingItemsTxtArea);
		
		//Done
		JLabel hospitalhealingWardLbl = new JLabel("Hospital Healing ward");
		hospitalhealingWardLbl.setBounds(20, 45, 238, 26);
		frame.getContentPane().add(hospitalhealingWardLbl);
		
		//Done
		JLabel squadHealingItemsLbl = new JLabel("Squad Healing items");
		squadHealingItemsLbl.setBounds(386, 45, 279, 25);
		frame.getContentPane().add(squadHealingItemsLbl);
		
		//Done
		JButton backToMapBtn = new JButton("Back to the Map! ");
		backToMapBtn.setBounds(109, 509, 504, 35);
		backToMapBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				manager.closeHospitalWindow(HospitalWindow.this, mainWindow);
				
			}
		});
		
		frame.getContentPane().add(backToMapBtn);
		//Done
		JLabel selectHeroLabel = new JLabel("Select a hero");
		selectHeroLabel.setBounds(10, 315, 180, 26);
		frame.getContentPane().add(selectHeroLabel);
		
		//Done
		JComboBox<String> selectHeroComboBox = new JComboBox<String>();
		selectHeroComboBox.setMaximumRowCount(3);
		selectHeroComboBox.setBounds(10, 358, 180, 32);
		
		for (Hero hero : manager.getSquad().getHeroSquad()) {
			String isAlive = new String();
			if (hero.isAlive()) {
				isAlive = "Alive";
			} else {
				isAlive = "Dead";
			}
			//VERY IMPORTANT THIS FORMAT IS USED ALL THE TIME, IF CHANGED IT WILL CRASH, see applyPowerUpToHeroBtn.addActionListener 60 lines below.
			selectHeroComboBox.addItem(hero.getCharacterName() + "  (" + isAlive + ")");
		}
		
		selectHeroComboBox.setSelectedIndex(0);
		frame.getContentPane().add(selectHeroComboBox);
		
		//Done
		JComboBox<String> selectHealingItemComboBox = new JComboBox<String>();
		selectHealingItemComboBox.addItem("Potion");
		selectHealingItemComboBox.addItem("SuperPotion");
		selectHealingItemComboBox.addItem("HyperPotion");
		selectHealingItemComboBox.setSelectedIndex(0);
		selectHealingItemComboBox.setMaximumRowCount(3);
		selectHealingItemComboBox.setBounds(200, 358, 180, 32);
		frame.getContentPane().add(selectHealingItemComboBox);
		
		//Done
		JLabel selectHealingItemLbl = new JLabel("Select healing item");
		selectHealingItemLbl.setBounds(200, 315, 180, 33);
		frame.getContentPane().add(selectHealingItemLbl);
		
		//Done
		JTextArea showSuccessOrFailureApplyingHealItemTxtArea = new JTextArea();
		showSuccessOrFailureApplyingHealItemTxtArea.setWrapStyleWord(true);
		showSuccessOrFailureApplyingHealItemTxtArea.setText((String) null);
		showSuccessOrFailureApplyingHealItemTxtArea.setLineWrap(true);
		showSuccessOrFailureApplyingHealItemTxtArea.setEditable(false);
		showSuccessOrFailureApplyingHealItemTxtArea.setBackground(SystemColor.menu);
		showSuccessOrFailureApplyingHealItemTxtArea.setBounds(386, 393, 338, 105);
		frame.getContentPane().add(showSuccessOrFailureApplyingHealItemTxtArea);
		
		JButton applyHealingItemToHeroBtn = new JButton("Apply healing item!");
		applyHealingItemToHeroBtn.setBounds(425, 358, 238, 33);
		frame.getContentPane().add(applyHealingItemToHeroBtn);
		
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public static void main(String[] args) {
		City city = new City();
		Hospital hospital = new Hospital("Ciao", TypeBuildings.Hospital);
		HeroesSquad heroes = new HeroesSquad();
		Hero hero1 = new Hero("Hero1test", Types.dog, Abilities.badDay);
		hero1.setHealth(50);
		heroes.addHero(hero1);
	
		heroes.getBackPack().addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
		
		GameWindowManager gm = new GameWindowManager(city, heroes);
		MainGameWindow mw = new MainGameWindow(gm);
		HospitalWindow hw = new HospitalWindow(gm, hospital, mw);
	}
}
