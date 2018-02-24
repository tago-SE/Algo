package f_06_back_tracking;

/**
 *
 * @author tiago
 */
public class LinkedListRec <E> {
    
    Node<E> head;
    
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;
        
        
        private Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        
        private Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
            if (next != null)
                next.prev = this;
            if (prev != null)
                prev.next = this;
        }
    }   
    
    
    private E get(Node<E> cur, int index, int i) {
        if (cur == null)
            return null;
        if (index == i && cur != null) {
            return cur.data;
        }
        return get(cur.next, index, i + 1);
    }
    
    public E get(int index) {
        return get(head, index, 0);
    }
    
    private void remove(Node<E> node, Node<E> prev, int index, int i) {
        if (i == index) {
            if (i == 0) {
                if (head != null)
                    head = head.next;
            } 
            else {
                prev.next = node.next;
                if (node.next != null)
                    node.next.prev = prev;
            }
        }
        if (node == null)
            return;
        remove(node.next, node, index, i + 1);
    }
    
    public void remove(int index) {
        remove(head, null, index, 0);
    }
    
    private void add(Node<E> node, Node<E> prev, int index, int i, E e) {
        if (i == index) {
            if (i == 0) {
                head = new Node(e, head, null);
                return;
            } else {
                new Node(e, node, prev);
                return;
            }
        } 
        if (node == null) {
            return; 
        }
        add(node.next, node, index, i + 1, e);
    }
    
    public void add( int index, E e) {
        add(head, null, index, 0, e);
    }
    
    private int size(Node<E> cur, int i) {
        if (cur == null)
            return i;
        return size(cur.next, i + 1);
    }
    
    public int size() {
        return size(head, 0);
    }
    
        @Override
    public String toString() {
        String s = "{head=" + head.data + "\n";
        StringBuilder sb = new StringBuilder(s);
        for (Node<E> n = head; n != null; n = n.next) {
            sb.append("{").append(n.data).append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}
