package city;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static engine.HelperScanner.*;


/**
 * 
 * This class deals with the user input and it allows the player to choose 
 * the number of levels they want to explore (between 3 and 6 inclusive).
 * 
 */

//TODO: chat with the lab tutors about the Scanner opening and closing Stream thing
public class WorldBuilder {

	private ArrayList<City> world;
	
	/**
	 * 
	 * The WorldBuilder constructor, when a new object of this class is instantiated it will 
	 * automatically ask for user input and create an ArrayList of City objects of the requested size.
	 * 
	 */
	public WorldBuilder() {
		world = createWorld();
	}
	
	/**
	 * 
	 * @return an ArrayList of City objects of size depending on the user input.
	 * User input also registered in this method. 
	 * 
	 */
	private ArrayList<City> createWorld() {
		boolean stillAsking = true;
		Integer integerTyped = null;
		System.out.println("How many cities would you like to explore? (Please type a number between 3 and 6)");
				
		while (stillAsking) {
			try {
				integerTyped = nextInt();
				if (integerTyped >= 3 && integerTyped <= 6) {
					stillAsking = false;
					
				} else {
					System.out.println("Invalid integer, please type a value betwen (and including) 3 and 6");
				}
			} catch (InputMismatchException error){
				System.out.println("Invalid input, have you typed a valid integer?");
				System.out.println("Try again");
				next();
				
			} finally {
				reset();
			}
		}
		
		if (! integerTyped.equals(null)) {
			world = new ArrayList<City>();
			createWorldHelper(integerTyped, world);
		}
		
		return world;
	}

	/**
	 * 
	 * @param numberCities Integer object, used for instantiating the right number of City objects.
	 * @param listCities an initially empty ArrayList of City objects that is filled up with @param numberCities City objects.
	 * 
	 * Helper method for createWorld() method.
	 * 
	 */
	public void createWorldHelper(Integer numberCities, ArrayList<City> listCities) {
		for (int i = 0; i < numberCities; i++) {
			City city = new City();
			listCities.add(city);
		}
	}
	
	/**
	 * 
	 * Getter method for world property.
	 * @return ArrayList of City objects.
	 *  
	 */
	public ArrayList<City> getWorld() {
		return world;
	}
	
	
//	public static void main(String[] args) {
//		WorldBuilder wb = new WorldBuilder();
//	}
	
}
