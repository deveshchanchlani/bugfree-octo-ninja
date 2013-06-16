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
			if (operator.getType() == OperatorType.BINARY) {
				String operand1 = rpnStack.pop();
				if (OperatorEnum.isOperator(operand1)) {
					tmpStack.push(arg);
					rpnStack.push(operand1);
					continue;
				}

				String operand2 = rpnStack.pop();
				if (OperatorEnum.isOperator(operand2)) {
					tmpStack.push(arg);
					tmpStack.push(operand1);
					rpnStack.push(operand2);
					continue;
				}

				Double[] operands = new Double[] { Double.parseDouble(operand1), Double.parseDouble(operand2) };
				rpnStack.push(operator.performOperation(operands).toString());
				while (!tmpStack.isEmpty()) {
					rpnStack.push(tmpStack.pop());
				}

			} else if (operator.getType() == OperatorType.UNARY) {
				String operand1;
				if(arg.length() > 1) {
					operand1 = arg.substring(0, arg.length() - 1);
				} else {
					operand1 = rpnStack.pop();
				}
				if (!OperatorEnum.isOperator(operand1)) {
					Double[] operands = new Double[] { Double.parseDouble(operand1) };
					rpnStack.push(operator.performOperation(operands).toString());
					while (!tmpStack.isEmpty()) {
						rpnStack.push(tmpStack.pop());
					}
				} else {
					tmpStack.push(arg);
					rpnStack.push(operand1);
				}
			}
		}
		double result = Double.parseDouble(rpnStack.pop());
		return Math.round(result * 100.0) / 100.0;
	}
}
