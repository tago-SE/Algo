package stack_3;

/**
 *
 * @author tiago
 */
public class StackLinked<E> implements StackInterface {

    private Node<E> tail;
    private int size;
    
    // !
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
    
    @Override
    public Object push(Object obj) {
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

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public int size() {
        return size;
    }
}
