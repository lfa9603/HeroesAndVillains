package collectables.powerUp;

import characters.Hero;
import collectables.CollectableID;

public class GameChooser extends PowerUp{

	

	public GameChooser(CollectableID collectID) {
		super(collectID);
		// TODO Auto-generated constructor stub
	}

	public void apply(Hero hero) {
		hero.setIsGameChooser(true);
	}


}
