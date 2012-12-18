package com.github.andriyermak.calculator;

import com.github.andriyermak.calculator.exception.CompilationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 18.12.12
 * Time: 9:28
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionFunction {

    @Test
    public void functionUnknownErrorPosition() throws Exception {
        try {
            String strExpr = " unknown ( 1 ) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing function Unknown");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with function Unknown",
                    9, e.getErrorPosition());
        }
    }

    @Test
    public void functionUnknownMessage() throws Exception {
        try {
            String strExpr = " unknown ( 1 ) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing function Unknown");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with function Unknown",
                    "Unknown signature of expression!", e.getMessage());
        }
    }

    @Test
    public void functionMinWithoutArgumentErrorPosition() throws Exception {
        try {
            String strExpr = " min (  ) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing function Min without argument in brackets");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with function Min without argument in brackets",
                    6, e.getErrorPosition());
        }
    }

    @Test
    public void functionMinWithoutArgumentMessage() throws Exception {
        try {
            String strExpr = " min (  ) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing function Min without argument in brackets");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with function Min without argument in brackets",
                    "Argument function is not defined!", e.getMessage());
        }
    }

    @Test
    public void functionSquareWithMultyArgumentErrorPosition() throws Exception {
        try {
            String strExpr = " sqrt ( 2,3 ) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing function Square with multy argument");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with function Square with multy argument",
                    9, e.getErrorPosition());
        }
    }

    @Test
    public void functionSquareWithMultyArgumentMessage() throws Exception {
        try {
            String strExpr = " sqrt ( 2,3 ) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing function Square with multy argument");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with function Square with multy argument",
                    "Character is not valid!", e.getMessage());
        }
    }
}
