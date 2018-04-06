package characters;

import java.util.ArrayList;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 *Collection of Character objects stored in an ArrayList 
 */
public class HeroesSquad {
	
	private static ArrayList<Hero> heroSquad = new ArrayList<Hero>();
	private String teamName;
	private boolean haveMap;

	

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
	
	public static void main(String[] args) {
		Hero hero1 = new Hero("hero1", "Be cool", "specialAbility_1");
		Hero hero4 = new Hero("hero1", "Be cooler", "specialAbility_4");
		Hero hero2 = new Hero("hero2", "Have some swag", "specialAbility_2");
		Hero hero3 = new Hero("hero3","Be the man", "specialAbility_3");
		HeroesSquad testsquad = new HeroesSquad();
		testsquad.addHero(hero1);
		testsquad.addHero(hero4);
		testsquad.addHero(hero2);
		testsquad.addHero(hero3);
		
		System.out.println(testsquad);
		testsquad.squadReset();
		System.out.println(testsquad);
	}



}
