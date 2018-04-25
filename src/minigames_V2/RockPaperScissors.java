package minigames_V2;

import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;
import engine.Icons;
import engine.Utilities;
import engine.VisualUtilities;

public class RockPaperScissors extends MiniGame {
	private Villain villain;
	private HeroesSquad squad;

	public RockPaperScissors(Games game, Villain givenVillain, HeroesSquad theSquad, boolean gotAbilities) {
		super(game, givenVillain, theSquad, gotAbilities);
		villain = givenVillain;
		squad = theSquad;
		
	}
	
	public void runGame(Hero hero) {
		String choices = "1) Rock \n"
				+ "2) Paper \n"
				+ "3) Scissors \n";
		
		String rock = " Rock";
		String paper = " Paper";
		String scissors = " Scissors";
		
		String youChoose = "you chose ";
		String villianChoose = villain.getCharacterName() + " chose ";
		
		
		System.out.println("You are playing Rock, Paper, Sissors!");
		System.out.println("The rules are: TODO add rules");
		System.out.println(choices);
		
		VisualUtilities.getIcon(Icons.bar);		
		int villainChoice = villain.getVillainsChoice(3);
		MiniGameUtilities.getHeroAbiltyEffects(hero, villain, squad, villainChoice, 1);
		VisualUtilities.getIcon(Icons.bar);
		
		int choice = Utilities.getChoice("Choose a number between 1-3 to select Rock, Paper or Scissors respectivly", 1, 3);
		
		switch(choice) {
		
		case 1: System.out.println(youChoose + gameResourses.Rock); 
			switch(villainChoice) {
			case 1: System.out.println(villianChoose + gameResourses.Rock); battleDraw(hero); break;
			case 2: System.out.println(villianChoose + gameResourses.Rock); herolosses(hero); break;
			case 3: System.out.println(villianChoose + gameResourses.Rock); heroWins(hero); break;
			}; break;
			
		case 2: System.out.println(youChoose + paper); 
			switch(villainChoice) {
			case 1: System.out.println(villianChoose + gameResourses.Rock); heroWins(hero); break;
			case 2: System.out.println(villianChoose + gameResourses.Paper); battleDraw(hero); break;
			case 3: System.out.println(villianChoose + gameResourses.Scissors); herolosses(hero); break;
			}; break;
			
		case 3: System.out.println(youChoose + scissors); 
			switch(villainChoice) {
			case 1: System.out.println(villianChoose + gameResourses.Rock); herolosses(hero); break;
			case 2: System.out.println(villianChoose + gameResourses.Paper); heroWins(hero); break;
			case 3: System.out.println(villianChoose + gameResourses.Scissors); battleDraw(hero); break;
			};break;
			
		}

}
}
