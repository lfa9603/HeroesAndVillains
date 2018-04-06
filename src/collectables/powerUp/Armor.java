package collectables.powerUp;

import characters.Hero;

public class Armor extends PowerUp {

	public Armor(PowerUpType powerUptype) {
		super(powerUptype);
	}

	@Override
	public void applyPowerUp(Hero hero) {
		hero.setHasArmor(true);
	}

	
}
