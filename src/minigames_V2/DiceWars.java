package minigames_V2;

import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;
import engine.Utilities;

public class DiceWars extends MiniGame{
	
	private Villain villain;
	private HeroesSquad squad;
	

	public DiceWars(Games game, Villain givenVillain, HeroesSquad theSquad, boolean gotAbilities) {
		super(game, givenVillain, theSquad, gotAbilities);
		villain = givenVillain;
		squad = theSquad;
		
	}

	@Override
	public void runGame(Hero hero) {
		System.out.println("You are playing Dice Wars! \n"
				+ "TODO Add rules \n"
				+ "whoever rolls the highest number on the dice wins.");
		int rollDice = Utilities.getChoice("Press 1 to roll the dice", 1, 1);
		if (rollDice == 1) {
			int roll = Utilities.getRandInt(6);
			System.out.println("You roll a " + roll);
			int villainRoll = villain.getVillainsChoice(6);
			System.out.println(villain.getCharacterName() + " rolls a " + villainRoll);
			MiniGameUtilities.getHeroAbiltyEffects(hero, villain, squad, villainRoll, 3);
			if (roll > villainRoll) {
				heroWins(hero);
			}
			else {
				if (roll == villainRoll) {
					battleDraw(hero);
				}
				else {
					herolosses(hero);
				}
			}
		}
		
	}
	
	

}
