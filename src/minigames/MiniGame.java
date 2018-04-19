package minigames;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import characters.Villain;
import collectables.Money;
import engine.Icons;
import engine.Utilities;
import engine.VisualUtilities;

public class MiniGame {
	private Hero hero;
	private HeroesSquad squad;
	private Villain villain;
	private int selectedGame; 

	public MiniGame(Villain givenVillain, HeroesSquad theSquad, int selectedMiniGame) {
		villain = givenVillain;
		squad = theSquad;
		selectedGame = selectedMiniGame;
		while (squad.isAllDead() == false && villain.isBeaten() == false) {
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			System.out.println("The Game will be " + getGame(selectedMiniGame));
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			villainEffects(givenVillain, theSquad);
			squad.checkTeamStatus();
			if (squad.isAllDead()) {
				break;
			}
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			
			selectHero();
			
			VisualUtilities.getIcon(Icons.bar);
			
			runBattle(selectedGame, hero, villain);
			selectedMiniGame = selectNewGame(3);
		}
		
		if (villain.isBeaten() == true) {
			System.out.println("CONGRADULATIONS!!! you Won!!");
			
		}
		
		else {
			System.out.println("Oh no, that was tough, but so is life! \nGAMEOVER \nThanks for playing!");
		}
		
	}
	
	private void villainEffects(Villain villain, HeroesSquad squad) {
		int randInt = Utilities.getRandInt(100);
		if (randInt > 99) {
			System.out.println(villain.getCharacterName() + "Chose not to use there abilty.");
		}
		else {
			CharacterAbiltyEffects.getVillainAbiltyEffects(villain, squad);
		}
		
		
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
		selectedGame = Utilities.getRandInt(upperLimit);
		return selectedGame;		
	}

	private void runBattle(int selectedGame, Hero hero, Villain villain) {
		switch (selectedGame) {
		case 1: rockPaperScissors(hero, villain); break;
		case 2: guessTheNumber(hero, villain); break;
		case 3: diceWars(hero, villain); break;
		}
		
	}


	private void rockPaperScissors(Hero hero, Villain villain) {
		String choices = "1) Rock \n"
				+ "2) Paper \n"
				+ "3) Scissors \n";
		
		String rock = " Rock";
		String paper = " Paper";
		String scissors = " Scissors";
		
		String youChoose = "you chose ";
		String villianChoose = villain.getCharacterName() + " chose";
		
		
		System.out.println("You are playing Rock, Paper, Sissors!");
		System.out.println("The rules are: TODO add rules");
		System.out.println(choices);
		
		VisualUtilities.getIcon(Icons.bar);		
		int villainChoice = villain.getVillainsChoice(3);
		CharacterAbiltyEffects.getHeroAbiltyEffects( hero, villain, squad, villainChoice, 1);
		VisualUtilities.getIcon(Icons.bar);
		
		int choice = Utilities.getChoice("Choose a number between 1-3 to select Rock, Paper or Scissors respectivly", 1, 3);
		
		switch(choice) {
		
		case 1: System.out.println(youChoose + rock); 
			switch(villainChoice) {
			case 1: System.out.println(villianChoose + rock); battleDraw(); break;
			case 2: System.out.println(villianChoose + paper); herolosses(); break;
			case 3: System.out.println(villianChoose + scissors); heroWins(); break;
			}; break;
			
		case 2: System.out.println(youChoose + paper); 
			switch(villainChoice) {
			case 1: System.out.println(villianChoose + rock); heroWins(); break;
			case 2: System.out.println(villianChoose + paper); battleDraw(); break;
			case 3: System.out.println(villianChoose + scissors); herolosses(); break;
			}; break;
			
		case 3: System.out.println(youChoose + scissors); 
			switch(villainChoice) {
			case 1: System.out.println(villianChoose + rock); herolosses(); break;
			case 2: System.out.println(villianChoose + paper); heroWins(); break;
			case 3: System.out.println(villianChoose + scissors); battleDraw(); break;
			};break;
			
		}
		
		
		
	}

	private void guessTheNumber(Hero hero, Villain villain) {
		int heroTrys = 0;
		System.out.println("Your Playing guess the number! \n"
				+ "The rules are: TODO add rules \n"
				+ "The Villain has chosen a number. \n");
		int villainChoice = villain.getVillainsChoice(10);
		
		CharacterAbiltyEffects.getHeroAbiltyEffects(hero, villain, squad, villainChoice, 2);
		
		while (heroTrys < 2) {
			int choice = Utilities.getChoice("Choose a number between 1-10 you have two chances to get it right", 1, 10);
			if (choice == villainChoice) {
				heroWins();
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
			herolosses();
		}
		
	}

	private void diceWars(Hero hero, Villain villain) {
		System.out.println("You are playing Dice Wars! \n"
				+ "TODO Add rules \n"
				+ "whoever rolls the highest number on the dice wins.");
		int rollDice = Utilities.getChoice("Press 1 to roll the dice", 1, 1);
		if (rollDice == 1) {
			int roll = Utilities.getRandInt(6);
			System.out.println("You roll a " + roll);
			int villainRoll = villain.getVillainsChoice(6);
			System.out.println(villain.getCharacterName() + " rolls a " + villainRoll);
			CharacterAbiltyEffects.getHeroAbiltyEffects(hero, villain, squad, villainRoll, 3);
			if (roll > villainRoll) {
				heroWins();
			}
			else {
				if (roll == villainRoll) {
					battleDraw();
				}
				else {
					herolosses();
				}
			}
		}
		
	}

	public void selectHero() {
		
		String avaliableHeros = squad.toString();
		System.out.println(avaliableHeros);
		
		VisualUtilities.getIcon(Icons.bar);
		System.out.println("Please select a Hero to fight with:");
		VisualUtilities.getIcon(Icons.bar);
		int choice = Utilities.getChoice("Please Choose a number between 1 and 3 to select your hero: ", 1, 3);		
		Hero possiblechoice = squad.getHero((choice-1));
		if (possiblechoice.isinDetention) {
			System.out.println(hero.getCharacterName() + "is in detention, he can't fight");
		}
		else {
			if (possiblechoice.isAlive() == true) {
				hero = squad.getHero((choice-1));
				System.out.println("Your choice was: " + hero.getCharacterName());	
			}
			
			else {
				System.out.println("Dead Heroes cannot fight! please select a valid hero");
				selectHero();
			}
		}
	}
	
	public void battleDraw() {
		System.out.println("Its a Draw!");
		if (villain.getCharacterType() != Types.Boss && hero.getCharacterType() == Types.sly) {
			System.out.println("Who dares Wins! Your Character is Sly, and you managed to cheat your way through this draw.");
			heroWins();
		}
		else {
			if (villain.getCharacterType() == Types.Boss) {
				System.out.println("Your Boss is NEVER wrong, they win this Draw!");
				herolosses();
			}
			else {
				System.out.println("No damage done");
			}
		}
	}
	
	public void heroWins() {
		System.out.println("You win! the villain has been defeated!");
		villain.setTimesBeaten();
		System.out.println("You have beaten the Villain " + villain.getTimesBeaten() + " times, "
				+ "you must beat hime three times to defeat him and move on to the next level");
	}
	
	public void herolosses() {
		System.out.println("You lost " + villain.getVillainDamage() + "HP");
		squad.heroTakesDamage(hero, villain.getVillainDamage());
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
		testsquad.addHero(hero3);
		testsquad.addHero(hero4);
		hero2.setisAlive(false);
		hero3.setisAlive(false);
//		hero3.setisAlive(false);
		testsquad.checkTeamStatus();
		Money wallet = testsquad.getWallet();
		
		
		Villain testVillain = new Villain("Lorenzo", Types.level_1, Abilities.detention, "Ciao bella dona ;p", 10);
//		testVillain.setBeaten(true);
		testVillain.setTimesBeaten();
		testVillain.setTimesBeaten();
		
		MiniGame game = new MiniGame(testVillain, testsquad, 1);
		System.out.println(wallet);
		
	}
	
}
