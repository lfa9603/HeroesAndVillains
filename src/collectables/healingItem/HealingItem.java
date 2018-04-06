package collectables.healingItem;

import characters.Hero;
import collectables.Collectable;
import collectables.Money;

public class HealingItem implements Collectable {

	private Money cost;
	private int recoverableHP;
	private HealingItemType healingItemType;
	
	public HealingItem(HealingItemType type) {
		healingItemType = type;
		setCost();
		setRecoverableHP();
	}
	
	public int getRecoverableHP() {
		return recoverableHP;
	}

	private void setRecoverableHP() {
		switch (healingItemType) {
			case GoodAntidote:
				recoverableHP = 25;
				break;
			case BetterAntidote:
				recoverableHP = 50;
				break;
			case BestAntidote:
				recoverableHP = 75;
				break; 
		}
			
	}

	private void setCost() {
		switch (healingItemType) {
			case GoodAntidote:
				cost = new Money(25);
				break;
			case BetterAntidote:
				cost = new Money(50);
				break;
			case BestAntidote:
				cost = new Money(75);
				break;
		}
	}

	public Money getCost() {
		return cost;
	}
	
	
	//TODO: find best way to retrieve the max health of a hero.
	
	public static void startHealing(Hero hero, int recoverableHP) {
		new Thread(new Runnable() {
			public void run() {
				while (hero.getHealth() <= hero.getMaxHealth() && recoverableHP > 0) {
					hero.setHealth(hero.getHealth() + 1);
					recoverableHP--;
					Thread.sleep(3600);
				}
			}
		}).start();
	}
	
	
}
