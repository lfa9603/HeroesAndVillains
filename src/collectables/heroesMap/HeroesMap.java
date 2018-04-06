package collectables.heroesMap;

import collectables.Collectable;
import collectables.Money;

public class HeroesMap implements Collectable {

	private Money cost;
	
	@Override
	public Money getCost() {
		return cost;
	}
	
	

}
