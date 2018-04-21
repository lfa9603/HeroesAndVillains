package tests.collectableTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.Types;
import collectables.CollectableID;
import collectables.powerUp.GameChooser;

class TestingGameChooser {

	private static Hero hero;
	
	@BeforeAll
	static void instantiateANewHeroObjcect() {
		hero = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
	}
	
	@Test
	void testingApplyPowerUp() {
		GameChooser gameChooser = new GameChooser(CollectableID.GameChooser);
		gameChooser.apply(hero);
		assertTrue(hero.getIsGameChooser());
		
		//extra, not part of GameChooser class
		hero.setIsGameChooser(false);
		assertFalse(hero.getIsGameChooser());
	}

}
