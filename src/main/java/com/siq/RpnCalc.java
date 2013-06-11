package com.siq;

public class RpnCalc {

	public Double calculate(String inputString) throws Exception {
		RPNFactory rpnFactory = new RPNFactory();
		ReversePolishNotation reversePolishNotation = rpnFactory.create(inputString);
		
		return reversePolishNotation.evaluate();
	}
}
