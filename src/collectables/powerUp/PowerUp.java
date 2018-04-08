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
	}
	

	public void setCost(Money cost) {
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
	
	public abstract void apply(Hero hero);

}
