package com.github.andriyermak.calculator.node;

import com.github.andriyermak.calculator.CreatorOfNode;
import com.github.andriyermak.calculator.operation.FunctionFactory;
import com.github.andriyermak.calculator.exception.CompilationException;

import java.util.ArrayList;
import java.util.List;

public class NodeMultiplay extends TreeExpression {
		
    private List<TreeExpression> operands;
    private final String operator;
    private final int startPosition;
    private final String OPENBRACKET = "(";
    private final String CLOSEBRACKET = ")";
    private final String COMMA = ",";

    public NodeMultiplay(int startPosition, String expression, Integer positionOpenBracket, Integer positionCloseBracket)
            throws CompilationException {

	    	this.startPosition = startPosition;
	    	operands = new ArrayList<TreeExpression>();
	    	int position = positionOpenBracket+1;
	    	int inBracket = 0;
	    	int startOperand = position;
	    	String expr = "";
	    	//Add operands to tree
	    	while(position< positionCloseBracket){
	    		if(expression.startsWith(OPENBRACKET, position)) inBracket++;
	    		if(expression.startsWith(CLOSEBRACKET, position)) inBracket--;
	    		if(expression.startsWith(COMMA, position) && inBracket==0){
	    			expr = expression.substring(startOperand, position);
	    	        this.operands.add(CreatorOfNode.getInstance().buildNode(this.startPosition +startOperand, expr));
	    	        startOperand = position+1;
	    		}
	    		position++;
	    	}
	    	//Add end operand to tree
	    	expr = expression.substring(startOperand, position);
	        this.operands.add(CreatorOfNode.getInstance().buildNode(this.startPosition +startOperand, expr));
	    	
	        this.operator = expression.substring(0, positionOpenBracket);
	    }
	    
	    @Override
	    public Double execute() throws Exception {
	    	List<Double> doubleOperands = new ArrayList<Double>();
	    	for(TreeExpression te : operands){
	    		doubleOperands.add(te.execute());
	    	}
	    	
	    	return FunctionFactory.getInstance().executeFunction(operator, doubleOperands);
	    }
	      
}
