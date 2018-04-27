package tests.charactersTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

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
import collectables.Money;
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
	
	/**
	 * Test for getHero(int index) method.
	 */
	@Test
	void getHeroTest() {
		assertEquals("hero1", heroes.getHero(0).getCharacterName());
		assertEquals("hero2", heroes.getHero(1).getCharacterName());
		assertEquals("hero3", heroes.getHero(2).getCharacterName());
	}
	
	/**
	 * Test for getLength() method.
	 */
	@Test
	void getLengthTest() {
		assertEquals(heroes.getLength(), 3);
	}
	
	/**
	 * Test for getter and setter for heroesMap property.
	 */
	@Test
	void getterAndSetterHeroesMap() {
		HeroesMap map = new HeroesMap(CollectableID.HeroesMap);
		heroes.setHeroesMap(map);
		assertEquals(map, heroes.getHeroesMap());
	}
	
	/**
	 * Test for getter and setter method of backPack property.
	 */
	@Test
	void getterAndSetterBackpackTest() {
		assertTrue(heroes.getBackPack().getInventory().isEmpty());
		
		heroes.getBackPack().addItemToInventory(new HealingItem(CollectableID.GoodHealingItem));
		assertEquals(heroes.getBackPack().getInventory().size(), 1);
		
		Inventory backpack = new Inventory();
		heroes.setBackPack(backpack);
		assertEquals(backpack, heroes.getBackPack());
		
	}
	
	/**
	 * Test for getter and setter for wallet property.
	 */
	@Test
	void getterAndsetterWalletTest() {
		Money moneyInWallet = new Money(90);
		heroes.setWallet(moneyInWallet);
		
		assertEquals(heroes.getWallet(), moneyInWallet);
	}
	
	/**
	 * Test for setter and getter method for currentPosition property.
	 */
	@Test
	void setterAndGetterCurrentPositionTest() {
		assertNull(heroes.getCurrentPosition());
		Point currentPosition = new Point(0, 0);
		
		heroes.setCurrentPosition(currentPosition);
		assertEquals(currentPosition, heroes.getCurrentPosition());
		
	}
	
	/**
	 * Test for heroStatus(Hero hero) method
	 */
	@Test
	void herosStatusTest() {
		hero1.setIsinDetention(true);
		assertEquals("In Detention", heroes.heroStatus(hero1));
		
		hero1.setIsinDetention(false);
		hero1.setisAlive(true);
		assertEquals("Alive", heroes.heroStatus(hero1));
		
		hero1.setisAlive(false);
		assertEquals("Dead", heroes.heroStatus(hero1));
	}
	
	/**
	 * Test for isAllDead() method and its setter method.
	 */
	@Test
	void isAllDeadAndSetterForIsAllDeadTest() {
		heroes.setAllDead(true);
		assertTrue(heroes.isAllDead());
	}
	
	/**
	 * Test for checkTeamStatus() method.
	 */
	@Test
	void checKTeamStatusTest() {
		
		assertFalse(heroes.isAllDead());
		
		hero1.setisAlive(false);
		hero2.setisAlive(false);
		hero3.setisAlive(false);
		heroes.checkTeamStatus();
		
		assertTrue(heroes.isAllDead());
	}
	
	/**
	 * Test for heroTakesDamage(Hero hero, Villain villain) method
	 */
	@Test
	void heroTakesDamageTest() {
		hero1.setHealth(100);
		hero1.setArmor(40);
		heroes.heroTakesDamage(hero1,  30);
		assertFalse(!hero1.isAlive());

		
		assertEquals(hero1.getHealth(), 100);
		assertEquals(hero1.getArmor(), 10);
		assertFalse(!hero1.isAlive());

		hero1.setisAlive(true);
		hero1.setArmor(20);
		heroes.heroTakesDamage(hero1,  30);
		assertEquals(hero1.getHealth(), 90);
		assertEquals(hero1.getArmor(), 0);
		assertFalse(!hero1.isAlive());

		hero1.setisAlive(true);
		hero1.setArmor(20);
		hero1.setHealth(10);
		heroes.heroTakesDamage(hero1,  30);
		assertEquals(hero1.getHealth(), 0);
		assertEquals(hero1.getArmor(), 0);
		assertFalse(hero1.isAlive());

		hero1.setisAlive(true);
		hero1.setArmor(20);
		hero1.setHealth(10);
		heroes.heroTakesDamage(hero1,  35);
		assertEquals(hero1.getHealth(), 0);
		assertEquals(hero1.getArmor(), 0);
		assertFalse(hero1.isAlive());

		hero1.setisAlive(true);
		hero1.setArmor(0);
		hero1.setHealth(40);
		heroes.heroTakesDamage(hero1,  30);
		assertEquals(hero1.getHealth(), 10);
		assertEquals(hero1.getArmor(), 0);
		assertFalse(!hero1.isAlive());

		hero1.setisAlive(true);
		hero1.setArmor(0);
		hero1.setHealth(30);
		heroes.heroTakesDamage(hero1,  30);
		assertEquals(hero1.getHealth(), 0);
		assertEquals(hero1.getArmor(), 0);
		assertFalse(hero1.isAlive());
	}
	
	//TODO: implement the tests for toString() when toString() will be good to go.
	
	

	
	@AfterEach
	void afterEach() {
		heroes = null;
		hero1 = null;
		hero2 = null;
		hero3 = null;
	}
}
