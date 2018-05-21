package tests.GuiTests;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import city.City;
import city.buildings.Building;
import city.buildings.homeBase.Home;
import guiClassesAndManager.GameWindowManager;
import guiClassesAndManager.HomeWindow;
import guiClassesAndManager.MainGameWindow;
import guiClassesAndManager.SetupAddHeros;
import guiClassesAndManager.SetupTeamAndWorld;
import guiClassesAndManager.VillainLairWindow;

class GameWindowManagerTests {
	private GameWindowManager manager;
	private MainGameWindow mainGameWindow;


	@BeforeEach
	void setUp() {
		this.manager = new GameWindowManager();
		this.mainGameWindow = new MainGameWindow(manager);
	}

	@AfterEach
	void tearDown() {
		manager.closeMainGameWindow(mainGameWindow);
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
	void testLaunchMainGameScreen() {
		manager.launchMainGameScreen();
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
		
		manager.launchSetupTeamAndWorld();

	}

	@Test
	void testCloseMainGameWindow() {

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
		VillainLairWindow villainsLairWindow = new VillainLairWindow(manager, mainGameWindow);
		manager.finalCloseVillainLairWindow(villainsLairWindow, mainGameWindow, true);
		manager.closeMainGameWindow(mainGameWindow);
		VillainLairWindow villainsLairWindow1 = new VillainLairWindow(manager, mainGameWindow);
		manager.finalCloseVillainLairWindow(villainsLairWindow1, mainGameWindow, false);
		manager.closeMainGameWindow(mainGameWindow);
	}

	@Test
	void testOpenBuildingWindow() {
		Hero hero1 = new Hero("heroOne", Types.talkitive, Abilities.charm);
		Hero hero2 = new Hero("heroTwo", Types.smart, Abilities.mystery);
		Hero hero3 = new Hero("heroThree", Types.practical, Abilities.betterOdds);
		Hero hero4 = new Hero("hero4", Types.strong, Abilities.lessDamage);
		Hero hero5 = new Hero("hero5",Types.sly, Abilities.winDraws);
		Hero hero6 = new Hero("hero3",Types.dog, Abilities.goodBoy);
		
		manager.getSquad().addHero(hero5);
		manager.getSquad().addHero(hero2);
		manager.getSquad().addHero(hero6);
		City city = new City();
		ArrayList<Building> buildings = city.getCityBuildings();
		Building building0 = buildings.get(0);
		Building building1 = buildings.get(1);
		Building building2 = buildings.get(2);
		Building building3 = buildings.get(3);
		manager.openBuildingWindow(building0, mainGameWindow);
		manager.openBuildingWindow(building1, mainGameWindow);
		manager.openBuildingWindow(building2, mainGameWindow);
		manager.openBuildingWindow(building3, mainGameWindow);
		manager.closeMainGameWindow(mainGameWindow);
		
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
		SetupTeamAndWorld setupTeamAndWorld = new SetupTeamAndWorld(manager);
		manager.closeSetupTeamAndWorld(setupTeamAndWorld);
//		assertTrue(setupTeamAndWorld == null);
		manager.closeMainGameWindow(mainGameWindow);
	}

	@Test
	void testLaunchsetupAddHeros() {
		manager.launchsetupAddHeros(manager);
	}

	@Test
	void testCloseSetupAddHeros() {
		SetupAddHeros setupAddHeros = new SetupAddHeros(manager);
		manager.closeSetupAddHeros(setupAddHeros);
	}

	@Test
	void testFinalcloseSetupAddHeros() {
		SetupAddHeros setupAddHeros = new SetupAddHeros(manager);
		manager.closeSetupAddHeros(setupAddHeros);
	}

	@Test
	void testCreateWorld() {
		manager.setWorldSize(4);;
		manager.createWorld();
		assertTrue(manager.getWorld().size() == 4);
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
