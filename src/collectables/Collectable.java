package collectables;

import characters.Hero;

public interface Collectable {
		
	public Money getCost();
	public void apply(Hero hero);
}
