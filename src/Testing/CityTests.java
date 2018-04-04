package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import city.Coordinates;
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
		Point home = Coordinates.HOME_COORDINATES;
		Point origin = new Point(0, 0);
		assertEquals(origin, home);
	}
	
	/**
	 * Testing the static value BUILDING_COORDINATES
	 */
	@Test
	void testingBUILDING_COORDINATES() {
		ArrayList<Point> toTest = Coordinates.BUILDINGS_COORDINATES;
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
		
		Coordinates.setBuildingsCoordinates(listBuildings);
		
		boolean allDifferentAndNotNull = true;
		for (Building buildingOne : listBuildings) {
			for (Building buildingTwo : listBuildings) {
				Point coordinatesOne = buildingOne.getBuildingCoordinates();
				Point coordinatesTwo = buildingTwo.getBuildingCoordinates();
				if (coordinatesOne.equals(coordinatesTwo) && !buildingOne.equals(buildingTwo)) {
					allDifferentAndNotNull = false;
				}
				if (coordinatesOne.equals(null) || coordinatesTwo.equals(null))  {
					allDifferentAndNotNull = false;
				}
			}
		}
		
		boolean expected = true;
		for (Building building : listBuildings) {
			System.out.println(building.getBuildingName() + "    " + building.getBuildingCoordinates());
		}
		assertEquals(expected, allDifferentAndNotNull);
	}

}
