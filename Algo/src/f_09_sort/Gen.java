
package f_09_sort;

/**
 *
 * @author tiago
 */
public class Gen {
    public static void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        
    public static int[] generate(int n) {
        int[] a = new int[n];
        Math.random();

        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random()*100);
        }
        return a;
    }

    public static void print(int[] a) {
        for (int i: a) {
            System.out.println(i);
        }
    }
}
