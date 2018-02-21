/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB43;

import java.util.Arrays;

/**
 *
 * @author Jacob
 */
public class VaxlingsProblem {
    //does not work
    public static void main(String[] args) {
        int value = 501;
        int[] valuta = {500, 100, 50, 20, 10, 5, 1};
        System.out.println(Arrays.toString(valuta));

        int res = vaxel(valuta, value);
        System.out.println("res: " + res);
    }

    public static int vaxel(int[] valuta, int value) {
        for (int i = 0; i < valuta.length; i++) {
            if (valuta[i] == value) {
                return valuta[i];
            }
        }
        
        int v = value;
        for (int i = 1; i < (value / 2); i++) {
            v = Math.min(v, vaxel(valuta, i) + vaxel(valuta, value - i));
        }
        return v;
    }
}
