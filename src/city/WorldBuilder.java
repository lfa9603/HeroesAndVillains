package city;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WorldBuilder {

	private ArrayList<City> world;
	
	public WorldBuilder() {
		world = createWorld();
	}
	
	
	private ArrayList<City> createWorld() {
		boolean stillAsking = true;
		Integer integerTyped = null;
		System.out.println("How many cities would you like to explore? (Please type a number between 3 and 6)");
		while (stillAsking) {
			Scanner input = new Scanner(System.in);
			try {
				integerTyped = input.nextInt();
				if (integerTyped >= 3 && integerTyped <= 6) {
					stillAsking = false;
					input.close();
				} else {
					System.out.println("Invalid integer, please type a value betwen (and including) 3 and 6");
				}
			} catch (InputMismatchException error){
				System.out.println("Invalid input, have you typed a valid integer?");
				System.out.println("Try again");
			} finally {
				input.reset();
			}
		}
		
		if (! integerTyped.equals(null)) {
			world = new ArrayList<City>();
			createWorldHelper(integerTyped, world);
		}
		
		return world;
	}

	
	private void createWorldHelper(Integer numberCities, ArrayList<City> listCities) {
		for (int i = 0; i < numberCities; i++) {
			City city = new City();
			listCities.add(city);
		}
	}
	
	public ArrayList<City> getWorld() {
		return world;
	}
	
	
	// main function for testing purposes
	public static void main(String[] args) {
		
	}
}
