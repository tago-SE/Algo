package f_03_stack;

import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class StackArray<E> implements StackInt {

    private final int DEFAULT_CAP = 5;
    private int cap = DEFAULT_CAP;
    private int size; 
    private E[] elements;
    
    public StackArray() {
        elements = (E[]) new Object[DEFAULT_CAP];
    }
    
    private boolean expandCondition() {
        return size >= cap - 1;
    }
    
    private boolean shrinkCondition() {
        return size == cap/4 && size > 1;
    }
        
    private void reallocate(int newCap) {
        cap = newCap;
        E[] newElements = (E[]) new Object[cap]; 
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
      
    @Override
    public Object push(Object obj) {
        if (obj == null) 
            return null;
        if (expandCondition())
            reallocate(cap*2);
        elements[size++] = (E) obj;
        return obj;
    }

    @Override
    public Object pop() {
        if (size == 0)
            return null;
        Object popValue = elements[--size];
        if (shrinkCondition())
            reallocate(cap/2);
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
        if (cap != DEFAULT_CAP)
            reallocate(DEFAULT_CAP);
    }

    /**
     * Collection Interface
     */

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
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
        return new Iterator() {
            int index = size;
            
            @Override
            public boolean hasNext() {
                return index - 1 > -1;
            }

            @Override
            public Object next() {
                return elements[--index];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] copy = new Object[size];
        System.arraycopy(elements, 0, copy, 0, size);
        return copy;
    }

    @Override
    public void clear() {
        flush();
    }
}
