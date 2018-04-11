package city.buildings;


import characters.HeroesSquad;
import characters.Villain;
import characters.Villains;
import engine.Engine;
import engine.Utilities;
import minigames.MiniGame;

public class VillainsLair extends Building {

	public VillainsLair(String name, TypeBuildings buildType) {
		super(name, buildType);
	}

	@Override
	public void interact(HeroesSquad heroesSquad) {
		int currentIndex = Engine.getCurrentIndex();
		Villains villains = Engine.getVillains();
		Villain villain = villains.getCurrentVillain(currentIndex);
		int startingGame = Utilities.getRandInt(3);
				
		new MiniGame(villain, heroesSquad, startingGame);
	}
}
