package com.github.andriyermak.calculator.node;

import com.github.andriyermak.calculator.CreatorOfNode;
import com.github.andriyermak.calculator.operation.OperatorFactory;
import com.github.andriyermak.calculator.exception.CompilationException;

public class NodeBinary extends TreeExpression {
	private final TreeExpression operandLeft;
	private final TreeExpression operandRight;
	private final String operator;
	private final int startPosition;
    private final int endOperandLeft;
	
    public NodeBinary(int startPosition, String expression, Integer endOperandLeft, Integer startOperandRight)
            throws CompilationException {
        this.startPosition = startPosition;
        this.endOperandLeft = endOperandLeft;
    	String exprLeft = expression.substring(0, endOperandLeft);
    	this.operandLeft = CreatorOfNode.getInstance().buildNode(this.startPosition, exprLeft);

    	String exprRight = expression.substring(startOperandRight);
        this.operandRight = CreatorOfNode.getInstance().buildNode(this.startPosition +startOperandRight, exprRight);

        this.operator = expression.substring(endOperandLeft, startOperandRight);
    }

    @Override
    public Double execute() throws Exception {
    	Double opLeft = operandLeft.execute();
    	Double opRight = operandRight.execute();
    	try{
    	    return OperatorFactory.getInstance().executeOperator(opLeft, operator, opRight);
        } catch (ArithmeticException e) {
            throw new CompilationException(startPosition+endOperandLeft, "ArithmeticException: " + e.getMessage());
        }
    }
}
