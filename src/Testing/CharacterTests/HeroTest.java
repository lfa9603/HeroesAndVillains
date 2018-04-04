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
		fail("Not yet implemented");
	}

	@Test
	void testGetCharacterName() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCharacterName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCharacterAbility() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCharacterAbility() {
		fail("Not yet implemented");
	}

	@Test
	void testGetHealth() {
		Hero lorenzo = new Hero("Lorenzo", "fire");
		int lorenzoHealth = lorenzo.getHealth();
		assertEquals(100, lorenzoHealth);
	}

	@Test
	void testSetHealth() {
		fail("Not yet implemented");
	}

}
