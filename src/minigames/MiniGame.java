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
		selectHero();
		runGame(selectedGame, hero, villain);
	}
	
	private void runGame(int selectedGame, Hero hero, Villain villain) {
		switch (selectedGame) {
		case 1: rockPaperScissors(hero, villain); break;
		case 2: guessTheNumber(hero, villain); break;
		case 3: diceWars(hero, villain); break;
		}
		
	}


	private void rockPaperScissors(Hero hero2, Villain villain2) {
		String choices = "1) Rock \n"
				+ "2) Paper \n"
				+ "3) Scissors";
		
		System.out.println("You are playing Rock, Paper, Sissors!");
		System.out.println("The rules are: TODO add rules");
		System.out.println("");
		
		
	}

	private void guessTheNumber(Hero hero2, Villain villain2) {
		// TODO Auto-generated method stub
		
	}

	private void diceWars(Hero hero2, Villain villain2) {
		// TODO Auto-generated method stub
		
	}

	public void selectHero() {
//		Scanner input = new Scanner(System.in);
		
		String avaliableHeros = squad.toString();
		System.out.println(avaliableHeros + "\n");
		
		System.out.println("Please select a Hero to fight with:");
		int choice = Utilities.getChoice("Please Choose a number between 1 and 3 to select your hero: ", 1, 3);
//		System.out.println("Your choice was: " + choice);		
		hero = squad.getHero((choice-1));
		System.out.println("Your choice was: " + hero.getCharacterName());	
	}
	
	
	
//  For testing
	public static void main(String[] args) {
//		TeamBuilder team = new TeamBuilder();
		Hero hero1 = new Hero("hero1", "Be cool", "specialAbility_1");
		Hero hero2 = new Hero("hero2", "Have some swag", "specialAbility_2");
		Hero hero3 = new Hero("hero3","Be the man", "specialAbility_3");
		HeroesSquad testsquad = new HeroesSquad();
		testsquad.addHero(hero1);
		testsquad.addHero(hero1);
		testsquad.addHero(hero2);
		testsquad.addHero(hero3);
		
		Villain testVillain = new Villain("Lorenzo", "Italian", "PastaFart", "Ciao bella dona ;p");
		MiniGame game = new MiniGame(testVillain, testsquad, 1);
		
	}
	
}
