
package f_09_sort;

/**
 *
 * @author tiago
 */
public class ShellSort {
    
    public static void sort(int[] a) {
        for (int gap = a.length/2; gap >= 0; gap /= (int) 2.2) {
            int cur, j;
            // Similar to insertion sort
            for (int i = gap; i < a.length; i++) {
               cur = a[i];
               for (j = i; j >= gap && cur < a[j - gap]; j -= gap) {
                   a[j] = a[j - gap];
               }
               a[j] = cur;
            }
            if (gap == 0) break;
        }
    }
}
