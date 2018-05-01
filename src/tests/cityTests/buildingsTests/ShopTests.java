package tests.cityTests.buildingsTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.HeroesSquad;
import city.buildings.TypeBuildings;
import city.buildings.shop.Merchandise;
import city.buildings.shop.Shop;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.Money;
import collectables.healingItem.HealingItem;
import collectables.heroesMap.HeroesMap;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;
import engine.HelperScanner;

class ShopTests {

	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	
	private Shop shop;
	//Create an instance for HealingItems
	private HealingItem goodHealingItem;
	private HealingItem betterHealingItem;
	private HealingItem bestHealingItem;
	
	//Create an instance of PowerUps
	private Armor armor;
	private IncreaseMaxLife increaseMaxLife;
	private GameChooser gameChooser;
	private HeroesMap map;
	
	private HeroesSquad squad;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		shop = new Shop("GreatShop", TypeBuildings.Shop);
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
		
		Inventory shopInventory = shop.getMerchandise().getInventory();
		shopInventory.setInventory(emptyInventory.getInventory());
		
		shopInventory.addItemToInventory(goodHealingItem);
		shopInventory.addItemToInventory(betterHealingItem);
		shopInventory.addItemToInventory(bestHealingItem);
		shopInventory.addItemToInventory(armor);
		shopInventory.addItemToInventory(increaseMaxLife);
		shopInventory.addItemToInventory(gameChooser);
		shopInventory.addItemToInventory(map);
		shop.getMerchandise().setInventory(shopInventory);
		
		squad = new HeroesSquad();
		squad.setWallet(new Money(10000000));
	}
	
	private void setInputStream(String input) {
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
	}
	
	@AfterEach
	void afterEach() {
		System.setOut(System.out);
		System.setIn(System.in);
	}


	@Test
	void testInteract() {
		setInputStream(""
				//random in main menu
				+ "dfgdf\n"
				+ "4654"
				//in map
				+ "0\n"
				+ "dfgdf\n"
				+ "4654"
				//exiting map
				+ "n\n"
				//re-entering and purchasing
				+ "0\n"
				+ "y\n"
				//trying to re purchase map
				+ "0\n"
				+ "y\n"
				+ "n\n"
				//in healing purchasing each item and mocking around
				+ "1\n"
				+ "0\n"
				+ "1\n"
				+ "2\n"
				+ "jslk\n"
				+ "345\n"
				+ "3\n"
				//in power ups purchasing each item and mocking around
				+ "2\n"
				+ "0\n"
				+ "1\n"
				+ "2\n"
				+ "jslk\n"
				+ "345\n"
				//trying to repurchase a good even though they don't have it
//				+ "2\n"
				+ "3\n"
				//exiting the main menu and terminating
				+ "3");
		HelperScanner.create();
		
		shop.interact(squad);
		
		assertEquals(squad.getBackPack().getInventory().size(), 6);
		assertTrue(squad.isHaveMap());
		
		int sizeBackpackBeforeTryingToBuy = squad.getBackPack().getInventory().size();
		
		shop.getMerchandise().getInventory().addItemToInventory(new HealingItem(CollectableID.GoodHealingItem));
		squad.setWallet(new Money(0));
		
		setInputStream("1\n"
				+ "0\n"
				+ "3\n"
				+ "3\n");
		HelperScanner.create();
		shop.interact(squad);
		
		int sizeBackpackAfterTryingToBuy = squad.getBackPack().getInventory().size();
		
		assertEquals(sizeBackpackBeforeTryingToBuy, sizeBackpackAfterTryingToBuy);
		
		shop.getMerchandise().setInventory(new Inventory());
		setInputStream("1\n"
				+ "0\n"
				+ "3\n"
				+ "3\n");
		HelperScanner.create();
		
		shop.interact(squad);
		assertEquals(sizeBackpackBeforeTryingToBuy, sizeBackpackAfterTryingToBuy);
		
	}
	

	@Test
	void testShop() {
		assertEquals(shop.getBuildingName(), "GreatShop");
		assertEquals(shop.getBuildingType(), TypeBuildings.Shop);
		assertTrue(shop.getMerchandise().getInventory().getInventory().size() >= 1);
		
	}

	@Test
	void testSetMerchandise() {
		Merchandise newMerchandise = new Merchandise();
		Inventory emptyInventory = new Inventory();
		newMerchandise.setInventory(emptyInventory);
		shop.setMerchandise(newMerchandise);
		assertTrue(shop.getMerchandise().getInventory().getInventory().size() == 0);
	}

}
