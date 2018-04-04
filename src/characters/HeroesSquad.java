package characters;

import java.util.ArrayList;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 *Collection of Character objects stored in an ArrayList 
 */
public class HeroesSquad {
	private ArrayList<Hero> HeroSquad = new ArrayList<Hero>();

	
	/**
	 * @return the heroSquad
	 */
	public ArrayList<Hero> getHeroSquad() {
		return HeroSquad;
	}


	/**
	 * @param Checks if hero is in the Squad and adds it, else it return the
	 */
	public void setHeroSquad(ArrayList<Hero> heroSquad) {
		HeroSquad = heroSquad;
	}


	/**
	 * IMPLEMENT
	 */
	public Character getPrimaryCharacter() {
		// TODO Auto-generated method stub
		return null;
	}

}
