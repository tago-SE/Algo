package f_09_sort;

/**
 *
 * @author tiago
 */

public class SelectionSort {

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void sort(int a[]) {
        // for every element except the last
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;   
            for (int j = i + 1; j < a.length; j++) { // Find  smallest                     
                if (a[j] < a[minIndex])
                    minIndex = j;
            }
            swap(a, i, minIndex);   // swap the smallest element 
        }
    }
}

