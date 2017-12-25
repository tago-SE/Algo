/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack_3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class StackLinkedTest {
    
    public StackLinkedTest() {
    }
    
    private StackInt getInstance() {
        return new StackArray();
    }

    @Test
    public void testPush() {
        System.out.println("push");
        Object obj = "hello";
        StackInt instance =  getInstance();
        Object expResult = "hello";
        Object result = instance.push(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testPop() {
        System.out.println("pop");
        StackInt instance = getInstance();
        Object expResult = null;
        Object result = instance.pop();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPop1() {
        System.out.println("pop1");
        StackInt instance = getInstance();
        instance.push("One");
        instance.push("Two");
        Object expResult = "Two";
        Object result = instance.pop();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPeek() {
        System.out.println("peek");
        StackInt instance = getInstance();
        instance.push("One");
        instance.push("Two");
        Object expResult = "Two";
        Object result = instance.peek();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPee1k() {
        System.out.println("---- peek1 ----");
        StackInt instance = getInstance();
        System.out.println("push: " + instance.push("One"));
        System.out.println("push: " + instance.push("Two"));
        System.out.println("pop: " + instance.pop());
        Object expResult = "One";
        Object result = instance.peek();
        System.out.println(expResult + " == " + result);
        assertEquals(expResult, result);
    }
}
