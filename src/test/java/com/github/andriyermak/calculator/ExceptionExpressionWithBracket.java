package com.github.andriyermak.calculator;

import com.github.andriyermak.calculator.exception.CompilationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 14.12.12
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionExpressionWithBracket {

    @Test
    public void operandsInBracketWithoutOperatorErrorPosition() throws Exception {
        try {
            String strExpr = " (1 + 1) (1 - 1) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operands in bracket without operator");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with operands in bracket without operator",
                    8, e.getErrorPosition());
        }
    }

    @Test
    public void operandsInBracketWithoutOperatorMessage() throws Exception {
        try {
            String strExpr = " (1 + 1) (1 - 1) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operands in bracket without operator");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with operands in bracket without operator",
                    "Operator is not defined!", e.getMessage());
        }
    }

    @Test
    public void operandWithoutOperatorErrorPosition() throws Exception {
        try {
            String strExpr = " 1 (1 - 1) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operand without operator before brackets");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with operand without operator before brackets",
                    3, e.getErrorPosition());
        }
    }

    @Test
    public void operandWithoutOperatorMessage() throws Exception {
        try {
            String strExpr = " 1 (1 - 1) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operand without operator before brackets");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with operand without operator before brackets",
                    "Unknown signature of expression!", e.getMessage());
        }
    }

    @Test
    public void closeBracketWithoutPairErrorPosition() throws Exception {
        try {
            String strExpr = "1+ (1 - 1)) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing close bracket without pair");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with close bracket without pair",
                    10, e.getErrorPosition());
        }
    }

    @Test
    public void closeBracketWithoutPairMessage() throws Exception {
        try {
            String strExpr = "1+ (1 - 1)) ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing close bracket without pair");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with close bracket without pair",
                    "Close bracket without pair!", e.getMessage());
        }
    }

    @Test
    public void closeBracketBeforeNumberErrorPosition() throws Exception {
        try {
            String strExpr = " (1 - 1) 1 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing close bracket before number");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with close bracket before number",
                    8, e.getErrorPosition());
        }
    }

    @Test
    public void closeBracketBeforeNumberMessage() throws Exception {
        try {
            String strExpr = " (1 - 1) 1 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing close bracket before number");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with close bracket before number",
                    "Operand without operator!", e.getMessage());
        }
    }

    @Test
    public void openBracketWithoutPairBeforeNumberErrorPosition() throws Exception {
        try {
            String strExpr = " ( 1 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing open bracket without pair before number");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with open bracket without pair before number",
                    1, e.getErrorPosition());
        }
    }

    @Test
    public void openBracketWithoutPairBeforeNumberMessage() throws Exception {
        try {
            String strExpr = " ( 1 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing open bracket without pair before number");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with open bracket without pair before number",
                    "Open bracket without pair!", e.getMessage());
        }
    }

    @Test
    public void openBracketWithoutPairBeforeOperandInBracketErrorPosition() throws Exception {
        try {
            String strExpr = " ( (1 - 1)  ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing open bracket without pair before operand in bracket");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with open bracket without pair before operand in bracket",
                    1, e.getErrorPosition());
        }
    }

    @Test
    public void openBracketWithoutPairBeforeOperandInBracketMessage() throws Exception {
        try {
            String strExpr = " ( (1 - 1)  ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing open bracket without pair before operand in bracket");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with open bracket without pair before operand in bracket",
                    "Open bracket without pair!", e.getMessage());
        }
    }
}
