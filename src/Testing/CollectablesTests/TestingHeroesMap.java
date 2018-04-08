package Testing.CollectablesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import characters.Hero;
import characters.HeroesSquad;
import city.City;
import collectables.heroesMap.HeroesMap;

class TestingHeroesMap {

	@Test
	void testApply() {
		
		HeroesMap heroesMap = new HeroesMap(new City());
		
		HeroesSquad heroesSquad = new HeroesSquad();
		heroesSquad.addHero(new Hero("Lorenzo", "c", "c"));
		
		heroesMap.apply(heroesSquad);
		
		assertTrue(heroesSquad.isHaveMap());
	}

}
