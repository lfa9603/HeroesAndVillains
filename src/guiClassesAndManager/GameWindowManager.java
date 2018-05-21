package guiClassesAndManager;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.time.*;


import javax.swing.JOptionPane;

import characters.Abilities;
import characters.Hero;
import characters.HeroTypes;
import characters.HeroesSquad;
import characters.Types;
import characters.Villains;
import city.City;
import city.buildings.Building;
import city.buildings.PowerUpDen;
/*
* This class deals with the GUI transitions and information transfer among the main windows of the game.
* It allows to start each city window and from there managing all the buildings windows. 
*/
import city.buildings.TypeBuildings;
import city.buildings.homeBase.Home;
import city.buildings.hospital.Hospital;
import city.buildings.shop.Shop;
import collectables.Money;
import engine.Tuple;
import minigames_V2.MiniGameEngine;



public class GameWindowManager implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private final String characterTypes = "Talkitive : Has the ability to Charm people \n"
			+ "    (Gets 25% better prices at shops) \n"
			+ "Smart : Mystery Ability, which could help or hinder \n"
			+ "    your team (Minigame dependant) \n"
			+ "Practical : Gets better odds at rock, paper Scissors \n"
			+ "Strong : Takes 30% less damage \n"
			+ "Sly : Wins all match draws unless the Villain \n"
			+ "    has this abilty \n"
			+ "Dog : Is a good boy (Grants all team member\n"
			+ "    extra 25HP Max Health)";
//	private HeroesSquad squad = new HeroesSquad();
//	private ArrayList<City> world = new ArrayList<City>();
	
	private int currentIndex;
	
	private ArrayList<City> world;
	private HeroesSquad squad;
	private Villains villains;
	private int worldSize;
	
	private City currentCity;
	private boolean isHospitalWindowOpen;
	
	//Minigame stuff
	private MiniGameEngine miniGameEngine;
	private int selectedHeroIndex;
	
//	private boolean hasSquadTalkativeHero;
	private Money lootAfterVillainDefated;



	public GameWindowManager() {
//		this.currentCity = city;
//		this.squad = squad;
		squad = new HeroesSquad();
		world = new ArrayList<City>();
//		hasSquadTalkativeHero = false;
		currentIndex = 0;
		lootAfterVillainDefated = new Money(30);
	}
	
	/**
	 * @return the city
	 */
	public City getCurrentCity() {
		return currentCity;
	}
	/**
	 * @param city the city to set
	 */
	public void setCurrentCity(City city) {
		this.currentCity = city;
	}
	/**
	 * @return the squad
	 */
	public HeroesSquad getSquad() {
		return squad;
	}
	/**
	 * @param squad the squad to set
	 */
	public void setSquad(HeroesSquad squad) {
		this.squad = squad;
	}
	
	/*
	 * The method that instantiates a new MainGameScreen window application.
	 * It passes the manager itself to the object to be able to have power on 
	 * the launching and closing of the buildings windows.
	 */
	public void launchMainGameScreen() {
		MainGameWindow mainGameScreen = new MainGameWindow(this);
		mainGameScreen.getFrame().setTitle("Level " + (currentIndex + 1));
	}
	
	/**
	 * 
	 * Method to start the full first part of the game, where the squad and the world are created
	 * 
	 */
	public void launchSetupTeamAndWorld() {
		SetupTeamAndWorld setupWindow = new SetupTeamAndWorld(this);
	}
	
	/**
	 * @param mainGameScreen (Type MainGameWindow) 
	 * Closes the MainGameWindow object.
	 */
	public void closeMainGameWindow(MainGameWindow mainGameWindow) {
		mainGameWindow.closeWindow();
	}
	
	/**
	 * 
	 * @param homeWindow (Type HomeWindow)
	 * @param mainWindow (Type MainGameWindow)
	 * 
	 * It deals with closing the homeWindow parameter. As homeWindow can exist only if mainWindow exists, every time 
	 * it is needed to exit the HomeBaseWindow, the main map needs to be visible and to reset the position of the moving label so that 
	 * the movingLabel will not involuntarily reactivate the listener and be sent back to HomeBase again.
	 * 
	 */
	public void closeHomeBaseWindow(HomeWindow homeWindow, MainGameWindow mainWindow) {
		homeWindow.closeWindow();
		//Hardcoded!! Watch out when measurements change
		mainWindow.moveSquadAwayFromBuilding(new Point(326, 264));
//		mainWindow.getFrame().setVisible(true);
		mainWindow.getFrame().setVisible(true);
	}
	
	public void closePowerUpDenWindow(PowerUpDenWindow powerUpDenWindow, MainGameWindow mainWindow) {
		powerUpDenWindow.closeWindow();
		//Hardcoded!! Watch out when measurements change
		// NOTE: this sends back to in front of the HomeBase, for now this will do, maybe try to improve, 
		// but it looks hard to do at the moment, leave it as a refinement.
		mainWindow.moveSquadAwayFromBuilding(new Point(326, 264));
//		mainWindow.getFrame().setVisible(true);
		mainWindow.getFrame().setVisible(true);
	}
	
	/**
	 * 
	 * @param hospitalWindow (Type HospitalWindow)
	 * @param mainWindow (Type MainGameWindow)
	 * 
	 * It deals with closing the MainGameWindow parameter. As hospitalWindow can exist only if mainWindow exists, every time 
	 * it is needed to exit the HospitalWindow, the main map needs to be visible and to reset the position of the moving label so that 
	 * the movingLabel will not involuntarily reactivate the listener and be sent back to HomeBase again.
	 * 
	 */
	public void closeHospitalWindow(HospitalWindow hospitalWindow, MainGameWindow mainWindow) {
		
		hospitalWindow.closeWindow();
		isHospitalWindowOpen = false;
		//Hardcoded!! Watch out when measurements change
		// NOTE: this sends back to in front of the HomeBase, for now this will do, maybe try to improve, 
		// but it looks hard to do at the moment, leave it as a refinement.
		mainWindow.moveSquadAwayFromBuilding(new Point(326, 264));
//		mainWindow.getFrame().setVisible(true);
		mainWindow.getFrame().setVisible(true);
	}
	
	
	/**
	 * 
	 * @param hospitalWindow (Type ShopWindow)
	 * @param mainWindow (Type MainGameWindow)
	 * 
	 * It deals with closing the MainGameWindow parameter. As hospitalWindow can exist only if mainWindow exists, every time 
	 * it is needed to exit the ShopWindow, the main map needs to be visible and to reset the position of the moving label so that 
	 * the movingLabel will not involuntarily reactivate the listener and be sent back to HomeBase again.
	 * 
	 */
	public void closeShopWindow(ShopWindow shopWindow, MainGameWindow mainWindow) {
		
		shopWindow.closeWindow();
		isHospitalWindowOpen = false;
		//Hardcoded!! Watch out when measurements change
		// NOTE: this sends back to in front of the HomeBase, for now this will do, maybe try to improve, 
		// but it looks hard to do at the moment, leave it as a refinement.
		mainWindow.moveSquadAwayFromBuilding(new Point(326, 264));
//		mainWindow.getFrame().setVisible(true);
		mainWindow.getFrame().setVisible(true);
	}
	
	
	public void finalCloseVillainLairWindow(VillainLairWindow villainLairWindow, MainGameWindow mainGameWindow, boolean herosWon) {
		currentIndex += 1;
		villainLairWindow.closeWindow();
		
		if (herosWon) {
			if (currentIndex < world.size()) {
				currentCity = world.get(currentIndex);
				squad.setCurrentCity(currentCity);

////				mainGameWindow.moveSquadAwayFromBuilding(new Point(336, 300));
//				mainGameWindow.getFrame().dispose();
				

				
//				mainGameWindow.moveSquadAwayFromBuilding(new Point(326, 264));
//				mainGameWindow.getFrame().setTitle("Level " + (currentIndex + 1));
//				mainGameWindow.getFrame().setVisible(true);
//				TODO: Gotta fix something around here, think now works
//				squad.getWallet().addMoney(lootAfterVillainDefated);
				squad.getWallet().addMoney(new Money(lootAfterVillainDefated.getAmount() * currentIndex));
				
				squad.setHaveMap(false);
				launchMainGameScreen();
				
				
				serialiseManagerStatus();
				
			} else {
				closeMainGameWindow(mainGameWindow);
				new YouWonWindow(this);
				System.out.println("YOU WON!");
				cleanManagerSerFil();
			}
		} else {
			closeMainGameWindow(mainGameWindow);
			new YouLostWindow(this);
			System.out.println("YOU LOST");
			cleanManagerSerFil();
		}
	}
	
	
	public void cleanManagerSerFil() {
		
		File file = new File("src/saved_instances/manager.ser");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	/**
	 * 
	 * @param building (Type {@link Building})
	 * @param mainWindow (Type {@link MainGameWindow})
	 * 
	 * Contains a switch statement that allows to choose in which building to be sent.
	 * If the {@link TypeBuildings} of the building parameter is one of the 5 possible ones, 
	 * it will instantiate a new Window and it will pass it the necessary parameters.
	 *   
	 */
	public void openBuildingWindow(Building building, MainGameWindow mainWindow) {
		
		switch (building.getBuildingType()) {
			case Home:
				HomeWindow hw = new HomeWindow(this, (Home) building, mainWindow);
				mainWindow.getFrame().setVisible(false);
				break;
			case PowerUpDen:
				PowerUpDenWindow powerUpDenWindow = new PowerUpDenWindow(this, (PowerUpDen) building, mainWindow);
				mainWindow.getFrame().setVisible(false);
				break;
			case Hospital:
				isHospitalWindowOpen = true;
				HospitalWindow hospitalWindow = new HospitalWindow(this, (Hospital) building, mainWindow);
				mainWindow.getFrame().setVisible(false);
				break;
			case Shop:
				ShopWindow shopWindow = new ShopWindow(this, (Shop) building, mainWindow);
				mainWindow.getFrame().setVisible(false);
				break;
			case VillainsLair:
				dealingWithVillainLairChoice(mainWindow);
//				miniGameEngine = new MiniGameEngine();
//				VillainLairWindow villLairWindow = new VillainLairWindow(this, mainWindow);
				break;
			default:
				break;//For now, want to give it a go with HomeBase and see what happens. Fingers crossed...
		}
	}
	
	private void dealingWithVillainLairChoice(MainGameWindow mainWindow) {
		int a = JOptionPane.showConfirmDialog(mainWindow.getFrame(),"Do you really want to enter the Villain Lair? You surely aren't good enough for this!", "Villain Lair", JOptionPane.YES_NO_OPTION);
		if (a == 0) {
			miniGameEngine = new MiniGameEngine();
			VillainLairWindow villLairWindow = new VillainLairWindow(this, mainWindow);
			mainWindow.getFrame().setVisible(false);
		} else {
			mainWindow.moveSquadAwayFromBuilding(new Point(326, 264));
		}
	}
	
	/**
	 * @return the isHospitalWindowOpen
	 */
	public boolean isHospitalWindowOpen() {
		return isHospitalWindowOpen;
	}
	
	
	/**
	 * @param isHospitalWindowOpen the isHospitalWindowOpen to set
	 */
	public void setHospitalWindowOpen(boolean isHospitalWindowOpen) {
		this.isHospitalWindowOpen = isHospitalWindowOpen;
	}
	
	
//<<<<<<< HEAD
//
//	public static void main(String[] args) {
//
//		GameWindowManager manager = new GameWindowManager();
//		manager.launchSetupTeamAndWorld();
//		
//		// For testing the minigame module
//		Hero hero1 = new Hero("heroOne", Types.talkitive, Abilities.charm);
//		Hero hero2 = new Hero("heroTwo", Types.smart, Abilities.mystery);
//		Hero hero3 = new Hero("heroThree", Types.practical, Abilities.betterOdds);
//		Hero hero4 = new Hero("hero4", Types.strong, Abilities.lessDamage);
//		Hero hero5 = new Hero("hero5",Types.sly, Abilities.winDraws);
//		Hero hero6 = new Hero("hero3",Types.dog, Abilities.goodBoy);
//		
////		manager.getSquad().addHero(hero5);
////		manager.getSquad().addHero(hero2);
////		manager.getSquad().addHero(hero6); 
//////		hero2.setisAlive(false);
//////		hero3.setisAlive(false);
//////		hero3.setisAlive(false);
////		hero2.setArmor(30);
////		hero5.setIsGameChooser(true);
////		hero2.setIsGameChooser(true);
////		hero6.setIsGameChooser(true);
////		hero6.setIsinDetention(true);
////		hero5.setHealth(10);
////		Villain villain = manager.villains.getCurrentVillain(manager.getCurrentIndex());
////		villain.setTimesBeaten();
////		villain.setTimesBeaten();
////		Money wallet = testsquad.getWallet();
//
////		MainGameWindow mainGameScreen = new MainGameWindow(manager);
////		VillainLairWindow villainLairWindow = new VillainLairWindow(manager, mainGameScreen);
//	}		

		
	
	// Merged from Jays Setup Manager
	
	
	public void closeSetupTeamAndWorld(SetupTeamAndWorld setupTeamAndWorld) {
		setupTeamAndWorld.closeWindow();
		launchsetupAddHeros(this);
	}
	
	public void launchsetupAddHeros(GameWindowManager gameWindowManager) {
		new SetupAddHeros(this);
	}
	
	public void closeSetupAddHeros(SetupAddHeros setupWindow) {
		setupWindow.closeWindow();
		launchSetupTeamAndWorld();
		
	}
	
	public void finalcloseSetupAddHeros(SetupAddHeros setupWindow) {
		setupWindow.closeWindow();
		villains = new Villains(world.size());
		setCurrentCity(world.get(currentIndex));
		squad.setCurrentCity(currentCity);
		
		launchMainGameScreen();
	}
	
	public void createWorld() {
		int numberCities = getWorldSize();
		world.removeAll(world);
		for (int i = 0; i < numberCities; i++) {
			City city = new City();
			world.add(city);
		}
	}
	
//	private boolean lookForTalkativeHero() {
//		for (Hero hero : squad.getHeroSquad()) {
//			if (hero.getCharacterType().equals(Types.talkitive)) {
//				return true;
//			}
//		}
//		
//		return false;
//	}
	
	public void closeVillainLairWindow(VillainLairWindow villainLairWindow, MainGameWindow mainGameWindow) {
		villainLairWindow.closeWindow();
		int selectedMiniGame = miniGameEngine.getSelectedMiniGame();
		System.out.println(selectedMiniGame);
		switch (selectedMiniGame) {
			case 1: launchRpsWindow(this, mainGameWindow); break;
			case 2: launchGtnWindow(this, mainGameWindow); break;
			case 3: launchDWWindow(this, mainGameWindow); break;
			default: System.out.println("Fail on window");
		}
		
	}
		
	public void launchRpsWindow(GameWindowManager gameWindowManager, MainGameWindow mainGameWindow) {
		RPSWindow rpsWindow = new RPSWindow(this, mainGameWindow);
	}
	
	public void closeRpsWindow(RPSWindow rpswindow, MainGameWindow mainGameWindow) {
		rpswindow.closeWindow();
		VillainLairWindow villainsLairWindow = new VillainLairWindow(this, mainGameWindow);
	}
	
	public void launchGtnWindow(GameWindowManager gameWindowManager, MainGameWindow mainGameWindow) {
		GTNWindow gtnWindow = new GTNWindow(this, mainGameWindow);
	}
	
	public void closeGtnWindow(GTNWindow gtnWindow, MainGameWindow mainGameWindow) {
		gtnWindow.closeWindow();
		VillainLairWindow villainsLairWindow = new VillainLairWindow(this, mainGameWindow);
	}
	
	public void launchDWWindow(GameWindowManager gameWindowManager, MainGameWindow mainGameWindow) {
		DWWindow dwWindow = new DWWindow(this, mainGameWindow);
	}
	
	public void closeDWWindow(DWWindow dwWindow, MainGameWindow mainGameWindow) {
		dwWindow.closeWindow();
		VillainLairWindow villainsLairWindow = new VillainLairWindow(this, mainGameWindow);
	}
	
	/**
	 * @return the characterTypes
	 */
	public String getCharacterTypes() {
		return characterTypes;
	}
	
	/**
	 * @return the world
	 */
	public ArrayList<City> getWorld() {
		return world;
	}

	/**
	 * @param world the world to set
	 */
	public void setWorld(ArrayList<City> world) {
		this.world = world;
	}
	
	/**
	 * @return the villains
	 */
	public Villains getVillains() {
		return villains;
	}

	/**
	 * @param villains the villains to set
	 */
	public void setVillains(Villains villains) {
		this.villains = villains;
	}
	
	/**
	 * @return the currentIndex
	 */
	public int getCurrentIndex() {
		return currentIndex;
	}

	/**
	 * @param currentIndex the currentIndex to set
	 */
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	/**
	 * @return the miniGameEngine
	 */
	public MiniGameEngine getMiniGameEngine() {
		return miniGameEngine;
	}

	/**
	 * @param miniGameEngine the miniGameEngine to set
	 */
	public void setMiniGameEngine(MiniGameEngine miniGameEngine) {
		this.miniGameEngine = miniGameEngine;
	}

	/**
	 * @return the selectedHeroIndex
	 */
	public int getSelectedHeroIndex() {
		return selectedHeroIndex;
	}

	/**
	 * @param selectedHeroIndex the selectedHeroIndex to set
	 */
	public void setSelectedHeroIndex(int selectedHeroIndex) {
		this.selectedHeroIndex = selectedHeroIndex;
	}

	/**
	 * @return the worldSize
	 */
	public int getWorldSize() {
		return worldSize;
	}

	/**
	 * @param worldSize the worldSize to set
	 */
	public void setWorldSize(int worldSize) {
		this.worldSize = worldSize;
	}
	
	/**
	 * @return the lootAfterVillainDefated
	 */
	public Money getLootAfterVillainDefated() {
		return lootAfterVillainDefated;
	}

	/**
	 * @param lootAfterVillainDefated the lootAfterVillainDefated to set
	 */
	public void setLootAfterVillainDefated(Money lootAfterVillainDefated) {
		this.lootAfterVillainDefated = lootAfterVillainDefated;
	}

	public Types typeConversion (HeroTypes heroType) {
		switch (heroType) {
		case Talkitive: return Types.talkitive;
		case Smart: return Types.smart;
		case Practical: return Types.practical;
		case Strong: return Types.strong;
		case Sly: return Types.sly;
		case Dog: return Types.dog;
		}
		
		return null;
		
	}
	
	public Abilities getHeroAbility (Types heroType) {
		switch (heroType) {
		case talkitive: return Abilities.charm;
		case smart: return Abilities.mystery;
		case practical: return Abilities.betterOdds;
		case strong: return Abilities.lessDamage;
		case sly: return Abilities.winDraws;
		case dog: return Abilities.goodBoy;
		default:
			break;
		}
		
		return null;
		
	}

	
	public static void main(String[] args) {

		GameWindowManager manager = new GameWindowManager();
		manager.launchSetupTeamAndWorld();
		
		// For testing the minigame module
		Hero hero1 = new Hero("heroOne", Types.talkitive, Abilities.charm);
		Hero hero2 = new Hero("heroTwo", Types.smart, Abilities.mystery);
		Hero hero3 = new Hero("heroThree", Types.practical, Abilities.betterOdds);
		Hero hero4 = new Hero("hero4", Types.strong, Abilities.lessDamage);
		Hero hero5 = new Hero("hero5",Types.sly, Abilities.winDraws);
		Hero hero6 = new Hero("hero3",Types.dog, Abilities.goodBoy);
		
		manager.getSquad().addHero(hero5);
		manager.getSquad().addHero(hero2);
		manager.getSquad().addHero(hero6); 
////		hero2.setisAlive(false);
////		hero3.setisAlive(false);
////		hero3.setisAlive(false);
//		hero2.setArmor(30);
//		hero5.setIsGameChooser(true);
		hero2.setIsGameChooser(true);
//		hero6.setIsGameChooser(true);
		hero6.setIsinDetention(true);
//		hero5.setHealth(10);
//		Villain villain = manager.villains.getCurrentVillain(manager.getCurrentIndex());
//		villain.setTimesBeaten();
//		villain.setTimesBeaten();
//		Money wallet = testsquad.getWallet();

//		MainGameWindow mainGameScreen = new MainGameWindow(manager);
//		VillainLairWindow villainLairWindow = new VillainLairWindow(manager, mainGameScreen);
	}	
	
	private void serialiseManagerStatus() {
		
//		GameWindowManager manager = new GameWindowManager();
//		manager.setWorld(this.getWorld());
//		manager.setSquad(this.getSquad());
//		manager.setVillains(this.getVillains());
//		manager.setWorldSize(this.getWorldSize());
//		manager.setCurrentCity(this.getCurrentCity());
//		manager.setLootAfterVillainDefated(this.getLootAfterVillainDefated());
//		manager.setMiniGameEngine(this.getMiniGameEngine());
//		manager.setCurrentIndex(this.getCurrentIndex());
		
		try {
			FileOutputStream fileOut = new FileOutputStream("src/saved_instances/manager.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in src/saved_instances/manager.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}

		
	}
	
	public boolean saveScore() {
//		This method is called inside the You Won and You Lost windows need to Deserialise what exists in scores_board, then reserialise it with the addition of 1 item
		ArrayList<Tuple<String, Integer, String>> pairList = null;
		try {
			FileInputStream fileIn = new FileInputStream("src/saved_instances/scores_board.ser");
			if (!(fileIn.available() == 0)) {
				ObjectInputStream in = new ObjectInputStream(fileIn);
				pairList =  (ArrayList<Tuple<String, Integer, String>>) in.readObject();
				in.close();
			}
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return false;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return false;
		}
		
		if (pairList == null) {
			pairList = new ArrayList<Tuple<String, Integer, String>>();
		}
		
		String teamName = squad.getTeamName();
		Integer score = squad.getWallet().getAmount() * 40;
		score -= squad.getLength() * 100;
		score += worldSize * 200;
		Date dateItem = new Date();
		String date = dateItem.toString();
		System.out.println(date);
		
		Tuple<String, Integer, String> newScore = new Tuple<String, Integer, String>(teamName, score, date);
		
		pairList.add(0, newScore);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("src/saved_instances/scores_board.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(pairList);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /src/saved_instances/scores_board.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
		
		return true;
	}

	
}
