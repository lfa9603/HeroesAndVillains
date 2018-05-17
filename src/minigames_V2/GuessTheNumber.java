package minigames_V2;

import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;
import engine.Utilities;

public class GuessTheNumber extends MiniGame{
	
	private Villain villain;
	private HeroesSquad squad;
	private String battleResult;

	public GuessTheNumber(Games game, Villain givenVillain, HeroesSquad theSquad, boolean gotAbilities) {
		super(game, givenVillain, theSquad, gotAbilities);
		villain = givenVillain;
		squad = theSquad;
		
	}

	@Override
	public void runGame(Hero hero) {
		int heroTrys = 0;
		System.out.println("Your Playing guess the number! \n"
				+ "The rules are: TODO add rules \n"
				+ "The Villain has chosen a number. \n");
		villain.setVillainsChoice(10);
		int villainChoice = villain.getVillainsChoice();
		
		MiniGameUtilities.getHeroAbiltyEffects(hero, villain, squad, villainChoice, 2);
		
		while (heroTrys < 2) {
			int choice = Utilities.getChoice("Choose a number between 1-10 you have two chances to get it right", 1, 10);
			if (choice == villainChoice) {
				heroWins(hero);
				break;
			}
			
			else {
				if (choice > villainChoice) {
					System.out.println("Villain says: Lower");
					heroTrys += 1;
				}
				else {
					System.out.println("Villain says: Higher");
					heroTrys += 1;
				}
			}
		}
		if (heroTrys >= 2) {
			herolosses(hero);
		}
		
	}
	
	public void runGuiGame(Hero hero, int playersChoice) {
		int villainChoice = villain.getVillainsChoice();
		System.out.println("Villains choice: " + villainChoice);
		String result = "";
		
		if (MiniGameEngine.getGuessesInGTN() == 1) {
			if (playersChoice == villainChoice) {
				MiniGameEngine.setHeroWonGTN(true);
				result = guiheroWins(hero);
			}
			
			else {
				if (playersChoice > villainChoice) {
					result = ("Villain says: Lower");
				}
				else {
					result = ("Villain says: Higher");
				}
			}
		}
		else {
			if (playersChoice == villainChoice) {
				MiniGameEngine.setHeroWonGTN(true);
				result = guiheroWins(hero);
			}
			
			else {
				result = guiherolosses(hero);
			}
		}
		battleResult = result;
	}

	/**
	 * @return the battleResults
	 */
	public String getBattleResult() {
		return battleResult;
	}

	/**
	 * @param battleResults the battleResults to set
	 */
	public void setBattleResult(String battleResults) {
		this.battleResult = battleResults;
	}


}
