/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB5;

/**
 *
 * @author Jacob
 */
public class MainTest {

    public static void main(String[] args) {
        StackUsingAList<String> stack = new StackUsingAList<String>();
        stack.push("Hej");
        stack.push("Pop"); //överst
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(stack.pop());
            } catch (Exception e) {
                System.out.println("Error, Empty: " + e.getMessage());
            }
        }
        
        //stack.push(1);
        stack.push("Test");
        System.out.println(stack.peek());
        System.out.println("is empty: " + stack.empty());
        
        stack.pop();
        System.out.println("is empty: " + stack.empty());

    }
}
