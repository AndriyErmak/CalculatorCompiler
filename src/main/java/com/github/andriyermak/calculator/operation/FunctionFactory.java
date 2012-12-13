package com.github.andriyermak.calculator.operation;

import com.github.andriyermak.calculator.operation.function.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionFactory {
	
	private static FunctionFactory instance = new FunctionFactory();
	private Map<String, AbstractFunction> functions;
	
	private FunctionFactory(){
		functions = new HashMap<String, AbstractFunction>();
		//functions.put("sqrt", new SquareFunction());
		//functions.put("min", new MinFunction());
        //functions.put("max", new MaxFunction());
        //functions.put("sum", new SumFunction());
	}
	
	public static FunctionFactory getInstance(){
		return instance;
	}
	
	public Double executeFunction(String function, Double operand){
		UnaryFunction func = (UnaryFunction) this.getFunction(function);
		return func.calculate(operand);
	}
	
	public Double executeFunction(String function, List<Double> operands){
		MultyFunction func = (MultyFunction) this.getFunction(function);
        return func.calculate(operands);
	}
	
	public boolean isFunction(String function){
		return functions.get(function.trim().toLowerCase())!=null;
	}

    public AbstractFunction getFunction(String function){
        return functions.get(function.trim().toLowerCase());
    }
	
}
