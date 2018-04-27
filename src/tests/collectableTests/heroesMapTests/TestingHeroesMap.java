package tests.collectableTests.heroesMapTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import city.City;
import collectables.CollectableID;
import collectables.heroesMap.HeroesMap;

class TestingHeroesMap {

	private HeroesSquad squad;
	private Hero hero;
	private HeroesMap heroesMap;
	
	@BeforeEach
	void instantiateANewHeroObjcect() {
		hero = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		squad = new HeroesSquad();
		squad.addHero(hero);
		
		heroesMap = new HeroesMap(CollectableID.HeroesMap);
	}
	
	
	@Test
	void testApply() {
		
		
		heroesMap.apply(squad);
		
		assertTrue(squad.isHaveMap());
	}
	
	@Test
	void testingApplyMethodForExtendingCollectable() {
		heroesMap.apply(hero);
		assertEquals(squad.isHaveMap(), false);
	}
	
	@Test
	void getterAndSetterForCityProperty() {
		City city = new City();
		heroesMap.setCity(city);
		assertEquals(heroesMap.getCity(), city);
	}
	
	@Test
	void toStringTest() {
		assertEquals(heroesMap.toString(), "This is a map of the current city you are in, "
				+ "you can buy it at the shop and use it ONLY inside your HomeBase" 
				+ "\nIt costs " + heroesMap.getCost());
	}
	
	@Test
	void buildingCoordinatesToStringTest() {
		City city = new City();
		heroesMap.setCity(city);
		assertEquals(heroesMap.builidngsCoordinatesToString(), heroesMap.getCity().toString());
	}

	@AfterEach
	void afterEach() {
		hero = null;
		squad = null;
		
		heroesMap = null;
	}
}
