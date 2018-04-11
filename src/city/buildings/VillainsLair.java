package city.buildings;

import characters.HeroesSquad;
import engine.Utilities;

public class VillainsLair extends Building {

	public VillainsLair(String name, TypeBuildings buildType) {
		super(name, buildType);
	}

	@Override
	public void interact(HeroesSquad heroesSquad) {
		Utilities.runMinigame(heroesSquad);
	}
}
