package com.github.andriyermak.calculator.operation.operator;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 12.12.12
 * Time: 14:40
 * To change this template use File | Settings | File Templates.
 */
public interface BinaryOperator {
    Double calculate(Double operandLeft, Double operandRight);
}
