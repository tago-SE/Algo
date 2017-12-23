package stack_3;

/**
 *
 * @author tiago
 */
public class StackArray<E> implements StackInterface {

    private final int DEFAULT_CAP = 5;
    private int cap = DEFAULT_CAP;
    private int size; 
    private E[] elements;
    
    public StackArray() {
        elements = (E[]) new Object[DEFAULT_CAP]; // !
    }
    
    private void refreshArraySize(int max) {
        if (max <= size) 
            throw new IllegalArgumentException("argument: " + max);
        E[] newElements = (E[]) new Object[max]; 
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
    
    @Override
    public Object push(Object obj) {
        if (size >= cap - 1)
            refreshArraySize(cap*2);
        elements[size++] = (E) obj;
        return obj;
    }

    @Override
    public Object pop() {
        if (size == 0)
            return null;
        Object popValue = elements[size - 1];
        size--;
        if (size == cap/4 && size > 1)
            refreshArraySize(cap/2);
        return popValue;
    }

    @Override
    public Object peek() {
        if (size == 0)
            return null;
        return elements[size - 1];
    }

    @Override
    public void flush() {
        size = 0;
        if (cap != DEFAULT_CAP)
            refreshArraySize(DEFAULT_CAP);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
