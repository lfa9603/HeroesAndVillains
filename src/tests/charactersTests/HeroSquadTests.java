package tests.charactersTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import junit.framework.TestSuite;

class HeroSquadTests {

	private HeroesSquad heroes;
	private Hero hero1;
	private Hero hero2; 
	private Hero hero3;
	
	@BeforeEach
	void addHeroesElementsToHeroesSquadElement() {
		hero1 = new Hero("hero1", Types.dog, Abilities.betterOdds);
		hero2 = new Hero("hero2", Types.dog, Abilities.betterOdds);
		hero3 = new Hero("hero3", Types.dog, Abilities.betterOdds);
		heroes = new HeroesSquad();
		heroes.addHero(hero1);
		heroes.addHero(hero1);
		heroes.addHero(hero2);
		heroes.addHero(hero3);
	}

	@Test
	void AddHeroAndCheckingNotAddingTheSameTwice() {
		assertEquals(3, heroes.getHeroSquad().size());
		
		assertTrue(heroes.squadContains(hero1));
		assertTrue(heroes.squadContains(hero2));
		assertTrue(heroes.squadContains(hero3));
	}

}
