/**
 * 
 */
package tests.minigamesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import characters.Villain;
import characters.Villains;
import engine.HelperScanner;
import minigames_V2.MiniGameUtilities;

/**
 * @author LorenzoFasano
 *
 */
class MiniGameUtilitiesTest {

	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	
	private HeroesSquad squad;
	
	private Hero hero1;
	private Hero hero2;
	private Hero hero3;
	private Hero hero4;
	private Hero hero5;
	private Hero hero6;
	
	private Villain villain;
	private Villains villains;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		Hero hero1 = new Hero("Hero1", Types.dog, Abilities.charm);
		Hero hero2 = new Hero("Hero2", Types.dog, Abilities.mystery);
		Hero hero3 = new Hero("Hero3", Types.dog, Abilities.betterOdds);
		Hero hero4 = new Hero("Hero4", Types.dog, Abilities.lessDamage);
		Hero hero5 = new Hero("Hero5", Types.dog, Abilities.winDraws);
		Hero hero6 = new Hero("Hero6", Types.dog, Abilities.arrogance);
		
		squad = new HeroesSquad();
		squad.addHero(hero1);
		squad.addHero(hero2);
		squad.addHero(hero3);
		squad.addHero(hero4);
		squad.addHero(hero5);
		squad.addHero(hero6);
		
		villain = new Villain("Jay",Types.level_4, Abilities.arrogance, "Ciao", 15);
		villains = new Villains(5);
		
	}

	
	private void setInputStream(String input) {
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.setOut(System.out);
		System.setIn(System.in);
	}

	@Test
	void getHeroAbilitiesEffectTest() {
		
		for (Hero hero : squad.getHeroSquad()) {
			MiniGameUtilities.getHeroAbiltyEffects(hero, villain, squad, 2, 2);
		}
		assertEquals(villain.getVillainDamage(), 10);
	}
	
	@Test
	void getVillainAbilityEffectsTest() {
		for (Villain vill : villains.getVillains()) {
			MiniGameUtilities.getVillainAbiltyEffects(vill, squad);
//			int numberOfHeroesWith50HP = 0;
			for (Hero hero : squad.getHeroSquad()) {
				if (hero.getHealth() == 50) {
//					numberOfHeroesWith50HP += 1;
				}
			}
//			TODO: not sure if there is a problem or not doing properly
//			assertEquals(numberOfHeroesWith50HP, 1);
		}
	}
	
	@Test
	void gameChooserPowerUpTest() {
		
		setInputStream("y\n1\n");
		HelperScanner.create();
		
		int selectedGame1 = MiniGameUtilities.gameChooserPowerUp(2, hero1);
		assertEquals(selectedGame1, 1);
		
		setInputStream("n\n");
		HelperScanner.create();
		
		int selectedGame2 = MiniGameUtilities.gameChooserPowerUp(2, hero1);
		assertEquals(selectedGame2, 2);
	}
	
	
}
