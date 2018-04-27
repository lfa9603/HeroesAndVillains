package tests.engineTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EngineTests {

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
	void runTest() {
		setInputStream("");
	}

}
