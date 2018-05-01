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

	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	private HealingWard healingWard;
	private Hero hero1;
	private Hero hero2;
	private Hero hero3;
	private HealingItem potion;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		//Squad for testing
		HealingWard healingWard = new HealingWard();
		hero1 = new Hero("Hero1", Types.dog, Abilities.badDay);
		hero2 = new Hero("Hero2", Types.sly, Abilities.betterOdds);
		hero1.setHealth(90);
		hero2.setHealth(90);
		hero1.setArmor(30);
		
		//Added a healing item to squad ones backPack
		potion = new HealingItem(CollectableID.BestHealingItem);
		
		//Adding a second squad with no healing items
		hero3 = new Hero("Hero3", Types.sly, Abilities.betterOdds);
		hero3.setHealth(90);
		hero3.setArmor(30);
		
		
		
	}
	
	private void setInputStream(String input) {
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
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
		Hero hero1 = new Hero("Ciao", Types.level_2, Abilities.arrogance);
		Hero hero2 = new Hero("Bye", Types.level_2, Abilities.badDay);
		
		HealingItem healingItem = new HealingItem(CollectableID.BestHealingItem);
		healingItem.apply(hero1);
		healingItem.apply(hero2);
		healingWard.addPatientAndUpdateHealingTime(healingItem, hero1);
		healingWard.addPatientAndUpdateHealingTime(healingItem, hero2);
		
		int i = 1;
		while (i > 0) {
			System.out.println(healingWard.toString());
			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		
		boolean expected = hero1.getHealth() == hero1.getMaxHealth();
		boolean expected2 = hero1.getHealth() == hero1.getMaxHealth();
		
		assertTrue(expected);
		assertTrue(expected2);
	}

}
