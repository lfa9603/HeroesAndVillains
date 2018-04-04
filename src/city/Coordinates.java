package city;

import city.buildings.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Coordinates {

	public static final ArrayList<Integer> HOME_COORDINATES = new ArrayList<Integer>(Arrays.asList(0, 0));
	
	private static final ArrayList<ArrayList<Integer>> BUILDINGS_COORDINATES = new ArrayList<ArrayList<Integer>>();
	
	public static void setHomeCoordinates(Home home) {
		home.setBuildingCoordinates(HOME_COORDINATES);
		buildingsCoordinatesCreation();
	}
	
	private static void buildingsCoordinatesCreation() {
		BUILDINGS_COORDINATES.add(new ArrayList<Integer>(Arrays.asList(4, 0)));
		BUILDINGS_COORDINATES.add(new ArrayList<Integer>(Arrays.asList(0, 4)));
		BUILDINGS_COORDINATES.add(new ArrayList<Integer>(Arrays.asList(-4, 0)));
		BUILDINGS_COORDINATES.add(new ArrayList<Integer>(Arrays.asList(0, -4)));
	}
	
	public static void setBuildingsCoordinates(ArrayList<Building> buildings) {
		
		ArrayList<ArrayList<Integer>> copyBuildingsCoordinates = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> setOfCoordinates : BUILDINGS_COORDINATES) {
			copyBuildingsCoordinates.add(setOfCoordinates);
		}
				
		for (Building building: buildings){
			
			Random random = new Random();
			Integer randomInt = random.nextInt(copyBuildingsCoordinates.size());
			ArrayList<Integer> randomSetCoordinates = copyBuildingsCoordinates.get(randomInt);
			
			building.setBuildingCoordinates(copyBuildingsCoordinates.get(randomInt));
			copyBuildingsCoordinates.remove(randomSetCoordinates);
			
		}
		
	}
	

	
}
