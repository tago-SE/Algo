/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package L2;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author tiago
 * @param <E>
 */
public class QueueDoubleLinked<E> extends AbstractQueue<E> implements Queue<E>  {
    private int size;
    private Node<E> head;
    private Node<E> tail;
    
    public QueueDoubleLinked() {
        size = 0;
        head = null;
        tail = null;
    }
    
    public void offerFirst(E e) {
        if (head == null) {
            tail = head = new Node(e);
        } else {
            Node<E> oldHead = head;
            head = new Node(e, oldHead);
            oldHead.prev = head;
        }
        size++;
    }
    
    public void offerLast(E e) {
        if (tail == null) {
            head = tail = new Node(e);
        } else {
            Node<E> oldTail = tail;
            tail = new Node(e, null, oldTail);
            oldTail.next = tail;
        }
        size++;
    }
    
    public E pollFirst() {
        E returnValue = null;
        if (head != null) {
            returnValue = head.data;
            if (size == 1) {
                tail = head = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }
        return returnValue;
    }
    
    public E pollLast() {
        E returnValue = null;
        if (tail != null) {
            returnValue = tail.data;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }
        return returnValue;
    }
    
    public void empty() {
        head = null;
        tail = null;
        size = 0;
    }
            
    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E e) {
        offerLast(e);
        return true;
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E peek() {
        return head.data;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<E> itr = new Iter();
        while (itr.hasNext()) {
            sb.append(">>").append(itr.next());
        }
        sb.append("]");
        return sb.toString();
    }
    
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;
        
        private Node(E data) {
            this.data = data;
        }
        
        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
        
        private Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    
    private class Iter implements Iterator {
        Node<E> current;
        
        public Iter() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E returnValue = current.data;
            current = current.next;
            return returnValue;
        }
    }
}
