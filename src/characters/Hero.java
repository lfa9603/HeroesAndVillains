package characters;

public class Hero implements Character{
	
	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	private String characterName;
	
	public Hero(String name) {
		characterName = name;
	}
	
	
	
}
