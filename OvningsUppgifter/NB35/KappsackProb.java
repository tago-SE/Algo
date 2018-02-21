/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class KappsackProb {

    public static void main(String[] args) {
        /*
        varor.add(new Vara(10, 4));
        varor.add(new Vara(15, 10));
        varor.add(new Vara(42, 25));
        varor.add(new Vara(15, 23));
        varor.add(new Vara(10, 13));

        Collections.sort(varor);
         */

        int varaVikt = 1;
        int varaPris = 1;
        Scanner scan = new Scanner(System.in);
        while (true) {
            ArrayList<Vara> varor = new ArrayList<>();
            while (varaVikt != 0 || varor.size() == 0) {
                System.out.println("Skriv in info för möjliga varor, vikt: (avsluta med värde 0)");
                varaVikt = scan.nextInt();
                if (varaVikt == 0 && varor.size() > 0) {
                    break;
                }
                System.out.println("Skriv in info för möjliga varor, pris:");
                varaPris = scan.nextInt();

                if (varaVikt > 0) {
                    System.out.println("adding..");
                    varor.add(new Vara(varaVikt, varaPris));
                }
            }

            System.out.println("Vikt på väskan? ");
            int vikt = scan.nextInt();

            varaVikt = 1;
            Collections.sort(varor);

            ArrayList<Vara> packPlan = fyllSack(vikt, varor);
            System.out.println("Packa väskan med dessa varor:");
            System.out.println(packPlan);
        }
    }

    public static ArrayList<Vara> fyllSack(int vikt, ArrayList<Vara> varor) {
        ArrayList<Vara> result = new ArrayList<>();
        int p;

        for (int i = 0; i < varor.size(); i++) {
            p = varor.get(i).getVikt();
            while (vikt - p >= 0) {
                vikt -= p;
                result.add(varor.get(i));
            }
        }

        return result;
    }
}
