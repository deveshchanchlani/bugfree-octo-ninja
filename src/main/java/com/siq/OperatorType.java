package com.siq;

import java.util.Stack;

public enum OperatorType {
	UNARY {
		@Override
		public void processRpnStack(Stack<String> rpnStack,
				Stack<String> tmpStack, String arg, OperatorEnum operator) {
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
	},
	BINARY {
		@Override
		public void processRpnStack(Stack<String> rpnStack,
				Stack<String> tmpStack, String arg, OperatorEnum operator) {
			String operand1 = rpnStack.pop();
			if (OperatorEnum.isOperator(operand1)) {
				tmpStack.push(arg);
				rpnStack.push(operand1);
				return;
			}

			String operand2 = rpnStack.pop();
			if (OperatorEnum.isOperator(operand2)) {
				tmpStack.push(arg);
				tmpStack.push(operand1);
				rpnStack.push(operand2);
				return;
			}

			Double[] operands = new Double[] { Double.parseDouble(operand1), Double.parseDouble(operand2) };
			rpnStack.push(operator.performOperation(operands).toString());
			while (!tmpStack.isEmpty()) {
				rpnStack.push(tmpStack.pop());
			}
		}
	};
	
	abstract public void processRpnStack(Stack<String> rpnStack,
			Stack<String> tmpStack, String arg, OperatorEnum operator);
}
