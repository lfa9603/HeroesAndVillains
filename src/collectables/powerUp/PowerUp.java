package collectables.powerUp;

import characters.Hero;
import collectables.Collectable;
import collectables.Money;

public abstract class PowerUp implements Collectable {

	private Money cost;
	private PowerUpType powerUpType;
	
	
	
	public PowerUp(PowerUpType powerUptype) {
		powerUpType = powerUptype;
	}
	
	public PowerUpType getPowerUpType() {
		return powerUpType;
	}

	public void setPowerUpType(PowerUpType powerUpType) {
		this.powerUpType = powerUpType;
	}

	public void setCost(Money cost) {
		this.cost = cost;
	}

	public Money getCost() {
		return cost;
	}
	
	public abstract void applyPowerUp(Hero hero);
	
	

}
