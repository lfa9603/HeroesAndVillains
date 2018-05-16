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
 * damageModified is a boolean which is used to indicate whether the villains damage is modified, this parameter is changed by
 * one of the Hero abilities the user can choose
 * 
 */

public class Villain extends Character{

	private boolean isBeaten;
	private int timesBeaten;
	private String villainTaunt;
	private int villainDamage;
	private boolean damageModified;
<<<<<<< HEAD
	private static int villainsChoice;
=======
>>>>>>> master
	
	
	/**
	 * @param name the name of the villain
	 * @param specialAbility the ability that the villain has
	 * @param taunt a string used to taunt the user
	 * @param damage the amount of damage done by the villain to the Heros health or armor
	 */
	public Villain(String name, Types type, Abilities specialAbility, String taunt, int damage) {
		super(name, type, specialAbility);
		villainTaunt = taunt;
		setVillainDamage(damage);
		isBeaten = false;
		damageModified = false;
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
	
	
	/**
	 * The getVillainsChoice method returns a random integer for interaction in the minigame class.
	 * @param upperLimit
	 * @return
	 */
	public void setVillainsChoice(int upperLimit) {
		villainsChoice = Utilities.getRandInt(upperLimit); 
	}
	
	public int getVillainsChoice() {
		return villainsChoice;
	}
	
	/**
	 * The class Villain has to implement as it extends Character
	 */
	public String toString() {
		String string = new String(getCharacterName() + " says " + getVillainTaunt());
		return string;
	}

	/**
	 * Getter method for the villainDamage parameter
	 * @return villainDamage
	 */
	public int getVillainDamage() {
		return villainDamage;
	}

	/**
	 * Setter method for the villainDamage parameter
	 * @param villainDamage
	 */
	public void setVillainDamage(int villainDamage) {
		this.villainDamage = villainDamage;
	}

	/**
	 * Getter method for the timesBeaten parameter
	 * @return timesBeaten
	 */
	public int getTimesBeaten() {
		return timesBeaten;
	}

	/**
	 * Setter method for the timesBeaten parameter
	 * @param timesBeaten
	 */
	public void setTimesBeaten() {
		this.timesBeaten += 1;
		if (getTimesBeaten() == 3) {
			setBeaten(true);
		}
	}

	/**
	 * Getter method for the isBeaten parameter
	 * @return the isBeaten
	 */
	public boolean isBeaten() {
		return isBeaten;
	}

	/**
	 * Setter method for the isBeaten parameter
	 * @param isBeaten
	 */
	public void setBeaten(boolean isBeaten) {
		this.isBeaten = isBeaten;
	}
	
	/**
	 * Getter method for the isDamageModified parameter
	 * @return
	 */

	public boolean isDamageModified() {
		return damageModified;
	}
	
	/**
	 * Setter method for the isDamageModified parameter
	 * @param modifyDamage
	 */

	public void setDamageModified(boolean modifyDamage) {
		damageModified = modifyDamage;
	}
<<<<<<< HEAD
=======
	
	
>>>>>>> master


}
