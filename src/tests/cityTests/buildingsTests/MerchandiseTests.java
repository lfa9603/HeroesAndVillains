package tests.cityTests.buildingsTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import city.buildings.shop.Merchandise;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.healingItem.HealingItem;
import collectables.heroesMap.HeroesMap;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;

class MerchandiseTests {
	private Merchandise shop;
	//Create an instance for HealingItems
	private HealingItem goodHealingItem;
	private HealingItem betterHealingItem;
	private HealingItem bestHealingItem;
	
	//Create an instance of PowerUps
	private Armor armor;
	private IncreaseMaxLife increaseMaxLife;
	private GameChooser gameChooser;
	private HeroesMap map;
	

	@BeforeEach
	void setUp() {
		shop = new Merchandise();
		//Create an instance for HealingItems
		goodHealingItem = new HealingItem(CollectableID.GoodHealingItem);
		betterHealingItem = new HealingItem(CollectableID.BetterHealingItem);
		bestHealingItem = new HealingItem(CollectableID.BestHealingItem);
		
		//Create an instance of PowerUps
		armor = new Armor(CollectableID.Armor);
		increaseMaxLife = new IncreaseMaxLife(CollectableID.IncreaseMaxLife);
		gameChooser = new GameChooser(CollectableID.GameChooser);
		
		map = new HeroesMap(CollectableID.HeroesMap);
		
		Inventory emptyInventory = new Inventory();
		
		Inventory shopInventory = shop.getInventory();
		shopInventory.setInventory(emptyInventory.getInventory());
		
		shopInventory.addItemToInventory(goodHealingItem);
		shopInventory.addItemToInventory(betterHealingItem);
		shopInventory.addItemToInventory(bestHealingItem);
		shopInventory.addItemToInventory(armor);
		shopInventory.addItemToInventory(increaseMaxLife);
		shopInventory.addItemToInventory(gameChooser);
		shopInventory.addItemToInventory(map);
		shop.setInventory(shopInventory);
		
		
	}

	@AfterEach
	void tearDown() {
		shop = null;
	}

	
	@Test
	void testGetInventory() {
		
		assertTrue(shop.getInventory().getInventory().size() >= 7);
		assertEquals(goodHealingItem, shop.getInventory().isInInventory(goodHealingItem));
		assertEquals(map, shop.getInventory().isInInventory(map));
		
		HealingItem expected = goodHealingItem;
		Collectable actual = shop.getInventory().isInInventory(goodHealingItem);
		System.out.println(shop.getInventory());
		assertEquals(expected, actual); 
	}


}
