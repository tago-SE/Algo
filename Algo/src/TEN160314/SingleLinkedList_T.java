
package TEN160314;

/**
 *
 * @author tiago
 */


import java.util.Iterator;

public class SingleLinkedList_T<E> implements Iterable<E> {

    private class Itr implements Iterator<E> {
        Node<E> itNext = head;
        Node<E> cur;
        
        @Override
        public boolean hasNext() {
            return itNext != null;
        }

        @Override
        public E next() {
            cur = itNext;
            itNext = itNext.next;
            return cur.data;
        }
    }
   
    public Iterator<E> iterator(int index) {
        if (index >= size || index < 0) 
            throw new IndexOutOfBoundsException();
        
        Itr itr = new Itr();
        Node<E> n = head;
        for (int i = 0; i < size && i != index; i++) {
            n = n.next;
        }
        itr.itNext = n;
        return itr;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }
        
    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node<E> head;
    private int size;

    public SingleLinkedList_T() {
        head = null;
        size = 0;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public void addFirst(E item) {
        head = new Node<>(item, head);
        size++;
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<>(item, node.next);
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public boolean add(E item) {
        add(size, item);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        E element;
        if (index == 0) {
            element = head.data;
            head = head.next;
        } else {
            Node<E> before = getNode(index - 1);
            element = before.next.data;
            before.next = before.next.next;
        }
        size--;
        return element;
    }
    
    public int size(){
        return size;
    }
}
