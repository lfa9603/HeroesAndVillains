package tests.charactersTests;

/**
*@author JayHamilton
*
**/

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.Types;

class HeroTest {


	@Test
	void testToString() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		String toString = lorenzo.toString();
		assertEquals("Hero named: Lorenzo\nHealth: 100\nSpecial ability: arrogance", toString);
	}

	@Test
	void testGetCharacterName() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		String toString = lorenzo.getCharacterName();
		assertEquals("Lorenzo", toString);
	}

	@Test
	void testSetCharacterName() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		lorenzo.setCharacterName("Lorenzo_edited");
		String toString = lorenzo.getCharacterName();
		assertEquals("Lorenzo_edited", toString);
	}

	@Test
	void testGetCharacterAbility() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		Abilities toString = lorenzo.getCharacterAbility();
		assertEquals(Abilities.arrogance, toString);
	}

	@Test
	void testSetCharacterAbility() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		lorenzo.setCharacterAbility(Abilities.charm);
		Abilities toString = lorenzo.getCharacterAbility();
		assertEquals(Abilities.charm, toString);
	}

	@Test
	void testGetHealth() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		int lorenzoHealth = lorenzo.getHealth();
		assertEquals(100, lorenzoHealth);
	}

	@Test
	void testSetHealth() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		lorenzo.setHealth(80);
		int lorenzoHealth = lorenzo.getHealth();
		assertEquals(80, lorenzoHealth);
	}
	
	@Test
	void testIsAlive() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		boolean lorenzoAlive = lorenzo.isAlive();
		assertTrue(lorenzoAlive);
		lorenzo.setisAlive(false);
		assertFalse(lorenzo.isAlive());
	}

}
