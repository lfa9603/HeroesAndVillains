package collectables.powerUp;

import characters.Hero;
import collectables.CollectableID;

/**
 * 
 * @author LorenzoFasano
 * This class extends PowerUp and implements the required method apply(Hero hero).
 *
 */
public class IncreaseMaxLife extends PowerUp {

	
	public IncreaseMaxLife(CollectableID collectID) {
		super(collectID);
	}

	/**
	 * Method to implement, as IncreaseMaxLife.java extends PowerUp.java.
	 * 
	 * This PowerUp allows to increase the maxHealth of the designated Hero object to 125 HP,
	 * however its currentHealth property will be untouched (eg. if one Hero object has 70 of currentHealth and 100 of maxHealth,
	 * after using the PowerUp the currentHealth will still be 70 but the maxHealth will be 125).
	 * 
	 */
	@Override
	public void apply(Hero hero) {
		hero.setMaxHealth(125);
	}

	
	
}
