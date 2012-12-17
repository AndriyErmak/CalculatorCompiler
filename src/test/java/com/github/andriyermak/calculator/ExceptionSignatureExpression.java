package com.github.andriyermak.calculator;

import com.github.andriyermak.calculator.exception.CompilationException;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 14.12.12
 * Time: 11:45
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionSignatureExpression {

    @Test
    public void expressionNullErrorPosition() throws Exception {
        try {
            String strExpr = null;
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing NULL expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in NULL expression",
                    0, e.getErrorPosition());
        }
    }

    @Test
    public void expressionNullMessage() throws Exception {
        try {
            String strExpr = null;
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing NULL expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for NULL expression",
                    "Expression is not defined!", e.getMessage());
        }
    }

    @Test
    public void expressionEmptyErrorPosition() throws Exception {
        try {
            String strExpr = "";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing empty expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in empty expression",
                    0, e.getErrorPosition());
        }
    }

    @Test
    public void expressionEmptyMessage() throws Exception {
        try {
            String strExpr = "";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing empty expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for empty expression",
                    "Expression is not defined!", e.getMessage());
        }
    }

    @Test
    public void expressionSpaceErrorPosition() throws Exception {
        try {
            String strExpr = " ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing space expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in space expression",
                    0, e.getErrorPosition());
        }
    }

    @Test
    public void expressionSpaceMessage() throws Exception {
        try {
            String strExpr = " ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing space expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for space expression",
                    "Expression is not defined!", e.getMessage());
        }
    }

    @Test
    public void expressionUnknownErrorPosition() throws Exception {
        try {
            String strExpr = "Unknown";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing unknown expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in unknown expression",
                    6, e.getErrorPosition());
        }
    }

    @Test
    public void expressionUnknownMessage() throws Exception {
        try {
            String strExpr = "Unknown";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing unknown expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for unknown expression",
                    "Character is not valid!", e.getMessage());
        }
    }

    @Test
    public void operatorWithinSpaceErrorPosition() throws Exception {
        try {
            String strExpr = " 1 2 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operator within space");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with operator within space",
                    0, e.getErrorPosition());
        }
    }

    @Test
    public void operatorWithinSpaceMessage() throws Exception {
        try {
            String strExpr = " 1 2 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operator within space");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with operator within space",
                    "Number Format Is Fail!", e.getMessage());
        }
    }

    @Test
    public void operatorWithinTwoDotsErrorPosition() throws Exception {
        try {
            String strExpr = " 1..2 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operator within two dots");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with operator within two dots",
                    0, e.getErrorPosition());
        }
    }

    @Test
    public void operatorWithinTwoDotsMessage() throws Exception {
        try {
            String strExpr = " 1..2 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operator within two dots");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with operator within two dots",
                    "Number Format Is Fail!", e.getMessage());
        }
    }

    @Test
    public void operatorWithinCommaErrorPosition() throws Exception {
        try {
            String strExpr = " 1,2 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operator within comma");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with operator within comma",
                    2, e.getErrorPosition());
        }
    }

    @Test
    public void operatorWithinCommaMessage() throws Exception {
        try {
            String strExpr = " 1,2 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operator within comma");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with operator within comma",
                    "Character is not valid!", e.getMessage());
        }
    }

    @Test
    public void operatorWithoutOperandErrorPosition() throws Exception {
        try {
            String strExpr = " 1 + ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operator without operand expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with operator without operand expression",
                    3, e.getErrorPosition());
        }
    }

    @Test
    public void operatorWithoutOperandMessage() throws Exception {
        try {
            String strExpr = " 1 + ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operator without operand expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with operator without operand expression",
                    "Operator without operand!", e.getMessage());
        }
    }

    @Test
    public void operatorWithOperatorErrorPosition() throws Exception {
        try {
            String strExpr = " 1 + - 1 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operator with operator expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with operator with operator expression",
                    3, e.getErrorPosition());
        }
    }

    @Test
    public void operatorWithOperatorMessage() throws Exception {
        try {
            String strExpr = " 1 + - 1 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing operator with operator expression");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with operator with operator expression",
                    "Operator without operand!", e.getMessage());
        }
    }

    @Test
     public void unaryOperatorIsNotUnaryErrorPosition() throws Exception {
        try {
            String strExpr = " * 1 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing unary operator is not unary");
        } catch (CompilationException e) {
            assertEquals("Wrong error position in expression with unary operator is not unary",
                    1, e.getErrorPosition());
        }
    }

    @Test
    public void unaryOperatorIsNotUnaryMessage() throws Exception {
        try {
            String strExpr = " * 1 ";
            CreatorOfNode.getInstance().buildNode(strExpr).execute();
            fail("Exception wasn't thrown when testing unary operator is not unary");
        } catch (CompilationException e) {
            assertEquals("Wrong error message for expression with unary operator is not unary",
                    "Illegal unary operator!", e.getMessage());
        }
    }
}
