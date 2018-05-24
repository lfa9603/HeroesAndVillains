package collectables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import characters.HeroesSquad;
import collectables.healingItem.HealingItem;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;


/**
 * 
 * This class is created to provide Inventory class methods with helper methods.
 * This class contains only static methods, the most of them deal with handling ArrayList objects 
 * and/or comparing items in HashMap and ArrayList objects or they deal with printing to 
 * console/showing in the GUI the content of a particular HashMap or ArrayList. 
 * 
 */
public class InventoryTools {

	public  InventoryTools() {
	}
	
	/**
	 * 
	 * @param heroesSquad
	 * @return a ArrayList object containing one instance for each HealingItem (GoodHealingItem, BetterHealingItem and BestHealingItem)
	 */
	public static ArrayList<Collectable> healingItems() {
		
		ArrayList<Collectable> healingItems = new ArrayList<Collectable>();
		HealingItem goodPotion = new HealingItem(CollectableID.GoodHealingItem);
		HealingItem betterPotion = new HealingItem(CollectableID.BetterHealingItem);
		HealingItem bestPotion = new HealingItem(CollectableID.BestHealingItem);
		healingItems.add(goodPotion);
		healingItems.add(betterPotion);
		healingItems.add(bestPotion);
		return healingItems;
		
	}

	
	
	/**
	 * 
	 * @param heroesSquad ()
	 * @return a ArrayList object containing one instance for each PowerUp (Armor, GameChooser, IncreaseMaxLife, HeroesMap)
	 */
	public static ArrayList<Collectable> powerUps() {
		
		ArrayList<Collectable> powerUps = new ArrayList<Collectable>();
		Armor armor = new Armor(CollectableID.Armor);
		GameChooser gameChooser = new GameChooser(CollectableID.GameChooser);
		IncreaseMaxLife increaseMaxLife = new IncreaseMaxLife(CollectableID.IncreaseMaxLife);
		powerUps.add(armor);
		powerUps.add(gameChooser);
		powerUps.add(increaseMaxLife);
		return powerUps;
		
	}
	
	
	/**
	 * 
	 * @param heroesSquad (type HeroesSquad)
	 * @param collectables (type ArrayLis<Collectable>)
	 * @return a String object containing each element present in @param collectables 
	 * and its quantity in the HeroesSquad object backpack (type Inventory).
	 * 
	 */
	public static String showTypeItemsInInventory(HeroesSquad heroesSquad, ArrayList<Collectable> collectables) {
		String string = new String();
		for (Collectable collectable : collectables) {
			string += "------>  " + collectable.getCollectableID() + "  <------\n";
			string += "DESCRIPTION: " + collectable + "\n";
			string += "QUANTITY: " + getQuantityItem(collectable, heroesSquad).toString() + "\n";
		}
		return string;
	}
	
	
	/**
	 * 
	 * @param heroes (type HeroesSquad)
	 * @param collectables (type ArrayList<Collectable>)
	 * @return the total quantity of the items in @param collectables present in the HeroesSquad object backpack (type Inventory).
	 * Uses the helper function getQuantityItem(...) to do so.
	 * 
	 */
	public static Integer getTotTypeItems(HeroesSquad heroes, ArrayList<Collectable> collectables) {
		Integer total = 0;
		for (Collectable item : collectables) {
			total += getQuantityItem(item, heroes);
		}
		return total;
	}
	
	
	/**
	 * 
	 * @param collect (type Collectable)
	 * @param heroesSquad (type HeroesSquad)
	 * @return the quantity (type Integer) of items corresponding to @param collect in the HeroesSquad object backpack (type Inventory).
	 * This is achieved by iterating through the HeroesSquad backpack and checking if the collectableID property of @param collect 
	 * is equal to the collectableID of any of the items in the HeroesSquad backpack. 
	 * 
	 */
	public static Integer getQuantityItem(Collectable collect, HeroesSquad heroesSquad) {
		Inventory heroesBackpack = heroesSquad.getBackPack();
		Integer quantity = 0;
		Iterator<Entry<Collectable, Integer>> iterator = heroesBackpack.getInventory().entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Collectable, Integer> collectable = (Entry<Collectable, Integer>) iterator.next();
			if ((collectable.getKey().getCollectableID()).equals(collect.getCollectableID())) {
				quantity = collectable.getValue();
			}
		}
		return quantity;
	}
	
}
