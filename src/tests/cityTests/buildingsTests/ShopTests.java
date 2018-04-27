package tests.cityTests.buildingsTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import city.buildings.TypeBuildings;
import city.buildings.shop.Shop;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.healingItem.HealingItem;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;

class ShopTests {
	private Shop shop;
	//Create an instance for HealingItems
	private HealingItem goodHealingItem;
	private HealingItem betterHealingItem;
	private HealingItem bestHealingItem;
	
	//Create an instance of PowerUps
	private Armor armor;
	private IncreaseMaxLife increaseMaxLife;
	private GameChooser gameChooser;


	@BeforeEach
	void setUp() {
		shop = new Shop("shopTest" , TypeBuildings.Shop);
		//Create an instance for HealingItems
		goodHealingItem = new HealingItem(CollectableID.GoodHealingItem);
		betterHealingItem = new HealingItem(CollectableID.BetterHealingItem);
		bestHealingItem = new HealingItem(CollectableID.BestHealingItem);
		
		//Create an instance of PowerUps
		armor = new Armor(CollectableID.Armor);
		increaseMaxLife = new IncreaseMaxLife(CollectableID.IncreaseMaxLife);
		gameChooser = new GameChooser(CollectableID.GameChooser);
	}

	@AfterEach
	void tearDown() {
		shop = null;
	}

	@Test
	void testInteract() {
		fail("Not yet implemented");
	}

	@Test
	void testShop() {
//		Shop shop2 = new Shop("shopTest2" , TypeBuildings.Shop);
		assertEquals("shopTest", shop.getBuildingName());
		assertEquals(TypeBuildings.Shop, shop.getBuildingType());
		HealingItem expected = goodHealingItem;
		Collectable actual = shop.getMerchandise().getInventory().isInInventory(goodHealingItem);
		assertEquals(expected, actual); 
	}

	@Test
	void testGetMerchandise() {
		fail("Not yet implemented");
	}

	@Test
	void testSetMerchandise() {
		fail("Not yet implemented");
	}

}
