package minigames_V2;

import characters.Abilities;
//import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import characters.Villain;
import collectables.Money;
//import collectables.Money;
import engine.Icons;
import engine.Utilities;
import engine.VisualUtilities;



/**
 * @author JayHamilton
 * This class controls the running of the minigame sequences, it prompts the user to select a hero to battle the villain, check to
 * see if the selected hero has any active powerups, or if the heros ability has an effect on the game, then it
 * constructs a minigame object in the moment that a minigame is required. The engine also checks to see if the villain 
 * is beaten or if all the heros are dead, after each battle sequence, the loop continues until this occurs.
 *
 */
public class MiniGameEngine {
	private static int selectedMiniGame;
<<<<<<< HEAD
	private static int playerChoice;

=======
	
	
	/**
	 * The runMiniGameEngine calls the newGame method, it then calls the villainEffects method, then it
	 * checks the HeroSquad objects status, it then asks the user to select a hero. It checks if the heros abilities or powerups have any effect
	 * on the current battle. It then constructs a minigame sequence and passes it the hero, villain and squad objects. 
	 * The loop is run until the villain is beaten or the heros are all dead.
	 * @param villain
	 * @param squad
	 */
>>>>>>> master
	public void runMiniGameEngine(Villain villain, HeroesSquad squad) {

		while (squad.isAllDead() == false && villain.isBeaten() == false) {
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			
			int selectedMiniGame = selectNewGame(3);
			System.out.println("The Game will be " + getGameString(selectedMiniGame));
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			villainEffects(villain, squad);
			squad.checkTeamStatus();
			if (squad.isAllDead()) {
				break;
			}
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			
			Hero hero = selectHero(squad);
			
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			
			if (hero.getIsGameChooser()) {
				selectedMiniGame = MiniGameUtilities.gameChooserPowerUp(selectedMiniGame, hero);
			}
			
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			
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
	
<<<<<<< HEAD
	public String runGuiMiniGameEngine(Villain villain, HeroesSquad squad, int selectedHeroIndex) {
		Hero hero = squad.getHero(selectedHeroIndex);
		switch (selectedMiniGame) {
		case 1: RockPaperScissors RPS = new RockPaperScissors(Games.RPS, villain, squad, false); 
		String result = RPS.runGuiGame(hero, playerChoice);
		return result;
		
//		case 2: GuessTheNumber GTN = new GuessTheNumber(Games.RPS, villain, squad, false); 
//		String result1 = GTN.runGuiGame(hero);
//		return result1; break;
//		
//		case 3: DiceWars DW = new DiceWars(Games.RPS, villain, squad, false); 
//		String result2 = DW.runGuiGame(hero);
//		return result2; break;
		default: System.out.println("Error in runGuiMiniGameEngine");
		}
		
		
		return null;
		
	}
	
	public String getHeroEffectsFromUtils(Villain villain, HeroesSquad squad, int selectedHeroIndex) {
		Hero hero = squad.getHero(selectedHeroIndex);
		int villainsChoice = villain.getVillainsChoice();
		String abiltyString = GuiMiniGameUtilities.getHeroAbiltyEffects(hero, villain, squad, villainsChoice, selectedMiniGame);
		System.out.println(abiltyString);
		return abiltyString;
		
	}
=======
	/**
	 * The villainEffects method checks the villains type parameter, then uses this to reference the difficulty level of that villain object
	 * the getVillainAbilties effects method is then called from the MiniGameUtilities class. 
	 * @param villain
	 * @param squad
	 */
>>>>>>> master
	
	private void villainEffects(Villain villain, HeroesSquad squad) {
		int randInt = Utilities.getRandInt(100);
		Types level = villain.getCharacterType();
		int difficulty = 0;
		
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
			MiniGameUtilities.getVillainAbiltyEffects(villain, squad);
		}
		
		
	}
	
	/**
	 * The selectHero method prompts the user to select a hero to battle the villain, it then returns that hero to the runMiniGameEngine method.
	 * @param squad
	 * @return hero
	 */
	
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
	
<<<<<<< HEAD
	public String getGameString(int selectedMiniGame) {
=======
	/**
	 * The getGame method returns a string representation of the current game.
	 * @param selectedMiniGame
	 * @return result
	 */
	
	private String getGame(int selectedMiniGame) {
>>>>>>> master
		String result = "";
		switch (selectedMiniGame) {
		case 1: result = "Paper, Scissors, Rock"; break;
		case 2: result = "Guess the Number out of Ten"; break;
		case 3: result = "Dice Wars"; break;
		}
		
		return result;
	}
	
<<<<<<< HEAD
	public int selectNewGame(int upperLimit) {
=======
	/**
	 * The selectNewGame calls the getRandInt from the Utilities class, it then returns that integer.
	 * @param upperLimit
	 * @return selectedGame
	 */
	
	private int selectNewGame(int upperLimit) {
>>>>>>> master
		int selectedGame = Utilities.getRandInt(upperLimit);
		return selectedGame;		
	}
	
	/**
	 * Setter method for selectedMiniGame, allows the selected Game parameter to be manually 
	 * selected rather than selected at random.
	 * @param newGame
	 */
	
	public static void setSelectedGame(int newGame) {
		selectedMiniGame = newGame;
		
	}
	
<<<<<<< HEAD
	public static void setSelectedGame(Games gameID) {
		switch (gameID) {
		case RPS: setSelectedGame(1); break;
		case GTN: setSelectedGame(2); break;
		case DW: setSelectedGame(3); break;
		}
		
	}
	
	public int getSelectedMiniGame() {
=======
	/**
	 * Getter method for selectedMinigame parameter
	 * @return
	 */
	
	public static int getSelectedMiniGame() {
>>>>>>> master
		return selectedMiniGame;
	}


	/**
	 * @return the playerChoice
	 */
	public static int getPlayerChoice() {
		return playerChoice;
	}

	/**
	 * @param playerChoice the playerChoice to set
	 */
	public static void setPlayerChoice(int playerChoice) {
		MiniGameEngine.playerChoice = playerChoice;
	}

	
	
	//  For testing
//	public static void main(String[] args) {
////		TeamBuilder team = new TeamBuilder();
//		Hero hero1 = new Hero("hero1", Types.talkitive, Abilities.charm);
//		Hero hero2 = new Hero("hero2", Types.smart, Abilities.mystery);
//		Hero hero3 = new Hero("hero3", Types.practical, Abilities.betterOdds);
//		Hero hero4 = new Hero("hero4", Types.strong, Abilities.lessDamage);
//		Hero hero5 = new Hero("hero5",Types.sly, Abilities.winDraws);
//		Hero hero6 = new Hero("hero3",Types.dog, Abilities.goodBoy);
//		HeroesSquad testsquad = new HeroesSquad();
//		testsquad.addHero(hero1);
////		testsquad.addHero(hero3);
////		testsquad.addHero(hero5);
////		hero2.setisAlive(false);
////		hero3.setisAlive(false);
////		hero3.setisAlive(false);
//		testsquad.checkTeamStatus();
//		hero2.setArmor(30);
//		hero1.setIsGameChooser(true);
//		Money wallet = testsquad.getWallet();
//		
//		
//		Villain testVillain = new Villain("Lorenzo", Types.level_1, Abilities.stealLunchMoney, "Ciao bella dona ;p", 10);
////		testVillain.setBeaten(true);
////		testVillain.setTimesBeaten();
////		testVillain.setTimesBeaten();
//		
//		MiniGameEngine game = new MiniGameEngine();	
//		game.runMiniGameEngine(testVillain, testsquad);
//		
//		System.out.println(wallet);
//		
//	}


	

}
