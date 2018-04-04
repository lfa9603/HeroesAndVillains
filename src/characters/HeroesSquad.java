package characters;

import java.util.ArrayList;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 *Collection of Character objects stored in an ArrayList 
 */
public class HeroesSquad {
	private ArrayList<Hero> heroSquad = new ArrayList<Hero>();

	
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
		 if (!heroSquad.contains(hero)){
			 heroSquad.add(hero);
		 }
		 else {
			 throw new ValueException("Heros cannot have the Same name");
		 }
	}
	
	public boolean squadContains(Hero hero) {
		boolean result = heroSquad.contains(hero);
		return result;
	}
	
	public String toString() {
		String squad = new String("Heros in squad: \n");
		for (Hero hero: heroSquad) {
			squad += hero.getCharacterName() + "\n";
		}
		return squad;
		
	}
}
