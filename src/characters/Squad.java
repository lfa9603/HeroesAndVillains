package characters;

import java.util.ArrayList;

public abstract class Squad {

	private ArrayList<Character> characters;
	
	public Squad(ArrayList<Character> listCharacters) {
		characters = listCharacters;
	}

	public ArrayList<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}
	
}
