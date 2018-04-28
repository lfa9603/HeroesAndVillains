package tests.engineTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import engine.HelperScanner;
import engine.Utilities;
import engine.YesNo;

class UtilitiesTests {

	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;
	
	
	@BeforeEach
	void beforeEach() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	private void setInputStream(String input) {
		inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
	}
	
	@AfterEach
	void afterEach() {
		System.setOut(System.out);
		System.setIn(System.in);
	}

	@Test
	void testGetChoice() {
		
		setInputStream("jkdhf\n111\n11\n");
		HelperScanner.create();
		
		int choice = Utilities.getChoice("How awesome am I from 1 to 10", 1, 11);
		assertEquals(11, choice);
	}

	@Test
	void testGetStringChoice() {
		setInputStream("ofcourse\n66\ny\n");
		HelperScanner.create();
		
		YesNo choice = Utilities.getStringChoice("Am I the greatest programmer in the world?");
		assertEquals(YesNo.yes, choice);
		
		
		setInputStream("maybeALittle\nNever!\nn\n");
		HelperScanner.create();
		
		YesNo choice2 = Utilities.getStringChoice("Am I tired of writing tests?");
		assertEquals(YesNo.no, choice2);
	}

	@Test
	void testGetRandInt() {
		
		int chosenValue = Utilities.getRandInt(4);
		assertTrue(chosenValue <= 4 && chosenValue >= 0);
		
		
	}

}
