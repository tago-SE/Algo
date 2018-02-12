package f_09_sort;

/**
 *
 * @author tiago
 */
public class QuickSort {
    
    public static void sort(int[] a) {
        quicksort(a, 0, a.length - 1); // first, last
    }
    
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } 
    
    private static void quicksort(int[] a, int first, int last) {
        if (first < last) { // there is data to be sorted
            int pivot = partition(a, first, last);
            quicksort(a, first, pivot - 1); // sort left half
            quicksort(a, pivot + 1, last);  // sort right half
        }
    }
    
    private static int partition(int[] a, int first, int last) {
        int pivot = a[first];
        int up = first;
        int down = last;
        do {
            while (up < last && pivot >= a[up]) up++;
            while (pivot < a[down])             down--;
            if (up < down) 
                swap(a, up, down);
        } while (up < down);
        swap(a, first, down);
        return down;
    }
    
}
