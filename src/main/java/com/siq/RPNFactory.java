package com.siq;

import java.util.Stack;
import java.util.StringTokenizer;

public class RPNFactory {

	public ReversePolishNotation create(String inputString) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputString);

		Stack<String> rpnStack = new Stack<String>();
		Stack<OperatorEnum> rpnOperatorStack = new Stack<OperatorEnum>();
		Stack<Double> rpnOperandStack = new Stack<Double>();

		while (stringTokenizer.hasMoreElements()) {
			String element = (String) stringTokenizer.nextElement();
			rpnStack.push(element);
		}

		while (!rpnStack.isEmpty()) {
			String value = rpnStack.pop();
			try {
				Double operand = Double.parseDouble(value);
				rpnOperandStack.push(operand);
			} catch (Exception e) {
				OperatorEnum operator = OperatorEnum.getOperator(value);
				rpnOperatorStack.push(operator);
			}
		}
		
		return new ReversePolishNotation(rpnOperatorStack, rpnOperandStack);
	}

}
