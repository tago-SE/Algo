package TEN180607;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tiago
 */
public class StringQueue {
    
    private static final int INIT_CAP = 2;
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private int cap;
    private String[] arr;
    
    public StringQueue() {
        arr = new String[INIT_CAP];
        cap = 2;
    }
    
    private void expand() {
        String[] newArr = new String[cap*2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[head];
            head = ++head % cap;
        }    
        head = 0;
        tail = size - 1;
        cap *= 2;
        arr = newArr;
    }
    
    public boolean enqueue(String s) {
        if (s == null)
            return false;
        if (size == cap) {
            expand();
        }
        arr[tail] = s;
        tail = ++tail % cap;
        size++;
        return true;
    }

    public String dequeue() {
        if (isEmpty())
            return "";
        String ret = arr[head];
        arr[head] = null;
        head = ++head % cap;
        size--;
        return ret;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
   
    
}
