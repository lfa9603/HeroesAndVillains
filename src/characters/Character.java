package characters;

/**
 * 
 * @author LorenzoFasano
 *Character abstract class needed to implement classes that take Character elements as objects,
 *This will make it easier to implement code that accepts both Hero and Villain objects.
 */
public abstract class Character {
	
	private String characterName;
	private Types characterType;
	private Abilities characterAbility;
	private int maxHealth = 100;
	private int health = 100;
	private boolean alive = true;
	

	/**
	 * 
	 * @param name
	 * @param specialAbility
	 */
	public Character(String name, Types type, Abilities specialAbility) {
		characterName = name;
		characterType = type;
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
	 * @return the characterType
	 */
	public Types getCharacterType() {
		return characterType;
	}

	/**
	 * @param characterType the characterType to set
	 */
	public void setCharacterType(Types characterType) {
		this.characterType = characterType;
	}

	/**
	 * @return characterAbility
	 */
	public Abilities getCharacterAbility() {
		return characterAbility;
	}

	/**
	 * @param characterAbility 
	 * characterAbility setter
	 */
	public void setCharacterAbility(Abilities characterAbility) {
		this.characterAbility = characterAbility;
	}
	
	/**
	 * @return the maxHealth
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @param maxHealth the maxHealth to set
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
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
		if (health <= maxHealth) {
			this.health = health;
		}
		else {
			System.out.println("Max HP value reached");
		}
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
