package surrounding;

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

		ArrayList<Building> copyOfBuildings = new ArrayList<Building>();
		for (Building building: buildings) {
			copyOfBuildings.add(building);
		}
		
		ArrayList<ArrayList<Integer>> copyBuildingsCoordinates = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> setOfCoordinates : BUILDINGS_COORDINATES) {
			copyBuildingsCoordinates.add(setOfCoordinates);
		}
		
		while (copyOfBuildings.size() != 0) {
			
			Random random = new Random();
			Integer randomInteger = random.nextInt(copyOfBuildings.size());
			
			Building building = copyOfBuildings.get(randomInteger);
			ArrayList<Integer> chosenSetCoordinates = copyBuildingsCoordinates.get(randomInteger);
			
			building.setBuildingCoordinates(chosenSetCoordinates);
			
			copyOfBuildings.remove(building);
			copyBuildingsCoordinates.remove(chosenSetCoordinates);
			
		}
	}
	

	
}
