package collectables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.core.IsInstanceOf;

import collectables.healingItem.HealingItem;
import collectables.powerUp.PowerUp;


public class Inventory implements java.io.Serializable {

	
	private static final long serialVersionUID = 345758306441672294L;
	private HashMap<Collectable, Integer> inventory;
	
	
	public Inventory() {
		inventory = new HashMap<Collectable, Integer>();
	}

	
	/**
	 * 
	 * Takes a @Collectable object and checks if the @inventory already has the same type of item in it. 
	 * This is achieved by comparing the CollectableID of the @param item and of each Collectable item in the inventory property.
	 * @param item
	 * @return the Collectable object if the item is in the inventory property or @null if the item is not in it.
	 * 
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
	 * 
	 * This method checks if the item we are trying to store is already present in the @inventory and 
	 * if it is it increases the value of the already present key, if not present it add the @Collectable object 
	 * to the @inventory and it assigns it a value of 1.
	 * 
	 * @param item (type Collectable)
	 * 
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
    
    
    public String showPowerUpsInInventory() {
    	
    	String powerUpsAndQuantities = new String();
    	
    	Iterator<Entry<Collectable, Integer>> iterator = inventory.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Collectable, Integer> collectable = (Entry<Collectable, Integer>) iterator.next();
			if (CollectableID.isPowerUp(collectable.getKey().getCollectableID())) {
				powerUpsAndQuantities += collectable.getKey() + "\nQUANTITY: " + collectable.getValue().toString() + "\n\n";
			}
		}
		
		if (powerUpsAndQuantities.length() == 0) {
			powerUpsAndQuantities = "Looks like you have no power-ups\n";
		}
		
		return powerUpsAndQuantities;
    }
    
    public String showHealingItemsInInventory() {
    	
    	String healingItemsAndQuantities = new String();
    	
    	Iterator<Entry<Collectable, Integer>> iterator = inventory.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Collectable, Integer> collectable = (Entry<Collectable, Integer>) iterator.next();
			if (CollectableID.isHealingItem(collectable.getKey().getCollectableID())) {
				healingItemsAndQuantities += collectable.getKey() + "\nQUANTITY: " + collectable.getValue().toString() + "\n\n";
			}
		}
		
		if (healingItemsAndQuantities.length() == 0) {
			healingItemsAndQuantities = "Looks like you have no healing item\n";
		}
		
		return healingItemsAndQuantities;
    }
    
	public String showMapItemInInventory() {
		String mapItemToString = new String();
	
		Iterator<Entry<Collectable, Integer>> iterator = inventory.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Collectable, Integer> collectable = (Entry<Collectable, Integer>) iterator.next();
			if (collectable.getKey().getCollectableID().equals(CollectableID.HeroesMap)) {
				mapItemToString += collectable.getKey() + "\nQUANTITY: " + collectable.getValue();
			}
		}
		
		if (mapItemToString.length() == 0) {
			mapItemToString = "Looks like you have no map item";
		}
		
		return mapItemToString;
	}
    
    /**
     * Overridden to string method.
     * It returns a String object containing each element present in the inventory \\
     * property and its quantity (each HashMap entry key and value).
     */
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
		
	
//	public static void main(String[] args) {
//		Inventory inventory = new Inventory();
//		inventory.addItemToInventory(new HealingItem(CollectableID.GoodHealingItem));
////		System.out.println(inventory);
////		System.out.println("-------------------------------------------");
//		inventory.addItemToInventory(new HealingItem(CollectableID.BetterHealingItem));
////		System.out.println(inventory);
////		System.out.println("-------------------------------------------");
//		inventory.addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
////		System.out.println(inventory);
////		System.out.println("-------------------------------------------");
//		inventory.addItemToInventory(new Armor(CollectableID.Armor));
//		inventory.addItemToInventory(new GameChooser(CollectableID.GameChooser));
//		inventory.addItemToInventory(new IncreaseMaxLife(CollectableID.IncreaseMaxLife));
//		inventory.addItemToInventory(new HeroesMap(CollectableID.HeroesMap));
//		
//		System.out.println(inventory);
		
		
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
//		
//		
//	}
//	
	
	
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
