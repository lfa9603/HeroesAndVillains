package characters;

import java.util.ArrayList;

/**
 * 
 * @author LorenzoFasano
 *Abstract class needed to simplify the creation of Classes that accept Squad items, 
 *so that they can be used to implement tools for HeroesSquad and VillainsSquad objects 
 */
public abstract class Squad {

	private ArrayList<Character> characters;
	
	/**
	 * 
	 * @param listCharacters
	 */
	public Squad(ArrayList<Character> listCharacters) {
		characters = listCharacters;
	}

	/**
	 * 
	 * @return ArrayList<Character>
	 * 
	 */
	public ArrayList<Character> getCharacters() {
		return characters;
	}

	
	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}
	
	/**
	 * @return Character object
	 * Method that any child class needs to implement,
	 */
	public abstract Character getPrimaryCharacter();
	
}
