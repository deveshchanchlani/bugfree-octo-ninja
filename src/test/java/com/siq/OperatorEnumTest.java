package com.siq;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OperatorEnumTest {
	
	@Test
	public void testAddOperator() {
		Double result = OperatorEnum.ADD.performOperation(2d, 3d);
		assertEquals(new Double(5), result);
	}
	
	@Test
	public void testSubOperator() {
		Double result = OperatorEnum.SUB.performOperation(2d, 3d);
		assertEquals(new Double(-1), result);
	}
	
	@Test
	public void testAddOperator2() {
		Double result = OperatorEnum.ADD.performOperation(2d, 13d);
		assertEquals(new Double(15), result);
	}
	
	@Test
	public void testSubOperator2() {
		Double result = OperatorEnum.SUB.performOperation(22d, 3d);
		assertEquals(new Double(19), result);
	}
	
	@Test
	public void testMultiplyOperator() {
		Double result = OperatorEnum.MUL.performOperation(2d, 3d);
		assertEquals(new Double(6), result);
	}
	
	@Test
	public void testMultiplyOperator2() {
		Double result = OperatorEnum.MUL.performOperation(2d, 31d);
		assertEquals(new Double(62), result);
	}
	
	@Test
	public void testDivideOperator() {
		Double result = OperatorEnum.DIV.performOperation(12d, 3d);
		assertEquals(new Double(4), result);
	}
	
	@Test
	public void testDivideOperator2() {
		Double result = OperatorEnum.DIV.performOperation(62d, 31d);
		assertEquals(new Double(2), result);
	}
	
	@Test
	public void testGetOperatorAdd() {
		OperatorEnum add = OperatorEnum.getOperator("+");
		assertEquals(OperatorEnum.ADD, add);
	}
	
	@Test
	public void testGetOperatorSub() {
		OperatorEnum sub = OperatorEnum.getOperator("-");
		assertEquals(OperatorEnum.SUB, sub);
	}
	
	@Test
	public void testGetOperatorDivide() {
		OperatorEnum div = OperatorEnum.getOperator("/");
		assertEquals(OperatorEnum.DIV, div);
	}
	
	@Test
	public void testGetOperatorMultiply() {
		OperatorEnum mul = OperatorEnum.getOperator("*");
		assertEquals(OperatorEnum.MUL, mul);
	}
}
