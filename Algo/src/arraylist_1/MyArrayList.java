package arraylist_1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author tiago
 */
public class MyArrayList<E> implements List {

    private final int DEFAULT_CAP = 5;
    private int cap = DEFAULT_CAP;
    private int size; 
    private E[] elements;
    
    
    
    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAP]; 
    }
    
    /**
    * Internal methods
    */
    
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
    
    private void shuffleElementsOnRemove(int index) {
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
    }
    
    private void shuffleElementsOnAdd(int index) {
        for (int i = size - 1; i > index; i--) {
            elements[i + 1] = elements[i];
        }
    }
    
    private void swap(int i, int j) {
        E temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
    
    /**
    * List Interface implementation
    */
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) 
            if (elements[i].equals(o))
                return true;
        return false;
    }

    @Override
    public Iterator iterator() {  
        return new Iterator() {
            private int index = 0;
            private boolean canRemove = false;
            
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Object next() {
                if (index >= size)
                    return null;
                canRemove = true;
                return elements[index++];
            }
            
            @Override
            public void remove() {
                if (!canRemove) 
                    throw new NullPointerException("NullPointerReference");
                
                shuffleElementsOnRemove(index--);
                size--;
                elements[size] = null;
                canRemove = false;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    @Override
    public Object[] toArray(Object[] a) {
        addAll(Arrays.asList(a));
        return elements;
    }

    @Override
    public boolean add(Object e) {
        if (e == null)
            throw new NullPointerException();
        if (expandCondition())
            reallocate(cap*2);
        elements[size++] = (E) e;
        return true;
    }
    
    @Override
    public boolean remove(Object o) { 
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                size--;
                elements[size] = null;
                if (shrinkCondition())
                    reallocate(cap/2);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return c.stream().noneMatch((o) -> (!contains(o)));
    }

    @Override
    public boolean addAll(Collection c) {
        c.stream().forEach((o) -> {
            add(o);
        });
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        int i = 0;
        for (Object o: c) {
            add(index + i++, o);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        c.stream().forEach((o) -> {
            remove(o);
        });
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[i]))
                remove(i);
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        if (cap != DEFAULT_CAP)
            reallocate(DEFAULT_CAP);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return elements[index];
    }

    @Override
    public Object set(int index, Object element) {
        if (index >= size) 
            throw new IndexOutOfBoundsException();
        return elements[index] = (E) element;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size) 
            throw new IndexOutOfBoundsException();
        if (element == null)
            throw new NullPointerException();
        add(element);
        if (index != size - 1) {
            shuffleElementsOnAdd(index);
            swap(index, size - 1);
        }
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) 
            throw new IndexOutOfBoundsException("index: " + index);
        
        Object removedObj = elements[index];
        shuffleElementsOnRemove(index);
        size--;
        elements[size] = null;
        return removedObj;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        List list = new MyArrayList();
        for (int i = fromIndex; i <= toIndex; i++) 
            list.add(elements[i]);
        return list;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ size=").append(size).append(", cap=").append(cap).append(", ");
        for (int i = 0; i < size; i++) {
            sb.append("{").append(elements[i]).append("}");
        }
        return sb.append("}").toString();
    }
}
