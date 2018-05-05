package characters;

/**
 * 
 * @author LorenzoFasano and JayHamilton
 * The Hero class extends the Character class, it provides specific functionality for the Hero object and has 
 * three unique parameters armor, isGamechooser and isinDentention. 
 * Armor provides an extra health pool of 30 armor points (AP) for the Hero.
 * isGameChooser is a boolean, that allows the user to choose which minigame they play (rather than having it at random), if they select 
 * the Hero, to play the minigame. This parameter is activated by the gameChooser powerUp.
 *
 */

public class Hero extends Character {
	private int armor;
	private boolean isGameChooser;
	public boolean isinDetention;
	

	/**
	 * @param name the name of the Hero 
	 * @param type the type of the Hero
	 * @param specialAbility the special ability given to the Hero
	 */
	public Hero(String name, Types type, Abilities specialAbility) {
		super(name, type, specialAbility);
		armor = 0;
		isGameChooser = false;
	}

	/**
	 * Getter method for the hasArmor parameter
	 * @return hasArmor
	 */
	public int getArmor() {
		return armor;
	}

	/**
	 * Setter method for the hasArmor parameter
	 * @param hasArmor the hasArmor to set
	 */
	public void setArmor(int Armor) {
		armor = Armor;
	}

	/**
	 * Getter method for the isGameChooser parameter 
	 * @return isGameChooser
	 */
	public boolean getIsGameChooser() {
		return isGameChooser;
	}
	
	/**
	 * Setter method for the isGameChooser parameter 
	 * @param isGameChooser the isGameChooser to set
	 */
	public void setIsGameChooser(boolean isGameChooser) {
		this.isGameChooser = isGameChooser;
	}
	
	/**
	 * This method overrides the standard equals method. The method checks to see if the Heros have the same name.
	 * @param other of Class Hero
	 * @return boolean
	 */
	
	public boolean equals(Hero other) {
		if (this.getCharacterName().equals(other.getCharacterName())) {
			return true;
		}
		
		else {
			return false;
		}
			
	}
	
	/**
	 * Getter method for the isInDetention parameter 
	 * @return isInDetention
	 */
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
