package characters;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 *Character abstract class implements classes that take Character elements as objects,
 *this class is parent to both the villain and hero classes. This class implements an abstract toString()
 *method.
 */
public abstract class Character implements java.io.Serializable {
	
	
	private static final long serialVersionUID = 9098228716645620486L;
	
	private String characterName;
	private Types characterType;
	private Abilities characterAbility;
	private int maxHealth = 100;
	private int health = 100;
	private boolean alive = true;
	

	/**
	 * Constructor for the Character class.
	 * @param name the name of the character.
	 * @param specialAbility the ability associated with the character.
	 */
	public Character(String name, Types type, Abilities specialAbility) {
		characterName = name;
		characterType = type;
		characterAbility = specialAbility;
	}
	
	/**
	 * Returns the Characters name.
	 * @return characterName
	 */
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * Setter Method of the character's name.
	 * @param characterName
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}


	/**
	 * Getter Method of the Characters Type.
	 * @return characterType
	 */
	public Types getCharacterType() {
		return characterType;
	} 

	/**
	 * Setter method for the Charater's type.
	 * @param characterType the character Type to set to.
	 */
	public void setCharacterType(Types characterType) {
		this.characterType = characterType;
	}

	/**
	 * Getter method for the Character's Ability.
	 * @return characterAbility
	 */
	public Abilities getCharacterAbility() {
		return characterAbility;
	}

	/**
	 * Setter method for the Characters Ability.
	 * @param characterAbility 
	 */
	public void setCharacterAbility(Abilities characterAbility) {
		this.characterAbility = characterAbility;
	}
	
	/**
	 * Getter method for the Character's Max Health parameter.
	 * @return maxHealth
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * Setter Method for the Character's max health parameter.
	 * @param maxHealth
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * Getter method for the Characters health.
	 * @return health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Setter method for the Characters health.
	 * @param health
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
	 * Getter method for the character is alive parameter which is a boolean value.
	 * @return alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Setter method for the characters is alive parameter.
	 * @param alive
	 */
	public void setisAlive(boolean alive) {
		this.alive = alive;
		
	}

	/**
	 * The abstract method all children have to implement.
	 */
	public abstract String toString();
}
