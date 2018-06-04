package f_09_sort;

/**
 *
 * @author tiago
 */
public class BinarySearch extends Gen {
  
    
    public static int find(int[] a, int target, int first, int last) {
        if (first > last) 
            return -1;
        int mid = (last - first)/2 + first; 
        if (a[mid] == target) 
            return a[mid];
        else if (target < a[mid]) 
            return find(a, target, first, mid - 1);
        return find(a, target, mid + 1, last);
    }    
    public static int find(int[] a, int target) {
        return find(a, target, 0, a.length - 1);
    }
}
