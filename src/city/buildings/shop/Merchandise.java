package city.buildings.shop;

import java.util.ArrayList;
import java.util.Random;

import collectables.Collectable;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.healingItem.HealingItem;
import collectables.heroesMap.HeroesMap;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;

/**
 * 
 * @author Lorenzo
 * 
 * This class contains an Inventory object, this object is automatically filled with a random quantity of objects 
 * that extend @Collectable at the moment of a Merchandise() object instantiation.
 * 
 */
public class Merchandise {

	private Inventory inventory;
	
	/**
	 * 
	 * the Merchandise constructor uses @addRandomElementsToMerchandise() helper to instantiate 
	 * @param inventory and to add to it a random quantity (between 0 and 2 inclusive) of objects 
	 * that extend @Collectable. 
	 * 
	 */
	public Merchandise() {
		addRandomElementsToMerchandise();
	}
	
	/**
	 * 
	 * Constructor helper method which instantiate @param inventory to a new Inventory object.
	 * It uses @addRandomAmountOfEachCollectableToInventory(...) and @retrieveAllCollectables() as helpers.
	 * 
	 */
	public void addRandomElementsToMerchandise() {
		inventory = new Inventory();
		ArrayList<Collectable> collectables = retrieveAllCollectables();
		addRandomAmountOfEachCollectableToInventory(inventory, collectables);
	}

	/**
	 * 
	 * @return an ArrayList containing one instance of each class that extends @Collectable 
	 * (directly as HealingItem or indirectly as objects that extend PowerUp).
	 * 
	 */
	public ArrayList<Collectable> retrieveAllCollectables() {
		ArrayList<Collectable> collectables = new ArrayList<Collectable>();
		
		//Create an instance for HealingItems
		HealingItem goodHealingItem = new HealingItem(CollectableID.GoodHealingItem);
		HealingItem betterHealingItem = new HealingItem(CollectableID.BetterHealingItem);
		HealingItem bestHealingItem = new HealingItem(CollectableID.BestHealingItem);
		
		//Create an instance of PowerUps
		Armor armor = new Armor(CollectableID.Armor);
		IncreaseMaxLife increaseMaxLife = new IncreaseMaxLife(CollectableID.IncreaseMaxLife);
		GameChooser gameChooser = new GameChooser(CollectableID.GameChooser);
		
		//Create an Instance for the map
		
		collectables.add(goodHealingItem);
		collectables.add(betterHealingItem);
		collectables.add(bestHealingItem);
		collectables.add(armor);
		collectables.add(increaseMaxLife);
		collectables.add(gameChooser);
		
		System.out.println("Completed retrieveAllCollectibles");
		
		return collectables;
		
	}
	

	/**
	 * 
	 * @param inventory an Inventory object which initially has no elements stored in it.
	 * @param collectables an ArrayList containing one instance of each class that extends @Collectable 
	 * The method deals with concretely populating the HashMap in the Inventory object adding a 
	 * random amount (0 to 2 elements) of each element present in @param collectables.
	 * 
	 */
	private void addRandomAmountOfEachCollectableToInventory(Inventory inventory, ArrayList<Collectable> collectables) {
		
		for (Collectable item : collectables) {
			Integer randInt = (new Random()).nextInt(3);
//			Integer randInt = 1;
			if (!(item.getCollectableID()).equals(CollectableID.HeroesMap)) {
				for (int i=0; i < randInt; i++) {
					inventory.addItemToInventory(item);
				}
			}
		}
		inventory.addItemToInventory(new HeroesMap(CollectableID.HeroesMap));
		System.out.println("Completed addRandomAmountOfEachCollectableToInventory");
		
	}

	/**
	 * 
	 * Getter for inventory property.
	 * @return inventory
	 * 
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * 
	 * The setter for inventory property.
	 * @param inventory
	 *
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
//	public static void main(String[] args) {
//		Merchandise merchandise = new Merchandise();
//		System.out.println(merchandise.getInventory());
//	}

}
