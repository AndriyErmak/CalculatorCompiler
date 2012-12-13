package com.github.andriyermak.calculator.operation.operator;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 12.12.12
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */
public class Multiply extends AbstractOperator implements BinaryOperator {

    public Multiply(int priority) {
        super(priority);
    }

    public Double calculate(Double operandLeft, Double operandRight) {
        return (operandLeft * operandRight);
    }
}
