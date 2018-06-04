/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_12_divide_n_conquer;

/**
 *
 * @author tiago
 */
public class LargestSubSequenceSum {
    
    static int counter = 0;
   
    
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
    public static int solve(int[] a) {
        int max = maxSum(a, 0, a.length -1);
        System.out.println("max: " + max);
        return max;
    }
    
}
