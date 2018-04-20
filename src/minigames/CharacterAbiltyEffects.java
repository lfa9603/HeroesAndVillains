package minigames;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;
import collectables.Money;
import engine.Icons;
import engine.Utilities;
import engine.VisualUtilities;

public class CharacterAbiltyEffects {
	
	public static void getHeroAbiltyEffects(Hero hero, Villain villain, HeroesSquad squad, int villainsChoice, int selectedGame) {
		Abilities abilty = hero.getCharacterAbility();
		boolean abilitiesAvaliable = MiniGame.isAbilitiesAvaliable();
		if (abilitiesAvaliable) {
			switch (abilty) {
			case charm: noEffect(); break;
			case mystery: mysteryAbilty(villain, villainsChoice, selectedGame, squad); break;
			case betterOdds: betterOddsAbilty(villainsChoice, selectedGame); break;
			case lessDamage: lessDamageAbilty(villain); break;
			case winDraws: winDrawsAbilty(); break;
			default: noEffect(); break;
			}
		}
		
		else {
			System.out.println("No abilities this game.");
		}
		
	}
	
	public static void getVillainAbiltyEffects(Villain villain, HeroesSquad squad) {
		Abilities abilty = villain.getCharacterAbility();
		switch (abilty) {
			case stealLunchMoney: stealLunchMoney(squad, villain); break;
			case detention: detention(squad, villain); break;
			case judge: judge(villain); break;
			case badDay: badDay(villain); break;
			case cancer: cancer(squad, villain); break;
			case arrogance: arrogance(); break;
			default: noEffect(); break;
			}
	}

	private static void cancer(HeroesSquad squad, Villain villain) {
		boolean run = true;
		while (run == true) {
			int randInt = Utilities.getRandInt(squad.getLength());
			Hero hero = squad.getHero(randInt-1);
			if (hero.isAlive()) {

				
				Money wallet = squad.getWallet();				
				String cost = wallet.toString();
				wallet.minus(wallet);				
				run = false;
				System.out.println(villain.toString());
				System.out.println(hero.getCharacterName() + " has been diagnosed with cancer.\n"
						+ "Cancer is expensive and life threatning.\n"
						+ "You are charged " + cost + " coins and "
						+ hero.getCharacterName() + " loses 50HP");
				squad.heroTakesDamage(hero, 50);
			}
		}
		
	}

	private static void badDay(Villain villain) {
		System.out.println(villain.getCharacterName() + " your Partner is having a bad day, therefore YOUR having a bad day...");
		System.out.println("You will not be able to use your abilties for the rest of this battle.");
		System.out.println(villain.toString());
		MiniGame.setAbilitiesAvaliable(false);
	}

	private static void judge(Villain villain) {
		System.out.println(villain.toString());
		System.out.println("You deserve to lose, then my child will see the loser that your really are...");
		System.out.println(villain.getCharacterName() + " changes the game to Guess the number.");
		MiniGame.setSelectedGame(2);
	}

	private static void arrogance() {
		System.out.println("Your boss is never wrong, he will win all draws.");
	}

	private static void detention(HeroesSquad squad, Villain villain) {
		boolean run = true;
		while (run == true) {
			int randInt = Utilities.getRandInt(squad.getLength());
			Hero hero = squad.getHero(randInt-1);
			if (hero.isAlive()) {
				hero.setIsinDetention(true);
				run = false;
				System.out.println(hero.getCharacterName() + "you peice of s***! your going to DENTENTION!");
				System.out.println(villain.toString());
			}
		}
	}

	private static void stealLunchMoney(HeroesSquad squad, Villain villain) {
		Money wallet = squad.getWallet();
		Money cost = new Money(5);
		wallet.minus(cost);
		System.out.println("The school bully stole your lunch money!");
		villain.getVillainTaunt();
		
	}

	private static void noEffect() {
		VisualUtilities.getIcon(Icons.bar);
		System.out.println("Your Characters abilty has no effect in this minigame.");
		VisualUtilities.getIcon(Icons.bar);
	}

	public static void betterOddsAbilty(int villainsChoice, int selectedGame) {
		if (selectedGame == 1) {
			
			int randInt = Utilities.getRandInt(3);
			
			while (randInt == villainsChoice) {
				randInt = Utilities.getRandInt(3);
			}
			if (randInt != villainsChoice) {
				int balencer = Utilities.getRandInt(10);
				if (balencer <= 1) {
					System.out.println("Your Hero's practical intuition tells you that, the villain has probably not chosen " + getRPS(villainsChoice));
				}
				else {
					System.out.println("Your Hero's practical intuition tells you that, the villain has probably not chosen " + getRPS(randInt));
				}	
			}
		}
		else {
			noEffect();
		}
		
	}
	
	private static String getRPS(int villainsChoice) {
		String result = null;
		switch (villainsChoice) {
		case 1: result = "Rock"; break;
		case 2: result = "Paper"; break;
		case 3: result = "Scissors"; break;
		}
		return result;
	}
	
	private static void lessDamageAbilty(Villain villain) {
		if (villain.isDamageModified()) {
			noEffect();
		}
		else {
			System.out.println("You Hero is Big and Strong, They will protect your team, everyone "
					+ "will take 25% less damage, from now on.");
			int oldDamage = villain.getVillainDamage();
			int newDamge = (int) (oldDamage * 0.70);
			villain.setVillainDamage(newDamge);
			villain.setDamageModified(true);
		}
		
	}
	
	private static void winDrawsAbilty() {
		System.out.println("Your Hero is a Sly Character, they will make sure that if it is a draw, they will win.");
	}
	
	private static void mysteryAbilty(Villain villain, int villainsChoice, int selectedGame, HeroesSquad squad) {
		if (selectedGame == 2) {
			int firstGuess = Utilities.getRandInt(10);
			int secondGuess = Utilities.getRandInt(10); 
			
			VisualUtilities.getIcon(Icons.bar);
			System.out.println("Your Character is smart, thanks to his understanding of multi-Variable Calculas, he knows: ");
			if (firstGuess >= villainsChoice) {
				System.out.println("That " + villain.getCharacterName() + " has chosen a number below or equal to " + firstGuess);
			}
			else {
				System.out.println("That " + villain.getCharacterName() + " has chosen a number above " + firstGuess);
			}
			
			System.out.println("and");
			
			if (secondGuess >= villainsChoice) {
				System.out.println("That " + villain.getCharacterName() + " has chosen a number below or equal to " + secondGuess);
			}
			else {
				System.out.println("That " + villain.getCharacterName() + " has chosen a number above " + secondGuess);
			}
			VisualUtilities.getIcon(Icons.bar);
		}
		
		else {
			System.out.println("Your Hero is out of his element, " + villain.getCharacterName() + " see's this...");
			getVillainAbiltyEffects(villain, squad);
			System.out.println(villain.getCharacterName() + " uses his abilty " + villain.getCharacterAbility());
			System.out.println(villain.getVillainTaunt());
		}
	}
	

}
