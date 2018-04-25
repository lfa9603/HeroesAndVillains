package tests.collectableTests.healingItemTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.Types;
import collectables.CollectableID;
import collectables.healingItem.HealingItem;

class TestingHealingItem {

	
	private Hero hero;
	
	@BeforeEach
	void instantiateANewHeroObjcect() {
		hero = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
	}
	
	/**
	 * Testing startHealing static method in package collectables.healingItems
	 * 
	 * startHealing method should:
	 *  1 - Run on secondary thread (putting the main thread asleep should not stop it)
	 *      and the value of hero.getHealth() should increase by the given scheme (one HP every 1600 ms)
	 *  2 - The method should restore all the HP required which can be 25, 50, or 75.
	 *  3 - The method should run off the main thread, which means that I need to be able to complete main tasks while
	 *      the HP get restored.
	 *  4 - A Hero HP cannot be higher than the maximum value (100 if it does not have the IncreaseMaxLife powerUp) 125 with powerUp.
	 */
	@Test
	void testStartHealing() {
		hero.setHealth(20);
		HealingItem healingPotion = new HealingItem(CollectableID.GoodHealingItem);
		healingPotion.apply(hero);
		
		
		//Requirement 1
		try {
			Thread.sleep(16000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		int healthAfter16000msFromHealingPotion = hero.getHealth();
		assertEquals(25, healthAfter16000msFromHealingPotion);
		
		
		try {
			Thread.sleep(16000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int healthAfter32000msFromHealingPotion = hero.getHealth();
		assertEquals(29, healthAfter32000msFromHealingPotion);
		
//		Requirement 2
//		Commented out as it takes way too long to finish
//		try {
//			Thread.sleep(25 * 16000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		int healthAfterFullRecover = hero.getHealth();
//		assertEquals(45, healthAfterFullRecover);
		
		
		//Requirement 3
		hero.setHealth(20);
		HealingItem healingPotionTwo = new HealingItem(CollectableID.BetterHealingItem);
		healingPotionTwo.apply(hero);

		long startTime = System.currentTimeMillis();
		long elapsedTime = 0L;

		while (elapsedTime < 3 * 1600) {
			System.out.println("Main thread alive!");
		    elapsedTime = (new Date()).getTime() - startTime;
		    assertNotNull(elapsedTime);
		    assertTrue(hero.getHealth() >= 20);
		}
		assertNotEquals(20, hero.getHealth());	
		
		//Requirement 4
		hero.setHealth(99);
		HealingItem potionThree = (new HealingItem(CollectableID.BestHealingItem));
		potionThree.apply(hero);
		
		try {
			Thread.sleep(5 * 16000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals(100, hero.getHealth());
		assertEquals(25, healingPotion.getRecoverableHP());
		assertEquals(50, healingPotionTwo.getRecoverableHP());
		assertEquals(75, potionThree.getRecoverableHP());
		
	}	

	
	@AfterEach
	void afterEach() {
		hero = null;
	}
}
