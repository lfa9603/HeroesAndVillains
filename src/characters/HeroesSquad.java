package characters;

import java.awt.Point;
import java.util.ArrayList;

import city.City;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.Money;
import collectables.heroesMap.HeroesMap;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 * A Collection of Hero objects stored in an ArrayList. This class holds the main functionality for the Team of Hero objects
 * in the game. The HeroSquad object also holds the Inventory, Wallet and current position.  
 */

public class HeroesSquad {
	
	private static ArrayList<Hero> heroSquad;
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
		
		heroSquad = new ArrayList<Hero>();
	}
	


	/**
	 * Checks if hero is in the Squad and adds it, else it raises an error.
	 * @param hero
	 */
	public void addHero(Hero hero) {
		 if (!this.squadContains(hero)){
			 heroSquad.add(hero);
		 }
		 else {
			 System.out.println("Heros cannot have the same name");
		 }
	}
	
	/**
	 * Checks if the hero object is in the array list heroSquad and returns the result
	 * @param hero
	 * @return result
	 */
	
	public boolean squadContains(Hero hero) {
		boolean result = false;
		for(Hero heroinsquad: heroSquad) {
			if (heroinsquad.getCharacterName().equals(hero.getCharacterName())) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Returns the Hero object in the given index
	 * @param choice(index)
	 * @return
	 */
	
	public Hero getHero(int choice) {
		return heroSquad.get(choice);
	}
	
	/**
	 * Returns how many Hero objects are in the array list heroSquad
	 * @return int
	 */
	
	public int getLength() {
		return heroSquad.size();
	}
	
	/**
	 * Removes all Hero objects from the array list heroSquad
	 */
	
	public void squadReset() {
		heroSquad.removeAll(heroSquad);
	}
	

	/**
	 * Getter method for the array list heroSquad
	 * @return the heroSquad
	 */
	
	public ArrayList<Hero> getHeroSquad() {
		return heroSquad;
	}
	
	/**
	 * Getter method for the TeamName parameter 
	 * @return the teamName
	 */
	
	public String getTeamName() {
		return teamName;
	}


	/**
	 * Setter method for the TeamName parameter 
	 * @param teamName the teamName to set
	 */
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	/**
	 * Getter method for the HaveMap parameter
	 * @return the haveMap
	 */
	
	public boolean isHaveMap() {
		return haveMap;
	}

	/**
	 * Setter method for the HaveMap parameter
	 * @param haveMap
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
	 * Getter method for the heroMap parameter
	 * @return the heroesMap
	 */
	
	public HeroesMap getHeroesMap() {
		return heroesMap;
	}

	/**
	 * Setter method for the heroMap parameter
	 * @param heroesMap
	 */
	public void setHeroesMap(HeroesMap heroesMap) {
		this.heroesMap = heroesMap;
	}
	
	/**
	 * Getter method for the currentCity parameter
	 * @return currentCity
	 */
	public City getCurrentCity() {
		return currentCity;
	}

	/**
	 * Setter method for the currentCity parameter
	 * @param currentCity the currentCity to set
	 */
	public void setCurrentCity(City currentCity) {
		this.currentCity = currentCity;
	}
	

	/**
	 * Getter method for the backPack parameter
	 * @return backPack
	 */
	public Inventory getBackPack() {
		return backPack;
	}

	/**
	 * Getter method for the backPack parameter
	 * @param backPack
	 */
	public void setBackPack(Inventory backPack) {
		this.backPack = backPack;
	}
	
    /**
     * Getter method for the wallet parameter
	 * @return the wallet
	 */
	public Money getWallet() {
		return wallet;
	}



	/**
	 * Setter method for the wallet parameter
	 * @param wallet
	 */
	public void setWallet(Money wallet) {
		this.wallet = wallet;
	}
	
	/**
	 * @return the currentPosition
	 */
	public Point getCurrentPosition() {
		return currentPosition;
	}

	/**
	 * Setter method for the currentPosition parameter
	 * @param currentPosition the currentPosition to set
	 */
	public void setCurrentPosition(Point currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	
	/**
	 * A method that checks if the Hero given is alive, dead of in detention.
	 * @param hero
	 * @return String
	 */
	public String heroStatus(Hero hero) {
		if (hero.isinDetention) {
			return "In Detention";
		}
		else {
			if (hero.isAlive() == true) {
				return "Alive";
			}
			else {
				return "Dead";
			}
		}
	}
	
	/**
	 * A method calculates how much damage the hero takes. If the hero has no armor then all 
	 * the villainDamge is removed from the heros current health (HP). If the Hero has armor and that armor 
	 * has enough AP (Armor points) then the damage is taken from the armor and a new armor value is set. If the 
	 * armor does not cover all the damage then the damage is split between the armor and health, 
	 * with the armor being drained first.  
	 * @param hero
	 * @param villainDamge
	 */
	
	public void heroTakesDamage(Hero hero, int villainDamge) {
		int hasArmor = hero.getArmor();
		int currentHealth = hero.getHealth() - villainDamge;
		int currentArmor = hero.getArmor() - villainDamge;
		if (hasArmor != 0) {
			if (currentArmor >= 0) {
				hero.setArmor(currentArmor);
				System.out.println(hero.getCharacterName() + "'s Armor is at " + hero.getArmor() + "AP");
			}
			
			else {
				hero.setArmor(0);//I added this part, think it makes sense to bring the armor to 0

				int finalHealth = currentArmor + hero.getHealth();
				if (finalHealth > 0) {
					hero.setHealth(finalHealth);
//					hero.setArmor(0);//I added this part, think it makes sense to bring the armor to 0
					System.out.println(hero.getCharacterName() + "'s Health is " + hero.getHealth() + "HP");
				}
				else {
					hero.setHealth(0);
					hero.setisAlive(false);
					System.out.println(hero.getCharacterName() + " has Died!!");
					checkTeamStatus();
				}
			}
		}
		else {
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
	}
	
	/**
	 * Getter method for the allDead parameter
	 * @return allDead
	 */
	public boolean isAllDead() {
		return allDead;
	}
	
	/**
	 * Setter method for the allDead parameter
	 * @param allDead
	 */
	public void setAllDead(boolean allDead) {
		this.allDead = allDead;
	}
	
	/**
	 * A method that checks the status of all the Heros in HeroSquad and sets allDead to true if all the heros are dead.
	 */
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
	
	public Hero getHeroByName(String heroName) {
		Hero heroToReturn = null;
		
		for (Hero hero : heroSquad) {
			if (hero.getCharacterName().equals(heroName)) {
				heroToReturn = hero;
			}
		}
		
		return heroToReturn;
	}
	
	public void removeHero(int hero) {
		heroSquad.remove(hero);
	}
	
	/**
	 * A method the provides the String representation of the HeroSquad object.
	 */

	//TODO: update Hero toString() and then make this method better, not tested yet
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
