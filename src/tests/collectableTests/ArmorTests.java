package tests.collectableTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.Types;
import collectables.CollectableID;
import collectables.powerUp.Armor;

class ArmorTests {

	@Test
	void testingApplyPowerUp() {
		
		Hero hero = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		Armor armor = new Armor(CollectableID.Armor);
		armor.apply(hero);
		
		assertTrue(hero.isHasArmor());
		
	}

}
