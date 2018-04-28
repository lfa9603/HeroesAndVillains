package tests.minigamesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import characters.Villain;
import engine.HelperScanner;
import minigames_V2.DiceWars;
import minigames_V2.Games;

class DiceWarsTests {

	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	
	private Villain villain;
	private Games game;
	private HeroesSquad squad;
	private Hero hero;
	
	private DiceWars dc;	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUpBeforeTest() throws Exception {
		
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		villain = new Villain("Jay", Types.Boss, Abilities.stealLunchMoney, "Ciao", 15);
		game = Games.RPS;
		squad = new HeroesSquad();
		hero =  new Hero("Lorenzo", Types.dog, Abilities.charm);
		squad.addHero(hero);
		
		dc = new DiceWars(game, villain, squad, true);
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
		
		villain = null;
		game = null;
		squad = null;
		hero =  null;
		
		dc = null;
		
	}


	@RepeatedTest(100)
	void testRunGame() {
				
		setInputStream("1\n");
		HelperScanner.create();
		
		dc.runGame(hero);
		
		if (villain.getTimesBeaten() == 1) {
			assertEquals(hero.getHealth(), 100);
		} else {
			assertEquals(villain.getTimesBeaten(), 0);
			assertEquals(hero.getHealth(), 85);
		}
	}
	

}
