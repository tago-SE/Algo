package f_09_sort;

import java.util.Arrays;

/**
 *
 * @author tiago
 */
public class MergeSort {
    
    // Precondition: left & right are already sorted
    private static void merge(int[] left, int[] right, int[] out) {
        int l = 0, r = 0, o = 0;
        // while there is data in both input sequences pick the smallest
        // and insert into the output sequence
        while (l < left.length && r < right.length) {
            if (left[l] <right[r]) 
                out[o++] = left[l++];
            else 
                out[o++] = right[r++];
        } // Assert: One of the sequences has more items to copy
        while (l <left.length) out[o++] = left[l++];
        while (r <right.length) out[o++] = right[r++];
    }
    
    private static void mergesort(int[] a) {
        if (a.length == 1) return;        
        int[] left = new int[a.length/2];       
        int[] right = new int[a.length/2 + a.length % 2];
        System.arraycopy(a, 0, left, 0, left.length);
        System.arraycopy(a, left.length, right, 0, right.length);
        mergesort(left);
        mergesort(right);
        merge(left, right, a);
    }
    
    public static void sort(int[] a) {
        mergesort(a);
    }
    
}
