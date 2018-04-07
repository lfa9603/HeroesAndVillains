package Testing.CollectablesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import characters.Hero;
import characters.HeroesSquad;
import collectables.heroesMap.HeroesMap;

class TestingHeroesMap {

	@Test
	void testApply() {
		
		HeroesMap heroesMap = new HeroesMap();
		
		HeroesSquad heroesSquad = new HeroesSquad();
		heroesSquad.addHero(new Hero("Lorenzo", "c", "c"));
		
		heroesMap.apply(heroesSquad);
		
		assertTrue(heroesSquad.isHaveMap());
	}

}
