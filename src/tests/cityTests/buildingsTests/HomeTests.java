package tests.cityTests.buildingsTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import city.City;
import city.buildings.Home;
import collectables.Money;

class HomeTests {

	private Home home;
	private Hero lorenzo;
	private Hero jay;
	private HeroesSquad squad;
	private City city;
	
	
	@BeforeEach
	void beforeAll() {
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
	
	//TODO: find a good way to test this method.
	@Test
	void testingInteract() {
		///
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
		///
		System.out.println("FOR NEXT TEST TYPE ANY LETTER, A NON ZERO OR 1 NUMBER AND FINALLY 0 AND 1, IF DOES NOT GO INTO INFINITE LOOP, GREAT STUFF");
		home.interact(squad);
		assertEquals(home.showMap(squad), city.toString());
		
		squad.setHaveMap(false);
		assertEquals(home.showMap(squad), "No map available at this stage");
	}
	

}
