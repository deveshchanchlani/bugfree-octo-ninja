package com.siq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RpnCalcTest {
	RpnCalc rpnCalc;
	private OutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() {
		rpnCalc = new RpnCalc();
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void after() {
		System.setOut(null);
	}
	
	@Test
	public void testThrowsExceptionOnInvalidInput() {
		String inputString = "111+";
		try {
			rpnCalc.calculate(inputString);
		} catch (Exception e) {
			assertTrue(e instanceof Exception);
			assertEquals("invalid input", e.getMessage());
		}
	}
	
	@Test
	public void testNotThrowsAnyExceptionOnValidInput() {
		String inputString = "2 1 +";
		Boolean isExceptionThrown = false;
		try {
			rpnCalc.calculate(inputString);
		} catch (Exception e) {
			isExceptionThrown = true;
		}
		assertFalse(isExceptionThrown);
	}
	
	@Test
	public void testAdd() {
		String inputString = "1 2 +";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(3), actualResult);
	}
	
	@Test
	public void testAddFloatingNumbers() {
		String inputString = "1.2 2.1 +";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(3.3d), actualResult);
	}
	
	@Test
	public void testSubtract() {
		String inputString = "1 2 -";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(-1), actualResult);
	}
	
	@Test
	public void testSubFloatingNumbers() {
		String inputString = "1.2 0.1 -";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(1.1d), actualResult);
	}
	
	@Test
	public void testMultiply() {
		String inputString = "3 2 *";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(6), actualResult);
	}
	
	@Test
	public void testMultiplyFloatingNumbers() {
		String inputString = "1.2 0.1 *";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(0.12d), actualResult);
	}
	
	@Test
	public void testDivide() {
		String inputString = "3 2 /";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(1.5), actualResult);
	}
	
	@Test
	public void testDivideFloatingNumbers() {
		String inputString = "1.2 0.1 /";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(12d), actualResult);
	}
	
	@Test
	public void testAddTwice() {
		String inputString = "1 2 + 3 +";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(6), actualResult);
	}
	
	@Test
	public void testSubTwice() {
		String inputString = "1 2 - 3 -";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(-4), actualResult);
	}
	
	@Test
	public void testDivideTwice() {
		String inputString = "12 2 / 3 /";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(2), actualResult);
	}
	
	@Test
	public void testMultiplyTwice() {
		String inputString = "1 2 * 3 *";
		Double actualResult = 0d;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Double(6), actualResult);
	}
	
	@Test
	public void testDisplayValuesFollowingOperator() {

		String inputString = "1 2 * 3 + 4 - 5 /";
		try {
			rpnCalc.calculate(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("[5.0, 4.0, 3.0, 2.0, 1.0][5.0, 4.0, 3.0, 2.0][5.0, 4.0, 5.0][5.0, 1.0]", 
				outContent.toString());
	}
}
