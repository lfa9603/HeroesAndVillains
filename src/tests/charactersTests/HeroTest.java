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
		lorenzo.setHealth(150);
		int actual = lorenzo.getHealth();
		assertEquals(80, actual);
		
	}
	
	@Test
	void testIsAlive() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		boolean lorenzoAlive = lorenzo.isAlive();
		assertTrue(lorenzoAlive);
		lorenzo.setisAlive(false);
		assertFalse(lorenzo.isAlive());
	}
	
	@Test
	void testSetCharacterType() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		Types actual = lorenzo.getCharacterType();
		assertEquals(Types.dog, actual);
	}
	
	@Test
	void testsetCharacterType() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		lorenzo.setCharacterType(Types.smart);
		Types actual = lorenzo.getCharacterType();
		assertEquals(Types.smart, actual);
	}
	
	@Test
	void testsetMaxHealth() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		lorenzo.setMaxHealth(150);
		int actual = lorenzo.getMaxHealth();
		assertEquals(150, actual);
	}
	
	@Test
	void testsetHasArmor() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		lorenzo.setArmor(30);
		int actual = lorenzo.getArmor();
		assertEquals(30, actual);
	}
	
	@Test
	void testsetIsGameChooser() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		lorenzo.setIsGameChooser(true);
		boolean actual = lorenzo.getIsGameChooser();
		assertTrue(actual);
	}
	
	@Test
	void testsetIsInDetention() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		lorenzo.setIsinDetention(true);
		boolean actual = lorenzo.isInDetention();
		assertTrue(actual);
	}
	
	@Test
	void testEquals() {
		Hero lorenzo = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		Hero lorenzo2 = new Hero("Lorenzo", Types.dog, Abilities.arrogance);
		Hero lorenzo3 = new Hero("Lorenzo3", Types.dog, Abilities.arrogance);
		boolean actual = lorenzo.equals(lorenzo2);
		assertTrue(actual);
		boolean actualfalse = lorenzo.equals(lorenzo3);
		assertFalse(actualfalse);
	}
	
	
	

}
