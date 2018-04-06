package characters;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 *
 */
public class Hero extends Character {
	private boolean isGameChooser = false;
	
	/**
	 * 
	 * @param name
	 * @param specialAbility
	 */
	public Hero(String name, String type, String specialAbility) {
		super(name, type, specialAbility);
	}
	
	/**
	 * @return the isGameChooser
	 */
	public boolean getisGameChooser() {
		return isGameChooser;
	}

	/**
	 * @param isGameChooser the isGameChooser to set
	 */
	public void setIsGameChooser(boolean isGameChooser) {
		this.isGameChooser = isGameChooser;
	}
	
	public boolean equals(Hero this, Hero other) {
		if (getCharacterName().equals(other.getCharacterName())) {
			return true;
		}
		
		else {
			return false;
		}
		
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
