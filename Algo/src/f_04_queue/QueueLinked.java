/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_04_queue;

/**
 *
 * @author tiago
 */
public class QueueLinked<E> {
   private Node<E> head;
    private Node<E> tail;
    private int size;
    
    private class Node<E> {
        public E e;
        public Node<E> next;
        public Node(E e) {
            this.e = e;
        }
        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    } 
    public void offer(Object o) {
        if (tail == null)
            tail = head = new Node(o);
        else {
            tail.next = new Node(o);
            tail = tail.next;
        }
        size++;
    }
    public Object poll() {
        if (head == null) throw new NullPointerException();
        Object o = head.e;
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return o;
    }
    public Object peek() {
        return head.e;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
       return size;
    }
}
