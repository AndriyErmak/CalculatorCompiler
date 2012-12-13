package com.github.andriyermak.calculator.operation.operator;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 12.12.12
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class Pow extends AbstractOperator implements BinaryOperator {

    public Pow(int priority) {
        super(priority);
    }

    public Double calculate(Double operandLeft, Double operandRight) {
        return Math.pow(operandLeft, operandRight);
    }
}
