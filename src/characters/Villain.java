package characters;

import engine.Utilities;

public class Villain extends Character{

	private boolean isBeaten = false;
	private int timesBeaten;
	private String villainTaunt;
	private int villainDamage;
	private boolean damageModified = false;
	
	
	/**
	 * @author LorenzoFasano and JayHamilton
	 * @param name
	 * @param specialAbility
	 * @param taunt
	 */
	public Villain(String name, Types type, Abilities specialAbility, String taunt, int damage) {
		super(name, type, specialAbility);
		villainTaunt = taunt;
		setVillainDamage(damage);
	}

	public String getVillainTaunt() { 
		return villainTaunt;
	}

	public void setVillainTaunt(String villainTaunt) {
		this.villainTaunt = villainTaunt;
	}
	
	public String sayTaunt() {
		return getCharacterName() + " taunts you, He says " + getVillainTaunt();
	}
	
	public int getVillainsChoice(int upperLimit) {
		return Utilities.getRandInt(upperLimit);
	}
	
	/**
	 * The class Villain has to implement as it extends Character
	 */
	public String toString() {
		String string = new String(
				"Villain named: " + getCharacterName() + 
				"\nHealth: " + getHealth() +
				"\nSpecial ability: " + getCharacterAbility() +
				"\nHis taunt is: " + getVillainTaunt());
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
	 * @return the damageModified
	 */
	public boolean isDamageModified() {
		return damageModified;
	}

	/**
	 * @param damageModified the damageModified to set
	 */
	public void setDamageModified(boolean damageModified) {
		this.damageModified = damageModified;
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
