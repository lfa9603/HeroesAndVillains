/**
 * 
 */
package tests.cityTests.buildingsTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import city.buildings.TypeBuildings;
import city.buildings.hospital.HealingWard;
import city.buildings.hospital.Hospital;
import collectables.CollectableID;
import collectables.healingItem.HealingItem;
import engine.HelperScanner;

/**
 * @author Jay Hamilton
 *
 */
class HospitalTests {
	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	
	private Hospital hospital;
	private HeroesSquad squad;
	private HeroesSquad squad2;
	private HealingItem potion;
	private Hero hero1;
	private Hero hero2;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		//Squad for testing
		hospital = new Hospital("Hospital", TypeBuildings.Hospital);
		squad = new HeroesSquad();
		hero1 = new Hero("Hero1", Types.dog, Abilities.badDay);
		squad.addHero(hero1);
		hero1.setHealth(98);
		hero1.setArmor(30);
		
		//Added a healing item to squad ones backPack
		potion = new HealingItem(CollectableID.BestHealingItem);
		squad.getBackPack().addItemToInventory(potion);
		
		//Adding a second squad with no healing items
		squad2 = new HeroesSquad();
		hero2 = new Hero("Hero2", Types.sly, Abilities.betterOdds);
		squad2.addHero(hero2);
		hero2.setHealth(90);
		hero2.setArmor(30);
		
		
		
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
		hospital = null;
		squad = null;
		squad2 = null;
	}

	/**
	 * Test method for {@link city.buildings.hospital.Hospital#interact(characters.HeroesSquad)}.
	 */
	@Test
	void testInteract() {
		setInputStream("0\n"
				+ "1\n"
				+ "3\n");
		HelperScanner.create();
		hospital.interact(squad);
		assertTrue(squad.getBackPack().getInventory().containsKey(potion));
	}
	
	@Test
	void testInteract2() {
		setInputStream("9\n"
				+ "0\n"
				+ "1\n"
				+ "2\n"
				+ "akljdsfhlaksjdhf\n"
				+ "8\n"
				+ "0\n"
				+ "3\n");
		HelperScanner.create();
		hospital.interact(squad);
		assertTrue(squad.getBackPack().getInventory().containsKey(potion));
	}
	
//	@Test
//	void testInteract3() {
//		setInputStream("2\n"
//				+ "1\n"
//				+ "kdf\n"
//				+ "kdf\n"
//				+ "kdf\n"
//				+ "kdf\n"
//				+ "kdf\n"
//				+ "0\n");
//		HelperScanner.create();
//		int initialHealth = squad.getHero(0).getHealth();
//		hospital.interact(squad);
//		
//		assertFalse(squad.getBackPack().getInventory().containsKey(potion));
//		assertEquals(squad.getHero(0).getHealth(), initialHealth + 1);
//	}
	
	@Test
	void testInteract4() {
		setInputStream("9\n"
				+ "akljdsfhlaksjdhf\n"
				+ "0\n");
		HelperScanner.create();
		hospital.interact(squad2);
		assertFalse(squad2.getBackPack().getInventory().containsKey(potion));
	}
	
	/**
	 * This method gets called only with indices values between 0 and 2 included, this is an enforced behaviour 
	 * that the GUI implementation underlines (only 3 choices in the Hospital list).
	 */
	@Test
	void testReturnCorrectHealingItemGivenIndex() {
		HealingItem healiItem1 = hospital.returnCorrectHealingItemGivenIndex(0);
		assertEquals(healiItem1.getCollectableID(), CollectableID.GoodHealingItem);
		
		HealingItem healiItem2 = hospital.returnCorrectHealingItemGivenIndex(1);
		assertEquals(healiItem2.getCollectableID(), CollectableID.BetterHealingItem);
		
		HealingItem healiItem3 = hospital.returnCorrectHealingItemGivenIndex(2);
		assertEquals(healiItem3.getCollectableID(), CollectableID.BestHealingItem);
	}
	
	@Test
	void testCompleteOrRejectHealingItemApplication() {
		
		String stringTest1 = hospital.completeOrRejectHealingItemApplication(squad, hero1, hospital.returnCorrectHealingItemGivenIndex(2));
		assertEquals("Great " + hero1.getCharacterName() + " has been added to the healing ward of the hospital!", stringTest1);
		
		String stringTest2 = hospital.completeOrRejectHealingItemApplication(squad, hero1, hospital.returnCorrectHealingItemGivenIndex(2));
		assertEquals("Wait until " + hero1.getCharacterName() + " is dismissed by the healing ward.", stringTest2);
		
		String stringTest3 = hospital.completeOrRejectHealingItemApplication(squad2, hero2, hospital.returnCorrectHealingItemGivenIndex(2));
		assertEquals("MATE! I TOLD YA NOT TO BE CHEEKY! YOU AIN'T GOT NONE OF THAT!", stringTest3);
		
		hero2.setisAlive(false);
		String stringTest4 = hospital.completeOrRejectHealingItemApplication(squad2, hero2, hospital.returnCorrectHealingItemGivenIndex(2));
		assertEquals("Unfortunately " + hero2.getCharacterName() + " is dead, you cannot apply a potion on a dead hero.", stringTest4);
		
	}
	
	@Test
	void testGetterAndSetterForHealingWard() {
		
		String stringTest1 = hospital.completeOrRejectHealingItemApplication(squad, hero1, hospital.returnCorrectHealingItemGivenIndex(2));		
		HealingWard hw = new HealingWard();
		assertTrue(hospital.getHealingWard().isInHealingWard(hero1));
		hospital.setHealingWard(hw);
		assertFalse(hospital.getHealingWard().isInHealingWard(hero1));
		
		
	}
	
	
}
