/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB14;

import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class Myntmaskinen {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Vilken poäng ska uppnås: ");
            int points = scan.nextInt();
            System.out.println(points);
            int res = calcOre(points);
            if (res == -1) {
                System.out.println("Poängen kan ej nås");
            } else {

                System.out.println("Poängen kan nås med " + res + " öre.");
            }
        }
    }

    public static int calcOre(int points) {
        return helpCalc(points, 1, 0, 0, points * 10);
    }

    private static int helpCalc(int target, int current, int counterTen, int counterFive, int smallest) {
        //System.out.println("outside current: " + current);
        if (current > target * 3) {
            if (target * 10 == smallest) {
                return -1;
            }
            return smallest;
        }

        // System.out.println("current: " + current);
        if (current == target) {
            int tioOringar = counterTen * 10;
            int femOringar = ((target - 1) / 4) * 5;
            System.out.println("SOLVED");
            System.out.println("tior, femmor: " + counterTen + " : " + ((target - 1) / 4));
            if ((tioOringar + femOringar) < smallest) {
                smallest = tioOringar + femOringar;
            }
            // return (tioOringar + femOringar);
        }

        if (current < target) {
            System.out.println("current: " + current);
            return helpCalc(target, current + 4, counterTen, counterFive+1, smallest);
        }
        current = (counterTen * 4) + 1;

        System.out.println("after multiply current is: " + current);
        
        if (current == target) {
            int tioOringar = counterTen * 10;
            int femOringar = counterFive;
            System.out.println("SOLVED");
            System.out.println("tior, femmor: " + counterTen + " : " + (counterFive));
            System.out.println("svar: " + tioOringar + femOringar);
            if ((tioOringar + femOringar) < smallest) {
                smallest = tioOringar + femOringar;
            }
            // return (tioOringar + femOringar);
        }

        return helpCalc(target, current * 3, counterTen + 1, counterFive, smallest);
    }
}
