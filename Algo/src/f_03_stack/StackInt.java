package f_03_stack;

import java.util.Iterator;

/**
 *
 * @author tiago
 */
public interface StackInt<E> {
    
    public E push(E obj);
    public E pop();
    public E peek();
    public void flush();
    
    // Collection
    
    public boolean isEmpty();
    public int size();
    public void clear();
    public Iterator iterator();
    public Object[] toArray();
    public boolean contains(Object obj);
}
