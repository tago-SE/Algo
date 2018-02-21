/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB7;

/**
 *
 * @author Jacob
 */
public class MainTest {

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
        try {
            System.out.println(stack.pop());
        } catch (Exception e) {
            System.out.println("Empty");
        }

        try {
            System.out.println(stack.peek());
        } catch (Exception e) {
            System.out.println("Empty");
        }

        System.out.println("Empty: " + stack.empty());
        System.out.println("Empty: " + stack.empty());

        stack.push("Hej");
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());

        stack.push("Hej"); //0
        stack.push("Hej2");
        stack.push("Hej3");
        stack.push("Hej4");
        stack.push("Hej5"); //4

        System.out.println(stack.peek(0));
        System.out.println(stack.peek(4));

        try {
            System.out.println(stack.peek(-1));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("arrayoutofbounds: " + ex.getMessage());
        }

        try {
            System.out.println("result: " + stack.peek(5));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("arrayoutofbounds: " + ex.getMessage());
        }

        System.out.println("After flush: " + stack.flush());
    }
}
