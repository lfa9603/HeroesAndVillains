package characters;

import java.util.ArrayList;

public class Villains {
	private ArrayList<Villain> villains = new ArrayList<Villain>();
	private Villain schoolBully1 = new Villain("Tony the Primary School bully", Types.level_1, Abilities.stealLunch, "Haha, you ugly", 10); //Primary School
	private Villain schoolPricipal2 = new Villain("Gertrude the HighSchool Principal", Types.level_2, Abilities.expel, "You have failed! See you next year", 15); //High School
	private Villain inLaws3 = new Villain("Richard your Partners Father", Types.level_3, Abilities.judge, "Your not good enough for my child! get out of my lair!!", 25); //Dating School
	private Villain Partner4 = new Villain("Alex your Partner ", Types.level_4, Abilities.badDay, "You dont appreciate me enough!", 25); //married
	private Villain docter5 = new Villain("Page your docter ", Types.level_5, Abilities.cancer, "I'm so sorry...", 25); //midLife
	private Villain Boss6 = new Villain("Sam your Manager", Types.Boss, Abilities.arrogance, "Hahah I'm ALWAYs right!", 25); //Work life

	

	public Villains(int worldSize) {
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
	 * @return the villains
	 */
	public ArrayList<Villain> getVillains() {
		return villains;
	}

	/**
	 * @param villains the villains to set
	 */
	public void addVillain(Villain villain) {
		villains.add(villain);
	}
	
	public void removeVillain(int index) {
		villains.remove(index);
	}
	
	public String toString() {
		String villainsList = "Villains: \n"; 
		for(Villain villain: villains) {
			villainsList += villain.getCharacterName() + "\n";
		}
		
		return villainsList;
		
	}
	
//	public static void main(String[] args) {
//		int worldSize = 6;
//		Villains villains  = new Villains(worldSize);
//		System.out.println(villains);
//		
//	}

}
