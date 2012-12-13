package com.github.andriyermak.calculator.operation.function;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 12.12.12
 * Time: 22:48
 * To change this template use File | Settings | File Templates.
 */
public class MinFunction extends AbstractFunction implements MultyFunction {

    public Double calculate(List<Double> operands) {
        Double operand = operands.get(0);
        int length = operands.size();
        Double buffer;

        for(int i=1; i<length; i++){
            buffer = operands.get(i);
            if(buffer<operand) operand = buffer;
        }
        return operand;
    }
}
