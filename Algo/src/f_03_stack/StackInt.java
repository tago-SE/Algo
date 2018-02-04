package f_03_stack;

import java.util.Iterator;

/**
 *
 * @author tiago
 */
public interface StackInt<E> {
    
    public E push(E obj);   // add to top e
    public E pop();         // get top e
    public E peek();        // view top e
    public void flush();    // clear
    
    // Collection
    
    public boolean isEmpty();
    public int size();
    public void clear();
    public Iterator iterator();
    public Object[] toArray();
    public boolean contains(Object obj);
}
