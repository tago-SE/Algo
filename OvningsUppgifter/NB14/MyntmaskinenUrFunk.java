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
public class MyntmaskinenUrFunk {

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
        return helpCalc(0, 0, points);
    }

    private static int addOre(int tio, int fem, int addOn) {
        return ((tio * 10) + (fem * 5) + addOn);
    }

    private static int helpCalc(int tioOre, int femOre, int target) {
        //end when target < 0
        //if target % 4 = 1 || target % 3 = 1 then we got answer
        //else target-4
        if (target < 0) {
            return -1;
        } else {
            if (target % 4 == 1) {
                int addOn = ((target-1) / 4) * 5;
                System.out.println("target % 4 == 1, " + addOn);
                System.out.println("Antal st femöringar: " + ((addOn / 5) + femOre));
                System.out.println("addOn, femOre, tioOre: " + addOn + " : " + femOre + " : " + tioOre);
                return addOre(tioOre, femOre, addOn);
            } else if (femOre > 0) {
                int testTio = multiToEnd(target + (femOre * 4), (femOre * 4) + 1, 0);

                if (testTio != -1) {
                    System.out.println("femOringar: " + femOre);
                    return addOre(tioOre, femOre, 0) + testTio; //tioOre + counter
                }
                return helpCalc(tioOre, femOre + 1, target - 4);
            } else {
                System.out.println("target, femOre, tioOre: " + target + " : " + femOre + " : " + tioOre);
                return helpCalc(tioOre, femOre + 1, target - 4);
            }
        }
    }

    private static int multiToEnd(int target, int current, int counter) {
        System.out.println("target, current, counter:" + target + " : " + current + " : " + counter);
        if (current > target) {
            return -1;
        } else {
            if (current == target) {
                System.out.println("current == target");
                System.out.println("Antal st 10 öringar extra: " + counter);
                return (counter) * 10;
            } else if (current % 4 == 0) {
                System.out.println("current % 4 == 0");
                System.out.println("Antal st 10 öringar extra: " + counter);
                System.out.println("Antal st 5 öringar extra: " + (target - 1) / 4);
                return (counter * 10) + (((target + 1) / 4) * 5);
            } else {
                return multiToEnd(target, current * 3, counter + 1);
            }
        }
    }
}
