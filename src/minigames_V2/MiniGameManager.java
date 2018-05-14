/**
 * 
 */
package minigames_V2;

import GUIPOC.VillainLairWindow;
import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import characters.Villain;
import collectables.Money;

/**
 * @author JayHamilton
 *
 */
public class MiniGameManager {
	private HeroesSquad squad;
	private Villain villain;
	private MiniGameEngine miniGameEngine;
	private RockPaperScissors rockPaperScissors;
	private GuessTheNumber guessTheNumber;
	private DiceWars diceWars;
	/**
	 * @param squad
	 * @param miniGameEngine
	 * @param rockPaperScissors
	 * @param guessTheNumber
	 * @param diceWars
	 */
	public MiniGameManager(HeroesSquad squad, Villain villain) {
		this.setSquad(squad);
		this.setVillain(villain);
		this.setMiniGameEngine(new MiniGameEngine());
//		this.rockPaperScissors = new RockPaperScissors(game, givenVillain, theSquad, gotAbilities);
//		this.guessTheNumber = guessTheNumber;
//		this.diceWars = diceWars;
		
		launchmainGameWindow();
	}
	
	public void launchmainGameWindow() {
		VillainLairWindow battleWindow = new VillainLairWindow(this);
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
	 * @return the miniGameEngine
	 */
	public MiniGameEngine getMiniGameEngine() {
		return miniGameEngine;
	}

	/**
	 * @param miniGameEngine the miniGameEngine to set
	 */
	public void setMiniGameEngine(MiniGameEngine miniGameEngine) {
		this.miniGameEngine = miniGameEngine;
	}

	/** For Testing
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		Hero hero1 = new Hero("heroOne", Types.talkitive, Abilities.charm);
		Hero hero2 = new Hero("heroTwo", Types.smart, Abilities.mystery);
		Hero hero3 = new Hero("heroThree", Types.practical, Abilities.betterOdds);
		Hero hero4 = new Hero("hero4", Types.strong, Abilities.lessDamage);
		Hero hero5 = new Hero("hero5",Types.sly, Abilities.winDraws);
		Hero hero6 = new Hero("hero3",Types.dog, Abilities.goodBoy);
		HeroesSquad testsquad = new HeroesSquad();
		testsquad.addHero(hero1);
		testsquad.addHero(hero3);
		testsquad.addHero(hero5);
//		hero2.setisAlive(false);
//		hero3.setisAlive(false);
//		hero3.setisAlive(false);
		testsquad.checkTeamStatus();
		hero2.setArmor(30);
		hero1.setIsGameChooser(true);
		Money wallet = testsquad.getWallet();
		
		
		Villain testVillain = new Villain("Lorenzo", Types.level_1, Abilities.stealLunchMoney, "Ciao bella dona ;p", 10);
//		testVillain.setBeaten(true);
//		testVillain.setTimesBeaten();
//		testVillain.setTimesBeaten();
//		
//		MiniGameEngine game = new MiniGameEngine();	
//		game.runMiniGameEngine(testVillain, testsquad);
//		
//		System.out.println(wallet);
		MiniGameManager game = new MiniGameManager(testsquad, testVillain);
	}



}
