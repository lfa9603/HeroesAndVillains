package tests.collectableTests.powerUpTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.Types;
import collectables.CollectableID;
import collectables.powerUp.GameChooser;

class TestingGameChooser {

	private Hero hero;
	
	@BeforeEach
	void instantiateANewHeroObjcect() {
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
