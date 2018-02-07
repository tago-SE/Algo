package f_09_sort;

/**
 *
 * @author tiago
 */
public class InsertionSort {
    
    public static void sort(int[] a) {
        int cur, j;
        for (int i = 1; i < a.length; i++) {
            cur = a[i];
            // iterate backwards and move every element that is larger than
            // the current element one step to the right, until a proper
            // position is found
            for (j = i; j > 0 && cur < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            // place element at right position
            a[j] = cur;
        }
    }
}


