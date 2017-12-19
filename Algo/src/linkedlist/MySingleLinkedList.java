package linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 *
 * @author tiago
 */
public class MySingleLinkedList<E> implements List, Iterable {

    private MyNode<E> head;
    
    private class MyIterator<E> implements Iterator {
    
        private MyNode<E> cur;
        private MyNode<E> next;
        private MyNode<E> prev;

        private MyIterator(MyNode<E> startNode) {
            next = startNode;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Object next() {
            prev = cur;
            cur = next;
            next = next.getNext();
            return cur;
        }

        @Override
        public void remove() {
            if (cur == null)
                throw new NullPointerException("Trying to remove null reference.");
            if (cur == head) {
                head = head.getNext();
            } else {
                if (prev != null) {
                    prev.setNext(next);
                }
            }
            cur = null;
        }
    }
        
    @Override 
    public Iterator<E> iterator() {
        return new MyIterator(head);
    }
    
    private MyNode<E> getNode(int index) {
        MyNode<E> node = head; 
        for (int i = 0; i < index && node != null; i++) {
            node = node.getNext();
        }
        return node; 
    }
    
    private int countNodes(MyNode<E> startNode, int count) {
        if (startNode.getNext() == null)
            return count;
        return countNodes(startNode.getNext(), count + 1);
    }
    
    @Override
    public int size() {
        if (head == null)
            return 0;
        return countNodes(head, 1);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public boolean add(Object o) {
        if (head == null) {
            head = new MyNode(o);
        } else {
            MyNode last = getNode(size() - 1); // add at last position
            last.setNext(new MyNode(o));
        }
        return true;
    }
    
    @Override
    public boolean remove(Object o) {
        MyNode<E> prev = null;
        MyNode<E> cur = head;
        while (cur != null) {
            if (cur.toString().equals(o)) {
                if (prev != null)
                    prev.setNext(cur.getNext());
                else 
                    head = cur.getNext();
                return true;
            }
            prev = cur;
            cur.getNext();
        }
        return false;
    }
    
    @Override
    public void clear() {
        head = null;
    }

    @Override
    public Object get(int index) {
       return getNode(index);
    }

    @Override
    public Object set(int index, Object element) {
        MyNode<E> n = getNode(index);
        if (n != null) {
            n.setData((E) element);
            return element;
        } 
        return null;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("" + index);
        }
        if (index == 0) {
            head = new MyNode(element, head);
        } else {
            MyNode<E> prev = getNode(index - 1);
            prev.setNext(new MyNode(element, prev.getNext()));
        }
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("" + index);
        }
        Object deleted = null;
        if (index == 0) {
            deleted = head;
            head = head.getNext();
        } else {
            MyNode<E> prev = getNode(index - 1);
            deleted = prev.getNext();
            prev.setNext(prev.getNext().getNext());
        }
        return deleted;
    }

    @Override
    public int indexOf(Object o) {
        MyNode<E> cur = head;
        for (int i = 0; i < size() && cur != null; i++, cur = cur.getNext()) {
            if (cur.toString().equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        MyNode<E> cur = head;
        while (cur != null) {
            if (cur.toString().equals(o)) {
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        MyNode<E> cur = head;
        for (int i = 0; i < size() && cur != null; i++, cur = cur.getNext()) {
            array[i] = cur.getData();
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] a) {
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
    public boolean addAll(int index, Collection c) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
