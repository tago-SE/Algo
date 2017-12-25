package stack_3;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author tiago
 */

public class StackLinked<E> implements StackInt, Collection {

    private Node<E> tail;
    private int size;

    private class Node<E> {
        private Node<E> prevNode;
        private E element;
    
        private Node(E element, Node<E> prevNode) {
            this.element = element;
            this.prevNode = prevNode;
        }
    }
    
    public StackLinked() {
    }
    
    /** ==================================== **
     **     Implementation of StackInt       **
     ** ==================================== **/
    
    @Override
    public Object push(Object obj) {
        if (obj == null) 
            return null;
        tail = new Node(obj, tail);
        size++;
        return obj;
    }

    @Override
    public Object pop() {
        if (tail == null)
            return null;   
        Object popValue = tail.element;
        tail = tail.prevNode;
        size--;
        return popValue;
    }

    @Override
    public Object peek() {
        if (tail != null)
            return tail.element;
        return null;
    }

    @Override
    public void flush() {
        tail = null;
        size = 0;
    }

    /** ==================================== **
     **     Implementation of Collection     **
     ** ==================================== **/
    
    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node<E> cur;
            Node<E> next = tail;
            Node<E> prev; 
            
            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public Object next() {
                Object returnValue = cur.element;
                prev = cur;
                cur = next;
                next = next.prevNode;
                return returnValue;
            }
            
            @Override
            public void remove() {
                
            }
        };
    }

    @Override
    public Object[] toArray() {
        E[] elements = (E[]) new Object[size()];
         int i = size() - 1;
         for (Node<E> n = tail; n != null; n = n.prevNode) {
             elements[i--] = n.element;
         }
         return elements;
    }

    @Override
    public Object[] toArray(Object[] a) {
       for (Object o: a) 
           push(o);
       return toArray();
    }

    @Override
    public boolean add(Object e) {
        return push(e) != null;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> prevPrevNode = null;
        for (Node<E> n = tail; n != null; n = n.prevNode) {
            if (o.equals(n.element)) {
                if (prevPrevNode != null)
                    prevPrevNode.prevNode = n.prevNode;
                else 
                    tail = n.prevNode;
                size--;
                if (size == 0)
                    tail = null;
            }
            prevPrevNode = n;
        }
        return false;
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
            push(o);
        });
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
        c.stream().filter((o) -> (!contains(o))).forEach((o) -> {
            remove(o);
        });
        return true;
    }

    @Override
    public boolean contains(Object obj) {
        for (Node<E> n = tail; n != null; n = n.prevNode) {
            if (obj.equals(n.element)) 
                return true;
        }
        return false;
    }
    
    @Override
    public void clear() {
        flush();
    }
    
    
    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public int size() {
        return size;
    }
    
}
