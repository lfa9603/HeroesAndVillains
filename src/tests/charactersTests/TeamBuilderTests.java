package tests.charactersTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Hero;
import characters.HeroesSquad;
import characters.TeamBuilder;
import characters.Types;
import engine.HelperScanner;

class TeamBuilderTests {


	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	private String teamCreationExpectedOutput = "Do you want to create a New Team? Y/N \n" + 
			"invalid input, please answer Y/N or y/n\n" + 
			"Do you want to create a New Team? Y/N \n" + 
			"Thanks for Playing!\n";
	private String teamCreationExpectedOutput2 = "Do you want to create a New Team? Y/N \n" +  
			"Team name: \n" + 
			"Team Name must be between 2 and 10 characters long\n" + 
			"Team name: \n" + 
			"Your Teams name is: 123456789\n" + 
			"Are you happy with this? Y/N\n" + 
			"...Please re-enter\n" + 
			"Team name:";
	
	
	@BeforeEach
	void beforeEach() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}
	
	private void setInputStream(String input) {
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
	}
	
	private String getOutputStream() {
		
		byte[] bytes = outputStream.toByteArray();
		CharBuffer charBuffer = Charset.defaultCharset().decode(ByteBuffer.wrap(bytes));
		
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		return charBuffer.toString().replaceAll("\r\n", "\n");
	}
	
	@AfterEach
	void afterEach() {
		System.setOut(System.out); 
		System.setIn(System.in);
	}
	
	@Test
	void testCreateTeam() {
		
		setInputStream("1\n"
				+ "n\n");
		HelperScanner.create();
		
		TeamBuilder testTeamCreation = new TeamBuilder();
		
		String outStream = getOutputStream();
		System.out.println(outStream);
		assertEquals(teamCreationExpectedOutput, outStream);  
		
	}
	
	@Test
	void testCreateTeam2() {
		
		setInputStream("y\n"
				+ "12345678910\n"
				+ "123456789\n"
				+ "n\n"
				+ "123456789\n"
				+ "1\n"
				+ "y\n"
				+ "TheLory\n"
				+ "y\n"
				+ "1\n"
				+ "jay\n"
				+ "n\n"
				+ "2\n"
				+ "lorenzo\n"
				
				+ "y\n");
		HelperScanner.create();
		
		TeamBuilder teamBuilder = new TeamBuilder();
		HeroesSquad squad = teamBuilder.getTeam();
		String teamName = squad.getTeamName();
		assertTrue(teamName.length() > 2 && teamName.length() < 10);
	}

	
	@Test
	void testGetNewTeam() {
		
		setInputStream("y\n"
				+ "TheLory\n"
				+ "y\n"
				+ "7\n"
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
				+ "y\n");
		HelperScanner.create();
		
		TeamBuilder testTeam2 = new TeamBuilder();
		
		HeroesSquad squad2 = testTeam2.getTeam();
		
		assertEquals(squad2.getLength(),  3);
		
		Hero hero1 = squad2.getHero(0);
		Hero hero2 = squad2.getHero(1); 
		Hero hero3 = squad2.getHero(2);
		
		String outStream = getOutputStream();
		
		assertEquals("Hero1", hero1.getCharacterName());
		assertEquals(Types.talkitive, hero1.getCharacterType());
		assertEquals("Hero2", hero2.getCharacterName());
		assertEquals(Types.smart, hero2.getCharacterType());
		assertEquals("Hero3", hero3.getCharacterName());
		assertEquals(Types.practical, hero3.getCharacterType());
		
	}
	
	@Test
	void testGetNewTeam3() {
		
		setInputStream("y\n"
				+ "TestTeam\n"
				+ "y\n"
				+ "4\n"
				+ "Hero4\n"
				+ "n\n"
				+ "5\n"
				+ "Hero5\n"
				+ "n\n"
				+ "6\n"
				+ "Hero6\n"
				+ "n\n"
				+ "y\n");
		HelperScanner.create();
		
		TeamBuilder testTeam2 = new TeamBuilder();
		
		HeroesSquad squad2 = testTeam2.getTeam();
		
		assertEquals(squad2.getLength(),  3);
		
		Hero hero4 = squad2.getHero(0);
		Hero hero5 = squad2.getHero(1); 
		Hero hero6 = squad2.getHero(2);
		
		String outStream = getOutputStream();
		
		assertEquals("Hero4", hero4.getCharacterName());
		assertEquals(Types.strong, hero4.getCharacterType());
		assertEquals("Hero5", hero5.getCharacterName());
		assertEquals(Types.sly, hero5.getCharacterType());
		assertEquals("Hero6", hero6.getCharacterName());
		assertEquals(Types.dog, hero6.getCharacterType());
		
	}

}
