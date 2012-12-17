package com.github.andriyermak.calculator;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 14.12.12
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
public class CorrectSimpleExpression {

    @Test
    public void operand() throws Exception {
        String strExpr = " 1 ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Simple Operand",
                result.equals(new Double(1)));
    }

    @Test
    public void operandWithUnaryMinus() throws Exception {
        String strExpr = " -1 ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Operand With Unary Minus",
                result.equals(new Double(-1)));
    }

    @Test
    public void operandWithUnaryPlus() throws Exception {
        String strExpr = " + 1 ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Operand With Unary Plus",
                result.equals(new Double(1)));
    }

    @Test
    public void operandWithDot() throws Exception {
        String strExpr = " 1.2 ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Operand With Dot",
                result.equals(new Double(1.2)));
    }

    @Test
    public void operatorPlus() throws Exception {
        String strExpr = " 1 + 2 ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Plus Operator ",
                result.equals(new Double(3)));
    }

    @Test
    public void operatorMinus() throws Exception {
        String strExpr = " 1 - 2 ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Minus Operator ",
                result.equals(new Double(-1)));
    }

    @Test
    public void operatorMultiply() throws Exception {
        String strExpr = " 1 * 2 ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Multiply Operator ",
                result.equals(new Double(2)));
    }

    @Test
    public void operatorDivide() throws Exception {
        String strExpr = " 1 / 2 ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Divide Operator ",
                result.equals(new Double(0.5)));
    }

    @Test
    public void operatorPow() throws Exception {
        String strExpr = " 2 ^ 2 ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated Pow Operator ",
                result.equals(new Double(4)));
    }

    @Test
    public void operatorPriority() throws Exception {
        String strExpr = "  2 + 1  * 3 ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Corrected Priority Operator",
                result.equals(new Double(5)));
    }
}
