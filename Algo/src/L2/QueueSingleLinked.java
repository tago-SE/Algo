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

public class QueueSingleLinked<E> extends AbstractQueue<E> implements Queue<E> {
    private int size;
    private Node<E> head; 
    private Node<E> tail;
    
    public QueueSingleLinked() {
        size = 0;
        head = null;
        tail = null;
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
        if (head == null) {
            tail = head = new Node(e);
        }
        else {
            Node<E> prev = tail;
            tail = new Node(e);
            prev.next = tail;
        }
        size++;
        return true;
    }

    @Override
    public E poll() {
        E returnValue = head.data;
        if (head != null) {
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
        }
        return returnValue;
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
        
        private Node(E data) {
            this.data = data;
        }
        
        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
    
    private class Iter implements Iterator<E> {
        private Node<E> curNode;
        
        private Iter() {
            curNode = head;
        }
        
        @Override
        public boolean hasNext() {
            return curNode != null;
        }

        @Override
        public E next() {
            E returnValue = curNode.data;
            curNode = curNode.next;
            return returnValue;
        }
        
    }
}
