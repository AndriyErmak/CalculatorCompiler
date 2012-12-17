package com.github.andriyermak.calculator;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 14.12.12
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
public class CorrectExpressionWithBracket {

    @Test
    public void operandInBrackets() throws Exception {
        String strExpr = " ( 1 ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Operand In Brackets",
                result.equals(new Double(1)));
    }

    @Test
    public void operandWithUnaryMinusInBracket() throws Exception {
        String strExpr = " ( - 1 ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Operand With Unary Minus In Bracket",
                result.equals(new Double(-1)));
    }

    @Test
    public void bracketWithUnaryMinus() throws Exception {
        String strExpr = " - ( 1 ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Bracket With Unary Minus",
                result.equals(new Double(-1)));
    }

    @Test
    public void bracketWithUnaryPlus() throws Exception {
        String strExpr = " + ( 1 ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Bracket With Unary Plus",
                result.equals(new Double(1)));
    }

    @Test
    public void bracketWithUnaryMinusAndOperandWithUnaryMinus() throws Exception {
        String strExpr = " - ( - 1 ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Bracket With Unary Minus And Operand With Unary Minus",
                result.equals(new Double(1)));
    }

    @Test
    public void bracketInMultyBracket() throws Exception {
        String strExpr = " ((( 1 ))) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Multy Bracket In Bracket",
                result.equals(new Double(1)));
    }

    @Test
    public void bracketCorrectedPriorityOperator() throws Exception {
        String strExpr = " ( 2 + 1 ) * 3 ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Bracket Corrected Priority Operator",
                result.equals(new Double(9)));
    }

    @Test
    public void bracketOperatorAndBracket() throws Exception {
        String strExpr = " ( 2 + 1 ) / ( 4 - 1 ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Expression In Bracket, Operator And Expression In Bracket",
                result.equals(new Double(1)));
    }

    @Test
    public void bracketOperatorAndBracketWithUnaryMinus() throws Exception {
        String strExpr = " - ( 2 + 1 ) / ( 4 - 1 ) ";
        Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
        assertTrue("Result Is Not Valid Calculated For Expression In Bracket, Operator And Expression In Bracket With Unary Minus",
                result.equals(new Double(-1)));
    }
}
