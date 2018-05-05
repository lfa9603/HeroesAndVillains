package characters;

import engine.Utilities;


/**
 * 
 * @author LorenzoFasano and JayHamilton
 * The Villain class extends the Character class, it provides specific functionality for the Villain object and has 
 * five unique parameters isBeaten, timesBeaten, villainTaunt and villainDamage.
 * isBeaten is a boolean which is set to true when the villain has been beaten 3 times.
 * timesBeaten is how many times the villain has been beaten.
 * villainTaunt is a string that is displayed on occasion to taunt the player and invoke an emotional response.
 * villainDamage is how much damage the villain does to armor of the Hero's health.
 * 
 */

public class Villain extends Character{

	private boolean isBeaten;
	private int timesBeaten;
	private String villainTaunt;
	private int villainDamage;
//	private boolean damageModified; TODO remove this parameter.
	
	
	/**
	 * @param name the name of the villain
	 * @param specialAbility the ability that the villain has
	 * @param taunt a string used to taunt the user
	 */
	public Villain(String name, Types type, Abilities specialAbility, String taunt, int damage) {
		super(name, type, specialAbility);
		villainTaunt = taunt;
		setVillainDamage(damage);
		isBeaten = false;
	}
	
	/**
	 * Getter method for the villainTaunt parameter
	 * @return villainTaunt
	 */

	public String getVillainTaunt() { 
		return villainTaunt;
	}
	
	/**
	 * Setter method for the villainTaunt parameter
	 * @param villainTaunt
	 */

	public void setVillainTaunt(String villainTaunt) {
		this.villainTaunt = villainTaunt;
	}
	
	//TODO remove this method
//	public String sayTaunt() {
//		return getCharacterName() + " taunts you, they say " + getVillainTaunt();
//	}
	
	public int getVillainsChoice(int upperLimit) {
		return Utilities.getRandInt(upperLimit);
	}
	
	/**
	 * The class Villain has to implement as it extends Character
	 */
	public String toString() {
		String string = new String(getCharacterName() + " says " + getVillainTaunt());
		return string;
	}

	/**
	 * @return the villainDamage
	 */
	public int getVillainDamage() {
		return villainDamage;
	}

	/**
	 * @param villainDamage the villainDamage to set
	 */
	public void setVillainDamage(int villainDamage) {
		this.villainDamage = villainDamage;
	}

	/**
	 * @return the timesBeaten
	 */
	public int getTimesBeaten() {
		return timesBeaten;
	}

	/**
	 * @param timesBeaten the timesBeaten to set
	 */
	public void setTimesBeaten() {
		this.timesBeaten += 1;
		if (getTimesBeaten() == 3) {
			setBeaten(true);
		}
	}

	/**
	 * @return the isBeaten
	 */
	public boolean isBeaten() {
		return isBeaten;
	}

	/**
	 * @param isBeaten the isBeaten to set
	 */
	public void setBeaten(boolean isBeaten) {
		this.isBeaten = isBeaten;
	}


}
