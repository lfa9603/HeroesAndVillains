package collectables.healingItem;

import characters.Hero;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Money;

public class HealingItem extends Collectable {

	private int recoverableHP;
	
	public HealingItem(CollectableID type) {
		super(type);
		setRecoverableHP();
		setHealingItemCost();
	}
	
	public int getRecoverableHP() {
		return recoverableHP;
	}

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
	
	
	//TODO: find best way to retrieve the max health of a hero.
	
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


	public String toString() {
		return "Healing item of type: " + getCollectableID() + ".\n"
				+ "Using this item the hero will recover " + getRecoverableHP() + " HP.\n"
				+ "The cost of this item is " + getCost() + " coins.";
	}
	
}
