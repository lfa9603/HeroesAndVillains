package city;

import city.buildings.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


public class Coordinates {

	public static final Point HOME_COORDINATES = new Point(0, 0);
	
	private static final ArrayList<Point> BUILDINGS_COORDINATES = new ArrayList<Point>();
	
	public static void setHomeCoordinates(Home home) {
		home.setBuildingCoordinates(HOME_COORDINATES);
		buildingsCoordinatesCreation();
	}
	
	private static void buildingsCoordinatesCreation() {
		BUILDINGS_COORDINATES.add(new Point(4, 0));
		BUILDINGS_COORDINATES.add(new Point(0, 4));
		BUILDINGS_COORDINATES.add(new Point(-4, 0));
		BUILDINGS_COORDINATES.add(new Point(0, -4));
	}
	
	public static void setBuildingsCoordinates(ArrayList<Building> buildings) {
		
		ArrayList<Point> copyBuildingsCoordinates = new ArrayList<Point>();
		for (Point setOfCoordinates: BUILDINGS_COORDINATES) {
			copyBuildingsCoordinates.add(setOfCoordinates);
		}
				
		for (Building building: buildings){
			
			Random random = new Random();
			Integer randomInt = random.nextInt(copyBuildingsCoordinates.size());
			Point randomSetCoordinates = copyBuildingsCoordinates.get(randomInt);
			
			building.setBuildingCoordinates(copyBuildingsCoordinates.get(randomInt));
			copyBuildingsCoordinates.remove(randomSetCoordinates);
			
		}
		
	}
	

	
}
