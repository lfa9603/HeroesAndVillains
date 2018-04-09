package characters;

import java.util.Random;

public class Villain extends Character{

	private String villainTaunt;
	private int villainDamage;
	
	
	/**
	 * @author LorenzoFasano and JayHamilton
	 * @param name
	 * @param specialAbility
	 * @param taunt
	 */
	public Villain(String name, String type, String specialAbility, String taunt, int damage) {
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
		return getCharacterName() + " taunts the Hero, He says " + getVillainTaunt();
	}
	
	public int getVillainsChoice(int upperLimit) {
		Random random = new Random();
		int choice = random.nextInt(upperLimit);
		return (choice+1);
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


}
