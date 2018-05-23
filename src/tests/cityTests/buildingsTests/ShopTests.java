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
import city.buildings.shop.NamesForInnkeeper;
import city.buildings.shop.Shop;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.Money;
import collectables.healingItem.HealingItem;
import collectables.heroesMap.HeroesMap;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;
import engine.Engine;
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
	
	/**
	 * 
	 * This method accepts only indices between 0 and 6 included.
	 * This is an enforced limit from the GUI (number of elements in the list is always 7)
	 * 
	 */
	
	@Test 
	void testRetrieveRightCollectable() {
		Collectable collectable1 = shop.retrieveRightCollectable(0);
		assertEquals(collectable1.getCollectableID(), CollectableID.Armor);
		
		Collectable collectable2 = shop.retrieveRightCollectable(1);
		assertEquals(collectable2.getCollectableID(), CollectableID.IncreaseMaxLife);
		
		Collectable collectable3 = shop.retrieveRightCollectable(2);
		assertEquals(collectable3.getCollectableID(), CollectableID.GameChooser);
		
		Collectable collectable4 = shop.retrieveRightCollectable(3);
		assertEquals(collectable4.getCollectableID(), CollectableID.HeroesMap);
		
		Collectable collectable5 = shop.retrieveRightCollectable(4);
		assertEquals(collectable5.getCollectableID(), CollectableID.GoodHealingItem);
		
		Collectable collectable6 = shop.retrieveRightCollectable(5);
		assertEquals(collectable6.getCollectableID(), CollectableID.BetterHealingItem);
		
		Collectable collectable7 = shop.retrieveRightCollectable(6);
		assertEquals(collectable7.getCollectableID(), CollectableID.BestHealingItem);
		
	}
	
	@Test
	void testSuccessOrRejectionPurchasedItem() {
		
		
		String string1 = shop.successOrRejectionPurchasedItem(3, squad);
		assertEquals("Great! You bought a " + CollectableID.HeroesMap, string1);
		assertEquals(squad.getWallet().getAmount(), 9999980);
		assertTrue(squad.isHaveMap());
		
		String string2 = shop.successOrRejectionPurchasedItem(3, squad);
		assertEquals("Sorry guys we have no HeroesMap", string2);
		assertEquals(squad.getWallet().getAmount(), 9999980);
		
		squad.setWallet(new Money(0));
		shop.getMerchandise().setInventory(new Inventory());
		shop.getMerchandise().getInventory().addItemToInventory(new GameChooser(CollectableID.GameChooser));
		
		String string3 = shop.successOrRejectionPurchasedItem(2, squad);
		String strToReturn = new String();
		strToReturn += ("\nSorry not enough money to purchase this item");
		strToReturn += ("\nYou currently have 0");
		strToReturn += ("\nYou need 90"  
		+ " to purchase a " + CollectableID.GameChooser + " item");
		assertEquals(string3, strToReturn);
	}
	
	@Test
	void testNameOfInnKeeperSettersAndGetters() {
		NamesForInnkeeper nameForInnkeeper = shop.getNameOfInnkeeper();
		boolean inThePoolOfChoices = false;
		for (int i=0; i < NamesForInnkeeper.values().length; i++) {
			if (nameForInnkeeper.equals(NamesForInnkeeper.values()[i])) {
				inThePoolOfChoices = true;
			}	
		}
		assertTrue(inThePoolOfChoices);
		
		shop.setNameOfInnkeeper(NamesForInnkeeper.Vladimiro);
		assertEquals(shop.getNameOfInnkeeper(), NamesForInnkeeper.Vladimiro);
	}

}
