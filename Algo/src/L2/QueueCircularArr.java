/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package L2;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author tiago
 * @param <E>
 */
public class QueueCircularArr <E> extends AbstractQueue<E> implements Queue<E>  {
    private int front, rear, size, capacity;
    private final static int INIT_CAPACITY = 1;
    private E[] data;
    private boolean expandable;
    private boolean contractable;   // not implemented
    
    QueueCircularArr() {
        front = 0; rear = 0; size = 0; capacity = INIT_CAPACITY;
        data = (E[]) new Object[capacity];
        expandable = true;
        contractable = false;
    }
    
    QueueCircularArr(int capacity) throws Exception {
        front = 0; rear = 0; size = 0; this.capacity = capacity;
        if (capacity < 1) {
            throw new Exception("Invalid constructor.");
        }
        data = (E[]) new Object[capacity];
        expandable = true;
        contractable = false;
    }
    
    public void setExpandable(boolean b) {
        expandable = b;
    }
    
     public void setContractable(boolean b) {
        contractable = b;
    }
     
    @Override // Enqueue
    public boolean offer(E e) {
        if (size == capacity ) {
            if (expandable) 
                adjuctArray(capacity*2);
            else throw new IllegalStateException("Failed to queue element.");
        }
        data[rear] = e;
        rear = ++rear % capacity; // next near position
        size++;
        return true;
    }

    @Override // Dequeue
    public E poll() {
        if (data[front] == null) {
            return null;   
        }
        E tempData = data[front];
        data[front] = null;
        front = ++front % capacity; // next front position
        size--;
        if (size == capacity/4 && size != 0 && contractable)
            adjuctArray(capacity/2);
        return tempData;
    }

    @Override
    public E peek() {
        return data[front];
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    @Override
    public int size() {
        return size;
    }  
    
    private void adjuctArray(int newCapacity) {
        if (newCapacity <= size) {
            throw new IllegalArgumentException("argument: " + newCapacity);
        }
        E[] newData = (E[]) new Object[newCapacity];
        int f = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[f];
            f = ++f % capacity;
        }
        capacity = newCapacity;
        front = 0;      // next front position
        rear = size;    // next rear position
        data = newData;
    }
    
    @Override   // Debug 
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<String> itr = (Iterator<String>) new Iter();
        while (itr.hasNext()) {
            sb.append(itr.next()).append(" ");
        }
        sb.append("}");
        return sb.toString();
    }
    
    private class Iter implements Iterator<E> {
        int index;
        int count;
        
        public Iter() {
            index = front;
            count = 0;
        }
        
        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = data[index];
            index = ++index % capacity;
            count++;
            return returnValue;
        }
    }
}
