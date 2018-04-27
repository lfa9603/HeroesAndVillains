package characters;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 *
 */
public class Hero extends Character {
	private int armor;
	private boolean isGameChooser;
	public boolean isinDetention;
	
	/**
	 * 
	 * @param name
	 * @param specialAbility
	 */
	public Hero(String name, Types type, Abilities specialAbility) {
		super(name, type, specialAbility);
		armor = 0;
		isGameChooser = false;
	}

	/**
	 * @return the hasArmor
	 */
	public int getArmor() {
		return armor;
	}

	/**
	 * @param hasArmor the hasArmor to set
	 */
	public void setArmor(int Armor) {
		armor = Armor;
	}

	/**
	 * @param isGameChooser the isGameChooser to set
	 */
	public void setIsGameChooser(boolean isGameChooser) {
		this.isGameChooser = isGameChooser;
	}
	
	
	/**
	 * @return the isGameChooser
	 */
	public boolean getIsGameChooser() {
		return isGameChooser;
	}
	
	public boolean equals(Hero other) {
		if (this.getCharacterName().equals(other.getCharacterName())) {
			return true;
		}
		
		else {
			return false;
		}
			
	}
	
	public boolean isInDetention() {
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
