package characters;

import java.util.ArrayList;

import engine.Engine;
import engine.Icons;
import engine.VisualUtilities;

/**
 * @author JayHamilton
 *This Class is created to apply the effects on the if the User pick Heros with the Charm and GoodBoy abilities. 
 *All the Methods are Static. The Charm ability lowers the price in all the shops by 25% and the good-boy ability 
 *increases the max health of all the Heros by 25Hp.
 *
 */

public class InitialAbiltyEffects {
	
	/**
	 * This Method iterates through the Array list squad and calls the GetCharacterAbiltyEffects method.
	 * @param squad
	 */
	public static void applyHeroSquadAbilties(ArrayList<Hero> squad) {
		for (Hero hero: squad) {
			Abilities abilty = hero.getCharacterAbility();
			getAbiltiesEffects(abilty, squad, hero);
		}
		
	}
	
	/**
	 * This Method Checks the ability the Hero has and respective ability method.
	 * @param abilty
	 * @param squad
	 * @param hero
	 */
	
	public static void getAbiltiesEffects(Abilities abilty, ArrayList<Hero> squad, Hero hero) {
		switch (abilty) {
		case charm: charmAbilty(hero); break;
		case mystery: noEffect(hero.getCharacterName()); break;
		case betterOdds: noEffect(hero.getCharacterName()); break;
		case lessDamage: noEffect(hero.getCharacterName()); break;
		case winDraws: noEffect(hero.getCharacterName()); break;
		case goodBoy: goodBoyAbilty(abilty, squad, hero); break;
		default: noEffect(hero.getCharacterName()); break;
		}
	}
	
	/**
	 * This method applies the effects of the Charm ability to the game.
	 * @param hero
	 */

	private static void charmAbilty(Hero hero) {
		Engine.setHasTalkitive(true);
		System.out.println(hero.getCharacterName() + "'s abilty has been applied, shop prices will be 30% cheaper.");
	}
	
	/**
	 * This method applies the effects of the Good-boy ability to the game.
	 * @param abilty
	 * @param squad
	 * @param dog
	 */
	
	private static void goodBoyAbilty(Abilities abilty, ArrayList<Hero> squad, Hero dog) {

		for (Hero hero: squad) {
			int newMaxHealth = hero.getMaxHealth() + 25;
			int newHealth = hero.getHealth() + 25;
			hero.setMaxHealth(newMaxHealth);
			hero.setHealth(newHealth);
		}
		
		System.out.println(dog.getCharacterName() + "'s goodboy abilty has been applied, all teammates have an extra 25HP.");
		
	}
	
	/**
	 * This method inform the user that the respective Hero's ability does not have an effect at 
	 * the beginning of the game. 
	 * @param name
	 */

	private static void noEffect(String name) {
		VisualUtilities.getIcon(Icons.bar);
		System.out.println(name + "'s abilty has no effect at the start of the game");
		VisualUtilities.getIcon(Icons.bar);
	}

}
