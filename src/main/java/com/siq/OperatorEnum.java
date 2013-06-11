package com.siq;

public enum OperatorEnum {
	ADD("+") {
		@Override
		public Double performOperation(double op1, double op2) {
			return op1 + op2;
		}
	}, SUB("-") {
		@Override
		public Double performOperation(double op1, double op2) {
			return op1 - op2;
		}
	}, MUL("*") {
		@Override
		public Double performOperation(double op1, double op2) {
			return op1 * op2;
		}
	}, DIV("/") {
		@Override
		public Double performOperation(double op1, double op2) {
			return op1 / op2;
		}
	};

	private String operator;

	abstract public Double performOperation(double op1, double op2);
	
	private OperatorEnum(String operator) {
		this.operator = operator;
	}

	public static OperatorEnum getOperator(String operatorStr) {
		for(OperatorEnum operatorEnum : OperatorEnum.values()) {
			if(operatorEnum.operator.compareTo(operatorStr) == 0) {
				return operatorEnum;
			}
		}
		return null;
	}
}
