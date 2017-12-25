package stack_3;

/**
 *
 * @author tiago
 */
public interface StackInt<E> {
    public E push(E obj);
    public E pop();
    public E peek();
    public void flush();
}
