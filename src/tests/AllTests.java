package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.charactersTests.HeroSquadTests;
import tests.charactersTests.HeroTest;
import tests.cityTests.CityTests;

@RunWith(Suite.class)
@SuiteClasses({
	HeroSquadTests.class,
	HeroTest.class,
	CityTests.class
})

public class AllTests {

}
