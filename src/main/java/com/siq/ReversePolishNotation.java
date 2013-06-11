package com.siq;

import java.util.Stack;

public class ReversePolishNotation {

	private Stack<OperatorEnum> operatorStack;
	private Stack<Double> operandStack;

	public ReversePolishNotation(Stack<OperatorEnum> operatorStack,
			Stack<Double> operandStack) {
		this.operatorStack = operatorStack;
		this.operandStack = operandStack;
	}

	public Double evaluate() throws Exception {
		while (!operatorStack.isEmpty()) {
			OperatorEnum operator = operatorStack.pop();
			System.out.print(operandStack.toString());
			Double operand1, operand2;

			try {
				operand1 = operandStack.pop();
				operand2 = operandStack.pop();
			} catch (Exception e) {
				throw new Exception("invalid input");
			}

			Double result = operator.performOperation(operand1, operand2);
			result = Math.round(result * 100.0) / 100.0;

			operandStack.push(result);
		}
		
		return operandStack.pop();
	}

}
