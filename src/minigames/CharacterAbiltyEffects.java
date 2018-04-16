package minigames;

import characters.Abilities;
import characters.Hero;
import characters.Villain;
import engine.Icons;
import engine.Utilities;

public class CharacterAbiltyEffects {
	
	public static void getAbiltyEffects(Abilities abilty, Hero hero, Villain villain, int villainsChoice, int selectedGame) {
		
//		switch (selectedGame) {
//		case 1: 
//			switch (abilty) {
//			case mystery: mysteryAbilty(villainsChoice); break;
//			case betterOdds: betterOddsAbilty(villainsChoice); break;
//			
//			} ; break;
//		case 2: 
//			switch (abilty) {
//			
//			} ; break;
//		
//		case 3: 
//			switch (abilty) {
//			
//			} ; break;
		
		switch (abilty) {
		case charm: noEffect(); break;
		case mystery: mysteryAbilty(villain, villainsChoice, selectedGame); break;
		case betterOdds: betterOddsAbilty(villainsChoice, selectedGame); break;
		case lessDamage: lessDamageAbilty(villain); break;
		case winDraws: winDrawsAbilty(); break;
		case goodBoy: noEffect(); break;
		default: noEffect(); break;
		}
	}

	private static void noEffect() {
		System.out.println(Icons.bar);
		System.out.println("You Characters abilty has no effect in this minigame.");
		System.out.println(Icons.bar);
	}

	public static void betterOddsAbilty(int villainsChoice, int selectedGame) {
		if (selectedGame == 1) {
			int randInt = Utilities.getRandInt(3);
			if (randInt != villainsChoice) {
				System.out.println("Your Hero's practical intuition tells you that, the villain has not chosen " + getRPS(villainsChoice));
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
		System.out.println("You Hero is Big and Strong, They will protect your team, everyone "
				+ "will take 25% less damage, from now on.");
		int oldDamage = villain.getVillainDamage();
		int newDamge = (int) (oldDamage * 0.25);
		villain.setVillainDamage(newDamge);
	}
	
	private static void winDrawsAbilty() {
		System.out.println("Your Hero is a Sly Character, the will make sure that if it a draw, they will win.");
	}
	
	private static void mysteryAbilty(Villain villain, int villainsChoice, int selectedGame) {
		if (selectedGame == 2) {
			int firstGuess = Utilities.getRandInt(10);
			int secondGuess = Utilities.getRandInt(10); 
			
			System.out.println("Your Character is smart, thanks to his understanding of multi-Variable Calculas, he knows: ");
			if (firstGuess >= villainsChoice) {
				System.out.println("That villain has chosen a number below " + firstGuess + "\n");
			}
			else {
				System.out.println("That villain has chosen a number above " + firstGuess + "\n");
			}
			
			System.out.println("and");
			
			if (secondGuess >= villainsChoice) {
				System.out.println("That villain has chosen a number below " + secondGuess + "\n");
			}
			else {
				System.out.println("That villain has chosen a number above " + secondGuess + "\n");
			}
		}
		
		else {
			System.out.println("Your Hero is out of his element, " + villain.getCharacterName() + "see's this...");
			//TODO add use villains abilty to this.
			System.out.println("the villain uses his abilty");
			villain.getVillainTaunt();
		}
	}
	

}
