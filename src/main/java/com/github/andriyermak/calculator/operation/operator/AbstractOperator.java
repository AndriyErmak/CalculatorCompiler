package com.github.andriyermak.calculator.operation.operator;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 12.12.12
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractOperator {
    protected final int priority;

    public AbstractOperator(int priority){
        this.priority = priority;
    }

    public boolean isUnary(){
        Class[] interfaces = this.getClass().getInterfaces();
        for(Class clazz : interfaces){
            if(clazz.toString().contains("UnaryOperator"))
                return true;
        }
        return false;
    }

    public int getPriority() {
        return priority;
    }
}
