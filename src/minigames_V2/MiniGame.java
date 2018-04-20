package minigames_V2;

import characters.Hero;
import characters.HeroesSquad;
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
	
	public abstract void runGame(Games game);

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
