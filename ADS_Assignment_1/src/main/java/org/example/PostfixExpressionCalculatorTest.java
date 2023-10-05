package org.example;

import java.util.ArrayList;

public class PostfixExpressionCalculatorTest {
    public static void main(String[] args) {
        testValidExpressions();
        testInvalidExpressions();
    }

    // Test valid postfix expressions
    private static void testValidExpressions() {
        PostfixExpressionCalculator calculator = new PostfixExpressionCalculator();

        // Test case 1: Addition and multiplication
        ArrayList<Token> expression1 = new ArrayList<>();
        expression1.add(new Operand(5));
        expression1.add(new Operand(3));
        expression1.add(new Operator('+'));
        expression1.add(new Operand(4));
        expression1.add(new Operator('*'));
        int result1 = calculator.evaluateExpression(expression1);
        System.out.println("Result of expression1: " + result1); // Should print 35

        // Test case 2: Division
        ArrayList<Token> expression2 = new ArrayList<>();
        expression2.add(new Operand(10));
        expression2.add(new Operand(2));
        expression2.add(new Operator('/'));
        int result2 = calculator.evaluateExpression(expression2);
        System.out.println("Result of expression2: " + result2); // Should print 5

        // Test case 3: Complex expression with multiple operators
        ArrayList<Token> expression3 = new ArrayList<>();
        expression3.add(new Operand(3));
        expression3.add(new Operand(5));
        expression3.add(new Operand(7));
        expression3.add(new Operator('*'));
        expression3.add(new Operand(2));
        expression3.add(new Operator('-'));
        expression3.add(new Operand(4));
        expression3.add(new Operator('*'));
        int result3 = calculator.evaluateExpression(expression3);
        System.out.println("Result of expression3: " + result3); // Should print 38

        // Test case 4: Single operand
        ArrayList<Token> expression4 = new ArrayList<>();
        expression4.add(new Operand(42));
        int result4 = calculator.evaluateExpression(expression4);
        System.out.println("Result of expression4: " + result4); // Should print 42
    }

    // Test invalid postfix expressions
    private static void testInvalidExpressions() {
        PostfixExpressionCalculator calculator = new PostfixExpressionCalculator();

        // Test case 5: Missing operator
        ArrayList<Token> expression5 = new ArrayList<>();
        expression5.add(new Operand(5));
        expression5.add(new Operand(3));
        try {
            calculator.evaluateExpression(expression5);
        } catch (IllegalArgumentException e) {
            System.out.println("Result of expression5: " + e.getMessage()); // Should print "Invalid postfix expression."
        }

        // Test case 6: Division by zero
        ArrayList<Token> expression6 = new ArrayList<>();
        expression6.add(new Operand(10));
        expression6.add(new Operand(0));
        expression6.add(new Operator('/'));
        try {
            calculator.evaluateExpression(expression6);
        } catch (ArithmeticException e) {
            System.out.println("Result of expression6: " + e.getMessage()); // Should print "Division by zero."
        }

        // Test case 7: Invalid operator
        ArrayList<Token> expression7 = new ArrayList<>();
        expression7.add(new Operand(5));
        expression7.add(new Operand(3));
        expression7.add(new Operator('%'));
        try {
            calculator.evaluateExpression(expression7);
        } catch (IllegalArgumentException e) {
            System.out.println("Result of expression7: " + e.getMessage()); // Should print "Invalid operator: %"
        }
    }
}
