package tests.collectableTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import collectables.Collectable;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.healingItem.HealingItem;
import collectables.powerUp.Armor;

class testInventory {

	private Inventory inventory;
	
	@BeforeEach
	void beforeEach() {
		inventory = new Inventory();
	}
	
	
	@Test
	void testAddItemToInventory() {
		
		inventory.addItemToInventory(new HealingItem(CollectableID.GoodHealingItem));
		assertEquals(1, (inventory.getInventory()).size());

		inventory.addItemToInventory(new HealingItem(CollectableID.GoodHealingItem));
		assertEquals(1, inventory.getInventory().size());
		
		inventory.addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
		assertEquals(2, inventory.getInventory().size());
		
	}
	
	@Test
	void testRemoveItemFromInventory() {
		/////////
		inventory.addItemToInventory(new HealingItem(CollectableID.GoodHealingItem));
		assertEquals(1, (inventory.getInventory()).size());

		inventory.addItemToInventory(new HealingItem(CollectableID.GoodHealingItem));
		assertEquals(1, inventory.getInventory().size());
		
		inventory.addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
		assertEquals(2, inventory.getInventory().size());
		/////////
		
		inventory.removeItemFromInventory(new HealingItem(CollectableID.GoodHealingItem));
		assertEquals(2, inventory.getInventory().size());
		assertNotNull(inventory.isInInventory(new HealingItem(CollectableID.GoodHealingItem)));

		
		inventory.removeItemFromInventory(new HealingItem(CollectableID.GoodHealingItem));
		assertEquals(1, inventory.getInventory().size());
		
		inventory.removeItemFromInventory(new HealingItem(CollectableID.BestHealingItem));
		assertEquals(0, inventory.getInventory().size());
		assertNull(inventory.isInInventory(new HealingItem(CollectableID.BestHealingItem)));
		
		inventory.removeItemFromInventory(new HealingItem(CollectableID.BestHealingItem));
		inventory.removeItemFromInventory(new Armor(CollectableID.Armor));
		assertEquals(0, inventory.getInventory().size());
	}
	
	
	@Test
	void testToString() {
		inventory.setInventory(new HashMap<Collectable, Integer>());
		assertEquals(inventory.getInventory().size(), 0);
		
		assertEquals(inventory.toString().length(), 0);
		
		HealingItem goodHealingItem = new HealingItem(CollectableID.GoodHealingItem);
		
		inventory.addItemToInventory(goodHealingItem);
		String expectingFromToString = goodHealingItem.toString() + "\nAMOUNT AVAILABLE:   " + inventory.getInventory().get(goodHealingItem) + "\n\n";
		
		assertEquals(inventory.toString(), expectingFromToString);
		
	}

	@Test
	void testInventorySetterAndGetter() {
		
		inventory.setInventory(new HashMap<Collectable, Integer>());
		assertEquals(inventory.getInventory().size(), 0);
			
	}
	
	@AfterEach
	void afterEach() {
		inventory = null;
	}
	
}
