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
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i])
               fail();
        }
    }
    
    private int[] createArray(int size, int min, int range) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            int rdm = ((int) (Math.random() * range) + min);
            a[i] = rdm;
        }
        return a;
    }

    
    
    @Test
    public void QuickSortTest() {
         int[] a;
        for (int i = 0; i < 10; i++) {
            a = createArray(100, 0, 255);
            QuickSort.sort(a);
            checkForSortFailure(a);
        }
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
    
    
    @Test
    public void ShellSortMultiple() {
        int[] a;
        for (int i = 0; i < 10; i++) {
            a = createArray(100, 0, 255);
            ShellSort.sort(a);
            checkForSortFailure(a);
        }
    }
    
}
