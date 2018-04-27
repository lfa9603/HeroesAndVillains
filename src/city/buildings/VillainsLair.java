package city.buildings;


import characters.HeroesSquad;
import characters.Villain;
import engine.Engine;
import minigames_V2.MiniGameEngine;
/**
 * 
 * @author LorenzoFasano
 *VillainsLair class extends Building, its TypeBuildings type is VillainsLair and its builidngCoordinates 
 *are always a random value among (4, 0),(-4, 0)(0, 4) or (0, -4) (this last step happens in WorldBuilder class).
 */
public class VillainsLair extends Building {

	public VillainsLair(String name, TypeBuildings buildType) {
		super(name, buildType);
	}

	/**
	 *The method interact() is implemented such that it retrieves the right Villain object from the higher level class Engine and then instantiate 
     *a new MiniGame object passing it the villain and an initial random value between 0 and 2 to initiate one of the three random games available. 
	 */
	@Override
	public void interact(HeroesSquad heroesSquad) {
		Villain villain = Engine.getCurrentVillain();
				
//		new MiniGame(villain, heroesSquad);
		MiniGameEngine engine = new MiniGameEngine();
		engine.runMiniGameEngine(villain, heroesSquad);
	}
}
