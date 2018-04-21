package tests.collectableTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import collectables.CollectableID;
import collectables.heroesMap.HeroesMap;

class TestingHeroesMap {

	private static HeroesSquad squad;
	private static Hero hero;
	
	@BeforeAll
	static void instantiateANewHeroObjcect() {
		hero = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		squad = new HeroesSquad();
		squad.addHero(hero);
	}
	
	@Test
	void testApply() {
		
		HeroesMap heroesMap = new HeroesMap(CollectableID.HeroesMap);
		
		heroesMap.apply(squad);
		
		assertTrue(squad.isHaveMap());
	}

}
