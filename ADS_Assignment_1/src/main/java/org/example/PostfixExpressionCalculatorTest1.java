package org.example;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PostfixExpressionCalculatorTest1 {

    @Test
    public void testValidExpressions() {
        PostfixExpressionCalculator calculator = new PostfixExpressionCalculator();

        // Test case 1: Addition and multiplication
        ArrayList<Token> expression1 = new ArrayList<>();
        expression1.add(new Operand(5));
        expression1.add(new Operand(3));
        expression1.add(new Operator('+'));
        expression1.add(new Operand(4));
        expression1.add(new Operator('*'));
        int result1 = calculator.evaluateExpression(expression1);
        assertEquals(32, result1);

        // Test case 2: Division
        ArrayList<Token> expression2 = new ArrayList<>();
        expression2.add(new Operand(10));
        expression2.add(new Operand(2));
        expression2.add(new Operator('/'));
        int result2 = calculator.evaluateExpression(expression2);
        assertEquals(5, result2);

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
        assertEquals(132, result3);

        // Test case 4: Single operand
        ArrayList<Token> expression4 = new ArrayList<>();
        expression4.add(new Operand(42));
        int result4 = calculator.evaluateExpression(expression4);
        assertEquals(42, result4);
    }

    @Test
    public void testInvalidExpressions() {
        PostfixExpressionCalculator calculator = new PostfixExpressionCalculator();

        // Test case 5: Missing operator
        ArrayList<Token> expression5 = new ArrayList<>();
        expression5.add(new Operand(5));
        //expression5.add(new Operand(3));
        expression5.add(new Operator('+')); // Adding an operator to make it a valid expression
        assertThrows(IllegalArgumentException.class, () -> calculator.evaluateExpression(expression5));

        // Test case 6: Division by zero
        ArrayList<Token> expression6 = new ArrayList<>();
        expression6.add(new Operand(10));
        expression6.add(new Operand(0));
        expression6.add(new Operator('/'));
        assertThrows(ArithmeticException.class, () -> calculator.evaluateExpression(expression6));

        // Test case 7: Invalid operator
        ArrayList<Token> expression7 = new ArrayList<>();
        expression7.add(new Operand(5));
        expression7.add(new Operand(3));
        expression7.add(new Operator('%'));
        assertThrows(IllegalArgumentException.class, () -> calculator.evaluateExpression(expression7));
    }
}
