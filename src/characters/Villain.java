package characters;


public class Villain extends Character{

	private String villainTaunt;
	
	
	/**
	 * 
	 * @param name
	 * @param specialAbility
	 * @param taunt
	 */
	public Villain(String name, String specialAbility, String taunt) {
		super(name, specialAbility);
		villainTaunt = taunt;
	}

	public String getVillainTaunt() {
		return villainTaunt;
	}

	public void setVillainTaunt(String villainTaunt) {
		this.villainTaunt = villainTaunt;
	}
	
	/**
	 * The class Villain has to implement as it extends Character
	 */
	public String toString() {
		String string = new String(
				"Villain named: " + getCharacterName() + 
				"\nSpecial ability: " + getCharacterAbility() +
				"\nHis taunt is: " + getVillainTaunt());
		return string;
	}


}
