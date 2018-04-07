package Testing.CollectablesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import characters.Hero;
import collectables.healingItem.HealingItem;
import collectables.healingItem.HealingItemType;
import collectables.powerUp.IncreaseMaxLife;
import collectables.powerUp.PowerUpType;

class TestingIncreaseMaxLife {

	@Test
	void testApplyPowerUp() {
		Hero hero = new Hero("Lorenzo", "Ciao", "Ciao");
		IncreaseMaxLife increaseMaxLife = new IncreaseMaxLife(PowerUpType.IncreaseMaxLife);
		increaseMaxLife.applyPowerUp(hero);
		
		assertEquals(125, hero.getMaxHealth());
		assertEquals(100, hero.getHealth());
		
		HealingItem healingItem = new HealingItem(HealingItemType.GoodAntidote);
		int recoverableHP = healingItem.getRecoverableHP();
		HealingItem.startHealing(hero, recoverableHP);
		
		long startTime = System.currentTimeMillis();
		long elapsedTime = 0L;
		while (elapsedTime < 60 * 1600) {
		    elapsedTime = (new Date()).getTime() - startTime;
		}
		
		assertEquals(125,  hero.getHealth());
		
		
	}


}
