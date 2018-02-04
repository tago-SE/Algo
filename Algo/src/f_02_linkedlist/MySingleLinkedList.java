package f_02_linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 *
 * @author tiago
 */
public class MySingleLinkedList<E> implements List {

    private NodeChainLink<E> head;
    
    /*
    Not implemented
    
    private class Node<E> {
        private Node<E> next;
        private E element;
        
        private Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
    */
    
    @Override 
    public Iterator<E> iterator() {
        return new Iterator() {
            private NodeChainLink<E> cur;
            private NodeChainLink<E> next = head;
            private NodeChainLink<E> prev;         
        
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
                    throw new NullPointerException();
                if (cur == head) {
                    head = head.getNext();
                } else {
                    if (prev != null) {
                        prev.setNext(next);
                    }
                }
                cur = null;
            }
        };
    }
    
    private NodeChainLink<E> getNode(int index) {
        NodeChainLink<E> node = head; 
        for (int i = 0; i < index && node != null; i++) {
            node = node.getNext();
        }
        return node; 
    }
    
     @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        if (index == 0) {
            head = new NodeChainLink(element, head);
        } else {
            NodeChainLink<E> prev = getNode(index - 1);
            prev.setNext(new NodeChainLink(element, prev.getNext()));
        }
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        Object deleted = null;
        if (index == 0) {
            deleted = head;
            head = head.getNext();
        } else {
            NodeChainLink<E> prev = getNode(index - 1);
            deleted = prev.getNext();
            prev.setNext(prev.getNext().getNext());
        }
        return deleted;
    }
    
    @Override
    public boolean add(Object o) {
        if (head == null) {
            head = new NodeChainLink(o);
        } else {
            NodeChainLink last = getNode(size() - 1); // add at last position
            last.setNext(new NodeChainLink(o));
        }
        return true;
    }
    
    @Override
    public boolean remove(Object o) {
        NodeChainLink<E> prev = null;
        NodeChainLink<E> cur = head;
        while (cur != null) {
            if (cur.getElement().equals(o)) {
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
    public int size() {
        int count = 0;
        for (NodeChainLink<E> node = head; node != null; node = node.getNext())
            count++;
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public void clear() {
        head = null;
    }

    @Override
    public Object get(int index) {
       NodeChainLink<E> node = getNode(index);
       if (node != null) 
           return node.getElement();
       return null;
    }

    @Override
    public Object set(int index, Object element) {
        NodeChainLink<E> n = getNode(index);
        if (n != null) {
          n.setElement((E) element);
          return element;
        } 
        return null;
    }
    
    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (NodeChainLink<E> n = head; n != null; n = n.getNext(), index++) {
            if (n.getElement().equals(o)) return index;
        }
        return -1;
    }
    
    

    @Override
    public boolean contains(Object o) {
        for (NodeChainLink<E> n = head; n != null; n = n.getNext()) {
            if (n.getElement().equals(o)) return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        NodeChainLink<E> cur = head;
        for (int i = 0; i < size() && cur != null; i++, cur = cur.getNext()) {
            array[i] = cur.getElement();
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] array) {
        NodeChainLink<E> cur = head;
        for (int i = 0; i < size() && cur != null; i++, cur = cur.getNext()) {
            array[i] = cur.getElement();
        }
        return array;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (!c.stream().noneMatch((o) -> (!contains(o)))) {
            return false;
        }
        return true;
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
        for (Object o: c) {
            add(index++, o);
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
        MyDoubleLinkedList<E> list = new MyDoubleLinkedList();
        int i = 0;
        for (NodeChainLink<E> n = head; n != null; n = n.getNext()) {
            if (i >= fromIndex && i <= toIndex) 
                list.add(n.getElement());
            i++;
        }
        return list;
    }
    
}
