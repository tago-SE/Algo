/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ten140314;

import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class Uppg5 {

    public static void main(String[] args) {
        String arr = "1,2,3,4,5,7,6,9,8";
        int res = noOfMoves(arr);
        System.out.println("Result: " + res);
    }

    private static String convArrToStr(String[] arr) {
        String returnVal = "";
        for (int i = 0; i < arr.length; i++) {
            returnVal += arr[i] + ",";
        }
        return returnVal;
    }

    private static String rotatePiece(String grid, int index, boolean clockWise) {
        String[] arr = grid.split(",\\s*");
        int realLen = 9;
        int rowSwitch = (int) Math.sqrt(realLen); //3
        int firstMod = (index + 1) % rowSwitch; //not 3,6
        int lastRow = realLen - rowSwitch; //not 7,8,9

        if (firstMod != 0 && index < lastRow && index >= 0) { //index is correct and we are at a index where we can rotate a 2*2
            if (clockWise == false) {
                //rotate
                String tmpFirst = arr[index];
                arr[index] = arr[index + 1];
                arr[index + 1] = arr[index + 1 + rowSwitch];
                arr[index + 1 + rowSwitch] = arr[index + rowSwitch];
                arr[index + rowSwitch] = tmpFirst;
            } else {
                String tmpFirst = arr[index];
                arr[index] = arr[index + rowSwitch];
                arr[index + rowSwitch] = arr[index + 1 + rowSwitch];
                arr[index + 1 + rowSwitch] = arr[index + 1];
                arr[index + 1] = tmpFirst;
            }
            return convArrToStr(arr);
        }
        return grid;
    }

    public static String increaseCount(String grid) {
        String[] arr = grid.split(",\\s*");
        int count = Integer.parseInt(arr[arr.length - 1]);
        arr[arr.length - 1] = String.valueOf(count + 1);
        String res = convArrToStr(arr);
        return res;
    }

    private static int getLast(String grid) {
        String[] arr = grid.split(",\\s*");
        int count = Integer.parseInt(arr[arr.length - 1]);
        return count;
    }

    public static int noOfMoves(String grid) {
        grid += ",0"; //starvalue on counter every path gets its own counter
        ArrayList<String> paths = new ArrayList<>(); //array of current positions with pathcounter on end
        paths.add(grid);
        int count = 0;
        int index = 0;
        while (count < 362880) { //do until we checked every possiblity of rotations
            if (index == 5) { //reset index
                count++;
                index = 0;
                paths.remove(0); //remove the last one checked
                
                System.out.println("until error: " + (((double) count / (double) 362880) * 100) + "%");
            } else if (index == 2) { //skip this one
                index = 3;
            } else if (index == 0 || index == 1 || index == 3 || index == 4) {
                //try this path with rotating and all valid indexes clockwise and counterclosewise
                String rotateCounter = rotatePiece(paths.get(0), index, false);
                rotateCounter = increaseCount(rotateCounter);
                paths.add(rotateCounter);
                if (isSorted(rotateCounter)) {
                    return getLast(rotateCounter);
                }

                String rotateClock = rotatePiece(paths.get(0), index, true);
                rotateClock = increaseCount(rotateClock);
                paths.add(rotateClock);
                if (isSorted(rotateClock)) {
                    return getLast(rotateClock);
                }
                index += 1;
            }
        }

        //System.out.println(paths);
        return Integer.MAX_VALUE;
    }

    private static boolean contains(ArrayList<String> paths, String newPath) {
        for (int i = 0; i < paths.size(); i++) {
            if (paths.get(i).contains(newPath)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSorted(ArrayList<String> paths) {
        if (paths.size() >= 3) {
            for (int i = paths.size() - 2; i < paths.size(); i++) { //the last two
                if (isSorted(paths.get(i))) {
                    return true;
                }
            }
        }

        return isSorted(paths.get(0));
    }

    private static boolean isSorted(String grid) {
        String[] arr = grid.split(",\\s*");
        for (int i = 0; i < arr.length - 2; i++) {
            if (Integer.parseInt(arr[i]) > Integer.parseInt(arr[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
