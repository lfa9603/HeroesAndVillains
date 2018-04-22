package minigames_V2;

import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import characters.Villain;

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
	
	public void battleDraw() {
		System.out.println("Its a Draw!");
		if (villain.getCharacterType() != Types.Boss && hero.getCharacterType() == Types.sly) {
			System.out.println("Who dares Wins! Your Character is Sly, and you managed to cheat your way through this draw.");
			heroWins();
		}
		else {
			if (villain.getCharacterType() == Types.Boss) {
				System.out.println("Your Boss is NEVER wrong, they win this Draw!");
				herolosses();
			}
			else {
				System.out.println("No damage done");
			}
		}
	}
	
	public void heroWins() {
		System.out.println("You win! the villain has been defeated!");
		villain.setTimesBeaten();
		System.out.println("You have beaten the Villain " + villain.getTimesBeaten() + " times, "
				+ "you must beat hime three times to defeat him and move on to the next level");
	}
	
	public void herolosses() {
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
