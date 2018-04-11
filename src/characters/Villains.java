package characters;

import java.util.ArrayList;

import city.WorldBuilder;

public class Villains {
	private static ArrayList<Villain> villains = new ArrayList<Villain>();
	private int numOfVillains = WorldBuilder.si

	/**
	 * @return the villains
	 */
	public static ArrayList<Villain> getVillains() {
		return villains;
	}

	/**
	 * @param villains the villains to set
	 */
	public static void createVillains(ArrayList<Villain> villains) {
		Villains.villains = villains;
	}
	
	

}
