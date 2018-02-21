/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB15;

/**
 *
 * @author Jacob
 */
public class ConvertBinary {

    public static void main(String[] args) {
        int res = convertToDec("1011");
        System.out.println("converted to decimal: " + res);

        String newRes = convertToBinary(11);
        System.out.println("converted to binary: " + newRes);
    }

    //to binary
    public static String convertToBinary(int dec) {
        // String ans = Integer.toBinaryString(dec);
        //Integer.toString(dec)
        return findLargestBit(dec, 0);
    }

    private static String findLargestBit(int target, int pos) {
        System.out.println("pos: " + pos);
        //termineringsvillkor

        int m = (int) Math.pow(2, pos);
        if (m < target) {
            return findLargestBit(target, pos + 1);
        } else {
            return addZAndOnes(target, pos, 0, ""); //in array it is bit 0..n
        }
    }

    private static String addZAndOnes(int target, int startPos, int current, String ans) {
        if (startPos == 0) {
            return ans;
        } else {
            int m = (int) Math.pow(2, startPos-1);
            if (m + current <= target) {
                current += m;
                ans += "1";
            } else {
                ans += "0";
            }
            return addZAndOnes(target, startPos-1, current, ans);
        }
    }
    //end binary

    //convert to dec
    public static int convertToDec(String binary) {
        return helpConverting(binary, 0, 0);
    }

    public static int helpConverting(String binary, int start, int result) {
        System.out.println(result);
        if (start == binary.length()) {
            return result;
        } else {
            int currentBit = Character.getNumericValue(binary.charAt(start));
            int position = binary.length() - start - 1;
            int multiply = (int) Math.pow(2, position);
            //  System.out.println("ans: " + multiply);
            //  System.out.println("binary charAt: " + currentBit);
            return result += helpConverting(binary, start + 1, currentBit * multiply);
        }
    }
    //end convertToDec
}
