package f_02_linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author tiago
 */
public class MyDoubleLinkedList<E> implements List {

    private NodeChainLink<E> head;
    private NodeChainLink<E> tail;
    private int size;   
    
    private NodeChainLink<E> getNode(int index) {
        if (index == size -1)
            return tail;
        NodeChainLink<E> node = head; 
        for (int i = 0; i < index && node != null; i++) {
            node = node.getNext();
        }
        return node; 
    }
    
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
                    if (head == null)
                        tail = null;
                    else 
                        head.setPrev(null);
                }
                else if (cur == tail) {
                    tail = tail.getPrev();
                    if (tail == null)
                        head = null;
                    else 
                        tail.setNext(null);
                }
                else {
                    prev.setNext(next);
                    next.setPrev(prev);
                }
                size--;
                cur = null;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public boolean add(Object o) {
        add(size, o);
        return true;
    }
    
    @Override
    public boolean remove(Object o) {
        try {
            remove(indexOf(o));
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
        return true;
    }
    
    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public Object get(int index) {
        NodeChainLink<E> node = getNode(index);
        if (node != null) {
            return node.getElement();
        }
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        NodeChainLink<E> node = getNode(index);
        if (node != null) {
            node.setElement((E) element);
            return element;
        }
        return null;
    }
    
    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        // Add first
        if (index == 0) {
            if (head == null) {
                head = 
                head = tail = new NodeChainLink(element);
            } else {
                NodeChainLink<E> newNode = new NodeChainLink(element, head);
                head.setPrev(newNode);
                head = newNode;
            }
        // Add last
        } else if (index == size) {
            NodeChainLink<E> newNode = new NodeChainLink(element, null, tail);
            tail.setNext(newNode);
            tail = newNode;
        } 
        // Insert at index
        else {
            NodeChainLink<E> oldNode = getNode(index);
            NodeChainLink<E> prev = oldNode.getPrev();
            NodeChainLink<E> newNode = new NodeChainLink(element, oldNode, prev);
            prev.setNext(newNode);
            oldNode.setPrev(newNode);
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        Object deleted = null;
        // Remove first
        if (index == 0) {
            deleted = head.getElement();
            head = head.getNext();
            if (head == null)
                tail = null;
            else 
                head.setPrev(null);
        }
        // Remove last 
        else if (index == (size - 1)) {
            deleted = tail.getElement();
            tail = tail.getPrev();
            if (tail == null)
                head = null;
            else
                tail.setNext(null);
        }
        // Remove at index
        else {
            NodeChainLink<E> node = getNode(index);
            NodeChainLink<E> prev = node.getPrev();
            NodeChainLink<E> next = node.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            deleted = node.getElement();
        }
        size--;
        return deleted;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        for (NodeChainLink<E> node = head; node != null; node = node.getNext()) {
            if (node.getElement().equals(o))
                return i;
            i++;
        }
        return -1;
    }
    
    @Override
    public boolean contains(Object o) {
        for (NodeChainLink<E> node = head; node != null; node = node.getNext()) {
            if (node.getElement().equals(o))
                return true;
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
            // WRONG NEED FIX
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
    
    @Override
    public String toString() {
        String s = "{head=" + head + ", tail=" + tail + ", size=" + size + " ";
        StringBuilder sb = new StringBuilder(s);
        for (NodeChainLink<E> node = head; node != null; node = node.getNext()) {
            sb.append("{").append(node.getElement()).append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}
