package Testing.CityTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import city.City;
import city.CoordinatesTool;
import city.buildings.Building;
import city.buildings.Hospital;
import city.buildings.PowerUpDen;
import city.buildings.Shop;
import city.buildings.TypeBuildings;
import city.buildings.VillainsLair;

class CityTests {

	
	/**
	 * Testing the static value HOME_COORDINATES
	 */
	@Test
	void testingHOME_COORDINATES() {
		Point home = CoordinatesTool.HOME_COORDINATES;
		Point origin = new Point(0, 0);
		assertEquals(origin, home);
	}
	
	/**
	 * Testing the static value BUILDING_COORDINATES
	 */
	@Test
	void testingBUILDING_COORDINATES() {
		ArrayList<Point> toTest = CoordinatesTool.BUILDINGS_COORDINATES;
		ArrayList<Point> buildingCoordinates = new ArrayList<Point>();
		buildingCoordinates.add(new Point(4, 0));
		buildingCoordinates.add(new Point(0, 4));
		buildingCoordinates.add(new Point(-4, 0));
		buildingCoordinates.add(new Point(0, -4));
		assertEquals(toTest, buildingCoordinates);
	}
	
	/**
	 * Testing the static function setBuildingsCoordinates
	 * This is achieved instantiating an ArrayList<Building> and then pass it to
	 * the function, this should assign a random set of coordinates
	 * to each building.
	 * The NonNull and NotEquals properties are checked comparing all the items with each other.
	 */
	@Test
	void testingSetBuildingsCoordinates() {
		Hospital hospital = new Hospital("Hospital", TypeBuildings.Hospital);
		PowerUpDen pub = new PowerUpDen("PowerUpDen", TypeBuildings.PowerUpDen);
		VillainsLair villainCave = new VillainsLair("VillainCave", TypeBuildings.VillainsLair);
		Shop shop = new Shop("Shop", TypeBuildings.Shop);
		
		ArrayList<Building> listBuildings = new ArrayList<Building>();
		
		listBuildings.add(pub);
		listBuildings.add(shop);
		listBuildings.add(villainCave);
		listBuildings.add(hospital);
		
		CoordinatesTool.setBuildingsCoordinates(listBuildings);
		for (Building buildingOne : listBuildings) {
			for (Building buildingTwo : listBuildings) {
				Point coordinatesOne = buildingOne.getBuildingCoordinates();
				Point coordinatesTwo = buildingTwo.getBuildingCoordinates();
				
				assertNotNull(coordinatesOne);
				assertNotNull(coordinatesTwo);
				
				if (coordinatesOne.equals(coordinatesTwo) && !buildingOne.equals(buildingTwo)) {
					
					assertNotEquals(coordinatesOne, coordinatesTwo);
					
				}
			}
		}
		
		for (Building building : listBuildings) {
			System.out.println(building.getBuildingName() + "    " + building.getBuildingCoordinates());
		}
	}
	
	/**
	 * Testing City.java this should:
	 *	1 - Generate a list of Building items of size 5
	 *	2 - Always return distinct coordinates for each building, no doubles accepted
	 *	3 - Retrieve the right object given a set of coordinates.
	 *  
	 */
	@Test
	void testingCity() {
		City city = new City();
		ArrayList<Building> buildingsList = city.getCityBuildings();
		
		//Requirement 1
		assertEquals(5, buildingsList.size());
		
		//Requirement 2
		boolean allDifferent = true;
		for (Building buildingOne : buildingsList) {
			for (Building buildingTwo : buildingsList) {
				if (! buildingOne.equals(buildingTwo)) {
					
					if ((buildingOne.getBuildingCoordinates()).equals(buildingTwo.getBuildingCoordinates())
							|| (buildingOne.getBuildingName()).equals(buildingTwo.getBuildingName())) {
						allDifferent = false;
					}
				}
			}
		}
		assertEquals(true, allDifferent);
		
		//Requirement 3
		Building home = city.returnBuildingAtSpecificCoordinates(new Point(0, 0));
		assertEquals(home.getBuildingName(), "Home Base");
		assertNotNull(home.getBuildingName(), home.getBuildingName());
		assertNotNull(home.getBuildingCoordinates(), home.getBuildingCoordinates().toString());
		
		Building building = city.returnBuildingAtSpecificCoordinates(new Point(4, 0));
		assertNotNull(building.getBuildingName(), building.getBuildingName());
		assertNotNull(building.getBuildingCoordinates(), building.getBuildingCoordinates().toString());
		

		Building buildingTwo = city.returnBuildingAtSpecificCoordinates(new Point(0, 4));
		assertNotNull(buildingTwo.getBuildingName(), buildingTwo.getBuildingName());
		assertNotNull(buildingTwo.getBuildingCoordinates(), buildingTwo.getBuildingCoordinates().toString());
		

		Building buildingThree = city.returnBuildingAtSpecificCoordinates(new Point(-4, 0));
		assertNotNull(buildingThree.getBuildingName(), buildingThree.getBuildingName());
		assertNotNull(buildingThree.getBuildingCoordinates(), buildingThree.getBuildingCoordinates().toString());
		
		Building buildingFour = city.returnBuildingAtSpecificCoordinates(new Point(0, -4));
		assertNotNull(buildingFour.getBuildingName(), buildingFour.getBuildingName());
		assertNotNull(buildingFour.getBuildingCoordinates(), buildingFour.getBuildingCoordinates().toString());
		
		
	}
	

}
