package characters;

import java.util.ArrayList;
import city.buildings.collectables.HeroesMap;

/**
 * 
 * @author LorenzoFasano
 *Collection of Character objects stored in an ArrayList 
 */
public class HeroesSquad {

	private boolean haveMap;
	private HeroesMap map;


	public HeroesSquad(ArrayList<Hero> listHeroes) {
		heroes = listHeroes;
		haveMap = false;
	}
	

	public boolean isHaveMap() {
		return haveMap;
	}


	public void setHeroes(ArrayList<Hero> heroes) {
		this.heroes = heroes;
	}


	public void setHaveMap(boolean haveMap) {
		this.haveMap = haveMap;
	}
	
	public HeroesMap getMap() {
		return map;
	}


	public void setMap(HeroesMap map) {
		this.map = map;
	}
	
}
