/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB7_1;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class PostfixEvaluator {

    private Stack<Integer> operandStack;
    private static final String OPERATORS = "+-*/";

    public PostfixEvaluator() {
        operandStack = new Stack<>();
    }

    private int evalOp(char op) throws Exception {
        int rightInt = operandStack.pop();
        int leftInt = operandStack.pop();
        int result = 0;
        if (op == '+') {
            result =  rightInt + leftInt;
        } else if (op == '-') {
            result = leftInt - rightInt;
        } else if (op == '*') {
            result = leftInt * rightInt;
        } else if (op == '/') {
            result = leftInt / rightInt;
        } else {
            throw new Exception("Not a operand");
        }
        
        operandStack.push(result);
        return result;
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws SyntaxErrorException {
        String tokens[] = expression.split(" +");
        try {
            for (String nextToken : tokens) {
                if (Character.isDigit(nextToken.charAt(0))) {
                    operandStack.push(Integer.parseInt(nextToken));
                } else if (isOperator(nextToken.charAt(0))) {
                    try {
                        evalOp(nextToken.charAt(0));
                    } catch (Exception ex) {
                        Logger.getLogger(PostfixEvaluator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    throw new SyntaxErrorException("Invalid character encountered: " + nextToken);
                }
            }
            return operandStack.pop();
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax error. The stack is empty");
        }
    }

    public static class SyntaxErrorException extends Exception {

        private String message;

        public SyntaxErrorException(String string) {
            message = string;
        }

        public String getMessage() {
            return message;
        }
    }
}
