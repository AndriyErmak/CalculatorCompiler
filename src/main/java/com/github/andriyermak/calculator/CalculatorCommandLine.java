package com.github.andriyermak.calculator;

import com.github.andriyermak.calculator.exception.CompilationException;
import com.github.andriyermak.calculator.node.TreeExpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 13.12.12
 * Time: 12:55
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorCommandLine {

    public CalculatorCommandLine(){
        String strExpr = "";
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("CALCULATOR");
        System.out.println("Enter 'quit' for exit.");

        do {
            System.out.println("Enter an expression for the calculation:");
            try {
                strExpr = bufferReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(!strExpr.equals("quit")){
                // Expression compile and calculate
                try {
                    TreeExpression expression = CreatorOfNode.getInstance().buildNode(strExpr);
                    Double result = expression.execute();
                    System.out.println("Result of calculation expression: " + result);
                    System.out.println();
                } catch (CompilationException e) {
                    System.out.println("Message: "+ e.getMessage());
                    System.out.println("Error position: " + e.getErrorPosition());
                    //e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (!strExpr.equals("quit"));
    }
}
