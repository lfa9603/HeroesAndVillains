package characters;

import java.util.ArrayList;

/**
 * @author JayHamilton
 * This Class constructs all the Villains for the game world, it is used to balance the game and 
 * provide a central point to change key elements of the game-play. This class is called by the GameEngine class when the world is being setup.
 * When the class is constructed all the villain objects are constructed and are then added to the ArrayList villains. Then depending on the size 
 * of the world chosen by the user the villains that are surplus to requirement are removed.
 *
 */
public class Villains implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7681678177938582870L;
	private ArrayList<Villain> villains;
	private Villain schoolBully1;
	private Villain schoolPricipal2;
	private Villain inLaws3;
	private Villain Partner4;
	private Villain docter5;
	private Villain Boss6;

	

	public Villains(int worldSize) {
		villains = new ArrayList<Villain>();
		schoolBully1 = new Villain("Tony the Primary School bully", Types.level_1, Abilities.stealLunchMoney, "Haha Loser, your money is Mine!", 10); //Primary School
		schoolPricipal2 = new Villain("Gertrude the HighSchool Principal", Types.level_2, Abilities.detention, "Your such a waste of potential, I guess i'll see you next year", 15); //High School
		inLaws3 = new Villain("Richard your Partners Father", Types.level_3, Abilities.judge, "Your not good enough for my child! get out of my lair!!", 25); //Dating \ School
		Partner4 = new Villain("Alex your Partner", Types.level_4, Abilities.badDay, "You dont appreciate me enough!", 25); //married
		docter5 = new Villain("Page your docter", Types.level_5, Abilities.sickness, "I'm so sorry...", 25); //midLife
		Boss6 = new Villain("Sam your Manager", Types.Boss, Abilities.arrogance, "Hahah I'm ALWAYs right!", 25); //Work life
		
		addVillain(schoolBully1);
		addVillain(schoolPricipal2);
		addVillain(inLaws3);
		addVillain(Partner4);
		addVillain(docter5);
		addVillain(Boss6);
				
		for (int i = 5; i >= worldSize; i--) {
			removeVillain(i);
		}
	}

	/**
	 * Getter Method for the villains parameter
	 * @return villains
	 */
	
	public ArrayList<Villain> getVillains() {
		return villains;
	}

	/**
	 * Setter method for the villains parameter
	 * @param villains
	 */
	
	public void addVillain(Villain villain) {
		villains.add(villain);
	}
	
	/**
	 * The removeVillain method is used to remove a villains from the Array-list Villains as required
	 * @param index
	 */
	
	public void removeVillain(int index) {
		villains.remove(index);
	}
	
	/**
	 * The getCurrentVillain method returns the villain associated with the city/level that the player is in.
	 * @param currentIndex
	 * @return villain
	 */
	
	public Villain getCurrentVillain(int currentIndex) {
		return villains.get(currentIndex);
	}
	
	/**
	 * the toString method provides a string representation for the Villains class
	 */
	
	public String toString() {
		String villainsList = "Villains: \n"; 
		for(Villain villain: villains) {
			villainsList += villain.getCharacterName() + "\n";
		}
		
		return villainsList;
	}

}
