package city.buildings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import characters.HeroesSquad;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.healingItem.HealingItem;

public class Hospital extends Building {

	public Hospital(String name, TypeBuildings buildType) {
		super(name, buildType);
	}

	@Override
	public void interact(HeroesSquad heroesSquad) {

		boolean atHospital = true;
		while (atHospital) {
			ArrayList<HealingItem> healingItems = createHealingItemsArray();
			addTemplate(heroesSquad, healingItems);
			Scanner input = new Scanner(System.in);
			if (getTotNumberHealingItems(heroesSquad, healingItems) > 0) {
				
			} else {
				System.out.println("Looks like you have no Healing items in the backpack! "
						+ "\nPress 0 for exiting the game");
				try {
					Integer exiting = input.nextInt();
					if (exiting.equals(0)) {
						atHospital = false;
						//exit
					} 
				} catch (InputMismatchException e) {
						//retry
				}
			}	
		}
	}
	
	
	private ArrayList<HealingItem> createHealingItemsArray() {
		ArrayList<HealingItem> healingItems = new ArrayList<HealingItem>();
		HealingItem goodPotion = new HealingItem(CollectableID.GoodHealingItem);
		HealingItem betterPotion = new HealingItem(CollectableID.BetterHealingItem);
		HealingItem bestPotion = new HealingItem(CollectableID.BestHealingItem);
		healingItems.add(goodPotion);
		healingItems.add(betterPotion);
		healingItems.add(bestPotion);
		return healingItems;
	}
	
	private void addTemplate(HeroesSquad heroesSquad, ArrayList<HealingItem> healingItems) {
		System.out.println("You are inside the hospital, here is you available Healing potions:");
		for (HealingItem healingItem : healingItems) {
			System.out.println("------>  " + healingItem.getCollectableID() + "  <------");
			System.out.println("DESCRIPTION: " + healingItem);
			System.out.println("QUANTITY: " + getQuantity(healingItem, heroesSquad).toString());
		}
	}

	private Integer getQuantity(HealingItem potion, HeroesSquad heroesSquad) {
		Inventory heroesBackpack = heroesSquad.getBackPack();
		Integer valueToReturn = new Integer(0);
		Iterator<Entry<Collectable, Integer>> iterator = heroesBackpack.getInventory().entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Collectable, Integer> collectable = (Entry<Collectable, Integer>) iterator.next();
			if ((collectable.getKey().getCollectableID()).equals(potion.getCollectableID())) {
				valueToReturn = collectable.getValue();
			}
		}
		return valueToReturn;
	}
	
	private Integer getTotNumberHealingItems(HeroesSquad heroes, ArrayList<HealingItem> healingItems) {
		Inventory heroesBackpack = heroes.getBackPack();
		Integer total = new Integer(0);
		Iterator<Entry<Collectable, Integer>> iterator = heroesBackpack.getInventory().entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Collectable, Integer> collectable = (Entry<Collectable, Integer>) iterator.next();
			for (HealingItem item : healingItems) {
				if ((collectable.getKey().getCollectableID()).equals(item.getCollectableID())) {
					total++;
				}
			}
		}
		return total;
	}

	public static void main(String[] args) {
		Hospital hospital = new Hospital("Ciao", TypeBuildings.Hospital);
		hospital.interact(new HeroesSquad());
	}

}
