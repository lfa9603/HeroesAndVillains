package collectables.powerUp;

import characters.Hero;

public class GameChooser extends PowerUp{

	public GameChooser(PowerUpType powerUptype) {
		super(powerUptype);
	}

	public void applyPowerUp(Hero hero) {
		hero.setIsGameChooser(true);
	}

}
