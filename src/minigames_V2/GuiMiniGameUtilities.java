package minigames_V2;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;
import collectables.Money;
import engine.Icons;
import engine.Utilities;
import engine.VisualUtilities;
import engine.YesNo;

public class GuiMiniGameUtilities {
	
	public static String getHeroAbiltyEffects(Hero hero, Villain villain, HeroesSquad squad, int villainsChoice, int selectedGame) {
		Abilities abilty = hero.getCharacterAbility();
		boolean abilitiesAvaliable = MiniGame.isAbilitiesAvaliable();
		String abilitiesString = "";
		if (abilitiesAvaliable) {
			switch (abilty) {
			case charm: abilitiesString = noEffect(); break;
			case mystery: abilitiesString = mysteryAbilty(villain, villainsChoice, selectedGame, squad); break;
			case betterOdds: abilitiesString = betterOddsAbilty(villainsChoice, selectedGame);
			case lessDamage: abilitiesString = lessDamageAbilty(villain); break;
			case winDraws: abilitiesString = winDrawsAbilty(); break;
			default: abilitiesString = noEffect(); break;
			}
		}
		
		
		else {
			return ("Error in getHeroAbilties");
		}
		return abilitiesString;
		
	}
	
	public static String getVillainAbiltyEffects(Villain villain, HeroesSquad squad) {
		Abilities abilty = villain.getCharacterAbility();
		String villainabilitiesString = "";
		switch (abilty) {
			case stealLunchMoney: villainabilitiesString = stealLunchMoney(squad, villain); break;
			case detention: villainabilitiesString = detention(squad, villain); break;
			case judge: villainabilitiesString = judge(villain); break;
			case badDay: villainabilitiesString = badDay(villain); break;
			case sickness: villainabilitiesString = sickness(squad, villain); break;
			case arrogance: villainabilitiesString = arrogance(); break;
			default: villainabilitiesString = "Error in getVillainAbilities"; break;
			}
		return villainabilitiesString;
	}
	

	private static String sickness(HeroesSquad squad, Villain villain) {
		String string = "";
		boolean run = true;
		while (run == true) {
			int randInt = Utilities.getRandInt(squad.getLength() - 1);
			Hero hero = squad.getHero(randInt);
			if (hero.isAlive()) {

				
				Money wallet = squad.getWallet();				
				String cost = wallet.toString();
				wallet.minus(wallet);				
				run = false;
				String villainTaunt = (villain.toString());
				squad.heroTakesDamage(hero, 50);
				string = (villainTaunt + hero.getCharacterName() + " has been diagnosed with cancer.\n"
						+ "Cancer is expensive and life threatning.\n"
						+ "You are charged " + cost + " coins and "
						+ hero.getCharacterName() + " loses 50HP");
				
			}
		}
		return string;
	}

	private static String badDay(Villain villain) {
		String string = (villain.getCharacterName() + " your Partner is having a bad day, therefore YOUR having a bad day..." + 
	"You will not be able to use your abilties for the rest of this battle." + villain.toString());
		MiniGame.setAbilitiesAvaliable(false);
		return string;
	}

	private static String judge(Villain villain) {
		String string = (villain.toString() + "You deserve to lose, then my child will see the loser that your really are...\n" 
	+ villain.getCharacterName() + " changes the game to Guess the number.");
		MiniGameEngine.setSelectedGame(2);
		return string;
	}

	private static String arrogance() {
		return ("Your boss is never wrong, he will win all draws.");
	}

	private static String detention(HeroesSquad squad, Villain villain) {
		String string = "";
		boolean run = true;
		while (run == true) {
			int randInt = Utilities.getRandInt(squad.getLength());
			Hero hero = squad.getHero(randInt-1);
			if (hero.isAlive()) {
				hero.setIsinDetention(true);
				run = false;
				string = (hero.getCharacterName() + "you peice of s***! your going to DENTENTION!\n" +
				villain.toString());
			}
		}
		return string;
	}

	private static String stealLunchMoney(HeroesSquad squad, Villain villain) {
		Money wallet = squad.getWallet();
		Money cost = new Money(5);
		wallet.minus(cost);
		return ("The school bully stole your lunch money!\n" +
		villain.getVillainTaunt());
		
	}

	private static String noEffect() {
		return ("Your hero's abilty has no effect");
	}

	public static String betterOddsAbilty(int villainsChoice, int selectedGame) {
		if (selectedGame == 1) {
			
			int randInt = Utilities.getRandInt(3);
			
			while (randInt == villainsChoice) {
				randInt = Utilities.getRandInt(3);
			}
			if (randInt != villainsChoice) {
				int balencer = Utilities.getRandInt(10);
				if (balencer <= 1) {
					String string = ("Your Hero's practical intuition tells you that, the villain has probably not chosen " + getRPS(villainsChoice));
					return string;
				}
				else {
					String string = ("Your Hero's practical intuition tells you that, the villain has probably not chosen " + getRPS(randInt));
					return string;
				}	
			}
		}
		else {
			noEffect();
		}
		return null;
		
	}
	
	public static String getRPS(int villainsChoice) {
		String result = null;
		switch (villainsChoice) {
		case 1: result = "Rock"; break;
		case 2: result = "Paper"; break;
		case 3: result = "Scissors"; break;
		}
		return result;
	}
	
	private static String lessDamageAbilty(Villain villain) {
		String result = "less Damage issue";
		if (villain.isDamageModified()) {
			result = noEffect();
		}
		else {
			int oldDamage = villain.getVillainDamage();
			int newDamge = (int) (oldDamage * 0.70);
			villain.setVillainDamage(newDamge);
			villain.setDamageModified(true);
			result = ("You Hero is Big and Strong, They will protect your team, everyone "
					+ "will take 30% less damage, from now on.");
		}
		return result; 
		
	}
	
	private static String winDrawsAbilty() {
		return ("Your Hero is a Sly Character, they will make sure that if it is a draw, they will win.");
	}
	
	private static String mysteryAbilty(Villain villain, int villainsChoice, int selectedGame, HeroesSquad squad) {
		String string1 = "";
		String string2 = "";
		String string3 = "";
		
		if (selectedGame == 2) {
			int firstGuess = Utilities.getRandInt(10);
			int secondGuess = Utilities.getRandInt(10); 

			string1 = ("Your Character is smart, thanks to his understanding of multi-Variable Calculas, he knows: ");
			if (firstGuess >= villainsChoice) {
				string2 = ("That " + villain.getCharacterName() + " has chosen a number below or equal to " + firstGuess);
			}
			else {
				string3 = ("That " + villain.getCharacterName() + " has chosen a number above " + firstGuess);
			}
			
			System.out.println("and");
			
			if (secondGuess >= villainsChoice) {
				string2 = ("That " + villain.getCharacterName() + " has chosen a number below or equal to " + secondGuess);
			}
			else {
				string3 = ("That " + villain.getCharacterName() + " has chosen a number above " + secondGuess);
			}
		}
		
		else {
			string1 = ("Your Hero is out of his element, " + villain.getCharacterName() + " see's this...");
			getVillainAbiltyEffects(villain, squad);
			string2 = (villain.getCharacterName() + " uses his abilty " + villain.getCharacterAbility());
			string3 = (villain.getVillainTaunt());
		}
		
		String finalString = (string1 + "\n" + string2 + "\n" + string3 + "\n");
		return finalString;
	}

//	public static int gameChooserPowerUp(int selectedMiniGame, Hero hero) {
//		YesNo userInput = Utilities.getStringChoice("Do you want to use your GameChooser power up?");
//		String string = "1 to select Paper Scissors Rock. \n"
//				+ "2 to select Guess the number \n"
//				+ "3 to select dice wars.";
//		
//		if (userInput == YesNo.yes) {
//			selectedMiniGame = Utilities.getChoice(string, 1, 3);
//		}
//		
//		
//		return selectedMiniGame;
//	}

}
