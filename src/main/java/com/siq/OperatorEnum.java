package com.siq;

public enum OperatorEnum {
	ADD("+", OperatorType.BINARY) {

		@Override
		public Double performOperation(Double[] operands) {
			return operands[0] + operands[1];
		}
	},
	SUB("-", OperatorType.BINARY) {

		@Override
		public Double performOperation(Double[] operands) {
			return operands[1] - operands[0];
		}
	},
	MUL("*", OperatorType.BINARY) {

		@Override
		public Double performOperation(Double[] operands) {
			return operands[0] * operands[1];
		}
	},
	DIV("/", OperatorType.BINARY) {

		@Override
		public Double performOperation(Double[] operands) {
			return operands[1] / operands[0];
		}
	},
	EXP("^", OperatorType.BINARY) {

		@Override
		public Double performOperation(Double[] operands) {
			return Math.pow(operands[1], operands[0]);
		}
	},
	PERC("%", OperatorType.UNARY) {

		@Override
		public Double performOperation(Double[] operands) {
			return operands[0] / 100;
		}
	},
	FACT("!", OperatorType.UNARY) {

		@Override
		public Double performOperation(Double[] operands) {
			Double fact = 1d;
			for (double x = operands[0]; x >= 1; x--) {
				fact *= x;
			}
			return fact;
		}
	};

	private String operator;
	protected OperatorType operatorType;

	abstract public Double performOperation(Double[] operands);

	private OperatorEnum(String operator, OperatorType operatorType) {
		this.operator = operator;
		this.operatorType = operatorType;
	}

	public static OperatorEnum getOperator(String operatorStr) throws Exception {
		if(operatorStr.length() > 1) {
			operatorStr = operatorStr.substring(operatorStr.length() - 1);
		}
		for (OperatorEnum operatorEnum : OperatorEnum.values()) {
			if (operatorEnum.operator.compareTo(operatorStr) == 0) {
				return operatorEnum;
			}
		}
		throw new Exception("invalid input");
	}

	public static boolean isOperator(String operatorStr) {
		if(operatorStr.length() > 1) {
			operatorStr = operatorStr.substring(operatorStr.length() - 1);
		}
		for (OperatorEnum operatorEnum : OperatorEnum.values()) {
			if (operatorEnum.operator.compareTo(operatorStr) == 0) {
				return true;
			}
		}
		return false;
	}

	public OperatorType getType() {
		return operatorType;
	}
}
