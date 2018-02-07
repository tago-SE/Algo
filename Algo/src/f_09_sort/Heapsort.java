
package f_09_sort;

/**
 *
 * @author tiago
 */
public class Heapsort {
    
    // Inplace
    public static void sort(int [] a) {
        buildHeap(a);
        shrinkHeap(a);
    }
    
    private static void swap(int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }    
    // Post: All items are in heaporder 
    private static void buildHeap(int [] a) {    
        int n = 1;
        while (n < a.length) {
            n++;
            int child = n - 1; // child      
            int parent = (child - 1)/2; // find parent
            while (parent >= 0 && a[parent] < a[child]) {
                swap(a, parent, child);
                child = parent;
                parent = (child - 1)/2;
            }
        }
    }
    
    // Pre: All items are in heaporder
    // Post: All items are sorted
    private static void shrinkHeap(int [] a) {
        int n = a.length;
        while (n > 0) {
            n--;
            swap(a, 0, n);
            int parent = 0;
            while (true) {
                int leftChild = 2*parent + 1;
                if (leftChild >= n) // No more children
                    break; 
                int rightChild = leftChild + 1;
                // find the largest of the children
                int maxChild = leftChild;
                if (rightChild < n // there is a rightChild
                        && a[leftChild] < rightChild) {
                    maxChild = rightChild;
                } 
                // if parent is smaller than the larger child 
                if (a[parent] < a[maxChild]) {
                    swap(a, parent, maxChild);
                    parent = maxChild;
                }
                else {
                    break;
                }
            }
        }
    }
}
