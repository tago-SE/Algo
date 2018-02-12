package f_09_sort;

/**
 *
 * @author tiago
 */
public class RadixSort {
    
    private static int getMaxNumber(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }
    
    private static int get(int[] a, int i, int exp) {
        return (a[i]/exp)%10;
    }
    private static void countSort(int[] a, int exp) {
        int[] output = new int[a.length];
        int[] count = new int[10];
        
        for (int i = 0; i < a.length; i++)  // Count occurances of digit 
            count[get(a, i, exp)]++;
        for (int i = 1; i < 10; i++)    // change count so it contains actual 
            count[i] += count[i - 1];   // position of this digit
        
        for (int i = a.length - 1, x; i >= 0; i--) {
            x = get(a, i, exp);
            output[count[x] - 1] = a[i];
            count[x]--;
        }
        for (int i = 0; i < a.length; i++) // Copy content
            a[i] = output[i];
    }
    public static void sort(int a[]) {
        int max = getMaxNumber(a); // highest number in array
        for (int exp = 1; max/exp > 0; exp *= 10) {       // exp is 10^i 
            countSort(a, exp);
        }
    }
}
