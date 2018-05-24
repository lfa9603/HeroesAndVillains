package collectables;

import characters.Hero;
import engine.Engine;

/**
 * 
 * This is an abstract class that wants to unify PowerUp objects and HealingItem objects, 
 * it requires each object that extends it to implement the method @apply() and gives each one of these objects a cost (type Money) 
 * and a collectableID (type CollectableID). 
 */
public abstract class Collectable implements java.io.Serializable {
		

	private static final long serialVersionUID = 4948691758247117330L;
	private Money cost;
	private CollectableID collectableID;
	
	/**
	 * 
	 * @param collectID
	 * This constructor leaves each child class to implement the cost property.
	 *  
	 */
	public Collectable(CollectableID collectID) {
		collectableID = collectID;
	}

	
	
	/**
	 * 
	 * Getter for the property cost
	 * @return the cost property
	 * 
	 */
	public Money getCost() {
		return cost;
	}

	/**
	 * 
	 * Setter for the property cost. 
	 * It automatically lowers the price if the HeroesSquad object contains a Hero object with the GoodBoy ability.
	 * @param itemCost(type Money)
	 * 
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
	 * 
	 * Getter method for property collectableID
	 * @return the collectableID property
	 * 
	 */
	public CollectableID getCollectableID() {
		return collectableID;
	}

	/**
	 * 
	 * Setter method for collectableID property.
	 * @param collectableID (type CollectableID)
	 */
	public void setCollectableID(CollectableID collectableID) {
		this.collectableID = collectableID;
	}
	
	/**
	 * 
	 * The method each class that extends Collectable has to implement.
	 * @param hero (type Hero)
	 * 
	 */
	public abstract void apply(Hero hero);
	
}
