package stack_3;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class StackArray<E> implements StackInt, Collection {

    private final int DEFAULT_CAP = 5;
    private int cap = DEFAULT_CAP;
    private int size; 
    private E[] elements;
    
    public StackArray() {
        elements = (E[]) new Object[DEFAULT_CAP]; // !
    }
    
    private void manageAllocation() {
        if (size == cap/4 && size > 1) // reduce size
            cap /= 2;
        else if (size >= cap - 1) // Increase size
            cap *= 2;
        else return;
        
        E[] newElements = (E[]) new Object[cap]; 
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
    
    @Override
    public Object push(Object obj) {
        if (obj == null) 
            return null;
        manageAllocation();
        elements[size++] = (E) obj;
        return obj;
    }

    @Override
    public Object pop() {
        if (size == 0)
            return null;
        Object popValue = elements[--size];
        manageAllocation();
        return popValue;
    }

    @Override
    public Object peek() {
        if (size == 0)
            return null;
        return elements[size - 1];
    }

    @Override
    public void flush() {
        size = 0;
        manageAllocation();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
    /**
     * Collection Interface
     */

    @Override
    public boolean contains(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(elements[i]))
                return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
