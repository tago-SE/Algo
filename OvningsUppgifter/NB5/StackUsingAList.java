/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB5;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 *
 * @author Jacob
 */
public class StackUsingAList<E> implements StackInt<E> {

    private ArrayList<E> data;
    private int top;

    public StackUsingAList() {
        data = new ArrayList<E>();
    }

    @Override
    public E push(E obj) {
        data.add(obj);
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data.get(data.size() - 1);
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        E returnItem = data.get(data.size()-1);
        data.remove(data.size()-1);
        return returnItem;
    }

    @Override
    public boolean empty() {
        return data.size() == 0;
    }
}
