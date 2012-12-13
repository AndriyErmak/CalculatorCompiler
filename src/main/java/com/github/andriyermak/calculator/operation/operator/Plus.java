package com.github.andriyermak.calculator.operation.operator;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 12.12.12
 * Time: 14:56
 * To change this template use File | Settings | File Templates.
 */
public class Plus extends AbstractOperator implements UnaryOperator, BinaryOperator {

    public Plus(int priority) {
        super(priority);
    }

    public Double calculate(Double operandLeft, Double operandRight) {
        return (operandLeft + operandRight);
    }

    public Double calculate(Double operator) {
        return operator;
    }
}
