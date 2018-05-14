package GUIPOC;

import java.awt.Point;
import java.util.ArrayList;

import characters.Abilities;
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
import minigames_V2.DiceWars;
import minigames_V2.GuessTheNumber;
import minigames_V2.MiniGameEngine;
import minigames_V2.RockPaperScissors;

public class GameWindowManager {
	
	private final String characterTypes = "1. Talkitive : Has the ability to Charm people \n"
			+ "    (Gets 25% better prices at shops) \n"
			+ "2. Smart : Mystery Ability, which could help or hinder \n"
			+ "    your team (Minigame dependant) \n"
			+ "3. Practical : Gets better odds at rock, paper Scissors \n"
			+ "4. Strong : Takes 30% less damage \n"
			+ "5. Sly : Wins all match draws unless the Villain \n"
			+ "    has this abilty \n"
			+ "6. Dog : Is a good boy (Grants all team member\n"
			+ "    extra 25HP Max Health)";
//	private HeroesSquad squad = new HeroesSquad();
//	private ArrayList<City> world = new ArrayList<City>();
	
	private int currentIndex;
	
	private ArrayList<City> world;
	private HeroesSquad squad;
	private Villains villains;
	
	private City currentCity;
	private boolean isHospitalWindowOpen;
	
	//Minigame stuff
	private MiniGameEngine miniGameEngine;
	private RockPaperScissors rockPaperScissors;
	private GuessTheNumber guessTheNumber;
	private DiceWars diceWars;
	

	public GameWindowManager() {
//		this.currentCity = city;
//		this.squad = squad;
		squad = new HeroesSquad();
		world = new ArrayList<City>();
		currentIndex = 0;
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
	}
	
	/**
	 * 
	 * Method to start the full first part of the game, where the squad and the world are created
	 * 
	 */
	public void launchSetupTeamAndWorld() {
		setupTeamAndWorld setupWindow = new setupTeamAndWorld(this);
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
		mainWindow.moveSquadAwayFromBuilding(new Point(336, 300));
//		mainWindow.getFrame().setVisible(true);
		mainWindow.getFrame().setVisible(true);
	}
	
	public void closePowerUpDenWindow(PowerUpDenWindow powerUpDenWindow, MainGameWindow mainWindow) {
		powerUpDenWindow.closeWindow();
		//Hardcoded!! Watch out when measurements change
		// NOTE: this sends back to in front of the HomeBase, for now this will do, maybe try to improve, 
		// but it looks hard to do at the moment, leave it as a refinement.
		mainWindow.moveSquadAwayFromBuilding(new Point(336, 300));
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
		mainWindow.moveSquadAwayFromBuilding(new Point(336, 300));
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
		mainWindow.moveSquadAwayFromBuilding(new Point(336, 300));
//		mainWindow.getFrame().setVisible(true);
		mainWindow.getFrame().setVisible(true);
	}
	
	
	public void closeVillainLairWindow(VillainLairWindow villainLairWindow, MainGameWindow mainGameWindow, boolean herosWon) {
		currentIndex += 1;
		villainLairWindow.closeWindow();
		
		if (herosWon) {
			if (currentIndex < world.size()) {
				currentCity = world.get(currentIndex);
				mainGameWindow.moveSquadAwayFromBuilding(new Point(336, 300));
				mainGameWindow.getFrame().setVisible(true);
			} else {
				closeMainGameWindow(mainGameWindow);
				System.out.println("YOU WON!");
			}
		} else {
			closeMainGameWindow(mainGameWindow);
			System.out.println("YOU LOST");
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
				HomeWindow homeWindow = new HomeWindow(this, (Home) building, mainWindow);
				break;
			case PowerUpDen:
				PowerUpDenWindow powerUpDenWindow = new PowerUpDenWindow(this, (PowerUpDen) building, mainWindow);
				break;
			case Hospital:
				isHospitalWindowOpen = true;
				HospitalWindow hospitalWindow = new HospitalWindow(this, (Hospital) building, mainWindow);
				break;
			case Shop:
				ShopWindow shopWindow = new ShopWindow(this, (Shop) building, mainWindow);
				break;
			case VillainsLair:
<<<<<<< HEAD
				VillainLairWindow villainsLairWindow = new VillainLairWindow(this, mainWindow);
=======
				miniGameEngine = new MiniGameEngine();
				VillainLairWindow villainsLairWindow = new VillainLairWindow(this);
>>>>>>> a61dffaa9168600240213cc7d9dc90d9d40b12ea
				break;
			default:
				break;//For now, want to give it a go with HomeBase and see what happens. Fingers crossed...
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

	public static void main(String[] args) {

		GameWindowManager manager = new GameWindowManager();
		manager.launchSetupTeamAndWorld();
		
	}
	
	// Merged from Jays Setup Manager
	
	
	public void closeSetupTeamAndWorld(setupTeamAndWorld setupTeamAndWorld) {
		setupTeamAndWorld.closeWindow();
		launchsetupAddHeros(this);
		
	}
	
	public void launchsetupAddHeros(GameWindowManager gameWindowManager) {
		SetupAddHeros setupWindow = new SetupAddHeros(this);
	}
	
	public void closeSetupAddHeros(SetupAddHeros setupWindow) {
		setupWindow.closeWindow();
		launchSetupTeamAndWorld();
		
	}
	
	public void finalcloseSetupAddHeros(SetupAddHeros setupWindow) {
		setupWindow.closeWindow();
		villains = new Villains(world.size());
		setCurrentCity(world.get(currentIndex));
		launchMainGameScreen();
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
	
}
