package GUIPOC;

import java.awt.Point;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import city.City;
import city.buildings.Building;
/*
* This class deals with the GUI transitions and information transfer among the main windows of the game.
* It allows to start each city window and from there managing all the buildings windows. 
*/
import city.buildings.TypeBuildings;

public class GameWindowManager {
	
	
	private City city;
	private HeroesSquad squad;
	
	public GameWindowManager(City city, HeroesSquad squad) {
		super();
		this.city = city;
		this.squad = squad;
	}
	
	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
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
	 * It deals with closing the MainGameWindow parameter. As homeWindow can exist only if mainWindow exists, every time 
	 * it is needid to exit the HomeBase, the main map needs to be visible and to reset the position of the moving label so that 
	 * the movingLabel will not involuntarily reactivate the listener and be sent back to HomeBase again.
	 * 
	 */
	public void closeHomeBaseWindow(HomeWindow homeWindow, MainGameWindow mainWindow) {
		homeWindow.closeWindow();
		//Hardcoded!! Watch out when measurements change
		mainWindow.moveSquadAwayFromBuilding(new Point(336, 300));
		mainWindow.getFrame().setVisible(true);
		
	}
	
	/**
	 * 
	 * @param building (Type {@link Building})
	 * @param mainWindow (Type {@link MainGameWindow})
	 * 
	 * Contains a switch statement that allows to choose in which building to be sent.
	 * If the {@link TypeBuildings} of the building parameter is one of the 5 possible ones, 
	 * it will instantiate a new Window and it will pass it the nexessary parameters.
	 *   
	 */
	public void openBuildingWindow(Building building, MainGameWindow mainWindow) {
		
		switch (building.getBuildingType()) {
			case Home:
				HomeWindow homeWindow = new HomeWindow(this, building, mainWindow);
				break;
			default:
				break;//For now, want to give it a go with HomeBase and see what happens. Fingers crossed...
		}
				
		
	}
	
	public static void main(String[] args) {
		City city = new City();
		HeroesSquad squad = new HeroesSquad();
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.betterOdds);
		squad.addHero(lorenzo);
		GameWindowManager manager = new GameWindowManager(city, squad);
		manager.launchMainGameScreen();
	}
	
	
	
}
