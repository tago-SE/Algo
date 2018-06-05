
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
   
        for (int n = 2; n < a.length; n++) {
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
                int leftC = 2*parent + 1;
                
                if (leftC >= n) break; 
                int rightC = leftC + 1;
                int maxC = leftC;
                
                if (rightC < n && a[rightC] > a[leftC]) // Find largest child
                        maxC = rightC;
               
                if (a[parent] < a[maxC]) {
                    swap(a, parent, maxC);
                    parent = maxC;
                } else 
                    break;
            }
        }
    }
}
