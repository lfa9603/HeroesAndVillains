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
import minigames_V2.MiniGameEngine;

/**
 * @author Jay Hamilton
 *
 */
class MiniGameEngineTest {
	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	private HeroesSquad squad;
	private Hero hero1;
	private Hero hero2;
	private Hero hero3;
	private Hero hero4;
	private Hero hero5;
	private Hero hero6;
	private Villain villain;
	private MiniGameEngine game;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		//Squad for testing
		squad = new HeroesSquad();
		hero1 = new Hero("hero1", Types.talkitive, Abilities.charm);
		hero2 = new Hero("hero2", Types.smart, Abilities.mystery);
		hero3 = new Hero("hero3", Types.practical, Abilities.betterOdds);
		hero4 = new Hero("hero4", Types.strong, Abilities.lessDamage);
		hero5 = new Hero("hero5",Types.sly, Abilities.winDraws);
		hero6 = new Hero("hero3",Types.dog, Abilities.goodBoy);
		
		villain = new Villain("testVillain", Types.level_1, Abilities.stealLunchMoney, "Ciao bella donna ;p", 10);
		game = new MiniGameEngine();
	}
	
	private void setInputStream(String input) {
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() {
		System.setOut(System.out); 
		System.setIn(System.in);

		squad = null;
		hero1 = null;
		hero2 = null;
		hero3 = null;
		hero4 = null;
		hero5 = null;
		hero6 = null;
		villain = null;
		game = null;
	}

	/**
	 * Test method for {@link minigames_V2.MiniGameEngine#runMiniGameEngine(characters.Villain, characters.HeroesSquad)}.
	 */
	@Test
	void testRunMiniGameEngine() {
		setInputStream("1\n"
				+ "y\n"
				+ "1\n"
				+ "1\n"
				+ "1\n"
				+ "1\n"
				+ "y\n"
				+ "1\n"
				+ "2\n"
				+ "3\n"
				+ "1\n"
				+ "y\n"
				+ "1\n"
				+ "2\n"
				+ "3\n"
				+ "1\n");
		HelperScanner.create();
		hero1.setIsGameChooser(true);
		hero1.setHealth(10);
		squad.addHero(hero1);
		villain.setTimesBeaten();
		villain.setTimesBeaten();
		game.runMiniGameEngine(villain, squad);

	}
	
	/**
	 * Test method for {@link minigames_V2.MiniGameEngine#runMiniGameEngine(characters.Villain, characters.HeroesSquad)}.
	 */
	@Test
	void testRunMiniGameEngine2() {
		setInputStream("1\n"
				+ "y\n"
				+ "2\n"
				+ "y\n"
				+ "2\n"
				+ "y\n"
				+ "2\n"
				+ "y\n"
				+ "2\n"
				+ "y\n"
				+ "2\n");
		HelperScanner.create();
		hero2.setIsGameChooser(true);
		hero2.setHealth(10);
		squad.addHero(hero2);
		villain.setTimesBeaten();
		villain.setTimesBeaten();
		villain.setCharacterType(Types.level_2);
		game.runMiniGameEngine(villain, squad);

	}
	
	/**
	 * Test method for {@link minigames_V2.MiniGameEngine#runMiniGameEngine(characters.Villain, characters.HeroesSquad)}.
	 */
	@Test
	void testRunMiniGameEngine3() {
		setInputStream("1\n"
				+ "y\n"
				+ "3\n"
				+ "1\n"
				+ "y\n"
				+ "3\n"
				+ "1\n"
				+ "y\n"
				+ "3\n"
				+ "1\n");
		HelperScanner.create();
		hero3.setIsGameChooser(true);
		hero3.setHealth(10);
		squad.addHero(hero3);
		villain.setTimesBeaten();
		villain.setTimesBeaten();
		villain.setCharacterType(Types.level_3);
		game.runMiniGameEngine(villain, squad);

	}
	
	/**
	 * Test method for {@link minigames_V2.MiniGameEngine#runMiniGameEngine(characters.Villain, characters.HeroesSquad)}.
	 */
	@Test
	void testRunMiniGameEngine4() {

		hero4.setisAlive(false);
		hero5.setIsinDetention(true);
		squad.addHero(hero4);
		squad.addHero(hero5);
		villain.setCharacterType(Types.level_4);
		game.runMiniGameEngine(villain, squad);
		assertTrue(squad.isAllDead());
		hero4.setisAlive(true);
		villain.setBeaten(true);
		game.runMiniGameEngine(villain, squad);
		squad.setAllDead(false);
		squad.checkTeamStatus();
		assertFalse(squad.isAllDead());

	}
	
	/**
	 * Test method for {@link minigames_V2.MiniGameEngine#runMiniGameEngine(characters.Villain, characters.HeroesSquad)}.
	 */
	@Test
	void testRunMiniGameEngine5() {
		//test villain difficulties

		hero4.setisAlive(false);
		squad.addHero(hero4);
		villain.setCharacterType(Types.level_5);
		game.runMiniGameEngine(villain, squad);
		squad.setAllDead(false);
		villain.setCharacterType(Types.Boss);
		game.runMiniGameEngine(villain, squad);
	}
	

	/**
	 * Test method for {@link minigames_V2.MiniGameEngine#selectHero(characters.HeroesSquad)}.
	 */
	@Test
	void testSelectHero() {
		setInputStream("1\n"
				+ "2\n");
		HelperScanner.create();
		hero4.setisAlive(false);
		hero5.setIsinDetention(true);
		squad.addHero(hero4);
		squad.addHero(hero5);
		game.selectHero(squad);

	}

	/**
	 * Test method for {@link minigames_V2.MiniGameEngine#setSelectedGame(int)}.
	 */
	@SuppressWarnings("static-access")
	@Test
	void testSetSelectedGame() {
		game.setSelectedGame(1);
		int actual = game.getSelectedMiniGame();
		assertEquals(1, actual);
	}

}
