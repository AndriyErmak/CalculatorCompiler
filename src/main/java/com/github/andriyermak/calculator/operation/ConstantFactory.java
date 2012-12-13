package com.github.andriyermak.calculator.operation;

import java.util.HashMap;
import java.util.Map;

public class ConstantFactory {
	
	private static ConstantFactory instance = new ConstantFactory();
	
	private Map<String, Double> constans;
	
	private ConstantFactory(){
		constans = new HashMap<String, Double>();
		//constans.put("pi", Math.PI);
	}
	
	public static ConstantFactory getInstance(){
		return instance;
	}
	
	public Double getConstant(String constant){
		return constans.get(constant);
	}
	
	public boolean isConstant(String constant){
		return constans.get(constant.trim().toLowerCase())!=null;
	}
}
