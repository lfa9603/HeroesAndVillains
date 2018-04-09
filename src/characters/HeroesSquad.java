package characters;

import java.util.ArrayList;

import city.City;

import collectables.Inventory;
import collectables.Money;
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

	private Inventory backPack;
	private Money wallet;

	public HeroesSquad() {
		haveMap = false;
		backPack = new Inventory();
		wallet = new Money(30);
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
	

	/**
	 * @return the heroSquad
	 */
	public ArrayList<Hero> getHeroSquad() {
		return heroSquad;
	}
	
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
	public Inventory getBackPack() {
		return backPack;
	}

    /**
	 * @return the wallet
	 */
	public Money getWallet() {
		return wallet;
	}



	/**
	 * @param wallet the wallet to set
	 */
	public void setWallet(Money wallet) {
		this.wallet = wallet;
	}

	/**
	 * @param backPack the backPack to set
	 */
	public void setBackPack(Inventory backPack) {
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
