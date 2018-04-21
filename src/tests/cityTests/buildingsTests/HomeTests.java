package tests.cityTests.buildingsTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import city.buildings.Home;
import city.buildings.TypeBuildings;
import collectables.Money;

class HomeTests {

	private static Home home;
	private static Hero lorenzo;
	private static Hero jay;
	private static HeroesSquad squad;
	
	
	@BeforeAll
	public static void beforeAll() {
		home = new Home("HomeBase",TypeBuildings.Home);
		
		lorenzo = new Hero("Lorenzo", Types.smart, Abilities.betterOdds);
		jay = new Hero("Jay", Types.talkitive, Abilities.betterOdds);
		
		squad = new HeroesSquad();
		squad.addHero(lorenzo);
		squad.addHero(jay);
		
		squad.setWallet(new Money(1000));
		
		squad.setHaveMap(true);
	}
	
	//TODO: find a good way to test this method.
	@Test
	void testingInteract() {
		home.interact(squad);
		
	}
	

}
