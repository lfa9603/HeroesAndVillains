package minigames_V2;

import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import characters.Villain;



/**
 * @author JayHamilton
 * The Abstract class MInigame sets the structure for the three minigames that will be run as apart of a battle between a Hero and villain
 * The Abstract method of this class is the runGame  method, which will be implemented by the children of this class.
 * the gameName parameter is an enum value which stores the name of the mingame
 * the hero parameter hold the selected hero that will play the minigame
 * the squad parameter holds the squad object that the hero came from
 * the villain object holds the villain object that the hero will battle against
 * the abilitiesAvaliable parameter is a boolean value that controls whether the abilities of the heros are avaliable to use in the current minigame
 */
public abstract class MiniGame {
	private Games gameName;
	private Hero hero;
	private HeroesSquad squad;
	private Villain villain;
	protected static boolean abilitiesAvaliable = true;
	
	public MiniGame(Games game, Villain givenVillain, HeroesSquad theSquad, boolean gotAbilities) {
		gameName = game;
		villain = givenVillain;
		squad = theSquad;
		abilitiesAvaliable = gotAbilities;

		}
	
	public abstract void runGame(Hero hero);
	
	/**
	 * The method battleDraw checks to see if the Villain is a boss type, and if it is the villain wins the draw. Otherwise it
	 * takes the current Hero as a parameter, and checks if they have the winDraws ability, if they do, the player wins the draw. 
	 * If neither the player or the villain have the ability, a draw is just a draw and no damage is dealt.
	 * @param hero
	 */
	
	public void battleDraw(Hero hero) {
		System.out.println("Its a Draw!");
		if (villain.getCharacterType() != Types.Boss && hero.getCharacterType() == Types.sly) {
			System.out.println("Who dares Wins! Your Character is Sly, and you managed to cheat your way through this draw.");
			heroWins(hero);
		}
		else {
			if (villain.getCharacterType() == Types.Boss) {
				System.out.println("Your Boss is NEVER wrong, they win this Draw!");
				herolosses(hero);
			}
			else {
				System.out.println("No damage done");
			}
		}
	}
	
	/**
	 * The heroWins method, adds 1 increment to the villains, timesBeaten attribute.  
	 * @param hero
	 */
	
	public void heroWins(Hero hero) {
		System.out.println("You win! the villain has been defeated!");
		villain.setTimesBeaten();
		System.out.println("You have beaten the Villain " + villain.getTimesBeaten() + " times, "
				+ "you must beat hime three times to defeat him and move on to the next level");
	}
	
	/**
	 * The heroLosses method calls the villain get damage method and the heroSquad method heroTakesDamage.
	 * @param hero
	 */
	
	public void herolosses(Hero hero) {
		System.out.println("You lost " + villain.getVillainDamage() + "HP");
		squad.heroTakesDamage(hero, villain.getVillainDamage());
	}
	
	//Methods For the GUI
	
	public String guibattleDraw(Hero hero) {
		String string1 = "";
		String string2 = "";
		
		if (villain.getCharacterType() != Types.Boss && hero.getCharacterType() == Types.sly) {
			string1 = guiheroWins(hero);
			string2 = ("Its a Draw and Who dares Wins! Your Character is Sly, and you managed to cheat your way through this draw.");
		}
		
		else {
			if (villain.getCharacterType() == Types.Boss) {
				herolosses(hero);
				string1 = ("Its a Draw! But your Boss is NEVER wrong, they win this Draw!");
			}
			else {
				string1 = ("Its a Draw! No damage done");
			}
		}
		String finalString = (string1 + "\n" + string2);
		return finalString;
	}
	
	public String guiheroWins(Hero hero) {
		villain.setTimesBeaten();
		return ("You win! the villain has been defeated!");
	}
	
	public String guiherolosses(Hero hero) {
		squad.heroTakesDamage(hero, villain.getVillainDamage());
		return ("You lost " + villain.getVillainDamage() + "HP");	
	}
	

	/**
	 * Getter method for the parameter gameName
	 * @return gameName
	 */
	public Games getGameName() {
		return gameName;
	}

	/**
	 * Setter method for the parameter gameName
	 * @param gameName
	 */
	public void setGameName(Games gameName) {
		this.gameName = gameName;
	}

	/**
	 * Getter method for the parameter hero
	 * @return hero
	 */
	public Hero getHero() {
		return hero;
	}

	/**
	 * Setter method for the parameter hero
	 * @param hero
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	/**
	 * Getter method for the parameter squad
	 * @return squad
	 */
	public HeroesSquad getSquad() {
		return squad;
	}

	/**
	 * Setter method for the parameter squad
	 * @param squad
	 */
	public void setSquad(HeroesSquad squad) {
		this.squad = squad;
	}

	/**
	 * Getter method for the parameter villain
	 * @return villain
	 */
	public Villain getVillain() {
		return villain;
	}

	/**
	 * Setter method for the parameter villain
	 * @param villain the villain to set
	 */
	public void setVillain(Villain villain) {
		this.villain = villain;
	}
	
	/**
	 * Getter method for the parameter abilitiesAvaliable
	 * @return the abilitiesAvaliable
	 */
	public static boolean isAbilitiesAvaliable() {
		return abilitiesAvaliable;
	}

	/**
	 * Setter method for the parameter abilitiesAvaliable
	 * @param abilitiesAvaliable
	 */
	public static void setAbilitiesAvaliable(boolean abilitiesAvaliable) {
		MiniGame.abilitiesAvaliable = abilitiesAvaliable;
	}

}
