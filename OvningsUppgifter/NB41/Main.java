/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB41;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class Main {

    static int counter = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter number of ints");
        int n = scan.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 2000) - 1000;
        }

        System.out.println(Arrays.toString(arr));
        delsekvens(arr);

     //   easier(arr);
    }
    
    public static void easier(int[] arr) {
        int sum = 0;
        int max = arr[0];
        
        for (int j = 0; j < arr.length; j++) {
            sum = 0;
            for (int i = j; i < arr.length; i++) {
                sum += arr[i];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        
        System.out.println("my easier alg: " + max); //O(n^2) :]
    }

    public static void delsekvens(int[] arr) {
        int svar = maxSum(arr, 0, arr.length - 1);
        System.out.println("svar: " + svar);
        System.out.println("antal anrop: " + counter); //n*2 - 1 :]
    }

    private static int max(int a, int b, int c) {
        int max;
        max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }

    public static int maxSum(int[] a, int left, int right) {
        counter++;
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return Math.max(0, a[left]); //return this element if its larger than 0
        }
        int center = (left + right) / 2;
        int sum = 0, maxLeft = 0;

        for (int i = center; i >= left; i--) { //add all items from center to left
            sum = sum + a[i];
            maxLeft = Math.max(maxLeft, sum); //maxLeft is the largest sum so far
        }

        sum = 0;
        int maxRight = 0;

        for (int i = center + 1; i <= right; i++) { //do same to right
            sum = sum + a[i];
            maxRight = Math.max(maxRight, sum);
        }

        int maxOverMitt = maxLeft + maxRight; //add the sum of group left and right
        return max(maxOverMitt, maxSum(a, left, center), maxSum(a, center + 1, right)); //divide problem by the center
    }
}
