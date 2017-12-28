package f_02_linkedlist;

/**
 *
 * @author tiago
 */

/**
 * @pre
 * @post
 * @author tiago
 */
public class DubbelLinkedNodes {
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
            next.prev = this;
            prev.next = this;
        }
        
        private void setData(E data) {
            this.data = data;
        }
        
        private void setNext(Node<E> next) {
            this.next = next;
        }
        
        private void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
            
    public static void main() 
    {
        Node<String> head = new Node("Head");
        Node<String> tail = new Node("tail");
       
        Node<String > n1 = new Node("Pos1", tail, head);
        Node<String > n2 = new Node("Pos2", tail, n1);
     
        Node<String> node;
        
        System.out.print("Forward: ");
        node = head;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
        
        System.out.print("Backwards: ");
        node = tail;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.prev;
        }
        System.out.println("");
        
        // Removing pos 2
        head.next.next = tail;
        tail.prev = tail.prev.prev;
        
        System.out.print("Forward: ");
        node = head;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
        
        Node<String> head2 = new Node("Head2");
        Node<String> tail2 = new Node("tail2");
        head2.next = tail2;
        tail2.prev = head2;
        
        
    }
    
}
