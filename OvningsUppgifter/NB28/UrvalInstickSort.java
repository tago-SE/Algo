/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB28;

import java.util.Arrays;

/**
 *
 * @author Jacob
 */
public class UrvalInstickSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.println("Unsorted array: " + toString(arr));
        System.out.println("InsertionSort: " + toString(instickSort(arr)));
        System.out.println("UrvalsSort: " + toString(urvalsSort(arr)));
    }

    public static int[] urvalsSort(int[] array) {
        int[] tmpArr = Arrays.copyOf(array, array.length);
        int minIndex = 0;

        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (tmpArr[j] < tmpArr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmpInt = tmpArr[i];
            tmpArr[i] = tmpArr[minIndex];
            tmpArr[minIndex] = tmpInt;
        }
        return tmpArr;
    }

    public static int[] instickSort(int[] array) {
        int[] tmpArr = Arrays.copyOf(array, array.length);
        int data = tmpArr[0];
        int dataIndex = 0;

        for (int i = 1; i < array.length; i++) {
            data = tmpArr[i];
            dataIndex = i;
            while (dataIndex > 0 && data < tmpArr[dataIndex - 1]) {
                tmpArr[dataIndex] = tmpArr[dataIndex - 1];
                dataIndex--;
            }
            tmpArr[dataIndex] = data;
        }

        return tmpArr;
    }

    public static String toString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + ", ");
        }
        return ("[" + sb.toString().substring(0, sb.length() - 2) + "]");
    }
}
