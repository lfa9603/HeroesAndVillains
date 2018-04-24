package tests.cityTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import city.City;
import city.WorldBuilder;
import city.buildings.Building;

class WorldBuilderTests {
	
	
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
		System.out.println("TYPE ANY LETTER OF THE ALPHABET AND THEN 5 FOR NEXT TEST TO WORK AS EXPECTED");//TODO:add automatic input
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
			
			//From CityTests.java
			CityTests.checkBuildingsInACity(city);
		}
	}

}