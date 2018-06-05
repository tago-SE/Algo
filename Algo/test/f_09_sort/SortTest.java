/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_09_sort;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class SortTest {
    
    
    public SortTest() {
    
    }
    
    private void checkForSortFailure(int[] a) {
        boolean failed = false;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i])
               fail();
        }
    }

    @Test
    public void QuickSortTest() {
        int[] a = {1, 3, 2, 34, 9, 82, 14, 10, 8, 12};
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
        checkForSortFailure(a);
    }
    
    @Test
    public void RadixSort() {
        int[] a = {1, 3, 2, 34, 9, 82, 14, 10, 8, 12};
        RadixSort.sort(a);
        System.out.println(Arrays.toString(a));
        checkForSortFailure(a);
    }
    
    @Test
    public void MergeSort_1() {
        int[] a = {1, 3, 2, 34, 9, 82, 14, 10, 8, 12};
        RadixSort.sort(a);
        System.out.println(Arrays.toString(a));
        checkForSortFailure(a);
    }
    
    @Test
    public void MergeSort_2() {
        int[] a = {1, 3, 2, 34, 9, 82, 14, 10, 8};
        MergeSort.sort(a);
        System.out.println(Arrays.toString(a));
        checkForSortFailure(a);
    }
    
    @Test
    public void HeapSort() {
        int[] a = {1, 3, 2, 34, 9, 82, 14, 10, 8, 7, 1, 3, 2};
        Heapsort.sort(a);
        System.out.println(Arrays.toString(a));
        checkForSortFailure(a);
    }
    
    @Test
    public void ShellSort() {
        int[] a = {1, 3, 2, 34, 9, 82, 14, 10, 8, 12};
        ShellSort.sort(a);
        System.out.println(Arrays.toString(a));
        checkForSortFailure(a);
    }
}
