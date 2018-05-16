package minigames_V2;

import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;
import engine.Icons;
import engine.Utilities;
import engine.VisualUtilities;


 /**
 * @author JayHamilton
 *
 */
public class RockPaperScissors extends MiniGame {
//	private Villain villain;
//	private HeroesSquad squad;
	private int villainChoice;
	private String battleResult;

	public RockPaperScissors(Games game, Villain givenVillain, HeroesSquad theSquad, boolean gotAbilities) {
		super(game, givenVillain, theSquad, gotAbilities);
//		villain = givenVillain;
//		squad = theSquad;
		
		
	}
	
	public void runGame(Hero hero) {
		String choices = "1) Rock \n"
				+ "2) Paper \n"
				+ "3) Scissors \n";
		
//		String rock = " Rock";
//		String paper = " Paper";
//		String scissors = " Scissors";
		
		String youChoose = "you chose ";
		String villianChoose = getVillain().getCharacterName() + " chose ";
		
		
		System.out.println("You are playing Rock, Paper, Sissors!");
		System.out.println("The rules are: TODO add rules");
		System.out.println(choices);
		
		VisualUtilities.getIcon(Icons.bar);
		getVillain().setVillainsChoice(3);
		int villainChoice = getVillain().getVillainsChoice();
		MiniGameUtilities.getHeroAbiltyEffects(hero, getVillain(), getSquad(), villainChoice, 1);

		VisualUtilities.getIcon(Icons.bar);
		
//		int villainChoice = getVillain().getVillainsChoice(3);
		
//		MiniGameUtilities.getHeroAbiltyEffects(hero, getVillain(), getSquad(), villainChoice, 1);
//		
//		VisualUtilities.getIcon(Icons.bar);
		
		int choice = Utilities.getChoice("Choose a number between 1-3 to select Rock, Paper or Scissors respectivly", 1, 3);
		
		switch(choice) {
		
		case 1: System.out.println(youChoose + gameResourses.Rock); 
			switch(villainChoice) {
				case 1: System.out.println(villianChoose + gameResourses.Rock); battleDraw(hero); break;
				case 2: System.out.println(villianChoose + gameResourses.Rock); herolosses(hero); break;
				case 3: System.out.println(villianChoose + gameResourses.Rock); heroWins(hero); break;
			}; 
			break;
			
		case 2: 
			System.out.println(youChoose + gameResourses.Paper);
			switch(villainChoice) {
				case 1: System.out.println(villianChoose + gameResourses.Rock); heroWins(hero); break;
				case 2: System.out.println(villianChoose + gameResourses.Paper); battleDraw(hero); break;
				case 3: System.out.println(villianChoose + gameResourses.Scissors); herolosses(hero); break;
			}; 
			break;
			
		case 3: System.out.println(youChoose + gameResourses.Scissors);
			switch(villainChoice) {
				case 1: System.out.println(villianChoose + gameResourses.Rock); herolosses(hero); break;
				case 2: System.out.println(villianChoose + gameResourses.Paper); heroWins(hero); break;
				case 3: System.out.println(villianChoose + gameResourses.Scissors); battleDraw(hero); break;
			};
			break;
			
		}

}

	public void runGuiGame(Hero hero, int playerChoice) {
		villainChoice = getVillain().getVillainsChoice();
		String youChoose = "you chose ";
		System.out.println("in Minigame: PC:" + playerChoice + " VC: " + villainChoice);
		String result = "";
		switch(playerChoice) {
		
		case 1: System.out.println(youChoose + gameResourses.Rock); 
			switch(villainChoice) {
				case 1: result = guibattleDraw(hero); break;
				case 2: result = guiherolosses(hero); break;
				case 3: result = guiheroWins(hero); break;
			}; 
			break;
			
		case 2: 
			System.out.println(youChoose + gameResourses.Paper);
			switch(villainChoice) {
				case 1: result = guiheroWins(hero); break;
				case 2: result = guibattleDraw(hero); break;
				case 3: result = guiherolosses(hero); break;
			}; 
			break;
			
		case 3: System.out.println(youChoose + gameResourses.Scissors);
			switch(villainChoice) {
				case 1: result = guiherolosses(hero); break;
				case 2: result = guiheroWins(hero); break;
				case 3: result = guibattleDraw(hero); break;
			};
			break;	
		}
		System.out.println(result);
		setBattleResult(result);
	}

	/**
	 * @return the villainChoice
	 */
	public int getVillainChoice() {
		return villainChoice;
	}

	/**
	 * @param villainChoice the villainChoice to set
	 */
	public void setVillainChoice(int villainChoice) {
		this.villainChoice = villainChoice;
	}

	/**
	 * @return the battleResult
	 */
	public String getBattleResult() {
		return battleResult;
	}

	/**
	 * @param battleResult the battleResult to set
	 */
	public void setBattleResult(String battleResult) {
		this.battleResult = battleResult;
	}
}
