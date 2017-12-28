package f_01_arraylist;

import java.util.Iterator;

/**
 *
 * @author tiago
 */
public interface ListInt {
    
    public Object add(Object o);
    public Object remove(Object o);
    public Object add(int i, Object o);
    public Object remove(int i);
    public Object get(int i);
    public Object set(int i, Object o);
    public void clear();
    public int size();
    public boolean isEmpty();
    public Iterator iterator();
    public boolean contains(Object o);
    public int indexOf(Object o);
    public Object[] toArray();
    
}
