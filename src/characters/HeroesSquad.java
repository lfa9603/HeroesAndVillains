package characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import city.City;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.healingItem.HealingItem;
import collectables.heroesMap.HeroesMap;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 *Collection of Character objects stored in an ArrayList 
 */
public class HeroesSquad {
	
	private static ArrayList<Hero> heroSquad = new ArrayList<Hero>();
	private String teamName;
	
	private City currentCity;
	
	private boolean haveMap;
	private HeroesMap heroesMap;

	private HashMap<Collectable, Integer> backPack;
	

	public HeroesSquad() {
		haveMap = false;
		backPack = new HashMap<Collectable, Integer>();
	}
	
	
	
	/**
	 * @return the heroSquad
	 */
	public ArrayList<Hero> getHeroSquad() {
		return heroSquad;
	}


	/**
	 * @param Checks if hero is in the Squad and adds it, else it raises an error.
	 */
	public void addHero(Hero hero) {
		 if (!this.squadContains(hero)){
			 heroSquad.add(hero);
		 }
		 else {
			 System.out.println("Heros cannot have the same name");
		 }
	}
	
	public boolean squadContains(Hero hero) {
		boolean result = false;
		for(Hero heroinsquad: heroSquad) {
			if (heroinsquad.getCharacterName().equals(hero.getCharacterName())) {
				result = true;
			}
		}
		return result;
	}
	
	
	public int getLength() {
		return heroSquad.size();
	}
	
	public void squadReset() {
		heroSquad.removeAll(heroSquad);
	}
	
	
	
	//WORKING ON BACKPACK, MIGHT MOVE THIS SECTION TO CREATE A NEW CLASS
	
//	public boolean addItemToBackPack(Collectable item) {
//		boolean alreadyInBackPack = checkBackPack(item);
//		return alreadyInBackPack;
//	}
//	
//	private boolean checkBackPack(Collectable item) {
//		Iterator<Entry<Collectable, Integer>> iterator = backPack.entrySet().iterator();
//		while (iterator.hasNext()) {
//			Map.Entry<Collectable, Integer> collectable = (Entry<Collectable, Integer>) iterator.next();
////			System.out.println(collectable.getKey() + " = " + collectable.getValue());
//			if ((collectable.getKey().getCollectableID()).equals(item.getCollectableID())) {
//				backPack.put(collectable.getKey(), backPack.get(collectable.getKey()) + 1);
//				return true;
//			}
//		}
//		backPack.put((Collectable) item, 1);
//		return false;
//	}
	
//	public static void main(String[] args) {
//		
//		HeroesSquad heros = new HeroesSquad();
//		HashMap<Collectable, Integer> bag = heros.getBackPack();
//		System.out.println(heros.addItemToBackPack(new HealingItem(CollectableID.GoodHealingItem)));
//		System.out.println(heros.addItemToBackPack(new HealingItem(CollectableID.GoodHealingItem)));
//		System.out.println(heros.addItemToBackPack(new HealingItem(CollectableID.Armor)));
//		System.out.println(heros.addItemToBackPack(new HealingItem(CollectableID.IncreaseMaxLife)));
//		
//		Iterator<Entry<Collectable, Integer>> iterator = bag.entrySet().iterator();
//		while (iterator.hasNext()) {
//			Map.Entry<Collectable, Integer> collectable = (Entry<Collectable, Integer>) iterator.next();
//			System.out.println(collectable.getKey() + " = " + collectable.getValue());
//			}
//	}
//	
	
	
	//
	//
	//FROM HERE ON ONLY GETTERS AND SETTERS AND toString() METHODS
	//
	//
	
	
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}


	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	/**
	 * @return the haveMap
	 */
	public boolean isHaveMap() {
		return haveMap;
	}

	/**
	 * @param haveMap the haveMap to set
	 */
	public void setHaveMap(boolean haveMap) {
		this.haveMap = haveMap;
	}
	
	/**
	 * @return the heroesMap
	 */
	public HeroesMap getHeroesMap() {
		return heroesMap;
	}

	/**
	 * @param heroesMap the heroesMap to set
	 */
	public void setHeroesMap(HeroesMap heroesMap) {
		this.heroesMap = heroesMap;
	}
	
	/**
	 * @return the currentCity
	 */
	public City getCurrentCity() {
		return currentCity;
	}

	/**
	 * @param currentCity the currentCity to set
	 */
	public void setCurrentCity(City currentCity) {
		this.currentCity = currentCity;
	}

	/**
	 * @return the backPack
	 */
	public HashMap<Collectable, Integer> getBackPack() {
		return backPack;
	}
	

	/**
	 * @param backPack the backPack to set
	 */
	public void setBackPack(HashMap<Collectable, Integer> backPack) {
		this.backPack = backPack;
	}
	
	public String toString() {
		String squad = new String("Heros in " + teamName + ": \n");
		for (Hero hero: heroSquad) {
			squad += hero.getCharacterName() + " : " + hero.getCharacterAbility() + "\n";
		}
		return squad;
		
	}
}
