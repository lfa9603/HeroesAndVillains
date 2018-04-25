package tests.charactersTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Types;
import characters.Villain;
import characters.Villains;

class VillainsTests {
	private Villains villains;
	private ArrayList<Villain> villainsList;

	@BeforeEach
	void setUp() throws Exception {
		villains = new Villains(6);
		villainsList = villains.getVillains();
	}

	@AfterEach
	void tearDown() throws Exception {
		villains = null;
		villainsList = null;
	}

	@Test
	void testVillains() {
		int actual = villainsList.size();
		assertTrue(actual == 6);
		
		Villains villains2 = new Villains(3);
		ArrayList<Villain> villainsList2 = villains2.getVillains();
		int actual2 = villainsList2.size();
		assertTrue(actual2 == 3);
		
		Villains villains3 = new Villains(4);
		ArrayList<Villain> villainsList3 = villains3.getVillains();
		int actual3 = villainsList3.size();
		assertTrue(actual3 == 4);
	}

	@Test
	void testGetVillains() {
		Villain actual1 = villains.getCurrentVillain(0);
		Villain actual2 = villains.getCurrentVillain(1);
		Villain actual3 = villains.getCurrentVillain(2);
		Villain actual4 = villains.getCurrentVillain(3);
		Villain actual5 = villains.getCurrentVillain(4);
		Villain actual6 = villains.getCurrentVillain(5);
		
		assertEquals(Types.level_1, actual1.getCharacterType());
		assertEquals(Types.level_2, actual2.getCharacterType());
		assertEquals(Types.level_3, actual3.getCharacterType());
		assertEquals(Types.level_4, actual4.getCharacterType());
		assertEquals(Types.level_5, actual5.getCharacterType());
		assertEquals(Types.Boss, actual6.getCharacterType());
		
	}


	@Test
	void testToString() {
		String actual = villains.toString();
		String expected = "Villains: \n"
				+ "Tony the Primary School bully\n"
				+ "Gertrude the HighSchool Principal\n"
				+ "Richard your Partners Father\n"
				+ "Alex your Partner\n"
				+ "Page your docter\n"
				+ "Sam your Manager\n";
		assertEquals(expected, actual);
	}

}
