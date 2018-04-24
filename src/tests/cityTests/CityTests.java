package tests.cityTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import city.City;
import city.buildings.Building;

public class CityTests {

	
	//TODO: Create a public test helper that checks on the coordinates of a building if they are in a pool of values (ArrayList<Point>), if made this helper public I can use it to also test City objects.

	private static City city;
	
	@BeforeEach
	static void beforeEach() {
		city = new City();
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
	 * Helper function used in testingWorldBuilder() and testingCity()
	 * Takes a City object and checks the coordinates and the name are not null;
	 * @param city
	 */
	public static void checkBuildingsInACity(City city) {
		Building home = city.returnBuildingAtSpecificCoordinates(new Point(0, 0));
		assertEquals(home.getBuildingName(), "Home Base");
		assertNotNull(home.getBuildingName(), home.getBuildingName());
		assertNotNull(home.getBuildingCoordinates(), home.getBuildingCoordinates().toString());
		
		String homeString = "This is the " + home.getBuildingName();
		homeString += "\nIts  coordinates are: " + home.getBuildingCoordinates() + "\n";
		assertEquals(home.toString(), homeString);
		
		
		Building buildingOne = city.returnBuildingAtSpecificCoordinates(new Point(4, 0));
		assertNotNull(buildingOne.getBuildingName(), buildingOne.getBuildingName());
		assertNotNull(buildingOne.getBuildingCoordinates(), buildingOne.getBuildingCoordinates().toString());
		
		String buildingOneString = "This is the " + buildingOne.getBuildingName();
		buildingOneString += "\nIts  coordinates are: " + buildingOne.getBuildingCoordinates() + "\n";
		assertEquals(buildingOne.toString(), buildingOneString);

		
		Building buildingTwo = city.returnBuildingAtSpecificCoordinates(new Point(0, 4));
		assertNotNull(buildingTwo.getBuildingName(), buildingTwo.getBuildingName());
		assertNotNull(buildingTwo.getBuildingCoordinates(), buildingTwo.getBuildingCoordinates().toString());
		
		String buildingTwoString = "This is the " + buildingTwo.getBuildingName();
		buildingTwoString += "\nIts  coordinates are: " + buildingTwo.getBuildingCoordinates() + "\n";
		assertEquals(buildingTwo.toString(), buildingTwoString);

		
		Building buildingThree = city.returnBuildingAtSpecificCoordinates(new Point(-4, 0));
		assertNotNull(buildingThree.getBuildingName(), buildingThree.getBuildingName());
		assertNotNull(buildingThree.getBuildingCoordinates(), buildingThree.getBuildingCoordinates().toString());
		
		String buildingThreeString = "This is the " + buildingThree.getBuildingName();
		buildingThreeString += "\nIts  coordinates are: " + buildingThree.getBuildingCoordinates() + "\n";
		
		assertEquals(buildingThree.toString(), buildingThreeString);
		
		
		Building buildingFour = city.returnBuildingAtSpecificCoordinates(new Point(0, -4));
		assertNotNull(buildingFour.getBuildingName(), buildingFour.getBuildingName());
		assertNotNull(buildingFour.getBuildingCoordinates(), buildingFour.getBuildingCoordinates().toString());
		
		String buildingFourString = "This is the " + buildingFour.getBuildingName();
		buildingFourString += "\nIts  coordinates are: " + buildingFour.getBuildingCoordinates() + "\n";
		assertEquals(buildingFour.toString(), buildingFourString);
		
	}
	
	@Test 
	void testingToString() {
		String str = new String();
		
		for (Building building : city.getCityBuildings()) {
			str += building.toString();
		}
		
		assertEquals(city.toString(), str);
	}

}
