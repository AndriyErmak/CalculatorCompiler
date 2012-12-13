package com.github.andriyermak.calculator.operation.function;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 13.12.12
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */
public class SumFunction extends AbstractFunction implements MultyFunction {

    public Double calculate(List<Double> operands) {
        Double operand = operands.get(0);
        int length = operands.size();

        for(int i=1; i<length; i++){
            operand += operands.get(i);
        }
        return operand;
    }
}
