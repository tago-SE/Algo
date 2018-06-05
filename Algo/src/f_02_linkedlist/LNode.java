/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_02_linkedlist;

/**
 *
 * @author tiago
 */
public class LNode<E> {
    E data;
    LNode<E> next;
    LNode<E> prev;
    
    private LNode(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
  private LNode(E data, LNode<E> next) {
        this.data = data;
        this.next = next;
        this.prev = null;
        next.prev = this;
    }
    
    private LNode(E data, LNode<E> next, LNode<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
        next.prev = this;
        prev.next = this;
    }
}
