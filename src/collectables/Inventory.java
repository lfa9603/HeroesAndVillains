package collectables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import collectables.healingItem.HealingItem;
import collectables.heroesMap.HeroesMap;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;

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
	
	/**
	 * This method removes an item from @inventory, if the element is in @inventory then it eliminates one quantity of it, if after that 
	 * the quantity of the element is 0 in the inventory, then the @Collectable element is eliminated from @inventory.
	 * If @Collectable not present in inventory, then it informs the user that he/she is trying to eliminate an object that is not there.
	 * @param item
	 */
    public void removeItemFromInventory(Collectable item) {
		
		Collectable collectable = isInInventory(item);
		
		if (collectable != null) {
			inventory.put(collectable, inventory.get(collectable) - 1);
			if (inventory.get(collectable) == 0) {
				inventory.remove(collectable);
			}
		} else {
			System.out.println("The item is already NOT in the inventory");
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
//		System.out.println("-------------------------------------------");
		inventory.addItemToInventory(new HealingItem(CollectableID.BetterHealingItem));
//		System.out.println(inventory);
//		System.out.println("-------------------------------------------");
		inventory.addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
//		System.out.println(inventory);
//		System.out.println("-------------------------------------------");
		inventory.addItemToInventory(new Armor(CollectableID.Armor));
		inventory.addItemToInventory(new GameChooser(CollectableID.GameChooser));
		inventory.addItemToInventory(new IncreaseMaxLife(CollectableID.IncreaseMaxLife));
		inventory.addItemToInventory(new HeroesMap(CollectableID.HeroesMap));
		
		System.out.println(inventory);
		
		
//		System.out.println(inventory);
//		System.out.println("-------------------------------------------");
//		inventory.removeItemFromInventory(new HealingItem(CollectableID.GoodHealingItem));
//		System.out.println(inventory);
//		System.out.println("-------------------------------------------");
//		inventory.removeItemFromInventory(new HealingItem(CollectableID.GoodHealingItem));
//		System.out.println(inventory);
//		System.out.println("-------------------------------------------");
//		inventory.removeItemFromInventory(new HealingItem(CollectableID.GoodHealingItem));
//		System.out.println(inventory);
//		System.out.println("-------------------------------------------");
		
		
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
