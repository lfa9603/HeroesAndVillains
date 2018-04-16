package minigames;

import characters.Abilities;
import characters.Hero;
import characters.Villain;
import engine.Icons;
import engine.Utilities;

public class CharacterAbiltyEffects {
	
	public static void getAbiltyEffects(Abilities abilty, Hero hero, Villain villain, int villainsChoice) {
		switch (abilty) {
		case charm: noEffect(); break;
		case mystery: noEffect(); break;
		case betterOdds: betterOddsAbilty(villainsChoice); break;
		case lessDamage: lessDamageAbilty(villain); break;
		case winDraws: winDrawsAbilty(); break;
		case goodBoy: noEffect(); break;
		default: noEffect(); break;
		}
	}

	private static void noEffect() {
		System.out.println(Icons.bar);
		System.out.println("You Characters abilty has no effect at the moment.");
		System.out.println(Icons.bar);
	}

	public static void betterOddsAbilty(int villainsChoice) {
		int randInt = Utilities.getRandInt(3);
		if (randInt != villainsChoice) {
			System.out.println("Your Hero's practical intuition tells you that, the villain has not chosen " + getRPS(villainsChoice));
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
		System.out.println("Your Hero is a Sly Character, the will make sure that if it a draw they will win.");
	}
	

}
