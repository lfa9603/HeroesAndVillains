package Testing.CityTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import city.CoordinatesTool;
import city.buildings.Building;
import city.buildings.Hospital;
import city.buildings.PowerUpDen;
import city.buildings.Shop;
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
		Hospital hospital = new Hospital("Hospital");
		PowerUpDen pub = new PowerUpDen("Pub");
		VillainsLair villainCave = new VillainsLair("VillainCave");
		Shop shop = new Shop("Shop");
		
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

}
