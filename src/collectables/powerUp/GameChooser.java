package collectables.powerUp;

import characters.Hero;
import collectables.CollectableID;
/**
 * 
 * This class extends PowerUp and implements the required method apply(Hero hero).
 *
 */
public class GameChooser extends PowerUp{

	

	public GameChooser(CollectableID collectID) {
		super(collectID);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method to implement, as GameChooser extends PowerUp.java.
	 * 
	 * If this method is called on a Hero object, 
	 * this object obtains the ability to choose the game it will be played against the Villain objects,
	 * this is achieved by setting the Hero object property isGameChooser to 
	 * true using the dedicated setter for this property.
	 * 
	 */
	public void apply(Hero hero) {
		hero.setIsGameChooser(true);
	}


}
