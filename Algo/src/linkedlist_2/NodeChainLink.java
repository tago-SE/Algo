package linkedlist_2;

/**
 *
 * @author tiago
 */
public class NodeChainLink<E> {
    private E data;
    private NodeChainLink<E> next;
    private NodeChainLink<E> prev;        
    
    public NodeChainLink() {
        
    }
    
    public NodeChainLink(E data) {
        this.data = data;
    }

    public NodeChainLink(E data, NodeChainLink<E> next) {
        this.data = data;
        this.next = next;
    }
    
    public NodeChainLink(E data, NodeChainLink<E> next, NodeChainLink<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    public void setNext(NodeChainLink<E> next) {
        this.next = next;
    }

    public NodeChainLink<E> getNext() {
        return next;
    }
        
    public NodeChainLink<E> getPrev() {
        return prev;
    }

    public void setPrev(NodeChainLink<E> prev) {
        this.prev = prev;
    }
    
    public void setElement(E data) {
        this.data = data;
    }
    
    public E getElement() {
        return data;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}