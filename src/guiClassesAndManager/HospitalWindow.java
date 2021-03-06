package guiClassesAndManager;


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
import java.awt.Font;

/**
 * @author LorenzoFasano
 *
 */
public class HospitalWindow {

	private JFrame frmHospital;
	
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
		
		frmHospital.setVisible(true);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHospital = new JFrame();
		frmHospital.setTitle("Hospital");
		frmHospital.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmHospital.setResizable(false);
		frmHospital.setBounds(100, 100, 900, 840);
		frmHospital.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHospital.getContentPane().setLayout(null);
		
		JTextArea healingWardTxtArea = new JTextArea();
		healingWardTxtArea.setWrapStyleWord(true);
		healingWardTxtArea.setText((String) null);
		healingWardTxtArea.setLineWrap(true);
		healingWardTxtArea.setEditable(false);
		healingWardTxtArea.setBackground(SystemColor.menu);
		healingWardTxtArea.setBounds(20, 81, 338, 231);
		
		//
		healingWardTxtArea.setText(hospitalBuilding.getHealingWard().toString());
		
		frmHospital.getContentPane().add(healingWardTxtArea);
		
		//Done
		JTextArea welcomeToHospitalTxtArea = new JTextArea();
		welcomeToHospitalTxtArea.setWrapStyleWord(true);
		welcomeToHospitalTxtArea.setText("Welcome to the Hospital! Select a Healing item and apply it to your hero!");
		welcomeToHospitalTxtArea.setLineWrap(true);
		welcomeToHospitalTxtArea.setEditable(false);
		welcomeToHospitalTxtArea.setBackground(SystemColor.menu);
		welcomeToHospitalTxtArea.setBounds(10, 11, 714, 35);
		frmHospital.getContentPane().add(welcomeToHospitalTxtArea);
		
		
		JTextArea squadHealingItemsTxtArea = new JTextArea();
		squadHealingItemsTxtArea.setWrapStyleWord(true);
		squadHealingItemsTxtArea.setText((String) null);
		squadHealingItemsTxtArea.setLineWrap(true);
		squadHealingItemsTxtArea.setEditable(false);
		squadHealingItemsTxtArea.setBackground(SystemColor.menu);
		squadHealingItemsTxtArea.setBounds(396, 81, 338, 231);
		
		//
		squadHealingItemsTxtArea.setText(manager.getSquad().getBackPack().showHealingItemsInInventory());
		
		frmHospital.getContentPane().add(squadHealingItemsTxtArea);
		
		//Done
		JLabel hospitalhealingWardLbl = new JLabel("Hospital Healing ward");
		hospitalhealingWardLbl.setBounds(20, 45, 212, 26);
		frmHospital.getContentPane().add(hospitalhealingWardLbl);
		
		//Done
		JLabel squadHealingItemsLbl = new JLabel("Squad Healing items");
		squadHealingItemsLbl.setBounds(386, 45, 279, 25);
		frmHospital.getContentPane().add(squadHealingItemsLbl);
		
		//Done
		JButton backToMapBtn = new JButton("Back to the Map! ");
		backToMapBtn.setBounds(161, 704, 504, 35);
		backToMapBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				manager.closeHospitalWindow(HospitalWindow.this, mainWindow);
				
			}
		});
		
		frmHospital.getContentPane().add(backToMapBtn);
		//Done
		JLabel selectHeroLabel = new JLabel("Select a hero");
		selectHeroLabel.setBounds(67, 362, 180, 26);
		frmHospital.getContentPane().add(selectHeroLabel);
		
		//Done
		JComboBox<String> selectHeroComboBox = new JComboBox<String>();
		selectHeroComboBox.setMaximumRowCount(3);
		selectHeroComboBox.setBounds(67, 409, 180, 32);
		
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
		frmHospital.getContentPane().add(selectHeroComboBox);
		
		//Done
		JComboBox<String> selectHealingItemComboBox = new JComboBox<String>();
		selectHealingItemComboBox.addItem("GoodHealingItem");
		selectHealingItemComboBox.addItem("BetterHealingItem");
		selectHealingItemComboBox.addItem("BestHealingItem");
		selectHealingItemComboBox.setSelectedIndex(0);
		selectHealingItemComboBox.setMaximumRowCount(3);
		selectHealingItemComboBox.setBounds(285, 409, 180, 32);
		frmHospital.getContentPane().add(selectHealingItemComboBox);
		
		//Done
		JLabel selectHealingItemLbl = new JLabel("Select healing item");
		selectHealingItemLbl.setBounds(285, 355, 180, 33);
		frmHospital.getContentPane().add(selectHealingItemLbl);
		
		//Done
		JTextArea showSuccessOrFailureApplyingHealItemTxtArea = new JTextArea();
		showSuccessOrFailureApplyingHealItemTxtArea.setWrapStyleWord(true);
		showSuccessOrFailureApplyingHealItemTxtArea.setText((String) null);
		showSuccessOrFailureApplyingHealItemTxtArea.setLineWrap(true);
		showSuccessOrFailureApplyingHealItemTxtArea.setEditable(false);
		showSuccessOrFailureApplyingHealItemTxtArea.setBackground(SystemColor.menu);
		showSuccessOrFailureApplyingHealItemTxtArea.setBounds(521, 463, 338, 105);
		frmHospital.getContentPane().add(showSuccessOrFailureApplyingHealItemTxtArea);
		
		JButton applyHealingItemToHeroBtn = new JButton("Apply healing item!");
		applyHealingItemToHeroBtn.setBounds(621, 409, 238, 33);
		
		applyHealingItemToHeroBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				String nameHeroSelected = selectHeroComboBox.getItemAt(selectHeroComboBox.getSelectedIndex()).split(" ")[0];
//				Hero heroToApplyPotionTo = manager.getSquad().getHeroByName(nameHeroSelected);
				Hero heroToApplyPotionTo = manager.getSquad().getHero(selectHeroComboBox.getSelectedIndex());
				
				HealingItem healingItem = hospitalBuilding.returnCorrectHealingItemGivenIndex(selectHealingItemComboBox.getSelectedIndex());
				
				String resultFromHealingItemApplication = hospitalBuilding.completeOrRejectHealingItemApplication(manager.getSquad(), heroToApplyPotionTo, healingItem);
				
				showSuccessOrFailureApplyingHealItemTxtArea.setText(resultFromHealingItemApplication);
				
				//Update HealingItems in HeroesSquad backpack
				
				squadHealingItemsTxtArea.setText(manager.getSquad().getBackPack().showHealingItemsInInventory());
				//Update healing ward display
				healingWardTxtArea.setText(hospitalBuilding.getHealingWard().toString());
				
				//Reset JComboBoxes to first item
				selectHealingItemComboBox.setSelectedIndex(0);
				selectHeroComboBox.setSelectedIndex(0);
				
				
			}
		});
		frmHospital.getContentPane().add(applyHealingItemToHeroBtn);
		
//		JButton healingWardRefreshButton = new JButton("Refresh");
//		healingWardRefreshButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		healingWardRefreshButton.setBounds(229, 50, 97, 21);
//		frame.getContentPane().add(healingWardRefreshButton);
//		
//		healingWardRefreshButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				//Update healing ward display
//				healingWardTxtArea.setText(hospitalBuilding.getHealingWard().toString());
//				
//			}
//		});
		
		//Is this thread killed if I close the page??
		Thread healingWardTxtAreaThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(manager.isHospitalWindowOpen()) {
					healingWardTxtArea.setText(hospitalBuilding.getHealingWard().toString());
					System.out.println("Go Big or Go Ciao");
				}
			}
		});
		healingWardTxtAreaThread.start();
		
	}
	
	public void closeWindow() {
		frmHospital.dispose();
	}
	
//	public static void main(String[] args) {
//		City city = new City();
//		Hospital hospital = new Hospital("Ciao", TypeBuildings.Hospital);
//		HeroesSquad heroes = new HeroesSquad();
//		Hero hero1 = new Hero("Hero1test", Types.dog, Abilities.badDay);
//		Hero hero2 = new Hero("Hero2test", Types.dog, Abilities.badDay);
//		hero1.setHealth(50);
//		hero2.setHealth(30);
//		heroes.addHero(hero1);
//		heroes.addHero(hero2);
//		
//		heroes.getBackPack().addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
//		heroes.getBackPack().addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
//		
//		GameWindowManager gm = new GameWindowManager();
//		gm.setHospitalWindowOpen(true);
//		MainGameWindow mw = new MainGameWindow(gm);
//		HospitalWindow hw = new HospitalWindow(gm, hospital, mw);
//	}
}
