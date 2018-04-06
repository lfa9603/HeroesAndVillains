package characters;


public class Villain extends Character{

	private String villainTaunt;
	
	
	/**
	 * @author LorenzoFasano and JayHamilton
	 * @param name
	 * @param specialAbility
	 * @param taunt
	 */
	public Villain(String name, String type, String specialAbility, String taunt) {
		super(name, type, specialAbility);
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
				"\nHealth: " + getHealth() +
				"\nSpecial ability: " + getCharacterAbility() +
				"\nHis taunt is: " + getVillainTaunt());
		return string;
	}


}
