package Testing.CollectablesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import characters.Hero;
import collectables.healingItem.HealingItem;
import collectables.healingItem.HealingItemType;

class HealingItemTests {

	
	/**
	 * Testing startHealing static method in package collectables.healingItems
	 * 
	 * startHealing method should:
	 *  1 - Run on secondary thread (putting the main thread asleep should not stop it)
	 *      and the value of hero.getHealth() should increase by the given scheme (one HP every 1600 ms)
	 *  2 - The method should restore all the HP required which can be 25, 50, or 75.
	 *  3 - The method should run off the main thread, which means that I need to be able to complete main tasks while
	 *      the HP get restored.
	 */
	@Test
	void testStartHealing() {
		Hero hero = new Hero("Lorenzo", "Cool Dude", "Ciao");
		hero.setHealth(20);
		HealingItem healingPotion = new HealingItem(HealingItemType.GoodAntidote);
		HealingItem.startHealing(hero, healingPotion.getRecoverableHP());
		
		
		//Requirement 1
		try {
			Thread.sleep(16000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		int healthAfter16000msFromHealingPotion = hero.getHealth();
		assertEquals(25, healthAfter16000msFromHealingPotion);
		
		
		try {
			Thread.sleep(16000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int healthAfter32000msFromHealingPotion = hero.getHealth();
		assertEquals(29, healthAfter32000msFromHealingPotion);
		
//		Requiremt 2
//		Commented out as it takes way too long to finish
//		try {
//			Thread.sleep(25 * 16000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		int healthAfterFullRecover = hero.getHealth();
//		assertEquals(45, healthAfterFullRecover);
		
		
		//Requirement 3
		Hero heroTwo = new Hero("Lorenzo", "Cool Dude", "Ciao");
		hero.setHealth(20);
		HealingItem healingPotionTwo = new HealingItem(HealingItemType.BetterAntidote);
		HealingItem.startHealing(heroTwo, healingPotionTwo.getRecoverableHP());

		long startTime = System.currentTimeMillis();
		long elapsedTime = 0L;

		while (elapsedTime < 3 * 1600) {
			System.out.println("Main thread alive!");
		    elapsedTime = (new Date()).getTime() - startTime;
		    assertNotNull(elapsedTime);
		    assertTrue(heroTwo.getHealth() >= 20);
		}
		assertNotEquals(20, heroTwo.getHealth());		
	}
	

}
