package city.buildings;

import java.util.ArrayList;

import characters.HeroesSquad;

public abstract class Building {

	
	private String buildingName;
	private ArrayList<Integer> buildingCoordinates;
	
	
	public Building(String name) {
		buildingName = name;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public ArrayList<Integer> getBuildingCoordinates() {
		return buildingCoordinates;
	}

	public void setBuildingCoordinates(ArrayList<Integer> buildingCoordinates) {
		this.buildingCoordinates = buildingCoordinates;
	}
	
	public abstract void interact(HeroesSquad heroesSquad);
	
}
