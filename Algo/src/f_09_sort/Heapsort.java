
package f_09_sort;

/**
 *
 * @author tiago
 */

public class Heapsort {

    // in place
   private static void swap(int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }    
   
    public static void sort(int [] a) {
        buildMaxheap(a);
        shrinkHeap(a);
    }

    private static void buildMaxheap(int [] a) {    
   
        for (int n = 2; n <= a.length; n++) {
            int child = n - 1;     
            int parent = (child - 1)/2; 
            while (parent >= 0 && a[parent] < a[child]) {
                swap(a, parent, child);
                child = parent;
                parent = (child -1)/2;
            }
        }        
    }
    private static void shrinkHeap(int [] a) {
        for (int n = a.length - 1; n > 0; n--) {
            swap(a, 0, n); // swap first with last, will always be the largest
            int parent = 0;
            for (;;) {
                int leftChild = 2*parent + 1;
                if (leftChild >= n) // No more children
                    break;
                int rightChild = leftChild + 1;
                // Find the largest child
                int maxChild = leftChild;
                if (rightChild < n) { // there is a right child
                    if (a[rightChild] > a[leftChild])
                        maxChild = rightChild;
                }
                if (a[parent] < a[maxChild]) {
                    swap(a, parent, maxChild);
                    parent = maxChild;
                } else {
                    break;
                }
            }
        }
    }
}
