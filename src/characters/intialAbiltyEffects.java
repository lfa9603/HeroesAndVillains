package characters;

import engine.Icons;
import engine.VisualUtilities;

public class intialAbiltyEffects {
	
	public static void getHeroSquadAbilties(HeroesSquad squad) {
		for (Hero hero: squad) {
			Abilities abilty = hero.getCharacterAbility();
			getAbiltiesEffects(abilty, hero);
		}
		
	}
	
	public static void getAbiltiesEffects(Abilities abilty, Hero hero) {
		switch (abilty) {
		case charm: charmAbilty(abilty, hero); break;
		case mystery: noEffect(hero.getCharacterName()); break;
		case betterOdds: noEffect(hero.getCharacterName()); break;
		case lessDamage: noEffect(hero.getCharacterName()); break;
		case winDraws: noEffect(hero.getCharacterName()); break;
		case goodBoy: goodBoyAbilty(abilty, hero); break;
		default: noEffect(hero.getCharacterName()); break;
		}
	}

	private static void charmAbilty(Abilities abilty, Hero hero) {
		// TODO Auto-generated method stub
		
	}
	
	private static void goodBoyAbilty(Abilities abilty, Hero hero) {
		int newMaxHealth = hero.getMaxHealth() + 25;
		hero.setMaxHealth(newMaxHealth);
		
	}

	private static void noEffect(String name) {
		VisualUtilities.getIcon(Icons.bar);
		System.out.println(name + "'s abilty has no effect at the start of the game");
		VisualUtilities.getIcon(Icons.bar);
	}

}
