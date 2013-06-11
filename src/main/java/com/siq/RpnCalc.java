package com.siq;

import java.util.Stack;
import java.util.StringTokenizer;

public class RpnCalc {

	public Double calculate(String inputString) throws Exception {
		StringTokenizer stringTokenizer = new StringTokenizer(inputString);
		
		Stack<String> rpnStack = new Stack<String>();
		Stack<String> rpnOperatorStack = new Stack<String>();
		Stack<Double> rpnOperandStack = new Stack<Double>();
		
		while(stringTokenizer.hasMoreElements()) {
			String element = (String) stringTokenizer.nextElement();
			rpnStack.push(element);
		}
		
		while(!rpnStack.isEmpty()) {
			String value = rpnStack.pop();
			try {
				Double operand = Double.parseDouble(value);
				rpnOperandStack.push(operand);
			} catch (Exception e) {
				rpnOperatorStack.push(value);
			}
		}

		while(!rpnOperatorStack.isEmpty()) {
			String operator = rpnOperatorStack.pop();
			System.out.print(rpnOperandStack.toString());
			Double operand1, operand2;
			
			try {
				operand1 = rpnOperandStack.pop();
				operand2 = rpnOperandStack.pop();
			} catch (Exception e) {
				throw new Exception("invalid input");
			}
			
			Double result = 0d;
			if(operator.compareTo("+") == 0) {
				result = operand1 + operand2;
			} else if(operator.compareTo("-") == 0) {
				result = operand1 - operand2;
			} else if(operator.compareTo("*") == 0) {
				result = operand1 * operand2;
			} else if(operator.compareTo("/") == 0) {
				result = operand1 / operand2;
			}
			result = Math.round( result * 100.0 ) / 100.0;
			
			rpnOperandStack.push(result);
		}
		
		return rpnOperandStack.pop();
	}

}
