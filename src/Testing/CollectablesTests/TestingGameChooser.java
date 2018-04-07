package Testing.CollectablesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import characters.Hero;
import collectables.powerUp.GameChooser;
import collectables.powerUp.PowerUpType;

class TestingGameChooser {

	@Test
	void testingApplyPowerUp() {
		Hero hero = new Hero("Lorenzo", "Cool as", "Ciao");
		GameChooser gameChooser = new GameChooser(PowerUpType.GameChooser);
		gameChooser.applyPowerUp(hero);
		assertTrue(hero.getIsGameChooser());
		
		//extra, not part of GameChooser class
		hero.setIsGameChooser(false);
		assertFalse(hero.getIsGameChooser());
	}

}
