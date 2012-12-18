package com.github.andriyermak.calculator.operation;

import com.github.andriyermak.calculator.operation.operator.*;
import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {

    private static OperatorFactory instance = new OperatorFactory();
	private Map<String, AbstractOperator> operators;
	
	private OperatorFactory(){
		operators = new HashMap<String, AbstractOperator>();
		operators.put("+", new Plus(1));
		operators.put("-", new Minus(1));
		operators.put("*", new Multiply(2));
		operators.put("/", new Divide(2));
		operators.put("^", new Pow(3));
	}
	
	public static OperatorFactory getInstance(){
		return instance;
	}
	
	public Double executeOperator(String operator, Double operand){
		UnaryOperator oper = (UnaryOperator) this.getOperator(operator.trim());
    	return oper.calculate(operand);
	}
	
	public Double executeOperator(Double operandLeft, String operator, Double operandRight) throws ArithmeticException {
		BinaryOperator oper = (BinaryOperator) this.getOperator(operator.trim());
        return  oper.calculate(operandLeft, operandRight);
	}
	
	public boolean isOperator(String operator){
		return operators.get(operator.trim())!=null;
	}

    public AbstractOperator getOperator(String operator){
        return operators.get(operator.trim());
    }

	public Integer getPriority(String operator){
		return operators.get(operator.trim()).getPriority();
	}
}
