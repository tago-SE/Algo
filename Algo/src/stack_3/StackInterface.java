package stack_3;

/**
 *
 * @author tiago
 */
public interface StackInterface<E> {
    public E push(E obj);
    public E pop();
    public E peek();
    public void flush();
    public boolean isEmpty();
    public int size();  
}
