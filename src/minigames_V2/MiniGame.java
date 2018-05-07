package minigames_V2;

import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import characters.Villain;



/**
 * @author JayHamilton
 * The Abstract class MInigame sets the structure for the three minigames that will be run as apart of a battle between a Hero and villain
 * The Abstract method of the class is the runGame method, which will be implemented by the children of this class.
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
	
	public void heroWins(Hero hero) {
		System.out.println("You win! the villain has been defeated!");
		villain.setTimesBeaten();
		System.out.println("You have beaten the Villain " + villain.getTimesBeaten() + " times, "
				+ "you must beat hime three times to defeat him and move on to the next level");
	}
	
	public void herolosses(Hero hero) {
		System.out.println("You lost " + villain.getVillainDamage() + "HP");
		squad.heroTakesDamage(hero, villain.getVillainDamage());
	}

	/**
	 * @return the gameName
	 */
	public Games getGameName() {
		return gameName;
	}

	/**
	 * @param gameName the gameName to set
	 */
	public void setGameName(Games gameName) {
		this.gameName = gameName;
	}

	/**
	 * @return the hero
	 */
	public Hero getHero() {
		return hero;
	}

	/**
	 * @param hero the hero to set
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	/**
	 * @return the squad
	 */
	public HeroesSquad getSquad() {
		return squad;
	}

	/**
	 * @param squad the squad to set
	 */
	public void setSquad(HeroesSquad squad) {
		this.squad = squad;
	}

	/**
	 * @return the villain
	 */
	public Villain getVillain() {
		return villain;
	}

	/**
	 * @param villain the villain to set
	 */
	public void setVillain(Villain villain) {
		this.villain = villain;
	}
	
	/**
	 * @return the abilitiesAvaliable
	 */
	public static boolean isAbilitiesAvaliable() {
		return abilitiesAvaliable;
	}

	/**
	 * @param abilitiesAvaliable the abilitiesAvaliable to set
	 */
	public static void setAbilitiesAvaliable(boolean abilitiesAvaliable) {
		MiniGame.abilitiesAvaliable = abilitiesAvaliable;
	}

}
