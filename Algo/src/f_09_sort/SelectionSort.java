package f_09_sort;

/**
 *
 * @author tiago
 */

public class SelectionSort {

    public static void selectionSort(int a[]) {
        int min, temp;
        // for every element except the last
        for (int i = 0; i < a.length - 1; i++) {
            // Set the current index as the minimum
            min = i;        
            // Find the smallest remaining element
            for (int j = i + 1; j < a.length; j++) {                               
                if (a[j] < a[min])
                    min = j;
            }
            // swap the smallest element 
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}

