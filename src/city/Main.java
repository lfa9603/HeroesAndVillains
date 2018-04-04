
package city;

import java.util.ArrayList;

import city.buildings.Building;
import city.buildings.Home;
import city.buildings.Hospital;
import city.buildings.PowerUpDen;
import city.buildings.Shop;
import city.buildings.VillainsLair;

public class Main {
	
	public static void main(String[] args) {
		
		Home home = new Home("Casa");
		Coordinates.setHomeCoordinates(home);
		System.out.println(home.getBuildingCoordinates());
		
		Hospital hospital = new Hospital("Hospital");
		PowerUpDen pub = new PowerUpDen("Pub");
		VillainsLair villainCave = new VillainsLair("VillainCave");
		Shop shop = new Shop("Shop");
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
