/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Jacob
 */
public class IntList<Integer> implements List {

    private int noOfElements;
    private int maxSize;
    private int[] data;

    public IntList() {
        this(10);
    }

    public IntList(int initialCapacity) {
        maxSize = initialCapacity;
        noOfElements = 0;
        data = new int[maxSize];
    }

    @Override
    public int size() {
        return noOfElements;
    }

    @Override
    public Object remove(int i) {
        if (i >= 0 && i < noOfElements) {
            Object oldItem = data[i];
            for (int j = i; j < noOfElements - 1; j++) {
                data[j] = data[j + 1];
            }
            noOfElements--;
            return oldItem;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < noOfElements; i++) {
            if (data[i] == (int) o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(int i) {
        if (i >= 0 && i < noOfElements) {
            return data[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    @Override
    /**
     * Returns the old integer that is being replaced with a new
     */
    public Object set(int i, Object e) {
        if (i >= 0 && i < noOfElements) {
            Object oldItem = data[i];
            data[i] = (int) e;
            return oldItem;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    private void reallocate() {
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
    }

    @Override
    public void add(int i, Object e) {
        if (i >= 0 && i < noOfElements) {
            if (noOfElements == maxSize) {
                reallocate();
            }
            
            for (int j = noOfElements; j > i; j--) {
                data[j] = data[j-1];
            }
            data[i] = (int) e;
            noOfElements++;
            return;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    @Override
    public boolean add(Object e) {
        if (noOfElements == maxSize) {
            reallocate();
        }
        data[noOfElements++] = (int) e;
        return true;
    }

    public String toString() {
        String info = "";
        for (int i = 0; i < noOfElements; i++) {
            info += data[i] + ", ";
        }
        return info;
    }

    //The following methods has not been implemented properly
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Object[] toArray(Object[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int i, Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public ListIterator listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
