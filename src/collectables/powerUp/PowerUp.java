package collectables.powerUp;

import characters.Hero;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Money;

public abstract class PowerUp implements Collectable {

	private Money cost;
	private CollectableID collectableID;
	
	
	
	public PowerUp(CollectableID collectID) {
		collectableID = collectID;
		setCost();
	}
	

	public void setCost() {
		switch (collectableID) {
			case Armor:
				cost = new Money(30);
			case GameChooser:
				cost = new Money(60);
			case IncreaseMaxLife:
				cost = new Money(90);
			default:
				break;
		}
	}

	public Money getCost() {
		return cost;
	}

	/**
	 * @return the collectableID
	 */
	public CollectableID getCollectableID() {
		return collectableID;
	}

	/**
	 * @param collectableID the collectableID to set
	 */
	public void setCollectableID(CollectableID collectableID) {
		this.collectableID = collectableID;
	}
	
	public String toString() {
		String string = new String("Power-up of type: " + collectableID 
				+ ".\nThe cost of this item is " + cost
				+ " coins.\nUsing this item will ");
		switch (collectableID) {
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
