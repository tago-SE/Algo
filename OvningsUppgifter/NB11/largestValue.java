/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB11;

/**
 *
 * @author Jacob
 */
public class largestValue {

    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 50);
        }
        
        String arrString = toString(array);
                
        int res = getLargest(array);
        System.out.println("largest int: " + res);
        System.out.println(arrString);
    }

    public static int getLargest(int[] array) {
        
        return array[loopArrayForLargest(0, array, 0)]; //set largest to first int in array, start at 0
    }
    
    public static int loopArrayForLargest(int start, int[] array, int largest) {
        if (start == array.length) {
            return largest;
        } else {
            if (array[start] > array[largest]) {
                System.out.println("Found larger!\nStartIndex, current largestIndex: " + start + ", " + largest);
                largest = start;
            }
            return loopArrayForLargest(start+1, array, largest);
        }
        //return 1;
    }
    
    public static String toString(int[] array) {
        StringBuilder builder = new StringBuilder();
        
        builder.append("[");
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] + ",");
        }
        builder.append("]");
        return builder.toString();
    }
}
