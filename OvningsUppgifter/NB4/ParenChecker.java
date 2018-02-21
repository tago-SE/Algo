/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 *
 * @author Jacob
 */
public class ParenChecker {

    public ParenChecker() {

    }

    public static boolean isBalanced(String expression) {
        Deque<Character> stack = new ArrayDeque<Character>();
        boolean balanced = true;

        int index = 0;
        int expressLength = expression.length();

        while (balanced && index < expressLength) {
            char nextChar = expression.charAt(index);
            if (isOpen(nextChar)) {
                stack.push(nextChar);
            } else if (isClosed(nextChar)) {
                if (stack.isEmpty() || !match(stack.pop(), nextChar)) { //stackpop is open and nextchar is closed
                    balanced = false;
                }
            }
            index++;
        }
        return balanced;
    }

    private static boolean match(char openCh, char closedCh) {
        if (openCh == '(') {
            if (closedCh == ')') {
                return true;
            }
        } else if (openCh == '[') {
            if (closedCh == ']') {
                return true;
            }
        } else if (openCh == '{') {
            if (closedCh == '}') {
                return true;
            }
        }
        return false;
    }

    private static boolean isOpen(char ch) {
        if (ch == '(' || ch == '{' || ch == '[') {
            return true;
        }
        return false;
    }

    private static boolean isClosed(char ch) {
        if (ch == ')' || ch == '}' || ch == ']') {
            return true;
        }
        return false;
    }

}
