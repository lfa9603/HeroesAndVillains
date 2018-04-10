package LorenzosIdeaForMiniGame;

import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;

public class RandomMiniGameLorenzoRandomlyImplemented {

	
	private Hero hero;
	private Villain villain;
	private HeroesSquad squad;
	
	public RandomMiniGameLorenzoRandomlyImplemented(Hero h, HeroesSquad theSquad, Villain v) {
		hero = h;
		villain = v;
		squad = theSquad;
	}
	
	public void heroWins() {
		villain.setTimesBeaten();
	}
	
	public void villainWins() {
		squad.heroTakesDamage(hero, villain.getVillainDamage());
	}
	
	public void battleDraw() {
		System.out.println("Do again!!");
	}
	
	
	
}
