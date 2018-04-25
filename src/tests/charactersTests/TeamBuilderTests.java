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

	
	@Test
	void testGetNewTeam() {
		
		setInputStream("y\n"
				+ "TheLory\n"
				+ "y\n"
				+ "1\n"
				+ "jay\n"
				+ "n\n"
				+ "2\n"
				+ "lorenzo\n"
				+ "y\n");
		HelperScanner.create();
		
		TeamBuilder testTeam = new TeamBuilder();
		
		HeroesSquad squad = testTeam.getTeam();
		
		assertEquals(squad.getLength(),  2);
		
		Hero jay = squad.getHero(0);
		Hero lorenzo = squad.getHero(1);
		
		assertEquals("jay", jay.getCharacterName());
		assertEquals("lorenzo", lorenzo.getCharacterName());
		
	}

}
