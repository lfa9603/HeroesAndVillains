package collectables;

import characters.Hero;
import engine.Engine;

public abstract class  Collectable {
		
	private Money cost;
	private CollectableID collectableID;
	
	public Collectable(CollectableID collectID) {
		collectableID = collectID;
	}

	
	
	/**
	 * @return the cost
	 */
	public Money getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Money itemCost) {
		if (!Engine.getHasTalkitive()) {
			cost = itemCost;
		} else {
			Integer price =(int) (itemCost.getAmount() * 70 / 100);
			cost = new Money(price);
		}
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
	
	
//	public Money getCost();
//	public void setCost(Money cost);
//	public abstract void apply(Hero hero);
//	public CollectableID getCollectableID();
}
