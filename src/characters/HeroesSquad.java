package characters;

import java.awt.Point;
import java.util.ArrayList;

import city.City;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.Money;
import collectables.heroesMap.HeroesMap;
import engine.Utilities;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 *Collection of Character objects stored in an ArrayList 
 */
public class HeroesSquad {
	
	private static ArrayList<Hero> heroSquad = new ArrayList<Hero>();
	private String teamName;
	private boolean allDead; 
	
	private City currentCity;
	
	private boolean haveMap;
	private HeroesMap heroesMap;

	private Inventory backPack;
	private Money wallet;
	
	private Point currentPosition;
	

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
	
	public Hero getHero(int choice) {
		return heroSquad.get(choice);
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
		if (haveMap) {
			HeroesMap map = new HeroesMap(CollectableID.HeroesMap);
			map.setCity(currentCity);
			heroesMap = map;
		}
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
	
	/**
	 * @return the currentPosition
	 */
	public Point getCurrentPosition() {
		return currentPosition;
	}



	/**
	 * @param currentPosition the currentPosition to set
	 */
	public void setCurrentPosition(Point currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	
	
	public String heroStatus(Hero hero) {
		if (hero.isinDetention) {
			return "In Detention";
		}
		else {
			if (hero.isAlive() == true) {
				return "Alive";
			}
			else {
				return "dead";
			}
		}
	}
	
	public void heroTakesDamage(Hero hero, int villainDamge) {
		int currentHealth = hero.getHealth() - villainDamge;
		if (currentHealth > 0) {
			hero.setHealth(currentHealth);
			System.out.println(hero.getCharacterName() + "'s Health is " + hero.getHealth() + "HP");
		}
		else {
			hero.setHealth(0);
			hero.setisAlive(false);
			System.out.println(hero.getCharacterName() + " has Died!!");
			checkTeamStatus();
		}
	
	}
	
		
	/**
	 * @return the allDead
	 */
	public boolean isAllDead() {
		return allDead;
	}
	
	public void checkTeamStatus() {
		int  teamSize = heroSquad.size();
		int deadTeamMembers = 0;
		
		for (Hero hero: heroSquad) {
			if (hero.isinDetention || hero.isAlive() == false) {
				deadTeamMembers += 1;
				if (deadTeamMembers == teamSize) {
					setAllDead(true);
				}
			}
		}
	}


	

	/**
	 * @param allDead the allDead to set
	 */
	public void setAllDead(boolean allDead) {
		this.allDead = allDead;
	}



	public String toString() {
		String squad = new String("Heros in " + teamName + ": \n"
				+ "Index : Name : Health : Type : Abilty : Status \n"
				+ "\n");
		for (Hero hero: heroSquad) {
			squad += (heroSquad.indexOf(hero)+1) + ") " + hero.getCharacterName() + " : " + hero.getHealth() + "HP : " + hero.getCharacterType() + " : " 
			+ hero.getCharacterAbility() + " : " + heroStatus(hero) + "\n";
		}
		return squad;
		
	}
	
}
