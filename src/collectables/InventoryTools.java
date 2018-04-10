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

public class InventoryTools {

	public  InventoryTools() {
	}
	
	
	public static ArrayList<Collectable> healingItems(HeroesSquad heroesSquad) {
		
		ArrayList<Collectable> healingItems = new ArrayList<Collectable>();
		HealingItem goodPotion = new HealingItem(CollectableID.GoodHealingItem);
		HealingItem betterPotion = new HealingItem(CollectableID.BetterHealingItem);
		HealingItem bestPotion = new HealingItem(CollectableID.BestHealingItem);
		healingItems.add(goodPotion);
		healingItems.add(betterPotion);
		healingItems.add(bestPotion);
		return healingItems;
		
	}

	
	
	
	public static ArrayList<Collectable> powerUps(HeroesSquad heroesSquad) {
		
		ArrayList<Collectable> powerUps = new ArrayList<Collectable>();
		Armor armor = new Armor(CollectableID.Armor);
		GameChooser gameChooser = new GameChooser(CollectableID.GameChooser);
		IncreaseMaxLife increaseMaxLife = new IncreaseMaxLife(CollectableID.IncreaseMaxLife);
		powerUps.add(armor);
		powerUps.add(gameChooser);
		powerUps.add(increaseMaxLife);
		return powerUps;
		
	}
	
	
	
	public static String showTypeItemsInInventory(HeroesSquad heroesSquad, ArrayList<Collectable> collectables) {
		String string = new String("You are inside the hospital, here is you available Healing potions:\n");
		for (Collectable collectable : collectables) {
			string += "------>  " + collectable.getCollectableID() + "  <------\n";
			string += "DESCRIPTION: " + collectable + "\n";
			string += "QUANTITY: " + getQuantityItem(collectable, heroesSquad).toString() + "\n";
		}
		return string;
	}
	
	
	
	public static Integer getTotTypeItems(HeroesSquad heroes, ArrayList<Collectable> collectables) {
		Integer total = 0;
		for (Collectable item : collectables) {
			total += getQuantityItem(item, heroes);
		}
		return total;

	}
	
	
	
	public static Integer getQuantityItem(Collectable collect, HeroesSquad heroesSquad) {
		Inventory heroesBackpack = heroesSquad.getBackPack();
		Integer valueToReturn = 0;
		Iterator<Entry<Collectable, Integer>> iterator = heroesBackpack.getInventory().entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Collectable, Integer> collectable = (Entry<Collectable, Integer>) iterator.next();
			if ((collectable.getKey().getCollectableID()).equals(collect.getCollectableID())) {
				valueToReturn = collectable.getValue();
			}
		}
		return valueToReturn;
	}
	
}
