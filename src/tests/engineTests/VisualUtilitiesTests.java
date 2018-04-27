/**
 * 
 */
package tests.engineTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import engine.Icons;
import engine.VisualUtilities;

/**
 * @author Lorenzo
 *
 */
class VisualUtilitiesTests {

	/**
	 * Test method for {@link engine.VisualUtilities#getIcon(engine.Icons)}.
	 */
	@Test
	void testGetIcon() {
		
		String expected = "==========================================================";
		String bar = VisualUtilities.getIcon(Icons.bar);
		assertEquals(expected, bar);
		
		assertTrue(VisualUtilities.getIcon(Icons.youWin).length() > 100); 
		
		assertEquals(VisualUtilities.getIcon(Icons.thumbsUp), "");
	}

}
