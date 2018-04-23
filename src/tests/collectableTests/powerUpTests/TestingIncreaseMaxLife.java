package tests.collectableTests.powerUpTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.Types;
import collectables.CollectableID;
import collectables.healingItem.HealingItem;
import collectables.powerUp.IncreaseMaxLife;

class TestingIncreaseMaxLife {

	private Hero hero;
	
	@BeforeEach
	void instantiateANewHeroObjcect() {
		hero = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
	}
	
	@Test
	void testApplyPowerUp() {
 		IncreaseMaxLife increaseMaxLife = new IncreaseMaxLife(CollectableID.IncreaseMaxLife);
		increaseMaxLife.apply(hero);
		
		assertEquals(125, hero.getMaxHealth());
		assertEquals(100, hero.getHealth());
		
//		Checking the Hero object can actually reach 125HP of Health
		HealingItem healingItem = new HealingItem(CollectableID.GoodHealingItem);
		healingItem.apply(hero);
		
		long startTime = System.currentTimeMillis();
		long elapsedTime = 0L;
		while (elapsedTime < 60 * 1600) {
		    elapsedTime = (new Date()).getTime() - startTime;
		}
		
		assertEquals(125,  hero.getHealth());
		
		
	}


}
