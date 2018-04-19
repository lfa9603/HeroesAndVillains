package collectables.powerUp;

import characters.Hero;
import collectables.CollectableID;

/**
 * 
 * @author Lorenzo
 * This class 
 *
 */
public class Armor extends PowerUp {

	
	public Armor(CollectableID collectID) {
		super(collectID);
	}

	/**
	 * Method to implement as Armor implements PowerUp.
	 * It allows the Hero to use its Armor during battle with the villain, 
	 * setting the hasArmor Hero property to true
	 * 
	 */
	@Override
	public void apply(Hero hero) {
		hero.setHasArmor(true);
	}


	
}
