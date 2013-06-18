package com.siq;

import java.util.Stack;

public class ReversePolishNotation {

	private Stack<String> rpnStack;

	public ReversePolishNotation(Stack<String> rpnStack) {
		this.rpnStack = rpnStack;
	}

	public Stack<String> getRpnStack() {
		return rpnStack;
	}

	public Double evaluate() throws Exception {
		Stack<String> tmpStack = new Stack<String>();
		
		while (true) {
			String arg = rpnStack.pop();
			System.out.print(rpnStack.toString());
			
			if(!OperatorEnum.isOperator(arg)) {
				rpnStack.push(arg);
				break;
			}
			
			OperatorEnum operator = OperatorEnum.getOperator(arg);
			OperatorType operatorType = operator.getType();
			operatorType.processRpnStack(rpnStack, tmpStack, arg, operator);
		}
		
		double result = Double.parseDouble(rpnStack.pop());
		return Math.round(result * 100.0) / 100.0;
	}
}
