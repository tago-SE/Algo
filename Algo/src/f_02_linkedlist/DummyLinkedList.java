package f_02_linkedlist;

/**
 *
 * @author tiago
 */
public class DummyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size; 
    
    public DummyLinkedList() {};

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
    private Node<E> getNode(int index) {
        Node<E> n = head;
        for (int i = 0; n != null && i < index; i++) {
            n = n.next;
        }
        return n;
    }
    
    public void add(Object o, int index) {
        if (index < 0 || index > size) 
            throw new IndexOutOfBoundsException("index: " + index);
        if (index == 0) { 
            if (head == null)
                head = tail = new Node(o);
            else {
                Node n = new Node(o, head);
                head.prev = n;
                head = n;
            }
        }
        else if (index == size) {
            if (head == null) 
                head = tail = new Node(o);
            else {
                Node<E> n = new Node(o, null, tail);
                tail.next = n;
                tail = n;
            }
        } else {
            Node<E> oldNode = getNode(index);
            Node<E> newNode = new Node(o, oldNode, oldNode.prev);
            oldNode.prev.next = newNode;
        }
        size++;
    }
    
    private Object remove(int index) {
          if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        Object deleted = null;
        if (index == 0) {
            deleted = head.e;
            head = head.next;
            if (head == null)
                tail = null;
            else head.prev = null;
        }
        else if (index == size) {
            deleted = tail.e;
            tail = tail.prev;
            if (tail == null)
                head = null;
            else tail.next = null;
        } else {
            Node<E> n = getNode(index);
            deleted = n.e;
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        size--;
        return deleted;
    }
    
    public String toString() {
        String s = "{head=" + head.e + ", tail=" + tail.e + ", size=" + size + " ";
        StringBuilder sb = new StringBuilder(s);
        
        for (Node<E> node = head; node != null; node = node.next) {
            sb.append("{").append(node.e).append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}
