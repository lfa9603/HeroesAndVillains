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

public class Merchandise {

	private Inventory inventory;
	
	public Merchandise() {
		addRandomElementsToMerchandise();
	}
	
	public void addRandomElementsToMerchandise() {
		inventory = new Inventory();
		ArrayList<Collectable> collectables = retrieveAllCollectables();
		addRandomAmountOfEachCollectableToInventory(inventory, collectables);
	}

	
	private ArrayList<Collectable> retrieveAllCollectables() {
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
	
	//TODO: Working perfectly
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
	 * @return the inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public static void main(String[] args) {
		Merchandise merchandise = new Merchandise();
		System.out.println(merchandise.getInventory());
	}

}
