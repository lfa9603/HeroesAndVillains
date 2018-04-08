package collectables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import collectables.healingItem.HealingItem;
import collectables.powerUp.Armor;

public class Inventory {

	private HashMap<Collectable, Integer> inventory;
	
	
	public Inventory() {
		inventory = new HashMap<Collectable, Integer>();
	}

	
	/**
	 * Takes a @Collectable object and checks if the @inventory already has the same type of item in it. 
	 * This is achieved by comparing the CollectableID of the 2 objects.
	 * @param item
	 * @return
	 */
	public Collectable isInInventory(Collectable item) {
		Iterator<Entry<Collectable, Integer>> iterator = inventory.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Collectable, Integer> collectable = (Entry<Collectable, Integer>) iterator.next();
			if ((collectable.getKey().getCollectableID()).equals(item.getCollectableID())) {
				return collectable.getKey();
			}
		}
		return null;
	}
	
	
	/**
	 * This method checks if the item we are trying to store is already present in the @inventory and 
	 * if it is it increases the value of the already present key, if not present it add the @Collectable object 
	 * to the @inventory and it assigns it a value of 1.
	 * @param item
	 */
	public void addItemToInventory(Collectable item) {
		
		Collectable collectable = isInInventory(item);
		
		if (collectable != null) {
			inventory.put(collectable, inventory.get(collectable) + 1);
		} else {
			inventory.put((Collectable) item, 1);
		}
	}
	
	
	public String toString() {
		String string = new String();
		Iterator<Entry<Collectable, Integer>> iterator = inventory.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Collectable, Integer> collectable = (Entry<Collectable, Integer>) iterator.next();
			string += collectable.getKey();
			string += "\nAMOUNT AVAILABLE:   " + collectable.getValue() + "\n\n";
		}
		return string;
	}
		
	
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		inventory.addItemToInventory(new HealingItem(CollectableID.GoodHealingItem));
//		System.out.println(inventory);
		inventory.addItemToInventory(new HealingItem(CollectableID.GoodHealingItem));
//		System.out.println(inventory);
		inventory.addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
//		System.out.println(inventory);
		inventory.addItemToInventory(new Armor(CollectableID.Armor));
		System.out.println(inventory);
	}
	
	
	
	///GETTERS AND SETTERS METHODS
	
	/**
	 * @return the inventory
	 */
	public HashMap<Collectable, Integer> getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(HashMap<Collectable, Integer> inventory) {
		this.inventory = inventory;
	}
	
	
	

}
