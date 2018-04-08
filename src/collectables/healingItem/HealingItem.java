package collectables.healingItem;

import characters.Hero;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Money;

public class HealingItem implements Collectable {

	private Money cost;
	private int recoverableHP;
	private CollectableID collectableID;
	
	public HealingItem(CollectableID type) {
		collectableID = type;
		setCost();
		setRecoverableHP();
	}
	
	public int getRecoverableHP() {
		return recoverableHP;
	}

	private void setRecoverableHP() {
		switch (collectableID) {
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

	private void setCost() {
		switch (collectableID) {
			case GoodHealingItem:
				cost = new Money(25);
				break;
			case BetterHealingItem:
				cost = new Money(50);
				break;
			case BestHealingItem:
				cost = new Money(75);
				break;
			default: 
				break;
		}
	}

	public Money getCost() {
		return cost;
	}
	
	
	//TODO: find best way to retrieve the max health of a hero.
	
	public void apply(Hero hero) {
		new Thread(new Runnable() {
			public void run() {
				Integer recoverable = recoverableHP;
				while (hero.getHealth() <= hero.getMaxHealth() && recoverable > 0) {
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

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Money cost) {
		this.cost = cost;
	}

	public String toString() {
		return "Healing item of type: " + collectableID + ".\n"
				+ "Using this item the hero will recover " + recoverableHP + " HP.\n"
				+ "The cost of this item is " + cost + " coins.";
	}
	
}
