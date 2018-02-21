/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB7;

import java.util.EmptyStackException;

/**
 *
 * @author Jacob
 */
public class LinkedStack<E> implements StackInt<E> {

    private static class Node<E> {

        private E data;
        private Node<E> next;

        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    private Node<E> top;

    public LinkedStack() {
        top = null;
    }

    @Override
    public E push(E obj) {
        top = new Node<E>(obj, top);
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return top.data;
        }
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            E result = top.data;
            top = top.next;
            return result;
        }
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    public int size() {
        int result = 0;
        Node tmp = top;
        while (tmp.next != null) {
            result++;
            tmp = tmp.next;
        }
        return result;
    }

    public E peek(int n) {
        if (n >= 0 && n <= size()) { //with 1 items top is 0, if n is 1 index is out of bounds
            
            int result = 0;
            Node tmp = top;
            while (result < n) {
                result++;
                tmp = tmp.next;
            }
            return (E) tmp.data;
        }
        throw new ArrayIndexOutOfBoundsException(n);
    }

    public E flush() {
        if (empty()) {
            return null;
        }
        E returnItem = null;
        while (!empty()) {
            returnItem = pop();
        }
        return returnItem;
    }

}
