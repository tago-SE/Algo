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
        // while there is data in both input sequences
        while (l < left.length && r < right.length) {
            // pick the smallest and insert it into the output sequence
            if (left[l] <right[r]) 
                out[o++] = left[l++];
            else 
                out[o++] = right[r++];
        }
        // Assert: One of the sequences has more items to copy
        while (l <left.length) out[o++] = left[l++];
        while (r <right.length) out[o++] = right[r++];
    }
    
    private static void mergesort(int[] a) {
        if (a.length == 1) return;        
        // splits the array into two
        int[] left = new int[a.length/2];
        int[] right = new int[a.length % 2 == 0? a.length/2 : a.length/2 + 1];
        
        for (int i = 0; i < a.length; i++) {
            if (i < a.length/2) 
                left[i] = a[i];
            else right[i - a.length/2] = a[i];
        }
       
        mergesort(left);
        mergesort(right);
        merge(left, right, a);
    }
    
    public static void sort(int[] a) {
        mergesort(a);
    }
    
}
