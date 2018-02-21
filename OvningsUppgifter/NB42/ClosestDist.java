/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Jacob
 */
public class ClosestDist {

    public static void main(String[] args) {
        ArrayList<Punkt> arr = new ArrayList<>();
        int noPoints = 30;

        for (int i = 0; i < noPoints; i++) { //30 = 13 sek, 40 = 
            arr.add(new Punkt((float) (Math.random() * 200) - 1, (float) (Math.random() * 200) - 1));
        }

        Collections.sort(arr);
        System.out.println("Sorted by x" + arr.toString() + "\n");
        printAllDist(arr);
        float res = closestMain(arr, arr.size());
        System.out.println("res: " + res);
    }

    public static float closestMain(ArrayList<Punkt> arr, int n) {
        if (n <= 3) {
            return shortDist(arr);
        }
        int middle = n / 2;
        Punkt midPunkt = arr.get(middle);

        float deltaL = closestMain(arr, middle);
        float deltaR = closestMain(arr, n - middle);

        float min = Math.min(deltaL, deltaR);

        ArrayList<Punkt> strip = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(arr.get(i).getX() - midPunkt.getX()) < min) {
                strip.add(arr.get(i));
            }
        }

        return Math.min(min, stripClosest(strip, min));
    }
    
    private static void printAllDist(ArrayList<Punkt> arr) {
                for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                System.out.println("Dist punkt " + i + " and " + j + " is: " + getDist(arr.get(i), arr.get(j)));
            }
        }
    }

    private static float stripClosest(ArrayList<Punkt> strip, float d) {
        float min = d;
        Collections.sort(strip, new Punkt());

        for (int i = 0; i < strip.size()-1; i++) {
            for (int j = i + 1; j < strip.size() && ((strip.get(i).getY() - strip.get(i).getY()) < min); j++) { //check only points with y distance smaller then current smallest distance
                if (getDist(strip.get(i), strip.get(j)) < min) {
                    min = getDist(strip.get(i), strip.get(j));
                }
            }
        }
        return min;
    }

    public static float shortDist(ArrayList<Punkt> arr) {
        float min = Float.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
                if (getDist(arr.get(i), arr.get(i + 1)) < min)
                    min = getDist(arr.get(i), arr.get(i + 1));
        }
        return min;
    }

    private static float getDist(Punkt a, Punkt b) {
        float dx = (float) Math.pow(a.getX() - b.getX(), 2);
        float dy = (float) Math.pow(a.getY() - b.getY(), 2);
        return (float) (Math.sqrt(dy + dx));
    }

}
