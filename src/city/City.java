package city;

import java.awt.Point;
import java.util.ArrayList;

import city.buildings.Building;
import city.buildings.Home;
import city.buildings.Hospital;
import city.buildings.PowerUpDen;
import city.buildings.Shop;
import city.buildings.TypeBuildings;
import city.buildings.VillainsLair;

public class City {

	/**
	 * Every City object needs a Home, Hospital, PowerUpDen, Shop and VillainsLair object as properties.
	 */
	private Home homeBase = new Home("Home Base", TypeBuildings.Home);
	private Hospital hospital = new Hospital("Hospital", TypeBuildings.Hospital);
	private Shop shop = new Shop("Shop", TypeBuildings.Shop);
	private VillainsLair villansLair = new VillainsLair("Villain Lair", TypeBuildings.VillainsLair);
	private PowerUpDen powerUpDen = new PowerUpDen("Power Up Den", TypeBuildings.PowerUpDen);
	
	/**
	 * The ArrayList that stores all the 5 buildings of each City
	 */
	private ArrayList<Building> cityBuildings;
	
	 
	/**
	 * The constructor for City.java:
	 * 	- setUpBuildingsCoordinates() : assigns the Point (0, 0) to the Home object and
	 * 	  then it assigns a distinct random coordinate from the coordinates pool to the remaining objects.
	 *	  Uses CoordinatesTool to achieve this.
	 *	- cityBuilidngs is instantiated using setUpCityBuildings() which adds all 5 properties to cityBuildings,
	 *	  cityBuildings has always size 5 and all the Building objects stored in it have different TypeBuildings type.		 
	 */
	public City() {
		setUpBuildingsCoordinates();
		cityBuildings = setUpCityBuildings();
	}

	
	/**
	 * Helper function for constructor City()
	 */
	private void setUpBuildingsCoordinates() {
		CoordinatesTool.setHomeCoordinates(homeBase);
		
		ArrayList<Building> cityBuildingsWithoutHome = new ArrayList<Building>();
		cityBuildingsWithoutHome.add(shop);
		cityBuildingsWithoutHome.add(villansLair);
		cityBuildingsWithoutHome.add(powerUpDen);
		cityBuildingsWithoutHome.add(hospital);
		
		CoordinatesTool.setBuildingsCoordinates(cityBuildingsWithoutHome);
	}
	
	/**
	 * Helper function for constructor City()
	 */
	private ArrayList<Building> setUpCityBuildings() {
		
		cityBuildings = new ArrayList<Building>();
		
		cityBuildings.add(homeBase);
		cityBuildings.add(shop);
		cityBuildings.add(villansLair);
		cityBuildings.add(powerUpDen);
		cityBuildings.add(hospital);
		
		return cityBuildings;
	}
	
	
	/**
	 * getter for cityBuildings
	 * @return the cityBuildings
	 */
	public ArrayList<Building> getCityBuildings() {
		return cityBuildings;
	}
	
	
	public Building returnBuildingAtSpecificCoordinates(Point setCoordinates) {
		
		Building building = null;
		for (Building aBuilding : cityBuildings) {
			if (aBuilding.getBuildingCoordinates().equals(setCoordinates)) {
				building = aBuilding;
			}
		}
		return building;
		
	}
//TODO: discuss whether or not we need the setter for cityBuildings
//	/**
//	 * @param cityBuildings the cityBuildings to set
//	 */
//	public void setCityBuildings(ArrayList<Building> cityBuildings) {
//		this.cityBuildings = cityBuildings;
//	}

	
	
	
	
	
}
