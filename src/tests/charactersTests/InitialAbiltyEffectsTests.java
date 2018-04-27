package tests.charactersTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.InitialAbiltyEffects;
import characters.Types;

class InitialAbiltyEffectsTests {

	private ArrayList<Abilities> abilities;
	private Hero hero;
	private HeroesSquad squad;
	
	@BeforeEach
	void beforeEach() {
		
		abilities = new ArrayList<Abilities>();
		abilities.add(Abilities.charm);
		abilities.add(Abilities.mystery);
		abilities.add(Abilities.betterOdds);
		abilities.add(Abilities.lessDamage);
		abilities.add(Abilities.winDraws);
		abilities.add(Abilities.goodBoy);
		abilities.add(Abilities.detention);
		
		hero = new Hero("Lorenzo",Types.dog, Abilities.goodBoy);
		squad = new HeroesSquad();
		squad.addHero(hero);
	}
	
	
	@AfterEach
	void afterEach() {
		
		abilities = null;
		hero = null;
		squad = null;
		
	}
	
	/**
	 * Test for getAbilitiesEffect static method.
	 */
	@Test
	void getAbilitiesEffectTest() {
		
		for (Abilities ability : abilities) {
			InitialAbiltyEffects.getAbiltiesEffects(ability, squad.getHeroSquad(), hero);
//			EXPECTED OUTCOME IN CONSOLE:
//			Lorenzo's abilty has been applied, shop prices will be 30% cheaper.
//			Lorenzo's abilty has no effect at the start of the game
//			Lorenzo's abilty has no effect at the start of the game
//			Lorenzo's abilty has no effect at the start of the game
//			Lorenzo's abilty has no effect at the start of the game
//			Lorenzo's goodboy abilty has been applied, all teammates have an extra 25HP.
//			Lorenzo's abilty has no effect at the start of the game
		}
		assertEquals(hero.getHealth(), 125);
	}

	/**
	 * Test for applyHeroSquadAbilitites static method.
	 */
	@Test
	void applyHeroSquadAbilititesTest() {
		InitialAbiltyEffects.applyHeroSquadAbilties(squad.getHeroSquad());
		assertEquals(hero.getHealth(), 125);
	}
}
