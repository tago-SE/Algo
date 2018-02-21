/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB13;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class calcRoot {

    public static void main(String[] args) {
        double res;
        try {
            res = rot(8, 2, 6);
            System.out.println(res);
        } catch (Exception ex) {
            Logger.getLogger(calcRoot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static double rot(int n, double a, int e) throws Exception {
        if (n < 1) {
            throw new Exception("n has to be equal or larger than 1");
        }
        if (Math.abs(a * a - n) < e) {
            System.out.println("n,a,e: " + n + " : " + a + " : " + e);
            return rot(n, ((a * a) + n) / (2 * a), e-1);
        } else {
            return (double)Math.round(a * 1000) / 1000;
        }
    }
}
