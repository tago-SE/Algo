package f_04_queue;

/**
 *
 * @author tiago
 */
public class QueueDoubleLinked<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    private class Node<E> {
        public E e;
        public Node<E> next;
        public Node<E> prev;
        public Node(E e) {
            this.e = e;
        }
        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e, Node<E> next, Node<E> prev) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }
    }
    
    public void offer(Object o) {
        if (tail == null)
            head = tail = new Node(o);
        else {
            tail.next = new Node(o, null, tail.prev);
            tail = tail.next;
        }
        size++;
    }
    public Object poll() {
        Object o = head.e;
        head = head.next;
        head.prev = null;
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
