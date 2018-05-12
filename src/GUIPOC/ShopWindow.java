package GUIPOC;

import javax.swing.JFrame;

import city.City;

import city.buildings.TypeBuildings;
import city.buildings.shop.Shop;
import collectables.CollectableID;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;


import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ShopWindow {

	private JFrame frame;
	
	private GameWindowManager manager;
	private MainGameWindow mainWindow;
	private Shop shopBuilding;
	

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShopWindow window = new ShopWindow();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public ShopWindow() {
//		initialize();
//	}
	
	public ShopWindow(GameWindowManager incomingWindow, Shop shopBuild, MainGameWindow mainWind) {
		
		manager = incomingWindow;
		shopBuilding = shopBuild;
		mainWindow = mainWind;
		
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 839, 839);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea welcomeShopTxtArea = new JTextArea();
		welcomeShopTxtArea.setWrapStyleWord(true);
		welcomeShopTxtArea.setText("Welcome to the Shop! Make " + shopBuilding.getNameOfInnkeeper() +", the owner, happy spending your money here!");
		welcomeShopTxtArea.setLineWrap(true);
		welcomeShopTxtArea.setEditable(false);
		welcomeShopTxtArea.setBackground(SystemColor.menu);
		welcomeShopTxtArea.setBounds(21, 21, 691, 43);
		frame.getContentPane().add(welcomeShopTxtArea);
		
		JToggleButton justBrowsingTgBtn = new JToggleButton("Just Browsing");
		justBrowsingTgBtn.setBounds(21, 265, 207, 35);
		frame.getContentPane().add(justBrowsingTgBtn);
		
		JToggleButton talkToInnkeeperTgBtn = new JToggleButton("Talk to " + shopBuilding.getNameOfInnkeeper());
		talkToInnkeeperTgBtn.setBounds(464, 265, 207, 35);
		frame.getContentPane().add(talkToInnkeeperTgBtn);
		
		JPanel justBrowsingPanel = new JPanel();
		justBrowsingPanel.setBounds(21, 321, 303, 347);
		frame.getContentPane().add(justBrowsingPanel);
		justBrowsingPanel.setLayout(null);
		
		JTextArea shopGoodsTxtArea = new JTextArea();
		shopGoodsTxtArea.setWrapStyleWord(true);
		shopGoodsTxtArea.setText((String) null);
		shopGoodsTxtArea.setLineWrap(true);
		shopGoodsTxtArea.setEditable(false);
		shopGoodsTxtArea.setBackground(SystemColor.menu);
		shopGoodsTxtArea.setBounds(21, 21, 271, 305);
		justBrowsingPanel.add(shopGoodsTxtArea);
		
		JPanel talkToInnkeeperPanel = new JPanel();
		talkToInnkeeperPanel.setBounds(464, 321, 313, 347);
		frame.getContentPane().add(talkToInnkeeperPanel);
		talkToInnkeeperPanel.setLayout(null);
		
		JComboBox<CollectableID> allItemsComboBox = new JComboBox<CollectableID>();
		allItemsComboBox.addItem(CollectableID.Armor);
		allItemsComboBox.addItem(CollectableID.IncreaseMaxLife);
		allItemsComboBox.addItem(CollectableID.GameChooser);
		allItemsComboBox.addItem(CollectableID.HeroesMap);
		allItemsComboBox.addItem(CollectableID.GoodHealingItem);
		allItemsComboBox.addItem(CollectableID.BetterHealingItem);
		allItemsComboBox.addItem(CollectableID.BestHealingItem);
		
		allItemsComboBox.setBounds(21, 104, 124, 32);
		talkToInnkeeperPanel.add(allItemsComboBox);
		
		JLabel chooseItemBuyLabel = new JLabel("Choose item to buy");
		chooseItemBuyLabel.setBounds(21, 72, 210, 26);
		talkToInnkeeperPanel.add(chooseItemBuyLabel);
		
		JLabel whatCanIGetYaLabel = new JLabel("Hi! what can I get ya?");
		whatCanIGetYaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		whatCanIGetYaLabel.setBounds(21, 21, 271, 26);
		talkToInnkeeperPanel.add(whatCanIGetYaLabel);
		
		JButton buyItemBtn = new JButton("Buy Item");
		buyItemBtn.setBounds(166, 104, 127, 32);
		talkToInnkeeperPanel.add(buyItemBtn);
		
		JTextArea displaySuccessOrRejectionPurchase = new JTextArea();
		displaySuccessOrRejectionPurchase.setWrapStyleWord(true);
		displaySuccessOrRejectionPurchase.setText((String) null);
		displaySuccessOrRejectionPurchase.setLineWrap(true);
		displaySuccessOrRejectionPurchase.setEditable(false);
		displaySuccessOrRejectionPurchase.setBackground(SystemColor.menu);
		displaySuccessOrRejectionPurchase.setBounds(21, 346, 271, 141);
		talkToInnkeeperPanel.add(displaySuccessOrRejectionPurchase);
		
		JButton backToMapBtn = new JButton("Back to the Map! ");
		backToMapBtn.setBounds(191, 691, 504, 35);
		frame.getContentPane().add(backToMapBtn);
		
		JPanel heroesInfosPanel = new JPanel();
		heroesInfosPanel.setBounds(21, 56, 771, 188);
		frame.getContentPane().add(heroesInfosPanel);
		heroesInfosPanel.setLayout(null);
		
		JTextArea heroesBackpackTxtArea = new JTextArea();
		heroesBackpackTxtArea.setWrapStyleWord(true);
		heroesBackpackTxtArea.setLineWrap(true);
		heroesBackpackTxtArea.setEditable(false);
		heroesBackpackTxtArea.setBackground(SystemColor.menu);
		heroesBackpackTxtArea.setBounds(0, 36, 522, 131);
		heroesInfosPanel.add(heroesBackpackTxtArea);
		
		JLabel heroesBackpackLbl = new JLabel("Heroes backpack");
		heroesBackpackLbl.setBounds(21, 0, 165, 32);
		heroesInfosPanel.add(heroesBackpackLbl);
		
		JLabel walletLbl = new JLabel("Wallet: " + manager.getSquad().getWallet() + " coins.");
		walletLbl.setBounds(537, 41, 234, 26);
		heroesInfosPanel.add(walletLbl);
		
		String haveMap = new String("no");
		if (manager.getSquad().isHaveMap()) {
			haveMap = "yes";
		}
		JLabel cityMapLbl = new JLabel("City map available: " + haveMap);
		cityMapLbl.setBounds(537, 88, 234, 26);
		heroesInfosPanel.add(cityMapLbl);
		
		backToMapBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.closeShopWindow(ShopWindow.this, mainWindow);
			}
		});
		
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
		
		GameWindowManager manager = new GameWindowManager(city, squad);
		Shop shop = new Shop("Shop", TypeBuildings.Shop); 
		MainGameWindow mw = new MainGameWindow(manager);
		ShopWindow win = new ShopWindow(manager, shop, mw);
	}
}
