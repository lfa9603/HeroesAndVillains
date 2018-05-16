package tests.cityTests.buildingsTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
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
import city.City;
import city.buildings.homeBase.Home;
import collectables.Money;
import engine.HelperScanner;

class HomeTests {

	private Home home;
	private Hero lorenzo;
	private Hero jay;
	private HeroesSquad squad;
	private City city;
	
	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	
	@BeforeEach
	void beforeEach() {
		
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		city = new City();
		home = (Home) city.returnBuildingAtSpecificCoordinates(new Point(0, 0));
		
		lorenzo = new Hero("Lorenzo", Types.smart, Abilities.betterOdds);
		jay = new Hero("Jay", Types.talkitive, Abilities.betterOdds);
		
		squad = new HeroesSquad();
		squad.addHero(lorenzo);
		squad.addHero(jay);
		
		squad.setWallet(new Money(1000));
		
		squad.setCurrentCity(city);
		squad.setHaveMap(true);
	}
	
	private void setInputStream(String input) {
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
	}
	
	//TODO: find a good way to test this method.
	@Test
	void testingInteract() {

		setInputStream("0\n1\nab\n2\n" );
		HelperScanner.create();

		
		///
//		System.out.println("FOR NEXT TEST TYPE ANY LETTER, A NON ZERO OR 1 NUMBER AND FINALLY 0 AND 1, IF DOES NOT GO INTO INFINITE LOOP, GREAT STUFF");
		home.interact(squad);
		assertEquals(home.showMap(squad), city.toString());
		
		squad.setHaveMap(false);
		assertEquals(home.showMap(squad), "No map available at this stage");
		
	}

	
	@AfterEach
	void afterEach() {
		home = null;
		lorenzo = null;
		jay = null;
		squad = null;
		city = null;
		
		System.setOut(System.out);
		System.setIn(System.in);
	}

}
