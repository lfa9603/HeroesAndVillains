package city.buildings;

import java.awt.Point;

import characters.HeroesSquad;

public abstract class Building {

	
	private String buildingName;
	private Point buildingCoordinates;
	private TypeBuildings buildingType;
	
	
	public Building(String name, TypeBuildings buildType) {
		buildingName = name;
		buildingType = buildType;
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
	
	
	public TypeBuildings getBuildingType() {
		return buildingType;
	}


//	public void setBuildingType(TypeBuildings buildingType) {
//		this.buildingType = buildingType;
//	}

	public String toString() {
		String string = new String();
		string += "This is the " + buildingName;
		string += "\nIts  coordinates are: " + buildingCoordinates + "\n";
		return string;
	}
	
	public abstract void interact(HeroesSquad heroesSquad);

}
