package city;

import java.util.ArrayList;

import city.buildings.Building;
import city.buildings.TypeBuildings;

public class City {

	private ArrayList<Building> listBuildingsWithHomebase;
	private Building homeBase;
	private ArrayList<Building> cityBuildings;
	
	public City(ArrayList<Building> buildings) {
		
		cityBuildings = buildings;
		
		homeBase = findHomeBase();
		cityBuildings = new ArrayList<Building>();
		addBuildingsToCityBuildings();
		
		CoordinatesTool.setHomeCoordinates(homeBase);
		CoordinatesTool.setBuildingsCoordinates(cityBuildings);
	}
	
	private Building findHomeBase() {
		for (Building building : listBuildingsWithHomebase) {
			if (building.getBuildingType().equals(TypeBuildings.Home)) {
				return building;
			}
		}
		
		System.out.println("You did not pass a home for the heroes!");
		return null;
	}
	
	private void addBuildingsToCityBuildings() {
		for (Building building : cityBuildings) {
			if (!(building.getBuildingType().equals(TypeBuildings.Home))) {
				listBuildingsWithHomebase.add(building);
			}
		}
		
	}
	
	public Building getHomeBase() {
		return homeBase;
	}

	public void setHomeBase(Building homeBase) {
		this.homeBase = homeBase;
	}

	public ArrayList<Building> getCityBuildings() {
		return cityBuildings;
	}

	public void setCityBuildings(ArrayList<Building> cityBuildings) {
		this.cityBuildings = cityBuildings;
	}

	
	
	
	
}
