package city.buildings;

import java.awt.Point;

import characters.HeroesSquad;


/**
 * 
 * @author LorenzoFasano
 *This abstract class is created to ensure Home, Hospital, Shop, PowerUpDen and VillainLair 
 *classes (the ones that extend Building) all adhere to a standard structure.
 *Each object that extends Building has a buildingName (String), a buildingCoordinates (java.awt.Point, which allows to create a 2D map built on x and y Cartesian axis) 
 *and a buildingType (TypeBuilidngs an enumerator created to give each building an ID). 
 *It also has to implement a method called interact() which performs different tasks depending on the building type.
 */
public abstract class Building {

	
	private String buildingName;
	
	private Point buildingCoordinates;
	
	private TypeBuildings buildingType;
	
	/**
	 * 
	 * @param name the name of the building
	 * @param buildType the type of the building
	 */
	public Building(String name, TypeBuildings buildType) {
		buildingName = name;
		buildingType = buildType;
	}


	/**
	 * Getter method for the property buildingName
	 * @return the name of the building.
	 */
	public String getBuildingName() {
		return buildingName;
	}

	/**
	 * Setter method for property buildingName.
	 * @param buildingName
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	
	/**
	 * Getter method for the property buildingCoordinates
	 * @return the coordinates of the building on the level map.
	 */
	public Point getBuildingCoordinates() {
		return buildingCoordinates;
	}

	/**
	 * Setter method for property builidngCoordinates
	 * @param buildingCoordinates
	 */
	public void setBuildingCoordinates(Point buildingCoordinates) {
		this.buildingCoordinates = buildingCoordinates;
	}
	
	
	/**
	 * Getter method for the property buildingType
	 * @return the buildingType of the building.
	 */
	public TypeBuildings getBuildingType() {
		return buildingType;
	}



	/**
	 * Overridden toString() method, it returns the property buildingName 
	 * and the position of the building on the level map. 
	 */
	public String toString() {
		String string = new String();
		string += "This is the " + buildingName;
		string += "\nIts  coordinates are: " + buildingCoordinates + "\n";
		return string;
	}
	
	public abstract void interact(HeroesSquad heroesSquad);

}
