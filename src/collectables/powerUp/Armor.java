package collectables.powerUp;

import characters.Hero;
import collectables.CollectableID;

public class Armor extends PowerUp {

	public Armor(CollectableID collectID) {
		super(collectID);
	}

	@Override
	public void apply(Hero hero) {
		hero.setHasArmor(true);
	}


	
}
