package f_07_binary_tree;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class BinarySearchTreeTest {
    
    public BinarySearchTreeTest() {
    }

    @Test
    public void testAdd() {
        System.out.println("add");
        Object item = null;
        BinarySearchTree instance = new BinarySearchTree();
        boolean expResult = false;
        boolean result = instance.add((Comparable) item);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        Object target = null;
        BinarySearchTree instance = new BinarySearchTree();
        Object expResult = null;
        Object result = instance.delete((Comparable) target);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNumberOfLeaves() {
        System.out.println("numberOfLeaves");
        BinarySearchTree instance = new BinarySearchTree();
        int expResult = 0;
        int result = instance.numberOfLeaves();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNumberOfNodes() {
        System.out.println("numberOfNodes");
        BinarySearchTree instance = new BinarySearchTree();
        int expResult = 0;
        int result = instance.numberOfNodes();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindLargestChild() {
        System.out.println("findLargestChild");
        BinarySearchTree instance = new BinarySearchTree();
        Object expResult = null;
        Object result = instance.findLargestChild();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNumberOfNodesWith2Children() {
        System.out.println("numberOfNodesWith2Children");
        BinarySearchTree instance = new BinarySearchTree();
        int expResult = 0;
        int result = instance.numberOfNodesWith2Children();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTreeHeight() {
        System.out.println("treeHeight");
        BinarySearchTree instance = new BinarySearchTree();
        int expResult = 0;
        int result = instance.treeHeight();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testContains() {
        System.out.println("contains");
        Object target = null;
        BinarySearchTree instance = new BinarySearchTree();
        boolean expResult = false;
        boolean result = instance.contains((Comparable) target);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFind() {
        System.out.println("find");
        Object target = null;
        BinarySearchTree instance = new BinarySearchTree();
        Object expResult = null;
        Object result = instance.find((Comparable) target);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPrintTree() {
        System.out.println("printTree");
        BinarySearchTree instance = new BinarySearchTree();
        String expResult = "";
        String result = instance.printTree();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        BinarySearchTree instance = new BinarySearchTree();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
