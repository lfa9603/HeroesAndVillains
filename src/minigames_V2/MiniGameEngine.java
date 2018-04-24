package minigames_V2;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import characters.Villain;
import collectables.Money;
import engine.Icons;
import engine.Utilities;
import engine.VisualUtilities;
import minigames.CharacterAbiltyEffects;
import minigames.MiniGame;

public class MiniGameEngine {

	public void runMiniGameEngine(Villain villain, HeroesSquad squad) {

		while (squad.isAllDead() == false && villain.isBeaten() == false) {
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			int selectedMiniGame = selectNewGame(3);
			System.out.println("The Game will be " + getGame(selectedMiniGame));
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			villainEffects(villain, squad);
			squad.checkTeamStatus();
			if (squad.isAllDead()) {
				break;
			}
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			
			Hero hero = selectHero(squad);
			
			VisualUtilities.getIcon(Icons.bar);
			
			switch (selectedMiniGame) {
			case 1: RockPaperScissors RPS = new RockPaperScissors(Games.RPS, villain, squad, false); 
			RPS.runGame(hero); break;
			case 2: GuessTheNumber GTN = new GuessTheNumber(Games.RPS, villain, squad, false); 
			GTN.runGame(hero); break;
			case 3: DiceWars DW = new DiceWars(Games.RPS, villain, squad, false); 
			DW.runGame(hero); break;
			}
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
	
	private void villainEffects(Villain villain, HeroesSquad squad) {
		int randInt = Utilities.getRandInt(100);
		Types level = villain.getCharacterType();
		int difficulty = 5;
		
		//Sets how often the villains ability will be activated, this will help adjust the games difficulty.
		switch (level) {
		case level_1: difficulty = 30; break;
		case level_2: difficulty = 10; break;
		case level_3: difficulty = 30; break;
		case level_4: difficulty = 40; break;
		case level_5: difficulty = 50; break;
		case Boss: difficulty = 100; break;
		default: difficulty = 10; break;
		}
		
		if (randInt > difficulty) {
			System.out.println(villain.getCharacterName() + " Chose not to use there abilty.");
		}
		else {
			CharacterAbiltyEffects.getVillainAbiltyEffects(villain, squad);
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
	
	//  For testing
	public static void main(String[] args) {
//		TeamBuilder team = new TeamBuilder();
		Hero hero1 = new Hero("hero1", Types.talkitive, Abilities.charm);
		Hero hero2 = new Hero("hero2", Types.smart, Abilities.mystery);
		Hero hero3 = new Hero("hero3", Types.practical, Abilities.betterOdds);
		Hero hero4 = new Hero("hero4", Types.strong, Abilities.lessDamage);
		Hero hero5 = new Hero("hero5",Types.sly, Abilities.winDraws);
		Hero hero6 = new Hero("hero3",Types.dog, Abilities.goodBoy);
		HeroesSquad testsquad = new HeroesSquad();
		testsquad.addHero(hero2);
//		testsquad.addHero(hero3);
//		testsquad.addHero(hero5);
//		hero2.setisAlive(false);
//		hero3.setisAlive(false);
//		hero3.setisAlive(false);
		testsquad.checkTeamStatus();
		hero2.setArmor(30);
		Money wallet = testsquad.getWallet();
		
		
		Villain testVillain = new Villain("Lorenzo", Types.level_1, Abilities.stealLunchMoney, "Ciao bella dona ;p", 10);
//		testVillain.setBeaten(true);
//		testVillain.setTimesBeaten();
//		testVillain.setTimesBeaten();
		
		MiniGameEngine game = new MiniGameEngine();	
		game.runMiniGameEngine(testVillain, testsquad);
		
		System.out.println(wallet);
		
	}
	

}