package com.github.andriyermak.calculator.exception;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 11.12.12
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
public class CompilationException extends Exception {

    private int errorPosition;

    public CompilationException(int errorPosition, String message){
        super(message);
        this.errorPosition=errorPosition;
    }

    public int getErrorPosition() {
        return errorPosition;
    }

}
