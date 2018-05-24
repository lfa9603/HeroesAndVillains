package city.buildings.homeBase;

import java.util.ArrayList;

import characters.HeroesSquad;
import city.buildings.shop.Merchandise;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.heroesMap.HeroesMap;
import engine.Utilities;


/**
 * 
 * This class works as a HomeBase.java class static helper.
 * It deals with the random events that can happen inside the interact() method in HomeBase.java.
 * Based on the choice of a randomCollectable item among all the possible ones and a random 
 * factor (integer choice between 0 and 100).
 * The HeroesSquad object can be gifted a Collectable object or robbed of one present in the backpack property.
 * 
 */
public class RandomEventsInHomeBase {

	
	/**
	 * 
	 * @param heroesSquad (type HeroesSquad)
	 * @return null if no object is gifted or the gifted Collectable object.
	 * 
	 * Selects one item out of all the possible Collectable objects and adds it to the backpack property of 
	 * the HeroesSquad object in case the odds are on the HeroesSquad object side.
	 * In the case the Collectable object selected is a HeroesMap object, the method will make sure
	 * to make it effective ( @see HeroesMap.java and HeroesSquad.java for further details on HeroesMap objects behaviour)
	 * 
	 */
	public static Collectable hasAnyoneBeenGenerous(HeroesSquad heroesSquad) {
		Merchandise merchandise = new Merchandise();
		ArrayList<Collectable> collectables = merchandise.retrieveAllCollectables();
		collectables.add(new HeroesMap(CollectableID.HeroesMap));
		
		Inventory squadBackPack = heroesSquad.getBackPack();
		
		int randomIndexInCollectables = Utilities.getRandInt(collectables.size() - 1);
		int randomInt = Utilities.getRandInt(100);
		
		if (randomInt <= 25) {
			Collectable itemDonated = collectables.get(randomIndexInCollectables);
			if (itemDonated.getCollectableID().equals(CollectableID.HeroesMap)) {
				
				if (!heroesSquad.isHaveMap()) {
					heroesSquad.setHaveMap(true);
				} else {
					return null;
				}
				
			} else {
				squadBackPack.addItemToInventory(itemDonated);
			}
			
			return itemDonated;
		} 
		
		return null;
	}
	
	
	/**
	 * 
	 * @param heroesSquad (type HeroesSquad)
	 * @return null if no object is stolen or the stolen Collectable object.
	 * 
	 * This method selects a random Collectable object out of all the possible ones.
	 * It then checks if the Collectable object is present in the HeroesSquad object backpack property, 
	 * if the backpack property of 
	 * HeroesSquad object has at least one object in it and if the odds are in favour of the "robber". 
	 * If so the selected Collectable item will be removed by the HeroesSquad backPack property of HeroesSquad.
	 * 
	 * In the case the Collectable object selected is a HeroesMap object, the method will make sure
	 * to make it effective ( @see HeroesMap.java and HeroesSquad.java for further details on
	 *  HeroesMap objects behaviour)
	 *  
	 * 
	 */
	public static Collectable haveWeBeenRobbed(HeroesSquad heroesSquad) {
		Merchandise merchandise = new Merchandise();
		Inventory inventory = heroesSquad.getBackPack();
		ArrayList<Collectable> collectables = merchandise.retrieveAllCollectables();
		collectables.add(new HeroesMap(CollectableID.HeroesMap));
		
		int randomIndexInCollectables = Utilities.getRandInt(collectables.size() - 1);
		int randomInt = Utilities.getRandInt(100);
		
		
		if (inventory.getInventory().size() > 0 && randomInt < 60) {
			
			Collectable itemToRemove = inventory.isInInventory(collectables.get(randomIndexInCollectables));
			
			if (itemToRemove != null) {
				
				if (itemToRemove.getCollectableID().equals(CollectableID.HeroesMap)) {
					
					if (heroesSquad.isHaveMap()) {
						heroesSquad.setHaveMap(false);
						return itemToRemove;
						
					} else {
						return null;
					}
				} else {
					inventory.removeItemFromInventory(itemToRemove);
				}
				
				return itemToRemove;
			}
		}
		
		return null;
	}

}
