/**
 * 
 */
package tests.minigamesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import characters.Villain;
import engine.HelperScanner;
import minigames_V2.Games;
import minigames_V2.RockPaperScissors;

/**
 * @author Lorenzo
 *
 */
class RockPaperScissorsTest {

	
	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	
	private Villain villain;
	private Games game;
	private HeroesSquad squad;
	private Hero hero;
	
	private RockPaperScissors rps;	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUpBeforeTest() throws Exception {
		
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		villain = new Villain("Jay", Types.level_1, Abilities.stealLunchMoney, "Ciao", 15);
		game = Games.RPS;
		squad = new HeroesSquad();
		hero =  new Hero("Lorenzo", Types.talkitive, Abilities.charm);
		squad.addHero(hero);
		
		rps = new RockPaperScissors(game, villain, squad, true);
		
	}

	private void setInputStream(String input) {
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDownAfterMethod() throws Exception {
		System.setOut(System.out);
		System.setIn(System.in);
	}

	/**
	 * Test method for {@link minigames_V2.RockPaperScissors#runGame(characters.Hero)}.
	 */
	@Test
	void testRunGameOnRockChoice() {
		
		setInputStream("1\n");
		HelperScanner.create();
		
		rps.runGame(hero);
		
		if (villain.getTimesBeaten() == 0) {
			assertEquals(hero.getHealth(), 85);
		} else {
			assertEquals(hero.getHealth(), 100);
			assertEquals(villain.getTimesBeaten(), 1);
		}

	}

	/**
	 * Test method for {@link minigames_V2.RockPaperScissors#runGame(characters.Hero)}.
	 */
	@Test
	void testRunGameOnPaperChoice () {
		
		setInputStream("2\n");
		HelperScanner.create();
		
		rps.runGame(hero);
		
		if (villain.getTimesBeaten() == 0) {
			assertEquals(hero.getHealth(), 85);
		} else {
			assertEquals(hero.getHealth(), 100);
			assertEquals(villain.getTimesBeaten(), 1);
		}
		
	}
	
	/**
	 * Test method for {@link minigames_V2.RockPaperScissors#RockPaperScissors(minigames_V2.Games, characters.Villain, characters.HeroesSquad, boolean)}.
	 */
//	@Test
//	void testRockPaperScissors() {
//		fail("Not yet implemented");
//	}

}
