package tests.GuiTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.Types;
import city.City;
import guiClassesAndManager.GameWindowManager;

class GameWindowManagerTests {
	private GameWindowManager manager;


	@BeforeEach
	void setUp() {
		this.manager = new GameWindowManager();
	}

	@AfterEach
	void tearDown() {
		manager = null;
	}

	@Test
	void testGameWindowManager() {
		assertTrue(manager.getSquad().getLength() == 0);
		assertTrue(manager.getWorld().size() == 0);
		
	}

	@Test
	void testGetCurrentCity() {
		assertTrue(manager.getSquad().getCurrentCity() == null);
	}

	@Test
	void testSetCurrentCity() {
		City city = new City();
		manager.setCurrentCity(city);
		assertTrue(manager.getSquad().getCurrentCity() == city);
	}

	@Test
	void testGetSquad() {
		fail("Not yet implemented");
	}

	@Test
	void testSetSquad() {
		fail("Not yet implemented");
	}

	@Test
	void testLaunchMainGameScreen() {
		fail("Not yet implemented");
	}

	@Test
	void testLaunchSetupTeamAndWorld() {
		// For testing the minigame module
		Hero hero1 = new Hero("heroOne", Types.talkitive, Abilities.charm);
		Hero hero2 = new Hero("heroTwo", Types.smart, Abilities.mystery);
		Hero hero3 = new Hero("heroThree", Types.practical, Abilities.betterOdds);
		Hero hero4 = new Hero("hero4", Types.strong, Abilities.lessDamage);
		Hero hero5 = new Hero("hero5",Types.sly, Abilities.winDraws);
		Hero hero6 = new Hero("hero3",Types.dog, Abilities.goodBoy);
		
		manager.getSquad().addHero(hero5);
		manager.getSquad().addHero(hero2);
		manager.getSquad().addHero(hero6); 


	}

	@Test
	void testCloseMainGameWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseHomeBaseWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testClosePowerUpDenWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseHospitalWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseShopWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testFinalCloseVillainLairWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testOpenBuildingWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testIsHospitalWindowOpen() {
		fail("Not yet implemented");
	}

	@Test
	void testSetHospitalWindowOpen() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseSetupTeamAndWorld() {
		fail("Not yet implemented");
	}

	@Test
	void testLaunchsetupAddHeros() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseSetupAddHeros() {
		fail("Not yet implemented");
	}

	@Test
	void testFinalcloseSetupAddHeros() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateWorld() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseVillainLairWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testLaunchRpsWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseRpsWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testLaunchGtnWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseGtnWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testLaunchDWWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseDWWindow() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCharacterTypes() {
		fail("Not yet implemented");
	}

	@Test
	void testGetWorld() {
		fail("Not yet implemented");
	}

	@Test
	void testSetWorld() {
		fail("Not yet implemented");
	}

	@Test
	void testGetVillains() {
		fail("Not yet implemented");
	}

	@Test
	void testSetVillains() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCurrentIndex() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCurrentIndex() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMiniGameEngine() {
		fail("Not yet implemented");
	}

	@Test
	void testSetMiniGameEngine() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSelectedHeroIndex() {
		fail("Not yet implemented");
	}

	@Test
	void testSetSelectedHeroIndex() {
		fail("Not yet implemented");
	}

	@Test
	void testGetWorldSize() {
		fail("Not yet implemented");
	}

	@Test
	void testSetWorldSize() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLootAfterVillainDefated() {
		fail("Not yet implemented");
	}

	@Test
	void testSetLootAfterVillainDefated() {
		fail("Not yet implemented");
	}

	@Test
	void testTypeConversion() {
		fail("Not yet implemented");
	}

	@Test
	void testGetHeroAbility() {
		fail("Not yet implemented");
	}

	@Test
	void testMain() {
		fail("Not yet implemented");
	}

}
