package f_03_stack;

import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringJoiner;

/**
 *
 * @author tiago
 */
public class InfixToPostfix {
    private final static String OPERATORS = "*/+-";
    private final static int[] PRECEDENCE = {1, 1, 2, 2};
    private Stack<Character> operatorStack;
    private final StringJoiner postfix = new StringJoiner("");
 
    
   
    
    /** Converts a string from infix to postfix. Public convert is called
     * by a client - Calls private method convertToPostfix to do the conversion.
     * @param infix the string to convert to postfix
     * @throws java.lang.Exception
     * @return the equivalent postfix expression
     */
    public static String convert(String infix) throws Exception {

        InfixToPostfix infixToPostfix = new InfixToPostfix();
        infixToPostfix.convertToPostfix(infix);
        return infixToPostfix.getPostfix();
    }
    
    private InfixToPostfix() {
    
    }

    private String getPostfix() {
        return postfix.toString();
    }
    
    public void convertToPostfix(String infix) throws Exception {
        try {    
            for (int i = 0; i < infix.length(); i++) {
                char ch = infix.charAt(i);

                if (Character.isJavaIdentifierStart(ch)) {
                    postfix.add("" + ch);
                }
                else if (isOperator(ch)) {
                    processOperator(ch);
                }
                else {
                    throw new Exception("Unexpected Character Encountered: " + ch);
                }
            }
            // Pop any remaining operators and append them to postfix
            while (!operatorStack.isEmpty()) {
                char op = operatorStack.pop();
                postfix.add(new Character(op).toString());
            }
        } catch (NoSuchElementException ex) {
            throw new Exception("Syntax Error: The stack is empty");
        }
    }
    
    private void processOperator(char op) {
        if (operatorStack.isEmpty()) {
            operatorStack.push(op);
        } else {
            char topOp = operatorStack.peek();
            if (presedence(op) > presedence(topOp)) {
                operatorStack.push(op);
            }
            else {
                while (!operatorStack.isEmpty() && presedence(op) <= presedence(topOp)) {
                    operatorStack.pop();
                    postfix.add(new Character(topOp).toString());
                    if (!operatorStack.isEmpty()) {
                        topOp = operatorStack.peek();
                    }
                }
                operatorStack.push(op);
            }
         }
    }
    
    private static int presedence(char op) {
         return PRECEDENCE[OPERATORS.indexOf(op)] ; 
    }
    
    private static boolean isOperator(char op) {
        return OPERATORS.contains("" + op);
    }
    
}
