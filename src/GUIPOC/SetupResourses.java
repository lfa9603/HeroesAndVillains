package GUIPOC;

public class SetupResourses {
	private String characterTypes = "1. Talkitive : Has the ability to Charm people (Gets 25% better prices at shops) \n"
			+ "2. Smart : Mystery Ability, which could help or hinder your team (Minigame dependant) \n"
			+ "3. Practical : Gets better odds at rock, paper Scissors \n"
			+ "4. Strong : Takes 30% less damage \n"
			+ "5. Sly : Wins all match draws unless the Villain has this abilty \n"
			+ "6. Dog : Is a good boy (Grants all team member extra 25HP Max Health)";

	/**
	 * @return the characterTypes
	 */
	public String getCharacterTypes() {
		return characterTypes;
	}

	/**
	 * @param characterTypes the characterTypes to set
	 */
	public void setCharacterTypes(String characterTypes) {
		this.characterTypes = characterTypes;
	}

}
