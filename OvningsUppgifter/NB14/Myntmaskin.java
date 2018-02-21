/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB14;

/**
 *
 * @author Jacob
 */
public class Myntmaskin {

    public static void main(String[] args) {
        int res = hittaMinstaPeng(43);
        System.out.println("Result: " + res);
    }

    public static int hittaMinstaPeng(int target) {
        return helpMynt(target, 1, 0);
    }

    public static int helpMynt(int target, int currentValue, int leastVal) {
       // System.out.println("currentVal: " + currentValue);

       // System.out.println("leastVal: " + leastVal);

        if (currentValue < target) {
            leastVal = Math.min(helpMynt(target, currentValue * 3, leastVal + 10), helpMynt(target, currentValue + 4, leastVal + 5));
        } else if (currentValue == target) {
            System.out.println("LeastVal: " + leastVal);
            return leastVal;
        } else {
            return Integer.MAX_VALUE;
        }
        //    return helpMynt(target, currentValue, leastVal);
        return leastVal; 
    }
}
