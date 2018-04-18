package collectables.powerUp;

import characters.Hero;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Money;

public abstract class PowerUp extends Collectable {

	
	
	
	public PowerUp(CollectableID collectableID) {
		super(collectableID);
		setCost();
	}
	

	private void setCost() {
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
	
	public abstract void apply(Hero hero);

}
