package collectables.heroesMap;

import characters.HeroesSquad;
import collectables.Collectable;
import collectables.Money;

public class HeroesMap implements Collectable {

	private Money cost;
	
	@Override
	public Money getCost() {
		return cost;
	}
	
	public void apply(HeroesSquad heroSquad) {
		heroSquad.setHaveMap(true);
	}

}
