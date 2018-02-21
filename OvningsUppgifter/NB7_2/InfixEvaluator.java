package NB7_2;

import java.util.Stack;
import java.util.EmptyStackException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InfixEvaluator {

    public static class SyntaxErrorException extends Exception {

        SyntaxErrorException(String message) {
            super(message);
        }
    }

    private Stack<Integer> integers;
    private Stack<Character> operators;

    private static final String OPERATORS = "+-*/()";
    private static final String PARANTES = "()";

    public InfixEvaluator() {
        operators = new Stack<>();
        integers = new Stack<>();
    }

    private int evalOp(char op) throws Exception {
        int rightInt = integers.pop();
        int leftInt = integers.pop();
        int result = 0;
        if (op == '+') {
            result = rightInt + leftInt;
        } else if (op == '-') {
            result = leftInt - rightInt;
        } else if (op == '*') {
            result = leftInt * rightInt;
        } else if (op == '/') {
            result = leftInt / rightInt;
        } else {
            throw new Exception("Not a operand");
        }

        integers.push(result);
        return result;
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }
    
    private boolean isParant(char ch) {
        return PARANTES.indexOf(ch) != -1;
    }

    private boolean compOperators(char charExp, char charStack) throws SyntaxErrorException {
        int expVal, stackVal;
        expVal = getValFromOperator(charExp);
        stackVal = getValFromOperator(charStack);

        System.out.println("expVal: " + expVal);
        System.out.println("stackVal: " + stackVal);

        if (expVal == -1 || stackVal == -1) {
            throw new SyntaxErrorException("Invalid character encountered");
        }

        if (expVal < stackVal) {
            return false;
        } else {
            return true;
        }
    }

    private int getValFromOperator(char compChar) {
        switch (compChar) {
            case '+':
                return 0;
            case '-':
                return 0;
            case '*':
                return 1;
            case '/':
                return 1;
            case '(':
                return 2;
            case ')':
                return 2;
            default:
                return -1;
        }
    }

    private int calculate() throws SyntaxErrorException {
        int rightInt = integers.pop();
        int leftInt = integers.pop();
        char operator = operators.pop();

        switch (operator) {
            case '+':
                return integers.push(leftInt + rightInt);
            case '-':
                return integers.push(leftInt - rightInt);
            case '*':
                return integers.push(leftInt * rightInt);
            case '/':
                return integers.push(leftInt / rightInt);
        }
        throw new SyntaxErrorException("Invalid expression");
    }

    public int eval(String expression) throws SyntaxErrorException {
        String tokens[] = expression.split(" +");
        try {
            for (String nextToken : tokens) {
                if (Character.isDigit(nextToken.charAt(0))) {
                    integers.push(Integer.parseInt(nextToken));
                } else if (isOperator(nextToken.charAt(0))) {
                    char tmpOperator = nextToken.charAt(0);
                    if (operators.isEmpty()) {
                        operators.push(tmpOperator);
                    } else {
                        if (!compOperators(tmpOperator, operators.peek())) { //expChar is lower then operator on stack
                            System.out.println("new operator is lower value");
                            System.out.println("before: " + operators.peek());
                            System.out.println("new: " + tmpOperator);
                            operators.push(nextToken.charAt(0));
                        } else {
                            System.out.println("new operator is higher or equal value");
                            if (tmpOperator == '(') {
                                operators.push(tmpOperator);
                                break;
                            }
                            
                            if (operators.peek() == ')') {
                                operators.pop();
                            } else {
                              //wait  operators.push(tmpOperator)
                            }
                            
                            while (!operators.isEmpty() && compOperators(tmpOperator, operators.peek())) {
                                //check that integerstack has size == 2, if not throw invalid exp exception
                                if (integers.size() < 2) {
                                    throw new SyntaxErrorException("Invalid expression: " + expression);
                                }
                                integers.push(calculate());
                                System.out.println("Integer stack after calc: " + integers.toString());
                            }

                            operators.push(tmpOperator);
                        }
                    }

                } else if (isParant(nextToken.charAt(0))) {
                    if (nextToken.charAt(0) == '(') {
                        operators.push(nextToken.charAt(0));
                    } else {
                 //       while (operators.operators.peek() != '(') {
                  //          integers.push(calculate());
                  //      }
                        operators.pop();
                    }
                }else {
                    throw new SyntaxErrorException("Invalid character encountered: " + nextToken);
                }

            }
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax error. The stack is empty");
        }

        while (!operators.isEmpty()) {
            integers.push(calculate());
        }

        int returnVal = integers.pop();
        integers.clear();

        System.out.println(integers.toString());
        System.out.println(operators.toString());

        integers.clear();

        return returnVal;
    }
}
