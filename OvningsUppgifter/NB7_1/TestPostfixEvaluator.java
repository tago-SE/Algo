/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB7_1;

import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class TestPostfixEvaluator {
    public static void main(String[] args) {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        
        String line;
        Scanner in = new Scanner(System.in);
        
        while(true) {
            System.out.println("Please enter the calc");
            line = in.nextLine();
            if (!line.equals("")) {
                try {
                    int result = evaluator.eval(line);
                    System.out.println("Value is " + result);
                    
                } catch (PostfixEvaluator.SyntaxErrorException ex) {
                    System.out.println("Syntax error " + ex.getMessage());
                    
                }
            } else {
                break;
            }
        }
    }
}
