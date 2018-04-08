package characters;

import java.util.ArrayList;

import city.City;
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


	public HeroesSquad() {
		haveMap = false;
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
	
	public int getLength() {
		return heroSquad.size();
	}
	
	public void squadReset() {
		heroSquad.removeAll(heroSquad);
	}
	
	public String toString() {
		String squad = new String("Heros in " + teamName + ": \n");
		for (Hero hero: heroSquad) {
			squad += hero.getCharacterName() + " : " + hero.getCharacterAbility() + "\n";
		}
		return squad;
		
	}
	
}
