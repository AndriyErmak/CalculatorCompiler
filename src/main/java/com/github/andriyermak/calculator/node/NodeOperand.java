package com.github.andriyermak.calculator.node;

import com.github.andriyermak.calculator.exception.CompilationException;
import com.github.andriyermak.calculator.operation.ConstantFactory;

public class NodeOperand extends TreeExpression {
    private Double operand;

    public NodeOperand(int startPosition, String expression) throws CompilationException{
    	if(ConstantFactory.getInstance().isConstant(expression)){
    		this.operand = ConstantFactory.getInstance().getConstant(expression);
    	}
    	else{
    		try{
    			this.operand = new Double(expression.trim());
			}
			catch (NumberFormatException e) { // if "1 2" (blank in operand)
                throw new CompilationException(startPosition, "Number Format Exception!");
			}
    	}
    }
    
    public Double execute() {
    	return operand;
    }
}
