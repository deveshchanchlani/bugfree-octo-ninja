package com.siq;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RpnCalc {

	public int calculate(String inputString) throws Exception {
		StringTokenizer stringTokenizer = new StringTokenizer(inputString);
		List<String> inputValues = new ArrayList<String>();
		while(stringTokenizer.hasMoreElements()) {
			inputValues.add((String) stringTokenizer.nextElement());
		}
		
		try {
			Integer.parseInt(inputValues.get(0));
		} catch (Exception e) {
			throw new Exception("invalid input");
		}
		
		return Integer.parseInt(inputValues.get(0)) + Integer.parseInt(inputValues.get(1));
	}

}
