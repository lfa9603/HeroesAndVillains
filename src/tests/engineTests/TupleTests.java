package tests.engineTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import engine.Tuple;

/**
 * @author Lorenzo
 * Tests for Engine.Tuple class.
 */
class TupleTests {
	
	private Tuple<String, Integer, Boolean> tuple;
	
	@BeforeEach
	void setUp() throws Exception {
		
		tuple = new Tuple<String, Integer, Boolean>("Ciao", 34, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		tuple = null;
	}

	@Test
	void correctFunctioningOfTupleTest() {
		tuple.setK("CiaoCiao");
		assertTrue(tuple.getK().length() == 8);
		
		tuple.setV(200);
		assertEquals(tuple.getV().intValue(), 200);
		
		tuple.setT(false);
		assertFalse(tuple.getT());
	}

}
