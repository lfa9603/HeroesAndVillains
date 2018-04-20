package Testing.CollectablesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import collectables.CollectableID;
import collectables.powerUp.HeroesMap;

class TestingHeroesMap {

	@Test
	void testApply() {
		
		HeroesMap heroesMap = new HeroesMap(CollectableID.HeroesMap);
		
		HeroesSquad heroesSquad = new HeroesSquad();
		heroesSquad.addHero(new Hero("Lorenzo", Types.level_1, "c"));
		
		heroesMap.apply(heroesSquad);
		
		assertTrue(heroesSquad.isHaveMap());
	}

}
