package Testing.CollectablesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import characters.Hero;
import collectables.powerUp.Armor;
import collectables.powerUp.PowerUpType;

class ArmorTests {

	@Test
	void testingApplyPowerUp() {
		
		Hero hero = new Hero("Jay", "Being Cool", "Ciao");
		Armor armor = new Armor(PowerUpType.Armor);
		armor.applyPowerUp(hero);
		
		assertTrue(hero.isHasArmor());
		
	}

}
