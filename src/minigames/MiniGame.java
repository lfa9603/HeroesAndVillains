package minigames;

import java.util.Random;

import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;
import engine.Utilities;

public class MiniGame {
	private Hero hero;
	private HeroesSquad squad;
	private Villain villain;
	private int selectedGame;
	
	public int getNewMiniGame() {
		Random random = new Random();
		Integer randInt = random.nextInt(3);
		int newGame = randInt + 1;
		return newGame;
	}

	public MiniGame(Villain givenVillain, HeroesSquad theSquad, int selectedMiniGame) {
		villain = givenVillain;
		squad = theSquad;
		selectedGame = selectedMiniGame;
		while (squad.isAllDead() == false && villain.isBeaten() == false) {
			selectHero();
			runBattle(selectedGame, hero, villain);
			selectedMiniGame = selectNewGame(3);
		}
		
		if (villain.isBeaten() == true) {
			System.out.println("CONGRADULATIONS!!! you Won!!");
		}
		
		else {
			System.out.println("Game over! \nThank you for playing!");
		}
		
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
		int choice = Utilities.getChoice("Choose a number between 1-3 to select Rock, Paper or Scissors respectivly", 1, 3);
		int villainChoice = villain.getVillainsChoice(3);
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
				+ "whoever rolls the highest number on the dice wins. The villain will win on a draw");
		int rollDice = Utilities.getChoice("Press 1 to roll the dice", 1, 1);
		if (rollDice == 1) {
			int roll = Utilities.getRandInt(6);
			System.out.println("You roll a " + roll);
			int villainRoll = villain.getVillainsChoice(6);
			System.out.println(villain.getCharacterName() + " rolls a " + villainRoll);
			if (roll > villainRoll) {
				heroWins();
			}
			else {
				herolosses();
			}
		}
		
	}

	public void selectHero() {
		
		String avaliableHeros = squad.toString();
		System.out.println(avaliableHeros + "\n");
		
		System.out.println("Please select a Hero to fight with:");
		int choice = Utilities.getChoice("Please Choose a number between 1 and 3 to select your hero: ", 1, 3);		
		Hero possiblechoice = squad.getHero((choice-1));
		if (possiblechoice.isAlive() == true) {
			hero = squad.getHero((choice-1));
			System.out.println("Your choice was: " + hero.getCharacterName());	
		}
		
		else {
			System.out.println("Dead Heroes cannot fight! please select a valid hero");
			selectHero();
		}
		
		
	}
	
	public void battleDraw() {
		System.out.println("Its a Draw! No Damage dealt.");
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
		Hero hero1 = new Hero("hero1", "Be cool", "specialAbility_1");
		Hero hero2 = new Hero("hero2", "Have some swag", "specialAbility_2");
		Hero hero3 = new Hero("hero3","Be the man", "specialAbility_3");
		HeroesSquad testsquad = new HeroesSquad();
		testsquad.addHero(hero1);
		testsquad.addHero(hero2);
		testsquad.addHero(hero3);
//		hero1.setisAlive(false);
//		hero2.setisAlive(false);
//		hero3.setisAlive(false);
		testsquad.checkTeamStatus();
		
		Villain testVillain = new Villain("Lorenzo", "Italian", "PastaFart", "Ciao bella dona ;p", 50);
//		testVillain.setBeaten(true);
		
		MiniGame game = new MiniGame(testVillain, testsquad, 3);
		
	}
	
}
