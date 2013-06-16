package com.siq;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class ReversePolishNotationTest {
	@Test
	public void testEvaluateADDUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("2");
		rpnStack.push("3");
		rpnStack.push("+");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(5), result);
	}
	
	@Test
	public void testEvaluateADDTwiceUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("2");
		rpnStack.push("3");
		rpnStack.push("+");
		rpnStack.push("1");
		rpnStack.push("+");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(6), result);
	}
	
	@Test
	public void testEvaluateAddSubComboUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("2");
		rpnStack.push("3");
		rpnStack.push("+");
		rpnStack.push("1");
		rpnStack.push("-");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(4), result);
	}
	
	@Test
	public void testEvaluateSUBUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("2");
		rpnStack.push("3");
		rpnStack.push("-");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(-1), result);
	}
	
	@Test
	public void testEvaluateMULUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("2");
		rpnStack.push("3");
		rpnStack.push("*");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(6), result);
	}
	
	@Test
	public void testEvaluateDIVUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("5");
		rpnStack.push("3");
		rpnStack.push("/");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(1.67d), result);
	}
	
	@Test
	public void testEvaluateEXPUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("5");
		rpnStack.push("3");
		rpnStack.push("^");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(125), result);
	}
	
	@Test
	public void testEvaluatePERCUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("3");
		rpnStack.push("%");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(0.03), result);
	}
	
	@Test
	public void testEvaluateFACTUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("3");
		rpnStack.push("!");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(6), result);
	}
	
	@Test
	public void testEvaluateFACTJoinedUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("3!");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(6), result);
	}
	
	@Test
	public void testEvaluateADD2FACTsUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("3!");
		rpnStack.push("4!");
		rpnStack.push("+");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(30), result);
	}
	
	@Test
	public void testEvaluateAddPercentsUsingSingleStack() throws Exception {
		Stack<String> rpnStack = new Stack<String>();
		rpnStack.push("3");
		rpnStack.push("4");
		rpnStack.push("+");
		rpnStack.push("%");
		
		ReversePolishNotation reversePolishNotation = new ReversePolishNotation(rpnStack);
		
		Double result = reversePolishNotation.evaluate();
		
		assertEquals(new Double(0.07), result);
	}
}
