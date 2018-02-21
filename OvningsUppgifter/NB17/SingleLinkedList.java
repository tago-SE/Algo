/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB17;

/**
 *
 * @author Jacob
 * @param <E>
 */
public class SingleLinkedList<E> {

    private static class Node<E> {

        private E data;
        private Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public SingleLinkedList() {
        head = null;
        size = 0;

    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public boolean add(E item) {
        add(size, item);
        return true;
    }
    
    public int getSize() {
        return helpGetSize(head, 0);
    }
    
    private int helpGetSize(Node<E> currentNode, int ticker) {
        if (currentNode == null) {
            return ticker;
        }
        return helpGetSize(currentNode.next, ticker+1);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = getNode(index);
        return node.data;
    }

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    private Node<E> getNode(int index) {
        return helpGetNode(head, index, 0);
    }

    private Node<E> helpGetNode(Node<E> start, int index, int current) {
        if (index == current) {
            return start;
        }
        if (start.next != null) {
            return helpGetNode(start.next, index, current + 1);
        }
        return null;
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

}
