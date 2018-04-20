package minigames_V2;

import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;
import engine.Icons;
import engine.Utilities;
import engine.VisualUtilities;
import minigames.CharacterAbiltyEffects;

public abstract class RockPaperScissors extends MiniGame {

	public RockPaperScissors(Games game, Villain givenVillain, HeroesSquad theSquad, boolean gotAbilities) {
		super(game, givenVillain, theSquad, gotAbilities);
		
	}
	
	private void runGame(Hero hero, Villain villain, HeroesSquad squad) {
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
}
