package com.github.andriyermak.calculator;

public class Calculator {

	public static void main(String[] args) {
        if(args.length>0){
            boolean command = false;
            for(String str : args){
                if(str.trim().equalsIgnoreCase("-c")){
                    command = true;
                    break;
                }
            }
            if(command){
                new CalculatorCommandLine();
            } else {
                new CalculatorJFrame().setVisible(true);
            }
        } else {
            new CalculatorJFrame().setVisible(true);
        }
	}
}