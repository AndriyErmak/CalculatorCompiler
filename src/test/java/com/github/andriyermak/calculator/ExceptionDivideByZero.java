package com.github.andriyermak.calculator;

import com.github.andriyermak.calculator.exception.CompilationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 18.12.12
 * Time: 9:31
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionDivideByZero {

    @Test
    public void divideByZero() throws Exception {
        try {
            String strExpr = " 3 / 0 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing divide by zero");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with divide by zero",
                    3, e.getErrorPosition());
        }
    }

    @Test
    public void constantPiWithParameterMessage() throws Exception {
        try {
            String strExpr = " 3 / 0 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing divide by zero");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with divide by zero",
                    "ArithmeticException: Division by zero!", e.getMessage());
        }
    }
}
