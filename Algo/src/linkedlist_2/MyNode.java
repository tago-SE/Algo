package linkedlist_2;

/**
 *
 * @author tiago
 */
class MyNode<E> {
    private E data;
    private MyNode<E> next;
    private MyNode<E> prev;        
    
    public MyNode() {
        
    }
    
    public MyNode(E data) {
        this.data = data;
    }

    public MyNode(E data, MyNode<E> next) {
        this.data = data;
        this.next = next;
    }
    
    public MyNode(E data, MyNode<E> next, MyNode<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    public void setNext(MyNode<E> next) {
        this.next = next;
    }

    public MyNode<E> getNext() {
        return next;
    }
        
    public MyNode<E> getPrev() {
        return prev;
    }

    public void setPrev(MyNode<E> prev) {
        this.prev = prev;
    }
    
    public void setData(E data) {
        this.data = data;
    }
    
    public E getData() {
        return data;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}
