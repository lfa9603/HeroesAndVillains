package tests.cityTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import city.City;
import city.WorldBuilder;
import city.buildings.Building;

public class CityTests {

	
	//TODO: Create a public test helper that checks on the coordinates of a building if they are in a pool of values (ArrayList<Point>), if made this helper public I can use it to also test City objects.

	
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
		for (Building buildingOne : buildingsList) {
			assertNotNull(buildingOne);
			for (Building buildingTwo : buildingsList) {
				assertNotNull(buildingTwo);
				if (! buildingOne.equals(buildingTwo)) {
					
					if ((buildingOne.getBuildingCoordinates()).equals(buildingTwo.getBuildingCoordinates())
							|| (buildingOne.getBuildingName()).equals(buildingTwo.getBuildingName())) {
						assertNotEquals(buildingOne, buildingTwo);
					}
				}
			}
		}
		
		checkBuildingsInACity(city);
		
	}
	
	/**
	 * Testing WorldBuilder.java, this should:
	 * 	1 - Return a ArrayList<City> object of given size
	 * 	2 - All the City objects stored need to be different
	 * 	3 - Each city must contain 5 Building objects and name and coordinates of each building cannot be null
	 */
	@Test
	void testingWorldBuilder() {
		System.out.println("NOW TESTING WorldBuilder CLASS, USER INPUT NEEDED FOLLOW INSTRUCTIONS");
		
		//Requirement 1
		System.out.println("TYPE 5 FOR NEXT TEST TO WORK AS EXPECTED");
		WorldBuilder world = new WorldBuilder();
		ArrayList<City> listCities = world.getWorld();
		//For the next test to pass type the value 5
		assertEquals(5, listCities.size());
		
		//Requirement 2
		for (City cityOne : listCities) {
			assertNotNull(cityOne);
			for (City cityTwo : listCities) {
				assertNotNull(cityTwo);
				//Using != as hasCode() returns an int (primitive data type) 
				if (cityOne.hashCode() != cityTwo.hashCode()) {
					assertNotEquals(cityOne, cityTwo);
				}
			}
		}
		
		//Requirement 3
		for (City city: listCities) {
			ArrayList<Building> listCityBuildings = city.getCityBuildings();
			assertEquals(5, listCityBuildings.size());
			checkBuildingsInACity(city);
		}
	}
	
	
	/**
	 * Helper function used in testingWorldBuilder() and testingCity()
	 * Takes a City object and checks the coordinates and the name are not null;
	 * @param city
	 */
	private void checkBuildingsInACity(City city) {
		Building home = city.returnBuildingAtSpecificCoordinates(new Point(0, 0));
		assertEquals(home.getBuildingName(), "Home Base");
		assertNotNull(home.getBuildingName(), home.getBuildingName());
		assertNotNull(home.getBuildingCoordinates(), home.getBuildingCoordinates().toString());
		System.out.println(home.toString());
		
		Building building = city.returnBuildingAtSpecificCoordinates(new Point(4, 0));
		assertNotNull(building.getBuildingName(), building.getBuildingName());
		assertNotNull(building.getBuildingCoordinates(), building.getBuildingCoordinates().toString());
		System.out.println(building.toString());

		Building buildingTwo = city.returnBuildingAtSpecificCoordinates(new Point(0, 4));
		assertNotNull(buildingTwo.getBuildingName(), buildingTwo.getBuildingName());
		assertNotNull(buildingTwo.getBuildingCoordinates(), buildingTwo.getBuildingCoordinates().toString());
		System.out.println(buildingTwo.toString());

		Building buildingThree = city.returnBuildingAtSpecificCoordinates(new Point(-4, 0));
		assertNotNull(buildingThree.getBuildingName(), buildingThree.getBuildingName());
		assertNotNull(buildingThree.getBuildingCoordinates(), buildingThree.getBuildingCoordinates().toString());
		System.out.println(buildingThree.toString());
		
		Building buildingFour = city.returnBuildingAtSpecificCoordinates(new Point(0, -4));
		assertNotNull(buildingFour.getBuildingName(), buildingFour.getBuildingName());
		assertNotNull(buildingFour.getBuildingCoordinates(), buildingFour.getBuildingCoordinates().toString());
		System.out.println(buildingFour.toString());
	}

}
