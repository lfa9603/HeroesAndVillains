package collectables.powerUp;

import characters.Hero;
import collectables.CollectableID;

public class IncreaseMaxLife extends PowerUp {

	
	public IncreaseMaxLife(CollectableID collectID) {
		super(collectID);
	}

	@Override
	public void apply(Hero hero) {
		hero.setMaxHealth(125);
	}

	
	
}
