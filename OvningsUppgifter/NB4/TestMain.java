/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB4;

/**
 *
 * @author Jacob
 */
public class TestMain {

    public static void main(String[] args) {
        String expression = "(4+1 + [4*4])"; //correct
        String expression2 = "( w * (x + y) / z - (p / (r - q)))";
        String expression3 = "(w * [x + y) / z - [p / {r - q}])";

        printExpression(expression);
        printExpression(expression2);
        printExpression(expression3);
    }

    private static void printExpression(String expression) {

        if (ParenChecker.isBalanced(expression)) {
            System.out.println("Exprssion: " + expression + "  is balanced");
        } else {
            System.out.println("Exprssion: " + expression + " is not balanced");
        }
    }
}
