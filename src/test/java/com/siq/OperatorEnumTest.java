package com.siq;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class OperatorEnumTest {
	Double[] operands;
	
	@Before
	public void setUp() {
		operands = new Double[2];
	}
	
	@Test
	public void testAddOperator() throws Exception {
		operands[0] = 2d;
		operands[1] = 3d;
		Double result = OperatorEnum.ADD.performOperation(operands);
		assertEquals(new Double(5), result);
	}
	
	@Test
	public void testSubOperator() throws Exception {
		operands[0] = 2d;
		operands[1] = 3d;
		Double result = OperatorEnum.SUB.performOperation(operands);
		assertEquals(new Double(1), result);
	}
	
	@Test
	public void testAddOperator2() throws Exception {
		operands[0] = 2d;
		operands[1] = 13d;
		Double result = OperatorEnum.ADD.performOperation(operands);
		assertEquals(new Double(15), result);
	}
	
	@Test
	public void testSubOperator2() throws Exception {
		operands[0] = 22d;
		operands[1] = 3d;
		Double result = OperatorEnum.SUB.performOperation(operands);
		assertEquals(new Double(-19), result);
	}
	
	@Test
	public void testMultiplyOperator() throws Exception {
		operands[0] = 2d;
		operands[1] = 3d;
		Double result = OperatorEnum.MUL.performOperation(operands);
		assertEquals(new Double(6), result);
	}
	
	@Test
	public void testMultiplyOperator2() throws Exception {
		operands[0] = 2d;
		operands[1] = 31d;
		Double result = OperatorEnum.MUL.performOperation(operands);
		assertEquals(new Double(62), result);
	}
	
	@Test
	public void testDivideOperator() throws Exception {
		operands[0] = 12d;
		operands[1] = 3d;
		Double result = OperatorEnum.DIV.performOperation(operands);
		assertEquals(new Double(0.25), result);
	}
	
	@Test
	public void testDivideOperator2() throws Exception {
		operands[0] = 2d;
		operands[1] = 32d;
		Double result = OperatorEnum.DIV.performOperation(operands);
		assertEquals(new Double(16), result);
	}
	
	@Test
	public void testExponentOperator() throws Exception {
		operands[0] = 2d;
		operands[1] = 3d;
		Double result = OperatorEnum.EXP.performOperation(operands);
		assertEquals(new Double(9), result);
	}
	
	@Test
	public void testExponentOperator2() throws Exception {
		operands[0] = 4d;
		operands[1] = 4d;
		Double result = OperatorEnum.EXP.performOperation(operands);
		assertEquals(new Double(256), result);
	}
	
	@Test
	public void testPercentOperator() throws Exception {
		operands[0] = 3d;
		Double result = OperatorEnum.PERC.performOperation(operands);
		assertEquals(new Double(0.03), result);
	}
	
	@Test
	public void testPercentOperator2() throws Exception {
		operands[0] = 40d;
		Double result = OperatorEnum.PERC.performOperation(operands);
		assertEquals(new Double(0.40), result);
	}
	
	@Test
	public void testFactorialOperator() throws Exception {
		operands[0] = 3d;
		Double result = OperatorEnum.FACT.performOperation(operands);
		assertEquals(new Double(6), result);
	}
	
	@Test
	public void testFactorialOperator2() throws Exception {
		operands[0] = 4d;
		Double result = OperatorEnum.FACT.performOperation(operands);
		assertEquals(new Double(24), result);
	}
	
	@Test
	public void testGetOperatorAdd() throws Exception {
		OperatorEnum add = OperatorEnum.getOperator("+");
		assertEquals(OperatorEnum.ADD, add);
	}
	
	@Test
	public void testGetOperatorSub() throws Exception {
		OperatorEnum sub = OperatorEnum.getOperator("-");
		assertEquals(OperatorEnum.SUB, sub);
	}
	
	@Test
	public void testGetOperatorDivide() throws Exception {
		OperatorEnum div = OperatorEnum.getOperator("/");
		assertEquals(OperatorEnum.DIV, div);
	}
	
	@Test
	public void testGetOperatorMultiply() throws Exception {
		OperatorEnum mul = OperatorEnum.getOperator("*");
		assertEquals(OperatorEnum.MUL, mul);
	}
	
	@Test
	public void testGetOperatorExponent() throws Exception {
		OperatorEnum exp = OperatorEnum.getOperator("^");
		assertEquals(OperatorEnum.EXP, exp);
	}
	
	@Test
	public void testGetOperatorPercent() throws Exception {
		OperatorEnum per = OperatorEnum.getOperator("%");
		assertEquals(OperatorEnum.PERC, per);
	}
	
	@Test
	public void testGetOperatorPercentWhenJoined() throws Exception {
		OperatorEnum per = OperatorEnum.getOperator("3%");
		assertEquals(OperatorEnum.PERC, per);
	}
	
	@Test
	public void testGetOperatorFactorial() throws Exception {
		OperatorEnum fact = OperatorEnum.getOperator("!");
		assertEquals(OperatorEnum.FACT, fact);
	}
	
	@Test
	public void testGetOperatorFactorialWhenJoined() throws Exception {
		OperatorEnum fact = OperatorEnum.getOperator("3!");
		assertEquals(OperatorEnum.FACT, fact);
	}
}
