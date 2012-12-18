package com.github.andriyermak.calculator;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 18.12.12
 * Time: 9:17
 * To change this template use File | Settings | File Templates.
 */
public class CorrectConstant {

    @Test
    public void constantPI() throws Exception {
        String strExpr = " pi( ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated PI Constant",
                result.equals(Math.PI));
    }
}
