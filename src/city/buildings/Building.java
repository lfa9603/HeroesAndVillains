package city.buildings;

import java.awt.Point;

import characters.HeroesSquad;

public abstract class Building {

	
	private String buildingName;
	private Point buildingCoordinates;
	
	
	public Building(String name) {
		buildingName = name;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Point getBuildingCoordinates() {
		return buildingCoordinates;
	}

	public void setBuildingCoordinates(Point buildingCoordinates) {
		this.buildingCoordinates = buildingCoordinates;
	}
	
	public abstract void interact(HeroesSquad heroesSquad);
	
}
