package Testing.CollectablesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import characters.Hero;
import characters.Types;
import collectables.CollectableID;
import collectables.powerUp.Armor;

class ArmorTests {

	@Test
	void testingApplyPowerUp() {
		
		Hero hero = new Hero("Jay", Types.level_1 , "Ciao");
		Armor armor = new Armor(CollectableID.Armor);
		armor.apply(hero);
		
		assertTrue(hero.isHasArmor());
		
	}

}
