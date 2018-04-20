package collectables.healingItem;

import characters.Hero;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Money;

/**
 * 
 * @author LorenzoFasano
 * HealingItem.java extends Collectable.java.
 * HealingItem objects when instantiated are assigned property recoverableHp (type int) 
 * and a cost (from Collectable.java) depending on the collectableID property (type CollectableID).
 *
 */
public class HealingItem extends Collectable {

	private int recoverableHP;
	
	/**
	 * 
	 * @param collectableID (type CollectableID)
	 * HealingItem constructor. It automatically assigns a recoverableHP value and a cost 
	 * value depending on the passed collectableID property.
	 * 
	 * This is achieved using the helper methods setRecoverableHP() and setHealingItemCost().
	 * 
	 */
	public HealingItem(CollectableID collectableID) {
		super(collectableID);
		setRecoverableHP();
		setHealingItemCost();
	}
	
	/**
	 * 
	 * Getter method for recoverableHP property.
	 * @return recoverableHP property (type int).
	 * 
	 */
	public int getRecoverableHP() {
		return recoverableHP;
	}

	/**
	 * Modified setter method for recoverableHP.
	 * This is not public as after instantiated a HealingItem never changes its recoverableHP value.
	 * Assigns a value of 25, 50 or 75 depending on the HealingItem collectableID 
	 * (GoodHealingItem. BetterHealingItem and BestHealingItem respectively).
	 * 
	 */
	private void setRecoverableHP() {
		switch (getCollectableID()) {
			case GoodHealingItem:
				recoverableHP = 25;
				break;
			case BetterHealingItem:
				recoverableHP = 50;
				break;
			case BestHealingItem:
				recoverableHP = 75;
				break; 
			default: 
				break;
		}
			
	}

	/**
	 * Modified setter method for cost property.
	 * This is not public as after instantiated a HealingItem never changes its cost value.
	 * Assigns a value of Money(25), Money(50) or Money(75) depending on the HealingItem collectableID 
	 * (GoodHealingItem. BetterHealingItem and BestHealingItem respectively).
	 * 
	 */
	private void setHealingItemCost() {
		switch (getCollectableID()) {
			case GoodHealingItem:
				setCost(new Money(25));
				break;
			case BetterHealingItem:
				setCost(new Money(50));
				break;
			case BestHealingItem:
				setCost(new Money(75));
				break;
			default: 
				break;
		}
	}
	
	
	/**
	 * 
	 * Method to implement as HealingItem.java extends Collectable.java. 
	 * When this method is called the selected Hero object recovers health 
	 * depending on the HealingItem type and on their currentHealth.
	 * This is achieved running the Hero recovery on a different thread, 
	 * which simplified the Hero object currentHealth property tracking process.
	 * 
	 */
	public void apply(Hero hero) {
		new Thread(new Runnable() {
			public void run() {
				Integer recoverable = recoverableHP;
				while (hero.getHealth() < hero.getMaxHealth() && recoverable > 0) {
					hero.setHealth(hero.getHealth() + 1);
					recoverable--;
					try {
						Thread.sleep(3600);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}


	/**
	 * 
	 * Overridden toString() method.
	 * It returns a String object containing the type of the HealingItem object, its cost and a brief description. 
	 * 
	 */
	public String toString() {
		return "Healing item of type: " + getCollectableID() + ".\n"
				+ "Using this item the hero will recover " + getRecoverableHP() + " HP.\n"
				+ "The cost of this item is " + getCost() + " coins.";
	}
	
}
