package com.github.andriyermak.calculator.operation.operator;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 12.12.12
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class Divide extends AbstractOperator implements BinaryOperator {

    public Divide(int priority) {
        super(priority);
    }

    public Double calculate(Double operandLeft, Double operandRight) throws ArithmeticException{
        if(operandRight.equals(new Double(0)))
            throw new ArithmeticException("Division by zero!");
        return (operandLeft / operandRight);
    }

}
