
package f_09_sort;

/**
 *
 * @author tiago
 */
public class ShellSort {
    
    public static void sort(int[] a) {
        for (int g = a.length/2; g >= 0; g /= (int) 2.2) {
            // Similar to insertion sort (g replaces 1 and 0)
            for (int i = g; i < a.length; i++) {
               int cur = a[i], j;
               for (j = i; j >= g && cur < a[j - g]; j -= g) {
                   a[j] = a[j - g];
               }
               a[j] = cur;
            }
            if (g == 0) break;  
        }
    }
    
}
