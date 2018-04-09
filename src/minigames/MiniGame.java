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
		runBattle(selectedGame, hero, villain);
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
		
		String rock = "Rock";
		String paper = "Paper";
		String scissors = "Scissors";
		
		String youChoose = "you choose";
		String villianChoose = villain.getCharacterName() + " choose";
		
		
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
		// TODO Auto-generated method stub
		
	}

	private void diceWars(Hero hero, Villain villain) {
		// TODO Auto-generated method stub
		
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
	}
	
	public void herolosses() {
		System.out.println("You lost! " + villain.getVillainDamage() + "HP");
		hero.takeDamage(villain.getVillainDamage());
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
		hero1.setisAlive(false);
		
		Villain testVillain = new Villain("Lorenzo", "Italian", "PastaFart", "Ciao bella dona ;p", 50);
		MiniGame game = new MiniGame(testVillain, testsquad, 1);
		
	}
	
}
