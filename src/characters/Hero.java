package characters;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 *
 */
public class Hero extends Character {
	private boolean hasArmor;
	private boolean isGameChooser;
	public boolean isinDetention;
	
	/**
	 * 
	 * @param name
	 * @param specialAbility
	 */
	public Hero(String name, Types type, Abilities specialAbility) {
		super(name, type, specialAbility);
		hasArmor = false;
		isGameChooser = false;
	}

	/**
	 * @return the hasArmor
	 */
	public boolean isHasArmor() {
		return hasArmor;
	}

	/**
	 * @param hasArmor the hasArmor to set
	 */
	public void setHasArmor(boolean hasArmor) {
		this.hasArmor = hasArmor;
	}

	/**
	 * @param isGameChooser the isGameChooser to set
	 */
	public void setIsGameChooser(boolean isGameChooser) {
		this.isGameChooser = isGameChooser;
	}
	
	public boolean equals(Hero other) {
		if (this.getCharacterName().equals(other.getCharacterName())) {
			return true;
		}
		
		else {
			return false;
		}
			
	}
	
	/**
	 * @return the isGameChooser
	 */
	public boolean getIsGameChooser() {
		return isGameChooser;
	}
	
	public boolean isIsinDetention() {
		return isinDetention;
	}

	public void setIsinDetention(boolean isinDetention) {
		this.isinDetention = isinDetention;
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
