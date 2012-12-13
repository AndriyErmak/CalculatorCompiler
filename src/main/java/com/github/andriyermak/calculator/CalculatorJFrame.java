package com.github.andriyermak.calculator;

import com.github.andriyermak.calculator.exception.CompilationException;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

/**
 * Created with IntelliJ IDEA.
 * User: def
 * Date: 13.12.12
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorJFrame extends JFrame{

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField tfExpression;
    private JTextField tfResult;

    public CalculatorJFrame() {
        setResizable(false);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 250, 345, 204);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblExpression = new JLabel("Input expression");
        lblExpression.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblExpression.setBounds(10, 19, 111, 19);
        contentPane.add(lblExpression);

        JLabel lblResult = new JLabel("Result: ");
        lblResult.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblResult.setBounds(10, 96, 53, 19);
        contentPane.add(lblResult);

        tfExpression = new JTextField();
        tfExpression.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfExpression.setBounds(10, 49, 319, 31);
        contentPane.add(tfExpression);

        tfResult = new JTextField();
        tfResult.setHorizontalAlignment(SwingConstants.RIGHT);
        tfResult.setEditable(false);
        tfResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfResult.setBounds(73, 90, 256, 31);
        contentPane.add(tfResult);

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                calculate();
            }
        });
        btnCalculate.setBounds(115, 134, 109, 31);
        contentPane.add(btnCalculate);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                tfExpression.setText("");
                tfResult.setText("");
                tfExpression.grabFocus();
            }
        });
        btnClear.setBounds(254, 7, 75, 31);
        contentPane.add(btnClear);

        tfExpression.grabFocus();
    }

    private void calculate(){
        String strExpr = "";
        try {
            strExpr = tfExpression.getText().trim();
            Double result = CreatorOfNode.getInstance().buildNode(strExpr).execute();
            tfResult.setText(result.toString());
        } catch (CompilationException e) {
            tfExpression.grabFocus();
            tfExpression.setCaretPosition(e.getErrorPosition());
            JOptionPane.showMessageDialog(new CalculatorJFrame(), e.getMessage(), "Compilation exception", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
