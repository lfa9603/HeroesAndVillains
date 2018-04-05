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

	private Home homeBase = new Home("Home Base", TypeBuildings.Home);
	private Hospital hospital = new Hospital("Hospital", TypeBuildings.Hospital);
	private Shop shop = new Shop("Shop", TypeBuildings.Shop);
	private VillainsLair villansLair = new VillainsLair("Villain Lair", TypeBuildings.VillainsLair);
	private PowerUpDen powerUpDen = new PowerUpDen("Power Up Den", TypeBuildings.PowerUpDen);
	
	private ArrayList<Building> cityBuildings;
	
	
	public City() {
		setUpBuildingsCoordinates();
		cityBuildings = setUpCityBuildings();
	}

	private void setUpBuildingsCoordinates() {
		CoordinatesTool.setHomeCoordinates(homeBase);
		
		ArrayList<Building> cityBuildingsWithoutHome = new ArrayList<Building>();
		cityBuildingsWithoutHome.add(shop);
		cityBuildingsWithoutHome.add(villansLair);
		cityBuildingsWithoutHome.add(powerUpDen);
		cityBuildingsWithoutHome.add(hospital);
		
		CoordinatesTool.setBuildingsCoordinates(cityBuildingsWithoutHome);
	}
	
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

//	/**
//	 * @param cityBuildings the cityBuildings to set
//	 */
//	public void setCityBuildings(ArrayList<Building> cityBuildings) {
//		this.cityBuildings = cityBuildings;
//	}

	
	
	
	
}
