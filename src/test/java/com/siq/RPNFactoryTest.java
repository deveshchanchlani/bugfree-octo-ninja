package com.siq;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class RPNFactoryTest {
	@Test
	public void testCreateRPNObjectWithBinaryOperators() throws Exception {
		RPNFactory factory = new RPNFactory();
		ReversePolishNotation rpn = factory.create("2 3 +");
		Stack<String> rpnStack = rpn.getRpnStack();
		
		Stack<String> expectedRpnStack =  new Stack<String>();
		expectedRpnStack.push("2");
		expectedRpnStack.push("3");
		expectedRpnStack.push("+");
		
		assertEquals(expectedRpnStack, rpnStack);
	}

	@Test
	public void testCreateRPNObjectWithUnaryOperators() throws Exception {
		RPNFactory factory = new RPNFactory();
		ReversePolishNotation rpn = factory.create("2 %");
		Stack<String> rpnStack = rpn.getRpnStack();
		
		Stack<String> expectedRpnStack =  new Stack<String>();
		expectedRpnStack.push("2");
		expectedRpnStack.push("%");
		
		assertEquals(expectedRpnStack, rpnStack);
	}

	@Test
	public void testCreateRPNObjectWithUnaryOperatorsJoined() throws Exception {
		RPNFactory factory = new RPNFactory();
		ReversePolishNotation rpn = factory.create("2%");
		Stack<String> rpnStack = rpn.getRpnStack();
		
		Stack<String> expectedRpnStack =  new Stack<String>();
		expectedRpnStack.push("2%");
		
		assertEquals(expectedRpnStack, rpnStack);
	}

	@Test
	public void testCreateRPNObjectWithUnaryAndBinaryOperators() throws Exception {
		RPNFactory factory = new RPNFactory();
		ReversePolishNotation rpn = factory.create("2% 3% +");
		Stack<String> rpnStack = rpn.getRpnStack();
		
		Stack<String> expectedRpnStack =  new Stack<String>();
		expectedRpnStack.push("2%");
		expectedRpnStack.push("3%");
		expectedRpnStack.push("+");
		
		assertEquals(expectedRpnStack, rpnStack);
	}
}
