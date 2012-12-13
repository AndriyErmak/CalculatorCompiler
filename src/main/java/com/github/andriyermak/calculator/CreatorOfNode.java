package com.github.andriyermak.calculator;

import com.github.andriyermak.calculator.node.*;
import com.github.andriyermak.calculator.operation.ConstantFactory;
import com.github.andriyermak.calculator.operation.FunctionFactory;
import com.github.andriyermak.calculator.operation.OperatorFactory;
import com.github.andriyermak.calculator.exception.CompilationException;

public class CreatorOfNode {
	
	private int startExpr;
	private Integer endLeftOperand;
	private Integer startRightOperand;
	private Integer positionOpenBracket;
	private Integer positionCloseBracket;
    private final static String OPENBRACKET = "(";
    private final static String CLOSEBRACKET = ")";
    //private final static char DOT = '.';
	
	private static CreatorOfNode instance = new CreatorOfNode();
	
	private CreatorOfNode(){
		startExpr = 0;
	}
	
	public static CreatorOfNode getInstance(){
		return instance;
	}
	
	public TreeExpression buildNode(int startExpression, String expression) throws CompilationException {
		this.startExpr = startExpression;
		return analyzedExpression(expression);
	}

    public TreeExpression buildNode(String expression) throws CompilationException {
        this.startExpr = 0;
        return analyzedExpression(expression);
    }
	
	private TreeExpression analyzedExpression(String expr) throws CompilationException {
		
		if(expr.trim().length()>0){
			endLeftOperand = null;
			startRightOperand = null;
            positionOpenBracket = null;
			positionCloseBracket = null;
			
			int length = expr.length()-1;
			int position = length;
			
			while (position>-1 && 
					(Character.isDigit(expr.charAt(position)) ||
					 Character.isWhitespace(expr.charAt(position)) /*||
					 expr.charAt(position)==DOT*/)) {
				position--;
			}
			
			if(position==-1){ // OPERAND (only digit, space or "." in expression)   
				return new NodeOperand(startExpr, expr);
			} else {
                    if(expr.startsWith(OPENBRACKET, position)){
                        throw new CompilationException(position, "Open bracket without pair!");
                    }
                    if(expr.startsWith(CLOSEBRACKET, position)){
                        if(expr.substring(position).trim().length()==1){ // CORRECT EXPR ( ")" is end symbol)
                            return expressionWithBracket(position, expr);
                        } else { // Right operand is not defined
                            throw new CompilationException(position, "Operand without operator!");
                        }
                    }

                    if(OperatorFactory.getInstance().isOperator(expr.substring(position, position+1))){
                        return expressionWithOperator(position, expr);
                    }
                    throw new CompilationException(position, "Character is not valid!");
			}
		} else {
            throw new CompilationException(startExpr, "Expression is not defined!");
		}
	}
	
	private TreeExpression expressionWithOperator(int positionOperator, String expr) throws CompilationException {
		String operator = expr.substring(positionOperator, positionOperator+1);
		if(positionOperator!=(expr.length()-1) && expr.substring(positionOperator+1).trim().length()>0){
            int position = positionOperator;
			startRightOperand = position+1;
			endLeftOperand = position;
			position--;
			String new_operator;
			int in_bracket = 0;
			while(position>-1){
				if(expr.startsWith(OPENBRACKET, position)) in_bracket--;
	    		if(expr.startsWith(CLOSEBRACKET, position)) in_bracket++;
				if(in_bracket==0){
					if(!(Character.isDigit(expr.charAt(position)))){
						new_operator = expr.substring(position, position+1);
						if(OperatorFactory.getInstance().isOperator(new_operator)){
							// if priority new < priority old
							if(OperatorFactory.getInstance().getPriority(new_operator)< OperatorFactory.getInstance().getPriority(operator)){
                                operator = new_operator;
								startRightOperand = position+1;
								endLeftOperand = position;
							}
						}
					}
				}
				position--;
			}
			if(expr.substring(0, endLeftOperand).trim().length()==0){
				// Unary expression
				if(OperatorFactory.getInstance().getOperator(operator).isUnary()){ //if unary PLUS or MINUS
                    return new NodeUnary(startExpr, expr, startRightOperand);
                } else {
                    throw new CompilationException(positionOperator, "Illegal unary operator!");
                }
			} else {
				// Binary expression	
				return new NodeBinary(startExpr, expr, endLeftOperand, startRightOperand);
			}
		} else {
            throw new CompilationException(positionOperator, "Operator without operand!");
		}
	}
	
	private TreeExpression expressionWithBracket(int position, String expr) throws CompilationException {
		positionCloseBracket = position--;
		int inBracket = 1;
		while (position>-1 && inBracket!=0) {
			if(!(Character.isDigit(expr.charAt(position)))){
				if(expr.startsWith(OPENBRACKET, position))
					inBracket--;
	    		if(expr.startsWith(CLOSEBRACKET, position))
	    			inBracket++;
			}
    		if(inBracket==0)
                positionOpenBracket = position;
    		position--;
		}
		if(position==-1 && inBracket!=0){
            throw new CompilationException(positionCloseBracket, "Close bracket without pair!");
		} else {
			if(expr.substring(0, positionOpenBracket).trim().length()>0){
				// Analysed expression before open bracket
				while (position>-1) {
                    if(OperatorFactory.getInstance().isOperator(expr.substring(position, position+1)))
                        return expressionWithOperator(position, expr);
					if(expr.startsWith(OPENBRACKET, position))
                        throw new CompilationException(position, "Open bracket without pair!");
		    		if(expr.startsWith(CLOSEBRACKET, position))
                        throw new CompilationException(position+1, "Operator is not defined!");
		    		position--;
				}
				String nameFuncOrConst = expr.substring(0, positionOpenBracket);
			
				if(FunctionFactory.getInstance().isFunction(nameFuncOrConst)){
                     if(expr.substring(positionOpenBracket+1, positionCloseBracket).trim().length()>0){
                        if(FunctionFactory.getInstance().getFunction(nameFuncOrConst).isUnary())
                            return new NodeUnary(startExpr, expr, positionOpenBracket, positionCloseBracket);
                        if(FunctionFactory.getInstance().getFunction(nameFuncOrConst).isMulty())
                            return new NodeMultiplay(startExpr, expr, positionOpenBracket, positionCloseBracket);
                     } else {
                         throw new CompilationException(positionOpenBracket, "Function argument is not defined!");
                     }
				}
					 
				if(ConstantFactory.getInstance().isConstant(nameFuncOrConst)){
					if(expr.substring(positionOpenBracket+1, positionCloseBracket).trim().length()==0){
                        return new NodeOperand(startExpr, nameFuncOrConst);
                    } else {
                        throw new CompilationException(positionOpenBracket, "Illegal argument in constant!");
                    }
				}

                throw new CompilationException(positionOpenBracket, "Unknown signature of expression!");
			} else { //Delete open and close bracket in (1+2)
				return new NodeUnary(startExpr + positionOpenBracket, expr, positionOpenBracket, positionCloseBracket);
			}
		}
	}
	
}
