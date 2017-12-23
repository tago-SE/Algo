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
    
    private StackInterface getInstance() {
        return new StackArray();
    }

    @Test
    public void testPush() {
        System.out.println("push");
        Object obj = "hello";
        StackInterface instance =  getInstance();
        Object expResult = "hello";
        Object result = instance.push(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testPop() {
        System.out.println("pop");
        StackInterface instance = getInstance();
        Object expResult = null;
        Object result = instance.pop();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPop1() {
        System.out.println("pop1");
        StackInterface instance = getInstance();
        instance.push("One");
        instance.push("Two");
        Object expResult = "Two";
        Object result = instance.pop();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPeek() {
        System.out.println("peek");
        StackInterface instance = getInstance();
        instance.push("One");
        instance.push("Two");
        Object expResult = "Two";
        Object result = instance.peek();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPee1k() {
        System.out.println("---- peek1 ----");
        StackInterface instance = getInstance();
        System.out.println("push: " + instance.push("One"));
        System.out.println("push: " + instance.push("Two"));
        System.out.println("pop: " + instance.pop());
        Object expResult = "One";
        Object result = instance.peek();
        System.out.println(expResult + " == " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testFlush() {
        System.out.println("flush");
        StackInterface instance = getInstance();
        instance.push("One");
        instance.push("Two");
        instance.flush();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        StackInterface instance = getInstance();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testSize() {
        System.out.println("size");
        StackInterface instance = getInstance();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSize1() {
        System.out.println("size1");
        StackInterface instance = getInstance();
        instance.push("One");
        instance.push("Two");
        int expResult = 2;
        int result = instance.size();
        assertEquals(expResult, result);
    }
}
