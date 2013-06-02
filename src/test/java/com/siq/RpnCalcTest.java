
package com.siq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RpnCalcTest {
	RpnCalc rpnCalc;
	
	@Before
	public void setUp() {
		rpnCalc = new RpnCalc();
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
	public void shouldAdd() {
		String inputString = "1 2 +";
		int actualResult = 0;
		try {
			actualResult = rpnCalc.calculate(inputString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3, actualResult);
	}
}
