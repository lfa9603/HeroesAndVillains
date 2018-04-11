package city.buildings;


import characters.HeroesSquad;
import characters.Villain;
import engine.Engine;
import engine.Utilities;
import minigames.MiniGame;

public class VillainsLair extends Building {

	public VillainsLair(String name, TypeBuildings buildType) {
		super(name, buildType);
	}

	@Override
	public void interact(HeroesSquad heroesSquad) {
		Villain villain = Engine.getCurrentVillain();
		int startingGame = Utilities.getRandInt(3);
				
		new MiniGame(villain, heroesSquad, startingGame);
	}
}
