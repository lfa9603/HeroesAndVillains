package city;

import city.buildings.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


public class Coordinates {

	public static final Point HOME_COORDINATES = new Point(0, 0);
	
	public static final ArrayList<Point> BUILDINGS_COORDINATES = buildingsCoordinatesCreation();;
	
	public static void setHomeCoordinates(Home home) {
		home.setBuildingCoordinates(HOME_COORDINATES);
		buildingsCoordinatesCreation();
	}
	
	private static ArrayList<Point> buildingsCoordinatesCreation() {
		ArrayList<Point> buildingCoordinates = new ArrayList<Point>();
		buildingCoordinates.add(new Point(4, 0));
		buildingCoordinates.add(new Point(0, 4));
		buildingCoordinates.add(new Point(-4, 0));
		buildingCoordinates.add(new Point(0, -4));
		return buildingCoordinates;
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
