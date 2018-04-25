package tests.charactersTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import city.City;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.healingItem.HealingItem;
import collectables.heroesMap.HeroesMap;

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
//		assertEquals(3, heroes.getHeroSquad().size());
		for (Hero hero : heroes.getHeroSquad()) {
			System.out.println(hero.getCharacterName());
		}
		assertTrue(heroes.squadContains(hero1));
		assertTrue(heroes.squadContains(hero2));
		assertTrue(heroes.squadContains(hero3));
	}
	
	@Test
	void squadResetTest() {
		heroes.squadReset();
		assertEquals(heroes.getHeroSquad().size(), 0);
	}
	
	@Test
	void getterAndSetterForTeamName() {
		heroes.setTeamName("CiaoBellaDonna");
		assertEquals("CiaoBellaDonna", heroes.getTeamName());
	}
	
	@Test
	void setterAndGetterHaveMap() {
		
		assertFalse(heroes.isHaveMap());
		assertNull(heroes.getCurrentCity());
		
		heroes.setCurrentCity(new City());
		heroes.setHaveMap(true);
		
		assertTrue(heroes.isHaveMap());
		assertNotNull(heroes.getCurrentCity());
		
		
	}
	
	@Test
	void getHeroTest() {
		assertEquals("hero1", heroes.getHero(0).getCharacterName());
		assertEquals("hero2", heroes.getHero(1).getCharacterName());
		assertEquals("hero3", heroes.getHero(2).getCharacterName());
	}
	
	@Test
	void getLengthTest() {
		assertEquals(heroes.getLength(), 3);
	}
	
	@Test
	void getterAndSetterHeroesMap() {
		HeroesMap map = new HeroesMap(CollectableID.HeroesMap);
		heroes.setHeroesMap(map);
		assertEquals(map, heroes.getHeroesMap());
	}
	
	@Test
	void getBackpackTest() {
		assertTrue(heroes.getBackPack().getInventory().isEmpty());
		
		heroes.getBackPack().addItemToInventory(new HealingItem(CollectableID.GoodHealingItem));
		assertEquals(heroes.getBackPack().getInventory().size(), 1);
		

	}

	@AfterEach
	void afterEach() {
		heroes = null;
		hero1 = null;
		hero2 = null;
		hero3 = null;
	}
}
