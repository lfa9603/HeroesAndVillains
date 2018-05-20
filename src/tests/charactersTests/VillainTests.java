package tests.charactersTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Types;
import characters.Villain;

class VillainTests {
	private Villain villain;


	@BeforeEach
	void setUp() {
		villain = new Villain("villain", Types.level_1, Abilities.stealLunchMoney, "test taunt", 10);
	}

	@AfterEach
	void tearDown() {
		villain = null;
	}

	@Test
	void testSetCharacterName() {
		villain.setCharacterName("villain1");
		String actual = villain.getCharacterName();
		assertEquals("villain1", actual);
	}

	@Test
	void testSetCharacterType() {
		villain.setCharacterType(Types.level_2);
		Types actual = villain.getCharacterType();
		assertEquals(Types.level_2, actual);
	}



	@Test
	void testToString() {
		String actual = villain.toString();
		assertEquals("villain says test taunt", actual);
		
	}

	@Test
	void testVillain() {
		Villain villain2 = new Villain("villain2", Types.level_2, Abilities.stealLunchMoney, "test taunt2", 102);
		assertEquals("villain2", villain2.getCharacterName());
		assertEquals(Types.level_2, villain2.getCharacterType());
		assertEquals(Abilities.stealLunchMoney, villain2.getCharacterAbility());
		assertEquals("test taunt2", villain2.getVillainTaunt());
		assertEquals(102, villain2.getVillainDamage());
	}


	@Test
	void testSetVillainTaunt() {
		villain.setVillainTaunt("test taunt2");
		String actual = villain.getVillainTaunt();
		assertEquals("test taunt2", actual);
	}

//	@Test
//	void testSayTaunt() {
//		String actual = villain.sayTaunt();
//		assertEquals("villain taunts you, they say test taunt", actual);
//	}

	@Test
	void testGetVillainsChoice() {
		villain.setVillainsChoice(1);
		int actual1 = villain.getVillainsChoice();
		villain.setVillainsChoice(10);
		int actual10 = villain.getVillainsChoice();
		villain.setVillainsChoice(100);
		int actual100 = villain.getVillainsChoice();
		villain.setVillainsChoice(1000);
		int actual1000 = villain.getVillainsChoice();
		
		assertTrue(actual1 <= 1);
		assertTrue(actual10 <= 10);
		assertTrue(actual100 <= 100);
		assertTrue(actual1000 <= 1000);
	}

	@Test
	void testSetVillainDamage() {
		villain.setVillainDamage(120);
		int actual = villain.getVillainDamage();
		assertEquals(120, actual);
	}

	@Test
	void testIsDamageModified() {
		assertFalse(villain.isDamageModified());
	}

	@Test
	void testSetDamageModified() {
		villain.setDamageModified(true);
		boolean actual = villain.isDamageModified();
		assertTrue(actual);
	}


	@Test
	void testSetTimesBeaten() {
		villain.setTimesBeaten();
		int actual = villain.getTimesBeaten();
		assertEquals(1, actual);
		villain.setTimesBeaten();
		int actual2 = villain.getTimesBeaten();
		assertEquals(2, actual2);
		villain.setTimesBeaten();
		int actual3 = villain.getTimesBeaten();
		assertEquals(3, actual3);
		assertTrue(villain.isBeaten());
	}

	@Test
	void testIsBeaten() {
		assertFalse(villain.isBeaten());
	}

	@Test
	void testSetBeaten() {
		villain.setBeaten(true);
		assertTrue(villain.isBeaten());
	}

}
