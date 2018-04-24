package tests.collectableTests.powerUpTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.Types;
import collectables.CollectableID;
import collectables.powerUp.Armor;

class ArmorTests {

	private Hero hero;
	private Armor armor;
	
	@BeforeEach
	void beforeAll() {
		hero = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		armor = new Armor(CollectableID.Armor);
	}
	
	@Test
	void testingApplyPowerUp() {
		
		armor.apply(hero);
//		assertTrue(hero.isHasArmor());TODO:RE-TEST RIGHT VALUE
	}
}
