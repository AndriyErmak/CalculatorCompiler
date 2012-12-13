package com.github.andriyermak.calculator.node;

import com.github.andriyermak.calculator.CreatorOfNode;
import com.github.andriyermak.calculator.operation.FunctionFactory;
import com.github.andriyermak.calculator.operation.OperatorFactory;

import com.github.andriyermak.calculator.exception.CompilationException;


public class NodeUnary extends TreeExpression {
	
	private final TreeExpression operand;
    private final String operator;
    private final int startPosition;
    private final static String PLUS = "+";

    public NodeUnary(int startPosition, String expression, Integer startRightOperand)
            throws CompilationException {
    	this.startPosition = startPosition;
    	String expr = expression.substring(startRightOperand);
    	this.operand = CreatorOfNode.getInstance().buildNode(this.startPosition +startRightOperand, expr);
    	this.operator = expression.substring(0, startRightOperand);
    }
    
    public NodeUnary(int carret, String expression, Integer positionOpenBracket, Integer positionCloseBracket)
            throws CompilationException {
    	startPosition = carret;
    	String expr = expression.substring(positionOpenBracket+1, positionCloseBracket);
        this.operand = CreatorOfNode.getInstance().buildNode(startPosition +positionOpenBracket+1, expr);
        this.operator = expression.substring(0, positionOpenBracket).trim().length()>0 ? expression.substring(0, positionOpenBracket) : PLUS;
    }
    
    @Override
    public Double execute() throws Exception {
    	Double doubleOperand = operand.execute();
    	if(OperatorFactory.getInstance().isOperator(operator))
    		return OperatorFactory.getInstance().executeOperator(operator, doubleOperand);
    	if(FunctionFactory.getInstance().isFunction(operator))
    		return FunctionFactory.getInstance().executeFunction(operator, doubleOperand);
    	return null;
    }
    
}
