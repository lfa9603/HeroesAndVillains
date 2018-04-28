package tests.cityTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.HeroesSquad;
import city.buildings.homeBase.RandomEventsInHomeBase;
import collectables.Collectable;
import collectables.CollectableID;

class RandomEventsInHomeBaseTests {

	private HeroesSquad squad;
	
	@BeforeEach
	void setUp() throws Exception {
		
		squad = new HeroesSquad();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		squad = null;
		
	}

	@Test
	void hasAnyoneBeenGenerousTests() {
		
		for (int i=0; i <= 1000; i++) {
			
			int sizeSquadInventoryBeforeMethod = squad.getBackPack().getInventory().size();
			Collectable collectableDonated = RandomEventsInHomeBase.hasAnyoneBeenGenerous(squad);
			int sizeSquadInventoryAfterMethod = squad.getBackPack().getInventory().size();
			if (collectableDonated != null) {
				if (sizeSquadInventoryBeforeMethod < sizeSquadInventoryAfterMethod) {
					assertNotNull(collectableDonated);
					assertEquals(sizeSquadInventoryBeforeMethod + 1, sizeSquadInventoryAfterMethod);
				}
				
				if (collectableDonated.getCollectableID().equals(CollectableID.HeroesMap)) {
					assertTrue(squad.isHaveMap());
				}
			}
		}
	}
	
	@Test
	void haveWeBeenRobbedTests() {
		
		for (int i=0; i <= 1000; i++) {
			RandomEventsInHomeBase.hasAnyoneBeenGenerous(squad);
			
			int sizeSquadInventoryBeforeMethod = squad.getBackPack().getInventory().size();
			Collectable collectableStolen = RandomEventsInHomeBase.haveWeBeenRobbed(squad);
			int sizeSquadInventoryAfterMethod = squad.getBackPack().getInventory().size();
			if (collectableStolen != null) {
				if (sizeSquadInventoryBeforeMethod > sizeSquadInventoryAfterMethod) {
					assertNotNull(collectableStolen);
					assertTrue(sizeSquadInventoryBeforeMethod >= sizeSquadInventoryAfterMethod);
				}
				
				if (collectableStolen.getCollectableID().equals(CollectableID.HeroesMap)) {
					assertFalse(squad.isHaveMap());
				}
			}
		}
	}

}
