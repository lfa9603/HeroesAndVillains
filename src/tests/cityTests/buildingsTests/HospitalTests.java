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

/**
 * @author Jay Hamilton
 *
 */
class HospitalTests {
	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	
	private Hospital hospital;
	private HeroesSquad squad;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		hospital = new Hospital("Hospital", TypeBuildings.Hospital);
		squad = new HeroesSquad();
		Hero hero1 = new Hero("Hero1", Types.dog, Abilities.badDay);
		squad.addHero(hero1);
		hero1.setHealth(50);
		hero1.setArmor(30);
		squad.getBackPack().addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
		
		
	}
	
	private void setInputStream(String input) {
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
	}
	
	private String getOutputStream() {
		
		byte[] bytes = outputStream.toByteArray();
		CharBuffer charBuffer = Charset.defaultCharset().decode(ByteBuffer.wrap(bytes));
		
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		return charBuffer.toString().replaceAll("\r\n", "\n");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() {
		System.setOut(System.out); 
		System.setIn(System.in);
		hospital = null;
		heroes = null;
	}

	/**
	 * Test method for {@link city.buildings.hospital.Hospital#interact(characters.HeroesSquad)}.
	 */
	@Test
	void testInteract() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link city.buildings.hospital.Hospital#Hospital(java.lang.String, city.buildings.TypeBuildings)}.
	 */
	@Test
	void testHospital() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link city.buildings.Building#Building(java.lang.String, city.buildings.TypeBuildings)}.
	 */
	@Test
	void testBuilding() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link city.buildings.Building#getBuildingName()}.
	 */
	@Test
	void testGetBuildingName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link city.buildings.Building#setBuildingName(java.lang.String)}.
	 */
	@Test
	void testSetBuildingName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link city.buildings.Building#getBuildingCoordinates()}.
	 */
	@Test
	void testGetBuildingCoordinates() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link city.buildings.Building#setBuildingCoordinates(java.awt.Point)}.
	 */
	@Test
	void testSetBuildingCoordinates() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link city.buildings.Building#getBuildingType()}.
	 */
	@Test
	void testGetBuildingType() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link city.buildings.Building#toString()}.
	 */
	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
