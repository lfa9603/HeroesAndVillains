package city;

import city.buildings.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 *This class has been created to deal with each building coordinates assignment, 
 *it is called every time a new city is built.
 *It offers the tools to place each building on a Cartesian plane (a square portion of the map with vertices at (4, 4), (-4,4), (-4,-4), (4, -4)).
 *The HomeBase is placed always at (0, 0) and the remaining four buildings are placed randomly at (4, 0), (0, 4), (-4, 0), (0,-4).
 */
public class CoordinatesTool {

	/**
	 * The coordinates for the HomeBase
	 */
	public static final Point HOME_COORDINATES = new Point(0, 0);
	
	/**
	 * An ArrayList of Point objects which contains the coordinates for the remaining four builidngs.
	 */
	public static final ArrayList<Point> BUILDINGS_COORDINATES = buildingsCoordinatesCreation();;
	
	/**
	 * 
	 * @param a Building object (home), @see City.java to notice that the object passed is aleways a Home object.
	 * Sets the Building object coordinates to (0, 0).
	 */
	public static void setHomeCoordinates(Building home) {
		home.setBuildingCoordinates(HOME_COORDINATES);
//		buildingsCoordinatesCreation();
	}
	
	/**
	 * 
	 * @return an ArrayList of Point objects, this always contains four elements 
	 * which are the coordinates of all the buildings except the HomeBase ones (0, 0).
	 * 
	 */
	private static ArrayList<Point> buildingsCoordinatesCreation() {
		ArrayList<Point> buildingCoordinates = new ArrayList<Point>();
		buildingCoordinates.add(new Point(4, 0));
		buildingCoordinates.add(new Point(0, 4));
		buildingCoordinates.add(new Point(-4, 0));
		buildingCoordinates.add(new Point(0, -4));
		return buildingCoordinates;
	}
	
	/**
	 * 
	 * @param the ArrayList of Building objects containing all the city buildings except for HomeBase.
	 * This method assigns to each element of the @param buildings a random set of coordinates chosen 
	 * among the ArrayList of Point objects BUILDINGS_COORDINATES.
	 */
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
