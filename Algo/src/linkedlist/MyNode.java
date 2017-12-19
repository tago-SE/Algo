/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author tiago
 */
class MyNode<E> {
    private E data;
    private MyNode<E> next;
    private MyNode<E> prev;        
    
    public MyNode(E data) {
        this.data = data;
    }

    public MyNode(E data, MyNode<E> next) {
        this.data = data;
        this.next = next;
    }
    
    public void setNext(MyNode<E> next) {
        this.next = next;
    }
    
    public void setData(E data) {
        this.data = data;
    }
    
    public MyNode<E> getNext() {
        return next;
    }
    
    public E getData() {
        return data;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}
