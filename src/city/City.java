package city;

import java.awt.Point;
import java.util.ArrayList;

import city.buildings.Building;
import city.buildings.PowerUpDen;
import city.buildings.TypeBuildings;
import city.buildings.VillainsLair;
import city.buildings.homeBase.Home;
import city.buildings.hospital.Hospital;
import city.buildings.shop.Shop;

public class City implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3072413044372633635L;
	/**
	 * Every City object needs a Home, Hospital, PowerUpDen, Shop and VillainsLair object as properties.
	 */
	private Home homeBase = new Home("Home Base", TypeBuildings.Home);
	private Hospital hospital = new Hospital("Hospital", TypeBuildings.Hospital);
	private Shop shop = new Shop("Shop", TypeBuildings.Shop);
	private VillainsLair villansLair = new VillainsLair("Villain Lair", TypeBuildings.VillainsLair);
	private PowerUpDen powerUpDen = new PowerUpDen("Power Up Den", TypeBuildings.PowerUpDen);
	
	/**
	 * The ArrayList that will store all the 5 buildings of each City
	 */
	private ArrayList<Building> cityBuildings;
	
	 
	/**
	 * The constructor for City.java:
	 * 	setUpBuildingsCoordinates() : assigns the Point (0, 0) to the Home object and
	 * 	then it assigns a distinct random coordinate from the coordinates pool to the remaining objects.
	 *	Uses CoordinatesTool to achieve this.
	 *
	 *	cityBuilidngs is instantiated using setUpCityBuildings() which adds all 5 properties to cityBuildings,
	 *	cityBuildings has always size 5 and all the Building objects stored in it have different TypeBuildings type.		 
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
	 * It adds one instance for each TypeBuilidngs type to @param listBuildngs.
	 * @return @param cityBuilidngs now modified to an ArrayList of Building objects of length 5.
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
	 * @return cityBuildings
	 */
	public ArrayList<Building> getCityBuildings() {
		return cityBuildings;
	}
	
	
	/**
	 * 
	 * This is achieved by checking the @param listBuilidngs Building objects and checking if 
	 * any of the building builidngCoordinates matches with @param setCoordinates. 
	 * 
	 * @param setCoordinates a awt.Point object.
	 * @return the building object present at the given setOfCoordinates

	 * 
	 */
	public Building returnBuildingAtSpecificCoordinates(Point setCoordinates) {
		
		Building building = null;
		for (Building aBuilding : cityBuildings) {
			if (aBuilding.getBuildingCoordinates().equals(setCoordinates)) {
				building = aBuilding;
			}
		}
		return building;
		
	}
	
	/**
	 * Overridden toString() method.
	 * @return mapOfCity a String object that prints each Building object String() showing each individual building name and set of coordinates. 
	 */
	@Override
	public String toString() {
		String mapOfCity = new String();
		for (Building building : cityBuildings) {
			mapOfCity += building;
		}
		return mapOfCity;
	}
	
}
