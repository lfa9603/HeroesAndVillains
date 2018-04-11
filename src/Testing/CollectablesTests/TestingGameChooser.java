package Testing.CollectablesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import characters.Hero;
import characters.Types;
import collectables.CollectableID;
import collectables.powerUp.GameChooser;

class TestingGameChooser {

	@Test
	void testingApplyPowerUp() {
		Hero hero = new Hero("Lorenzo", Types.level_1, "Ciao");
		GameChooser gameChooser = new GameChooser(CollectableID.GameChooser);
		gameChooser.apply(hero);
		assertTrue(hero.getIsGameChooser());
		
		//extra, not part of GameChooser class
		hero.setIsGameChooser(false);
		assertFalse(hero.getIsGameChooser());
	}

}
