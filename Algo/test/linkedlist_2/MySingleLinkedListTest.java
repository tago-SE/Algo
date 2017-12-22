
package linkedlist_2;

import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class MySingleLinkedListTest {
    
    /**
     * Constructor
     */
    public MySingleLinkedListTest() {        
    }

    /**
     * Replace the instance with the List class you wish to test. 
     * @return List<String>
     */
    private List getInstance() {
        List<String> instance = new MySingleLinkedList<>();
        return instance;
    }
    
    /**
     * Expected to catch IndexOutOfBoundsException when attempting to add a 
     * negative index
     */
    @Test(expected = IndexOutOfBoundsException.class) 
    public void testAdd_int_Object_1() {
        List<String> instance = getInstance();
        instance.add(-1, "Hello");
    }
    
    /**
     * Expected to catch IndexOutOfBoundsException when attempting to add at an index
     * greater than 0 (when empty).
     */
    @Test(expected = IndexOutOfBoundsException.class) 
    public void testAdd_int_Object_2() {
        List<String> instance = getInstance();
        instance.add(1, "Hello");
    }
    
    
    /**
     * Expected to add at the first index position when empty. 
     */
    @Test
    public void testAdd_int_Object_3() {
        List<String> instance = getInstance();
        instance.add(0, "Hello");
        int result = instance.size();
        int expResult = 1;
        assertEquals(result, expResult);
    }
    
    /**
     * Expected to add at the second index position.
     */
    @Test
    public void testAdd_int_Object_4() {
        List<String> instance = getInstance();
        instance.add("First");
        instance.add(1, "Hello");
        int result = instance.size();
        int expResult = 2;
        assertEquals(result, expResult);
    }
    
    /**
     * Attempting to print 3 elements through an iterator. 
     */
    @Test
    public void testIterator_iteration() {
        List<String> instance = getInstance();
        instance.add("First");
        instance.add("Second");
        instance.add("Third");
        Iterator itr = instance.iterator();
        int result = 0;
        int expResult = 3;
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
            result++;
        }
        assertEquals(result, expResult);
    }
    
     /**
     * Attempting to iterate through an empty list expecting NullPointerException
     */
    @Test(expected = NullPointerException.class) 
    public void testIterator_nextOnEmptyList() {
        List<String> instance = getInstance();
        Iterator itr = instance.iterator();
        itr.next();
    }
    
    /**
     * Attempting to iterate beyond the list size expecting NullPointerException
     */
    @Test(expected = NullPointerException.class) 
    public void testIterator_nextBeyondListSize() {
        List<String> instance = getInstance();
        instance.add("First");
        instance.add("Second");
        Iterator itr = instance.iterator();
        itr.next();
        itr.next();
        itr.next();
    }
    
    /**
     * Attempting to iterate-remove from an empty list, expecting NullPointerException
     */
    @Test(expected = NullPointerException.class) 
    public void testIterator_removeOnEmptyList() {
        List<String> instance = getInstance();
        Iterator itr = instance.iterator();
        itr.remove();
    } 
    
    /**
     * Attempting to iterate-remove without first doing next, expecting NullPointerException
     */
    @Test(expected = NullPointerException.class) 
    public void testIterator_remove_failure() {
        List<String> instance = getInstance();
        instance.add("First");
        Iterator itr = instance.iterator();
        itr.remove();
    } 
    
    /**
    * Attempting to do a double remove without first executing another next between the removes
    * expecting NullPointerException
    */
    @Test(expected = NullPointerException.class) 
    public void testIterator_doubleRemove_failure() {
        List<String> instance = getInstance();
        instance.add("First");
        instance.add("Second");
        Iterator itr = instance.iterator();
        itr.next();
        itr.remove();
        itr.remove();
    } 
    /**
    * Attempting to do a double remove without first executing another next between the removes
    */
    @Test
    public void testIterator_doubleRemove_success() {
        List<String> instance = getInstance();
        instance.add("First");
        instance.add("Second");
        instance.add("Third");
        Iterator itr = instance.iterator();
        itr.next();
        itr.remove();
        itr.next();
        itr.remove();
        int expResult = 1;
        int result = instance.size();
        assertEquals(result, expResult);
    } 
}
