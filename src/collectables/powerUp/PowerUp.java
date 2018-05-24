package collectables.powerUp;

import characters.Hero;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Money;
/**
 * 
 * PowerUp is an abstract class which extends Collectable.java abstract class but instead of implementing the required apply(Hero hero) 
 * method it delegates this responsibility to the classes that will extend PowerUp.
 * 
 * This class also sets the cost property in Collectable depending on the collectableID passed 
 * to it which can be for PowerUp objects: Armor, GameChooser or IncreaseMaxLife.
 * 
 */
public abstract class PowerUp extends Collectable {

	
	
	/**
	 * 
	 * @param collectableID (type CollectableID)
	 * Constructor for PowerUp, it depends on Collectable.java constructor.
	 * It also automatically set the cost property to the right amount depending on the 
	 * collectableID property.
	 *  
	 */
	public PowerUp(CollectableID collectableID) {
		super(collectableID);
		setCostPowerUp();
	}
	

	/**
	 * This is a helper function for the constructor method.
	 * It sets the cost property (present in Collectable.java) to the right Money object depending on collectableID property.
	 * 
	 */
	private void setCostPowerUp() {
		switch (getCollectableID()) {
			case Armor:
				setCost(new Money(30));
			case GameChooser:
				setCost(new Money(60));
			case IncreaseMaxLife:
				setCost(new Money(90));
			default:
				break;
		}
	}

	/**
	 * Overridden toString() method.
	 * @return a String object showing the name of the PowerUp object and the benefits gained by using the powerUp.
	 * 
	 */
	public String toString() {
		String string = new String("Power-up of type: " + getCollectableID() 
				+ ".\nThe cost of this item is " + getCost()
				+ " coins.\nUsing this item will ");
		switch (getCollectableID()) {
			case Armor:
				string += "add a protective shield to the hero's equipment, this allows "
						+ "him/her to take one hit without loosing HP.";
				break;
			case IncreaseMaxLife:
				string += "increase the hero's max life of 25 HP, "
						+ "however his/her current health will be untouched.";
				break;
			case GameChooser:
				string += "allow the hero to choose the game to play when he/she "
						+ "will challenge any villain.";
			default:
				break;
		}
		return string;
	}
	
	/**
	 * The method to implement as PowerUp extends Collectable.
	 * This responsibility is passed down to those classes that will extend PowerUp.
	 */
	public abstract void apply(Hero hero);

}
