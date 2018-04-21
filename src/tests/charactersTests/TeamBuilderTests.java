package tests.charactersTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.HeroesSquad;
import characters.TeamBuilder;

class TeamBuilderTests {

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
	void testGetNewTeam() {
		TeamBuilder testTeam = new TeamBuilder();
		/* Enter the following inputs:
		 * Y
		 * testTeam
		 * Y
		 * 4
		 * Character 1
		 * 2
		 * Character 2
		 * 2
		 * Character 3
		 * Y
		 */
		String expected = "Heros in testTeam: \n" + 
				"Character 1 : ability4\n" + 
				"Character 2 : ability2\n" + 
				"Character 3 : ability2\n";
		HeroesSquad team = testTeam.getTeam();
		String teamString = team.toString();
		assertEquals(expected,  teamString);
		
	}

}
