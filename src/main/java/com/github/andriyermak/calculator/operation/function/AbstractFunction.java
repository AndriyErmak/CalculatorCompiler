package com.github.andriyermak.calculator.operation.function;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 12.12.12
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public class AbstractFunction {

    public boolean isUnary(){
        Class[] interfaces = this.getClass().getInterfaces();
        for(Class clazz : interfaces){
            if(clazz.toString().contains("UnaryFunction"))
                return true;
        }
        return false;
    }

    public boolean isBinary(){
        Class[] interfaces = this.getClass().getInterfaces();
        for(Class clazz : interfaces){
            if(clazz.toString().contains("BinaryFunction"))
                return true;
        }
        return false;
    }

    public boolean isMulty(){
        Class[] interfaces = this.getClass().getInterfaces();
        for(Class clazz : interfaces){
            if(clazz.toString().contains("MultyFunction"))
                return true;
        }
        return false;
    }
}
