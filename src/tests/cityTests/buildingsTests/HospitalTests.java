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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import city.buildings.TypeBuildings;
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
		Hero hero1 = new Hero("Hero1", Types.dog, Abilities.badDay);
		squad.addHero(hero1);
		hero1.setHealth(98);
		hero1.setArmor(30);
		
		//Added a healing item to squad ones backPack
		potion = new HealingItem(CollectableID.BestHealingItem);
		squad.getBackPack().addItemToInventory(potion);
		
		//Adding a second squad with no healing items
		squad2 = new HeroesSquad();
		Hero hero2 = new Hero("Hero1", Types.sly, Abilities.betterOdds);
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
	
	@Test
	void testInteract3() {
		setInputStream("2\n"
				+ "1\n"
				+ "0\n");
		HelperScanner.create();
		// Can't get this to cover ... Still having issues
		hospital.interact(squad);
		assertFalse(squad.getBackPack().getInventory().containsKey(potion));
		boolean expected = squad.getHero(0).getHealth() == squad.getHero(0).getMaxHealth();
		System.out.println(expected);
		
		assertTrue(expected);
	}
	
	@Test
	void testInteract4() {
		setInputStream("9\n"
				+ "akljdsfhlaksjdhf\n"
				+ "0\n");
		HelperScanner.create();
		hospital.interact(squad2);
		assertFalse(squad2.getBackPack().getInventory().containsKey(potion));
	}

}
