package f_09_sort;

/**
 *
 * @author tiago
 */
public class BucketSort {
    private static int getMaxNumber(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }
    
    public static void sort(int[] a) {
        // create a bucket fitting the highest number
        int[] bucket = new int[getMaxNumber(a) + 1];
    
        for (int i = 0; i < a.length; i++) 
            bucket[a[i]]++; // Count number of occurances

        // For every position on the bucket distribute the items,
        // inner loop takes care of multiple occourances
        for (int i = 0, o = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                a[o++] = i;
            }
        }  
    }
}
