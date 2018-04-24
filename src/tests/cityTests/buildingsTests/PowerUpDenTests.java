package tests.cityTests.buildingsTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import city.buildings.PowerUpDen;
import city.buildings.TypeBuildings;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;

class PowerUpDenTests {

	private PowerUpDen powerUpDen;
	
	private Hero lorenzo1;
	private Hero jay1;
	
	private HeroesSquad squad1;
	
	private Inventory backpack;
	
	private Armor armor;
	private IncreaseMaxLife increaseMaxHealth;
	private GameChooser gameChooser;
	
	
	@BeforeEach
	void beforeEach() {

		powerUpDen = new PowerUpDen("PowerUpDen", TypeBuildings.PowerUpDen);
		
		increaseMaxHealth = new IncreaseMaxLife(CollectableID.IncreaseMaxLife);
		armor = new Armor(CollectableID.Armor);
		gameChooser = new GameChooser(CollectableID.GameChooser);
		
		lorenzo1 = new Hero("Lorenzo1", Types.smart, Abilities.betterOdds);
		jay1 = new Hero("Jay1", Types.talkitive, Abilities.betterOdds);
		
		squad1 = new HeroesSquad();
		squad1.addHero(lorenzo1);
		squad1.addHero(jay1);
		
		backpack = squad1.getBackPack();
		
		backpack.addItemToInventory(armor);
		backpack.addItemToInventory(increaseMaxHealth);
		backpack.addItemToInventory(gameChooser);
		
	}
	
	/**
	 * 
	 * In this test the correct functioning of interact method are tested and therefore all the apply() 
	 * methods for the items that extend Collectable.java are tested.
	 * For doing so it is passed an input to the method and registered the correct functioning of each element, 
	 * their remotion from the Hero object backpack property and the effect each element causes on the selected Hero. 
	 * 
	 */
	@Test
	void testingCorrectFunctioningOfInteract() {
		
		
		//TODO: having troubles with this test, works individually, fails when testing all.
		System.out.println("Type:\n"
				+ "- 0 to select Armor power-up\n" 
				+ "- 1 to select the first Hero\n");
		
		System.out.println("Type:\n"
				+ "- 2 to select IncreaseMaxLife power-up\n" 
				+ "- 1 to select the first Hero\n");
		
		System.out.println("Type:\n"
				+ "- 1 to select GameChooser power-up\n"
				+ "- 1 to select the first Hero\n");
		powerUpDen.interact(squad1);
		
		assertEquals(lorenzo1.getArmor(), 30);
		assertFalse(backpack.getInventory().containsKey(armor));
		
		
		
		assertTrue(lorenzo1.getIsGameChooser());
		assertFalse(backpack.getInventory().containsKey(gameChooser));
		
		
		assertEquals(lorenzo1.getMaxHealth(), 125);
		assertEquals(lorenzo1.getHealth(), 100);
		assertTrue(backpack.getInventory().size() == 0);
		assertFalse(backpack.getInventory().containsKey(gameChooser));
		
	}
	
	//This test has no asserts, the fact that it does 
			//not crash or runs in infinite loop is enough for this part.
	@Test
	void testingBadInputPassedToInteract() {
		
		System.out.println("Type:\n"
				+ "- Random char"
				+ "- 0 to select Armor powerUp"
				+ "- Random char"
				+ "- 0 to exit the Hero chooser"
				+ "- 2 to try to use IncreaseMaxLife which you don't have"
				+ "- Random char or num"
				+ "- 0 to select Armor power-up"
				+ "- 1 to select first Hero"
				+ "- Random char"
				+ "- 0 to exit");
		
		backpack.addItemToInventory(gameChooser);
		backpack.addItemToInventory(armor);
		powerUpDen.interact(squad1);
		
	}
	
	@Test
	void normallyExitingInteractWithItemsInInventory() {
		
		System.out.println("Press 3 to exit");
		backpack.addItemToInventory(armor);
		powerUpDen.interact(squad1);
		
	}

	
	@AfterEach
	void afterEach() {
		powerUpDen = null;
		
		lorenzo1 = null;
		jay1 = null;
		
		squad1 = null;
		
		backpack = null;
		
		armor = null;
		increaseMaxHealth = null;
		gameChooser = null;
	}
}
