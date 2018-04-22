package minigames_V2;

import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;
import engine.Icons;
import engine.Utilities;
import engine.VisualUtilities;

public class MiniGameEngine {

	public void runMiniGameEngine(Villain villain, HeroesSquad squad, int selectedMiniGame) {

		while (squad.isAllDead() == false && villain.isBeaten() == false) {
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			System.out.println("The Game will be " + getGame(selectedMiniGame));
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			MiniGameUtilities.getVillainAbiltyEffects(villain, squad);
			squad.checkTeamStatus();
			if (squad.isAllDead()) {
				break;
			}
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			
			Hero hero = selectHero(squad);
			
			VisualUtilities.getIcon(Icons.bar);
			
//			runBattle(selectedMiniGame, hero, villain);
			
			switch (selectedMiniGame) {
			case 1: RockPaperScissors RPS = RockPaperScissors(Games.RPS, villain, squad, false); 
			RPS.runGame(hero); break;
			case 2: result = "Guess the Number out of Ten"; break;
			case 3: result = "Dice Wars"; break;
			}
			
			selectedMiniGame = selectNewGame(3);
		}
		
		if (villain.isBeaten() == true) {
			System.out.println("CONGRADULATIONS!!! you Won!!");
			MiniGame.setAbilitiesAvaliable(true);
			for (Hero hero: squad.getHeroSquad()) {
				if (hero.isinDetention) {
					hero.setIsinDetention(false);
				}
			}
			
		}
		
		else {
			System.out.println("Oh no, that was tough, but so is life! \nGAMEOVER \nThanks for playing!");
		}
		
	}
	
	public Hero selectHero(HeroesSquad squad) {
		
		String avaliableHeros = squad.toString();
		System.out.println(avaliableHeros);
		int squadSize = squad.getLength();
		
		VisualUtilities.getIcon(Icons.bar);
		System.out.println("Please select a Hero to fight with:");
		VisualUtilities.getIcon(Icons.bar);
		int choice = Utilities.getChoice("Please Choose a number between 1 and " + squadSize + " to select your hero: ", 1, squadSize);		
		Hero possiblechoice = squad.getHero((choice-1));
		if (possiblechoice.isinDetention) {
			System.out.println(possiblechoice.getCharacterName() + "is in detention, he can't fight");
		}
		else {
			if (possiblechoice.isAlive() == true) {
				Hero hero = squad.getHero((choice-1));
				System.out.println("Your choice was: " + hero.getCharacterName());
				return hero;
			}
			
			else {
				System.out.println("Dead Heroes cannot fight! please select a valid hero");
				selectHero(squad);
			}
		}
		return null;
	}
	
	private String getGame(int selectedMiniGame) {
		String result = "";
		switch (selectedMiniGame) {
		case 1: result = "Paper, Scissors, Rock"; break;
		case 2: result = "Guess the Number out of Ten"; break;
		case 3: result = "Dice Wars"; break;
		}
		
		return result;
	}
	
	private int selectNewGame(int upperLimit) {
		int selectedGame = Utilities.getRandInt(upperLimit);
		return selectedGame;		
	}
	
	

}
