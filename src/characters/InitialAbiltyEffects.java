package characters;

import java.util.ArrayList;

import engine.Engine;
import engine.Icons;
import engine.VisualUtilities;

public class InitialAbiltyEffects {
	
	public static void applyHeroSquadAbilties(ArrayList<Hero> squad) {
		for (Hero hero: squad) {
			Abilities abilty = hero.getCharacterAbility();
			getAbiltiesEffects(abilty, squad, hero);
		}
		
	}
	
	public static void getAbiltiesEffects(Abilities abilty, Hero hero) {
		switch (abilty) {
		case charm: charmAbilty(hero); break;
		case mystery: noEffect(hero.getCharacterName()); break;
		case betterOdds: noEffect(hero.getCharacterName()); break;
		case lessDamage: noEffect(hero.getCharacterName()); break;
		case winDraws: noEffect(hero.getCharacterName()); break;
		case goodBoy: goodBoyAbilty(abilty, hero); break;
		default: noEffect(hero.getCharacterName()); break;
		}
	}

	private static void charmAbilty(Hero hero) {
		Engine.setHasTalkitive(true);
		System.out.println(hero.getCharacterName() + "'s abilty has been applied, shop prices will be 30% cheaper.");
	}
	
	private static void goodBoyAbilty(Abilities abilty, Hero hero) {
		int newMaxHealth = hero.getMaxHealth() + 25;
		for (Hero hero: squad) {
			hero.setMaxHealth(newMaxHealth);
		}
		
		System.out.println(hero.getCharacterName() + "'s goodboy abilty has been applied, all teammates have an extra 25HP.");
		
	}

	private static void noEffect(String name) {
		VisualUtilities.getIcon(Icons.bar);
		System.out.println(name + "'s abilty has no effect at the start of the game");
		VisualUtilities.getIcon(Icons.bar);
	}

}
