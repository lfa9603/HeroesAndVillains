package minigames;

import java.util.Scanner;

import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;

public class MiniGame {
	private Hero hero;
	private Villain villain;
	private int selectedGame;
	
	public MiniGame(Villain givenVillain, int selectedMiniGame) {
		villain = givenVillain;
		selectedGame = selectedMiniGame;
		selectHero();
	}
	
	public void selectHero() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please select a Hero to fight with:");
		HeroesSquad.to
		
	}
	

}
