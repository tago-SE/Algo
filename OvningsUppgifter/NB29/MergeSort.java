/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB29;

import java.util.Arrays;

/**
 *
 * @author Jacob
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.println(Arrays.toString(arr));
        mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static String toString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + ", ");
        }
        return ("[" + sb.toString().substring(0, sb.length() - 2) + "]");
    }

    public static void mergesort(int[] a) {
        if (a.length == 1) {
            return;
        }

        int[] b = Arrays.copyOfRange(a,0, a.length / 2);
        int[] c = Arrays.copyOfRange(a, a.length / 2, a.length);

        mergesort(b);
        mergesort(c);
        merge(b, c, a);
    }

    public static void merge(int[] a, int[] b, int[] c) {
        int n = a.length;
        int m = b.length;
        int indexa = 0, indexb = 0, indexc = 0;

        while (indexa < n && indexb < m) {
            if (a[indexa] <= b[indexb]) {
                c[indexc++] = a[indexa++];
            } else {
                c[indexc++] = b[indexb++];
            }
        }

        while (indexa < n) {
            c[indexc++] = a[indexa++];
        }
        while (indexb < m) {
            c[indexc++] = b[indexb++];
        }

    }
}
