package Testing.CharacterTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Hero;
import characters.HeroesSquad;
import characters.Types;

class HeroSquadTests {

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
	void testAddHero() {
		Hero hero1 = new Hero("hero1", Types.level_1, "specialAbility_1");
		Hero hero2 = new Hero("hero2", Types.level_1, "specialAbility_2");
		Hero hero3 = new Hero("hero3",Types.level_1, "specialAbility_3");
		HeroesSquad testsquad = new HeroesSquad();
		testsquad.addHero(hero1);
		testsquad.addHero(hero1);
		testsquad.addHero(hero2);
		testsquad.addHero(hero3);
		assertEquals(3, testsquad.getHeroSquad().size());
		assertTrue(testsquad.squadContains(hero1));
		assertTrue(testsquad.squadContains(hero2));
		assertTrue(testsquad.squadContains(hero3));
	}
	
	@Test
	void TestToString() {
		Hero hero1 = new Hero("hero1", Types.level_1, "specialAbility_1");
		Hero hero2 = new Hero("hero2", Types.level_1, "specialAbility_2");
		Hero hero3 = new Hero("hero3",Types.level_1, "specialAbility_3");
		HeroesSquad testsquadOne = new HeroesSquad();
		testsquadOne.addHero(hero1);
		testsquadOne.addHero(hero1);
		testsquadOne.addHero(hero2);
		testsquadOne.addHero(hero3);
		assertEquals(3, testsquadOne.getHeroSquad().size());
//		assertEquals("Heros in squad: \nhero1\nhero2\nhero3\n", testsquad.toString());TODO: check this returning statement in toString()
	}

}
