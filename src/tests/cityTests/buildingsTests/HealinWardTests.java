package tests.cityTests.buildingsTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.Types;
import city.buildings.hospital.HealingWard;
import collectables.CollectableID;
import collectables.healingItem.HealingItem;

class HealinWardTests {


	private HealingWard healingWard;
	private Hero hero1;
	private Hero hero2;
	private Hero hero3;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() {
		//Squad for testing
		healingWard = new HealingWard();
		hero1 = new Hero("Hero1", Types.dog, Abilities.badDay);
		hero2 = new Hero("Hero2", Types.sly, Abilities.betterOdds);
		hero1.setHealth(96);
		hero2.setHealth(90);
		hero1.setArmor(30);
				
		//Adding a second squad with no healing items
		hero3 = new Hero("Hero3", Types.sly, Abilities.betterOdds);
		hero3.setHealth(90);
		hero3.setArmor(30);
		
		
		
	}


	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() {
		System.setOut(System.out); 
		System.setIn(System.in);
//		healingWard = null;
//		hero1 = null;
//		hero2 = null;
//		hero3 = null;
	}


	@Test
	void testAddPatientAndUpdateHealingTime() {
		
		HealingItem healingItem = new HealingItem(CollectableID.BestHealingItem);

		healingItem.apply(hero1);
		healingWard.addPatientAndUpdateHealingTime(healingItem, hero1);
//		healingWard.addPatientAndUpdateHealingTime(healingItem, hero2);
//		
		try {
			Thread.sleep(4500);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		assertEquals(hero1.getHealth(), 98);
		assertTrue(healingWard.isInHealingWard(hero1));
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertFalse(healingWard.isInHealingWard(hero1));
			
	}

	@Test
	void testToString() {
		
		HealingItem healingItem = new HealingItem(CollectableID.BestHealingItem);

		healingItem.apply(hero1);
		healingWard.addPatientAndUpdateHealingTime(healingItem, hero1);
		
		try {
			Thread.sleep(4500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String string = new String();
		string += "\nThe hero " + hero1.getCharacterName() 
		    	+ " is going to be dismissed in 7 seconds.";
		string += "\nTheir current health is 98";
		
		assertEquals(healingWard.toString(), string);
		
	}
}
