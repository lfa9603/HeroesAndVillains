package tests.charactersTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Hero;
import characters.HeroesSquad;
import characters.TeamBuilder;
import engine.HelperScanner;

class TeamBuilderTests {


	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	
	
	@BeforeEach
	void beforeEach() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}
	
	private void setInputStream(String input) {
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
	}
	
	@AfterEach
	void afterEach() {
		System.setOut(System.out);
		System.setIn(System.in);
	}

	
//	@Test
//	void testGetNewTeam() {
//		
//		setInputStream("y\n"
//				+ "TheLory\n"
//				+ "y\n"
//				+ "1\n"
//				+ "jay\n"
//				+ "n\n"
//				+ "2\n"
//				+ "lorenzo\n"
//				
//				+ "y\n");
//		HelperScanner.create();
//		
//		TeamBuilder testTeam = new TeamBuilder();
//		
//		HeroesSquad squad = testTeam.getTeam();
//		
//		assertEquals(squad.getLength(),  2);
//		
//		Hero jay = squad.getHero(0);
//		Hero lorenzo = squad.getHero(1);
//		
//		assertEquals("jay", jay.getCharacterName());
//		assertEquals("lorenzo", lorenzo.getCharacterName());
//		
//	}
	
	@Test
	void testGetNewTeam2() {
		
		setInputStream("y\n"
				+ "TestTeam\n"
				+ "y\n"
				+ "1\n"
				+ "Hero1\n"
				+ "n\n"
				+ "2\n"
				+ "Hero2\n"
				+ "n\n"
				+ "3\n"
				+ "Hero3\n"
				+ "n\n"
				+ "y\n"
				
				+ "y\n");
		HelperScanner.create();
		
		TeamBuilder testTeam2 = new TeamBuilder();
		
		HeroesSquad squad2 = testTeam2.getTeam();
		
		assertEquals(squad2.getLength(),  3);
		
		Hero hero1 = squad2.getHero(0);
		Hero hero2 = squad2.getHero(1);
		Hero hero3 = squad2.getHero(2);
		
		assertEquals("Hero1", hero1.getCharacterName());
		assertEquals("Hero2", hero2.getCharacterName());
		assertEquals("Hero3", hero3.getCharacterName());
		
	}

}
