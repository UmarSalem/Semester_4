package org.example;

import org.example.Token;
import org.example.Operand;
import org.example.Operator;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixExpressionCalculator {
    private Stack<Operand> operandStack;

    public PostfixExpressionCalculator() {
        operandStack = new Stack<>();
    }

    public int evaluateExpression(ArrayList<Token> tokenList) {
        for (Token token : tokenList) {
            if (token instanceof Operand) {
                operandStack.push((Operand) token);
            } else if (token instanceof Operator) {
                performOperation((Operator) token);
            }
        }
        return getResult();
    }

    private void performOperation(Operator operator) {
        if (operandStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }
        Operand operand2 = operandStack.pop();
        if (operandStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }
        Operand operand1 = operandStack.pop();

        char symbol = operator.getSymbol();
        int result;
        switch (symbol) {
            case '+':
                result = operand1.getValue() + operand2.getValue();
                break;
            case '-':
                result = operand1.getValue() - operand2.getValue();
                break;
            case '*':
                result = operand1.getValue() * operand2.getValue();
                break;
            case '/':
                if (operand2.getValue() == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                result = operand1.getValue() / operand2.getValue();
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + symbol);
        }
        operandStack.push(new Operand(result));
    }

    public int getResult() {
        if (operandStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }
        return operandStack.peek().getValue();
    }
}
