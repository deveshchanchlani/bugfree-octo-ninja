package com.siq;

import java.util.Stack;
import java.util.StringTokenizer;

public class RPNFactory {	

	public ReversePolishNotation create(String inputString) throws Exception {
		StringTokenizer stringTokenizer = new StringTokenizer(inputString);

		Stack<String> rpnStack = new Stack<String>();

		while (stringTokenizer.hasMoreElements()) {
			String element = (String) stringTokenizer.nextElement();
			rpnStack.push(element);
		}
		
		return new ReversePolishNotation(rpnStack);
	}

}
