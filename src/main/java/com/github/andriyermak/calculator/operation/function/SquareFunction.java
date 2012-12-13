package com.github.andriyermak.calculator.operation.function;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 12.12.12
 * Time: 22:45
 * To change this template use File | Settings | File Templates.
 */
public class SquareFunction extends AbstractFunction implements UnaryFunction {

    public SquareFunction() {}

    public Double calculate(Double operand) {
        return Math.sqrt(operand);
    }
}
