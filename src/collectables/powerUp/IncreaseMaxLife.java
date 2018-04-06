package collectables.powerUp;

import characters.Hero;

public class IncreaseMaxLife extends PowerUp {

	public IncreaseMaxLife(PowerUpType powerUptype) {
		super(powerUptype);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyPowerUp(Hero hero) {
		hero.setMaxHealth(125);
	}

	
	
}
