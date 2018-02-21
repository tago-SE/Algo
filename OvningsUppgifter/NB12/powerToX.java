/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB12;

/**
 *
 * @author Jacob
 */
public class powerToX {

    public static void main(String[] args) throws Exception {
        int x, n;
        //x^n
        int res = iteratePowerTo(2, 5);
        System.out.println(res);
        res = iteratePowerTo(0, 5);
        System.out.println(res);
        res = iteratePowerTo(-2, 5);
        System.out.println(res);
        res = iteratePowerTo(-2, 0);
        System.out.println(res);
        try {
            res = iteratePowerTo(2, -2);
        } catch (Exception ex) {
            System.out.println("error.. cont..");
        }

        int resRec = recursivePowerTo(2, 5);
        System.out.println(resRec);
        resRec = recursivePowerTo(0, 5);
        System.out.println(resRec);
        resRec = recursivePowerTo(-2, 5);
        System.out.println(resRec);
        resRec = recursivePowerTo(-2, 0);
        System.out.println(resRec);
    }

    public static int recursivePowerTo(int x, int n) throws Exception {
        if (n < 0) {
            throw new Exception("Cannot calculate negative integers for n");
        }

        return helpRec(x, n, 1); //x^0 = 1
    }

    public static int helpRec(int x, int n, int result) {
        //  System.out.println("x,n,result: " + x + " : " + n + " : " + result);
        if (n == 0) {
            return result;
        } else {
            result = result * x;
            return helpRec(x, n - 1, result);
        }
    }

    public static int iteratePowerTo(int x, int n) throws Exception {
        if (n < 0) {
            throw new Exception("Cannot calculate negative integers for n");
        }
        
        int orgX = x;
        for (int i = 0; i < n - 1; i++) {
            //  System.out.println("i, x: " + i + " : " + x);
            x *= orgX;
        }
        if (n == 0)
            x = 1;
        
        return x;
    }
}
