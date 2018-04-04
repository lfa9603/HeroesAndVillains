package characters;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 *
 */
public class Hero extends Character{
	
	/**
	 * 
	 * @param name
	 * @param specialAbility
	 */
	public Hero(String name, String specialAbility) {
		super(name, specialAbility);
	}
	
	/**
	 * Method that Character forces this class to implement.
	 */
	public String toString() {
		String string = new String(
				"Hero named: " + getCharacterName() +
				"\nHealth: " + getHealth() +
				"\nSpecial ability: " + getCharacterAbility());
		return string;
	}
	
	
	
}
