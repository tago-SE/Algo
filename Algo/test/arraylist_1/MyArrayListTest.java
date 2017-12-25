package arraylist_1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class MyArrayListTest {
    
    public MyArrayListTest() {
    }

    @Test 
    public void testSize() {
        System.out.println("============================================"); 
        System.out.println("size");
        System.out.println("============================================"); 
        MyArrayList instance = new MyArrayList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        System.out.println("'size==0' " + (result == expResult));
        System.out.println("added " + instance.add("Hey"));
        System.out.println("added " + instance.add("Hey"));
        expResult = 2;
        result = instance.size();
        assertEquals(expResult, result);
        System.out.println("'size==2' " + (result == expResult));
    }

    @Test
    public void testIsEmpty() {
        System.out.println("============================================"); 
        System.out.println("isEmpty");
        System.out.println("============================================");    
        MyArrayList instance = new MyArrayList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        System.out.println("'empty == true' " + (result == expResult));
        System.out.println("added " + instance.add("Hey"));
        expResult = false;
        result = instance.isEmpty();
        assertEquals(expResult, result);
        System.out.println("'empty == false' " + (result == expResult));
    }

    @Test
    public void testContains() {
        System.out.println("============================================"); 
        System.out.println("contains");
        System.out.println("============================================");            
        Object o = "Hey";
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.contains(o);
        assertEquals(expResult, result);
        System.out.println("!contains 'Hey' " + (expResult == result) + " result = " + result);
        System.out.println("added 'Hey' " + instance.add("Hey"));
        expResult = true;
        result = instance.contains(o);
        assertEquals(expResult, result);
        System.out.println("contains 'Hey' " + (expResult == result) + " result = " + result);
    }

    @Test 
    public void testIterator() {
        System.out.println("============================================"); 
        System.out.println("iterator");
        System.out.println("============================================");
        MyArrayList instance = new MyArrayList();
        Iterator it = instance.iterator();
        assertEquals(false,  it.hasNext());
        System.out.println("hasNext() is "  + it.hasNext() + " expected " + false);
        System.out.println("added 'a' " + instance.add("a"));
        it = instance.iterator();
        assertEquals(true,  it.hasNext());
        System.out.println("hasNext() is "  + it.hasNext() + " expected " + true);
        
        // Testing to retrieve an element through next
        Object o = null;
        try {
            o = it.next();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        System.out.println("next is '" + o + "' expected 'a'");
        assertEquals("a",  o);
      
        // Testing if next outside of bounds generates exception
        boolean result = false;
        try {
            it.next();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            result = true;  
        }
        assertEquals(true, result);
        System.out.println("Cought Exception when trying to next out of bounds: " + result);
        
        result = false;
        instance.add("1");
        instance.add("2");
        System.out.println(it.toString());
        it = instance.iterator();
        while (it.hasNext()) {
            o = it.next();
            System.out.println("next = " + o);
            if (o.equals("a")) {
                try {
                    it.remove();
                    result = true;
                    System.out.println("Removed 'a' through iterator");
                } catch (Exception ex) {
                    System.out.println("Failed to remove 'a' through iterator");
                }
            }
        }
    }
    
    @Test
    public void testIteratorRemove() {
        System.out.println("============================================"); 
        System.out.println("iteratorRemove");
        System.out.println("============================================");
        
        MyArrayList instance = new MyArrayList();
        instance.add("1");
        instance.add("2");
        instance.add("3");
        Iterator it = instance.iterator();
        
        boolean beforeRemove = instance.contains("1");
        assertEquals(beforeRemove,  true);
        System.out.println("Instance contains '1' before remove: " + beforeRemove);
        
        Object o;
        Object removed = null;
        while (it.hasNext()) {
            o = it.next();
            System.out.println("next: " + o);
            if (o.equals("1")) {
                removed = o;
                it.remove();
                System.out.println("removed: " + removed);
            }
        }
        assertEquals(removed,  "1");
        boolean afterRemvoe = instance.contains("1");
        assertEquals(afterRemvoe, false);
        System.out.println("Instance contains '1' after remove: " + afterRemvoe);
        System.out.println(instance.toString());
        
    }

    @Test
    public void testToArray_0args() {
        System.out.println("============================================"); 
        System.out.println("toArray");
        System.out.println("============================================"); 
        MyArrayList instance = new MyArrayList();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToArray_ObjectArr() {
        System.out.println("toArray");
        Object[] a = null;
        MyArrayList instance = new MyArrayList();
        Object[] expResult = null;
        Object[] result = instance.toArray(a);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdd_Object() {
        System.out.println("add");
        Object e = null;
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.add(e);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemove_Object() {
        System.out.println("remove");
        Object o = null;
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.remove(o);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testContainsAll() {
        System.out.println("containsAll");
        Collection c = null;
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.containsAll(c);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddAll_Collection() {
        System.out.println("addAll");
        Collection c = null;
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.addAll(c);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddAll_int_Collection() {
        System.out.println("addAll");
        int index = 0;
        Collection c = null;
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.addAll(index, c);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        Collection c = null;
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.removeAll(c);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        Collection c = null;
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.retainAll(c);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testClear() {
        System.out.println("============================================"); 
        System.out.println("clear");
        System.out.println("============================================"); 
        MyArrayList instance = new MyArrayList();
        instance.clear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        MyArrayList instance = new MyArrayList();
        Object expResult = null;
        Object result = instance.get(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        Object element = null;
        MyArrayList instance = new MyArrayList();
        Object expResult = null;
        Object result = instance.set(index, element);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdd_int_Object() {
        System.out.println("add");
        int index = 0;
        Object element = null;
        MyArrayList instance = new MyArrayList();
        instance.add(index, element);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int index = 0;
        MyArrayList instance = new MyArrayList();
        Object expResult = null;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object o = null;
        MyArrayList instance = new MyArrayList();
        int expResult = 0;
        int result = instance.indexOf(o);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLastIndexOf() {
        System.out.println("lastIndexOf");
        Object o = null;
        MyArrayList instance = new MyArrayList();
        int expResult = 0;
        int result = instance.lastIndexOf(o);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testListIterator_0args() {
        System.out.println("listIterator");
        MyArrayList instance = new MyArrayList();
        ListIterator expResult = null;
        ListIterator result = instance.listIterator();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testListIterator_int() {
        System.out.println("listIterator");
        int index = 0;
        MyArrayList instance = new MyArrayList();
        ListIterator expResult = null;
        ListIterator result = instance.listIterator(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSubList() {
        System.out.println("subList");
        int fromIndex = 0;
        int toIndex = 0;
        MyArrayList instance = new MyArrayList();
        List expResult = null;
        List result = instance.subList(fromIndex, toIndex);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        MyArrayList instance = new MyArrayList();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
