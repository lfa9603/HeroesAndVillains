package collectables.powerUp;

import characters.Hero;
import collectables.CollectableID;

public class Armor extends PowerUp {

	public Armor(CollectableID collectID) {
		super(collectID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void apply(Hero hero) {
		hero.setHasArmor(true);
	}


	
}
