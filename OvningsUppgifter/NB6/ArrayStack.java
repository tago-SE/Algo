/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB6;

import NB5.StackInt;
import NB7_1.PostfixEvaluator;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *
 * @author Jacob
 */
public class ArrayStack<E> implements StackInt<E> {

    private E[] elements;
    private int top;
    private int maxSize;

    public ArrayStack() {
        maxSize = 10;
        elements = (E[]) new Object[maxSize];
        top = -1;
    }

    private void reallocate() {
        maxSize *= 2;
        elements = Arrays.copyOf(elements, maxSize);
    }

    @Override
    public E push(E obj) {
        if (top == maxSize - 1) {
            reallocate();
        }
        top++;
        elements[top] = obj;
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return elements[top];
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return elements[top--];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public E peek(int n) {
        if (n >= 0 && n < size()) { //with 1 items top is 0, if n is 1 index is out of bounds
            return elements[n];
        }
        throw new ArrayIndexOutOfBoundsException(n);
    }

    public E flush() {
        if (empty()) {
            return null;
        }
        E returnItem = elements[0];
        while (!empty()) {
            pop();
        }
        return returnItem;
    }
}
