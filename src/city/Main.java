
package city;

import java.util.ArrayList;

import city.buildings.Building;
import city.buildings.Home;

public class Main {
	
	public static void main(String[] args) {
		
		Home home = new Home("Casa");
		Coordinates.setHomeCoordinates(home);
		System.out.println(home.getBuildingCoordinates());
		
		Home hospital = new Home("Hospital");
		Home pub = new Home("Pub");
		Home villainCave = new Home("VillainCave");
		Home shop = new Home("Shop");
		ArrayList<Building> listBuildings = new ArrayList<Building>();
		listBuildings.add(pub);
		listBuildings.add(shop);
		listBuildings.add(villainCave);
		listBuildings.add(hospital);
		Coordinates.setBuildingsCoordinates(listBuildings);
		for (Building building : listBuildings) {
			System.out.println(building.getBuildingName() +  "   " + building.getBuildingCoordinates());
		}
	}

}
