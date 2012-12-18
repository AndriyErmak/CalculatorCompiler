package com.github.andriyermak.calculator;

import com.github.andriyermak.calculator.exception.CompilationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 18.12.12
 * Time: 9:19
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionConstant {

    @Test
    public void constantPiWithoutBracketsErrorPosition() throws Exception {
        try {
            String strExpr = " pi ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing constant PI without brackets");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with constant PI without brackets",
                    2, e.getErrorPosition());
        }
    }

    @Test
    public void constantPiWithoutBracketsMessage() throws Exception {
        try {
            String strExpr = " pi ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing constant PI without brackets");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with constant PI without brackets",
                    "Character is not valid!", e.getMessage());
        }
    }

    @Test
    public void constantPiWithParameterErrorPosition() throws Exception {
        try {
            String strExpr = " pi ( 1 ) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing constant PI with parameter in brackets");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with constant PI with parameter in brackets",
                    4, e.getErrorPosition());
        }
    }

    @Test
    public void constantPiWithParameterMessage() throws Exception {
        try {
            String strExpr = " pi ( 1 ) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing constant PI with parameter in brackets");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with constant PI with parameter in brackets",
                    "Illegal parameter in constant!", e.getMessage());
        }
    }
}
