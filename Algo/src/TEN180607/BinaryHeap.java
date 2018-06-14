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
public class BinaryHeap {
    
    private static final int MAX = 1000;
    private int a[];
    private int size;

    public BinaryHeap(){
        a = new int[MAX];
        size = 0;
    }

    private void swap(int p, int c) {
        int temp = a[p];
        a[p] = a[c];
        a[c] = temp;
    }
    
    public boolean offer(int data){
       if (size == MAX)
           return false;
        a[size] = data;
        size++;
        for (int n = 2; n <= size; n++) {
            int c = n - 1;
            int p = (c - 1)/2;
            while (p >= 0 && a[p] > a[c]) {
                swap(p, c);
                c = p;
                p = (c - 1)/2;
            }
        }
        return true;
    }
    
 
    public int poll(){
        if (size == 0)
            return Integer.MAX_VALUE;
        
        int returnValue = a[0];
        size--;
        for (int n = size; n > 0; n--) {
            swap(0, n);
            int p = 0;
            for (;;) {
                int lc = 2*p + 1;
                if (lc >= n) 
                    break;
                int rc = lc + 1;
                int max = lc;
                if (rc < n && a[lc] < a[rc]) 
                    max = rc;
                if (a[p] < a[max]) {
                    swap(p, max);
                    p = max;
                } 
                else 
                    break;
            }
        }
        return returnValue;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int n = 0; n < size; n++) {
            int lc = 2*n + 1;
            int rc = lc + 1;
            System.out.println(n + ": " + a[n] + " lc: " + lc + " rc: " + rc);
            
        }
        
        return sb.toString();
    }
        

}
