package com.github.andriyermak.calculator;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 14.12.12
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
public class CorrectFunction {

    @Test
    public void functionSquare() throws Exception {
        String strExpr = " sqrt( 4 ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Square Function",
                result.equals(new Double(2)));
    }

    @Test
    public void functionMin() throws Exception {
        String strExpr = " min( 4 , 5, 6 ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Minimum Function",
                result.equals(new Double(4)));
    }

    @Test
    public void functionMax() throws Exception {
        String strExpr = " max( 4 , 5, 6 ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Maximum Function",
                result.equals(new Double(6)));
    }

    @Test
    public void functionSum() throws Exception {
        String strExpr = " sum( 4 , 5, 6 ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Sum Function",
                result.equals(new Double(15)));
    }

    @Test
    public void functionInFunction() throws Exception {
        String strExpr = " sum( min(5, sqrt (16), 6, 2+3),  5, max(-2, (2+3) , 5, sqrt (16), 6)) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Function In Function",
                result.equals(new Double(15)));
    }
}
