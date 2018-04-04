package Testing.CharacterTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Hero;

class HeroTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToString() {
		Hero lorenzo = new Hero("Lorenzo", "fire");
		String toString = lorenzo.toString();
		assertEquals("Hero named: Lorenzo\nHealth: 100\nSpecial ability: fire", toString);
	}

	@Test
	void testGetCharacterName() {
		Hero lorenzo = new Hero("Lorenzo", "fire");
		String toString = lorenzo.getCharacterName();
		assertEquals("Lorenzo", toString);
	}

	@Test
	void testSetCharacterName() {
		Hero lorenzo = new Hero("Lorenzo", "fire");
		lorenzo.setCharacterName("Lorenzo_edited");
		String toString = lorenzo.getCharacterName();
		assertEquals("Lorenzo_edited", toString);
	}

	@Test
	void testGetCharacterAbility() {
		Hero lorenzo = new Hero("Lorenzo", "fire");
		String toString = lorenzo.getCharacterAbility();
		assertEquals("fire", toString);
	}

	@Test
	void testSetCharacterAbility() {
		Hero lorenzo = new Hero("Lorenzo", "fire");
		lorenzo.setCharacterAbility("fire_edited");
		String toString = lorenzo.getCharacterAbility();
		assertEquals("fire_edited", toString);
	}

	@Test
	void testGetHealth() {
		Hero lorenzo = new Hero("Lorenzo", "fire");
		int lorenzoHealth = lorenzo.getHealth();
		assertEquals(100, lorenzoHealth);
	}

	@Test
	void testSetHealth() {
		Hero lorenzo = new Hero("Lorenzo", "fire");
		lorenzo.setHealth(80);
		int lorenzoHealth = lorenzo.getHealth();
		assertEquals(80, lorenzoHealth);
	}

}
