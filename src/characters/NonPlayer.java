package characters;

/**
 * 
 * @author JayHamilton
 *
 */


public class NonPlayer extends Character{
	
	/**
	 * 
	 * @param name
	 * @param specialAbility
	 */

	public NonPlayer(String name, String specialAbility) {
		super(name, specialAbility);
	}
	
	/**
	 * Method that Character forces this class to implement.
	 */
	
	public String toString() {
		String string = new String(
				"NPC named: " + getCharacterName() +
				"\nHealth: " + getHealth() +
				"\n ability: " + getCharacterAbility());
		return string;
	}
	
}