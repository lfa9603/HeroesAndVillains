package minigames_V2;


import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import characters.Villain;
import engine.Icons;
import engine.Utilities;
import engine.VisualUtilities;
import guiClassesAndManager.MainGameWindow;



/**
 * @author JayHamilton
 * This class controls the running of the minigame sequences, it prompts the user to select a hero to battle the villain, check to
 * see if the selected hero has any active powerups, or if the heros ability has an effect on the game, then it
 * constructs a minigame object in the moment that a minigame is required. The engine also checks to see if the villain 
 * is beaten or if all the heros are dead, after each battle sequence, the loop continues until this occurs.
 *
 */
public class MiniGameEngine implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8541911594061434851L;
	private static int selectedMiniGame;
	private static int playerChoice;
	private static int selectedHeroIndex = -1;
	private static int guessesInGTN;
	private static Boolean heroWonGTN = false;
	
	/**
	 * The runMiniGameEngine calls the newGame method, it then calls the villainEffects method, then it
	 * checks the HeroSquad objects status, it then asks the user to select a hero. It checks if the heros abilities or powerups have any effect
	 * on the current battle. It then constructs a minigame sequence and passes it the hero, villain and squad objects. 
	 * The loop is run until the villain is beaten or the heros are all dead.
	 * @param villain
	 * @param squad
	 */

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
	

	public String runGuiMiniGameEngine(Villain villain, HeroesSquad squad, int selectedHeroIndex) {
		Hero hero = squad.getHero(selectedHeroIndex);
		boolean gotAbilities = MiniGame.isAbilitiesAvaliable();
		String result = "";
		switch (selectedMiniGame) {
			case 1: RockPaperScissors RPS = new RockPaperScissors(Games.RPS, villain, squad, gotAbilities); 
			RPS.runGuiGame(hero, playerChoice); result = RPS.getBattleResult(); break;
			
			case 2: GuessTheNumber GTN = new GuessTheNumber(Games.RPS, villain, squad, gotAbilities); 
			result = GTN.runGuiGame(hero, playerChoice); break;
			
			case 3: DiceWars DW = new DiceWars(Games.RPS, villain, squad, gotAbilities); 
			DW.runGuiGame(hero, playerChoice); result = DW.getBattleResult(); break;
			
			default: System.out.println("Error in runGuiMiniGameEngine");
		}
		if (villain.isBeaten() == true) {
			System.out.println("removed heros from detention");
			MiniGame.setAbilitiesAvaliable(true);
			for (Hero selectedhero: squad.getHeroSquad()) {
				if (selectedhero.isinDetention) {
					selectedhero.setIsinDetention(false);
				}
			}
			
		}
		
		
		return result;
		
	}
	
	public String getHeroEffectsFromUtils(Villain villain, HeroesSquad squad, int selectedHeroIndex) {
		Hero hero = squad.getHero(selectedHeroIndex);
		int villainsChoice = villain.getVillainsChoice();
		String abiltyString = GuiMiniGameUtilities.getHeroAbiltyEffects(hero, villain, squad, villainsChoice, selectedMiniGame);
		System.out.println(abiltyString);
		return abiltyString;
		
	}

	/**
	 * The villainEffects method checks the villains type parameter, then uses this to reference the difficulty level of that villain object
	 * the getVillainAbilties effects method is then called from the MiniGameUtilities class. 
	 * @param villain
	 * @param squad
	 */

	
	public String villainEffects(Villain villain, HeroesSquad squad) {
		String villainEffect;
		int randInt = Utilities.getRandInt(100);
		Types level = villain.getCharacterType();
		int difficulty = 0;
		
		//Sets how often the villains ability will be activated, this will help adjust the games difficulty.
		switch (level) {
		case level_1: difficulty = 30; break;
		case level_2: difficulty = 30; break;
		case level_3: difficulty = 30; break;
		case level_4: difficulty = 40; break;
		case level_5: difficulty = 50; break;
		case Boss: difficulty = 100; break;
		default: difficulty = 10; break;
		}
		
		if (randInt > difficulty) {
			villainEffect = (villain.getCharacterName() + " Chose not to use their abilty.");
		}
		else {
			villainEffect = GuiMiniGameUtilities.getVillainAbiltyEffects(villain, squad);
		}
		return villainEffect;
		
		
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
	


	/**
	 * The getGame method returns a string representation of the current game.
	 * @param selectedMiniGame
	 * @return result
	 */
	
	public String getGameString(int selectedMiniGame) {
		String result = "";
		switch (selectedMiniGame) {
		case 1: result = "Paper, Scissors, Rock"; break;
		case 2: result = "Guess the Number out of Ten"; break;
		case 3: result = "Dice Wars"; break;
		}
		
		return result;
	}

	/**
	 * The selectNewGame calls the getRandInt from the Utilities class, it then returns that integer.
	 * @param upperLimit
	 * @return selectedGame
	 */
	
	public int selectNewGame(int upperLimit) {
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

	public static void setSelectedGame(Games gameID) {
		switch (gameID) {
		case RPS: setSelectedGame(1); break;
		case GTN: setSelectedGame(2); break;
		case DW: setSelectedGame(3); break;
		}
		
	}

	/**
	 * Getter method for selectedMinigame parameter
	 * @return
	 */
	
	public static int getSelectedMiniGame() {
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


	/**
	 * @return the selectedHeroIndex
	 */
	public static int getSelectedHeroIndex() {
		return selectedHeroIndex;
	}


	/**
	 * @param selectedHeroIndex the selectedHeroIndex to set
	 */
	public static void setSelectedHeroIndex(int selectedHeroIndex) {
		MiniGameEngine.selectedHeroIndex = selectedHeroIndex;
	}


	/**
	 * @return the guessesInGTN
	 */
	public static int getGuessesInGTN() {
		return guessesInGTN;
	}


	/**
	 * @param guessesInGTN the guessesInGTN to set
	 */
	public static void setGuessesInGTN(int guessesInGTN) {
		MiniGameEngine.guessesInGTN = guessesInGTN;
	}


	/**
	 * @return the heroWonGTN
	 */
	public static Boolean getHeroWonGTN() {
		return heroWonGTN;
	}


	/**
	 * @param heroWonGTN the heroWonGTN to set
	 */
	public static void setHeroWonGTN(Boolean heroWonGTN) {
		MiniGameEngine.heroWonGTN = heroWonGTN;
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
