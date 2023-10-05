package org.example;

import org.example.Token;
import org.example.Operand;
import org.example.Operator;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Test cases
        ArrayList<Token> expression1 = new ArrayList<>();
        expression1.add(new Operand(5));
        expression1.add(new Operand(3));
        expression1.add(new Operator('+'));
        expression1.add(new Operand(4));
        expression1.add(new Operator('*'));

        ArrayList<Token> expression2 = new ArrayList<>();
        expression2.add(new Operand(10));
        expression2.add(new Operand(2));
        expression2.add(new Operator('/'));

        PostfixExpressionCalculator calculator = new PostfixExpressionCalculator();

        int result1 = calculator.evaluateExpression(expression1);
        System.out.println("Result of expression1: " + result1); // Should print 35

        int result2 = calculator.evaluateExpression(expression2);
        System.out.println("Result of expression2: " + result2); // Should print 5
    }
}
