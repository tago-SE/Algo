/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB34;

import java.util.Arrays;

/**
 *
 * @author Jacob
 */
public class Main {

    public static void main(String[] args) {
        int[] res = change(789, new int[]{1000, 500, 100, 50, 20, 10, 5, 1});
        System.out.println(Arrays.toString(res));
    }

    public static int[] change(int vaxSumma, int[] valutor) {
        int[] result = new int[valutor.length];

        for (int i = 0; i < valutor.length; i++) {
            result[i] = 0;
            while (vaxSumma - valutor[i] >= 0) {
                vaxSumma -= valutor[i];
                result[i]++;
            }
        }
        return result;
    }
}
