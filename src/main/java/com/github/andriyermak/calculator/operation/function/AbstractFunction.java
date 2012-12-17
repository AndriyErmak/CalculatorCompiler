package com.github.andriyermak.calculator.operation.function;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 12.12.12
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public class AbstractFunction {

    public AbstractFunction() throws Exception {
        //Function implement only one interface from
        int impl = 0;
        if(isUnary())
            impl++;
        if(isBinary())
            impl++;
        if(isMulty())
            impl++;
        if(impl==0)
            throw new Exception("Interface is not implemented: UnaryFunction or BinaryFunction or MultyFunction!");
        if(impl>1)
            throw new Exception("More than one interface was implemented (UnaryFunction or BinaryFunction or MultyFunction)!");
    }

    public boolean isUnary(){
        Class[] interfaces = this.getClass().getInterfaces();
        for(Class clazz : interfaces){
            if(clazz.equals(UnaryFunction.class))
                return true;
        }
        return false;
    }

    public boolean isBinary(){
        Class[] interfaces = this.getClass().getInterfaces();
        for(Class clazz : interfaces){
            if(clazz.equals(BinaryFunction.class))
                return true;
        }
        return false;
    }

    public boolean isMulty(){
        Class[] interfaces = this.getClass().getInterfaces();
        for(Class clazz : interfaces){
            if(clazz.equals(MultyFunction.class))
                return true;
        }
        return false;
    }
}
