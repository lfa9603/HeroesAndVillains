package characters;

/**
 * 
 * @author LorenzoFasano
 *Character abstract class needed to implement classes that take Character elements as objects,
 *This will make it easier to implement code that accepts both Hero and Villain objects.
 */
public abstract class Character {
	
	private String characterName;
	private String characterAbility;
	private int health = 100;
	private boolean alive = true;
	

	/**
	 * 
	 * @param name
	 * @param specialAbility
	 */
	public Character(String name, String specialAbility) {
		characterName = name;
		characterAbility = specialAbility;
	}
	
	/**
	 * @return characterName
	 */
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * @param characterName 
	 * characterName setter
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}


	/**
	 * @return characterAbility
	 */
	public String getCharacterAbility() {
		return characterAbility;
	}

	/**
	 * @param characterAbility 
	 * characterAbility setter
	 */
	public void setCharacterAbility(String characterAbility) {
		this.characterAbility = characterAbility;
	}
	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @param alive the alive to set
	 */
	public void setisAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * The class all children classes have to implement
	 */
	public abstract String toString();
}
