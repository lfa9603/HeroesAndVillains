package city.buildings.homeBase;

//import java.awt.Point;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import java.util.InputMismatchException;
//import java.util.Scanner;

//import characters.Abilities;
//import characters.Abilities;
import characters.Character;
//import characters.Hero;
//import characters.Hero;
import characters.HeroesSquad;
//import characters.Types;
//import characters.Types;
//import city.City;
//import collectables.CollectableID;
//import collectables.Money;
//import collectables.heroesMap.HeroesMap;
//import city.City;
import city.buildings.Building;
import city.buildings.TypeBuildings;
import collectables.Collectable;
//import collectables.Money;

import static engine.HelperScanner.*;


/**
 * 
 * Home class extends Building, its TypeBuildings type is PowerUpDen and its builidngCoordinates 
 * are always a random value among (4, 0),(-4, 0)(0, 4) or (0, -4) (this last step happens in WorldBuilder class).
 * The method interact is implemented such that it allows the user to use the PowerUp items bought in the Shop.
 * If the team does not own a selected item, it will tell the player that the item is not available to be used.
 */

public class Home extends Building {

	
	
	/**
	 * 	
	 * @param name
	 * @param buildType
	 */
	public Home(String name, TypeBuildings buildType) {
		super(name, buildType);		
	}	
		
	/**
	 * Method to override, it allows the user to choose between checking the heroes' 
	 * status and checking the map of the level.
	 * If the team does not own a map it will tell the player the map is not available.
	 * It uses the two helper methods @showMap(...) and @showHeroesStatus(...) for readability and maintenance purposes.
	 * Handles @InputMismatchException exceptions alerting the user and giving them the chance press a different key.
	 */
	public void interact(HeroesSquad heroesSquad) {
		
		checkingSomeoneRobbedOrDonated(heroesSquad);
		
		boolean atHome = true;
		System.out.println("Welcome in your Home Base!");
		while (atHome) {
			
			System.out.println("Type:\n"
					+ " 0 to see the map\n"
					+ " 1 to check the heroes status\n"
					+ " 2 to exit\n");
			try {
				Integer valueTyped = nextInt();
				switch(valueTyped) {
				case 0:
					showMap(heroesSquad);//TODO modify this method
					break;
				case 1:
					showHeroesStatus(heroesSquad);
					break;
				case 2:
//					input.close();
					atHome = false;
					System.out.println("Come back soon");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please press a key corresponding to one of the three options");
				next();
				
			} finally {
				reset();
			}
		}
	}
	
	
	/**
	 * 
	 * @param heroesSquad
	 * @return a String object indicating if the team has been robbed or gifted anything.
	 * 
	 */
	public String checkingSomeoneRobbedOrDonated(HeroesSquad heroesSquad) {
		
		Collectable itemStolen = RandomEventsInHomeBase.haveWeBeenRobbed(heroesSquad);
		Collectable itemDonated = RandomEventsInHomeBase.hasAnyoneBeenGenerous(heroesSquad);
		
		String toReturn = new String();
		
		if (itemDonated != null) {
			toReturn += ("Someone has been generous!! \n"
					+ "A " + itemDonated.getCollectableID() + " has been left in the house for you!"
					+ "\n Enjoy!\n");
		}
		
		if (itemStolen != null) {
			toReturn += ("Someone broke into the house!\n "
					+ "A " + itemStolen.getCollectableID() + " has been stolen!");
		}
		
//		System.out.println(heroesSquad.getBackPack().toString());
		
		if (toReturn.length() == 0) {
			toReturn = "No good or bad luck this time!";
		}
		return toReturn;
	}
	
	
	/**
	 * 
	 * @param heroesSquad the HeroesSquad element playing the game
	 * 
	 * * Helper method for @interact(), checks if the heroes squad has a map of the current city and 
	 * @return the coordinates of the 5 buildings in each city or a message telling the player the heroes squad does not own a map.
	 * Helper method for @interact().
	 */
	public String showMap(HeroesSquad heroesSquad) {
		String showMapMessage = new String();
		if (heroesSquad.isHaveMap()) {
			System.out.println(heroesSquad.getCurrentCity());
			showMapMessage += heroesSquad.getCurrentCity();
		} else {
			System.out.println("No map available at this stage");
			showMapMessage += "No map available at this stage";
		}
		return showMapMessage;
	}

	/**
	 * 
	 * @param heroesSquad the HeroesSquad element playing the game
	 * 
	 * Iterates through the heroes squad and 
	 * @return a string containing each character status and abilities.
	 */
	public String showHeroesStatus(HeroesSquad heroSquad) {
		String heroesDescription = heroSquad.toString();
		return heroesDescription;
		
	}




}
