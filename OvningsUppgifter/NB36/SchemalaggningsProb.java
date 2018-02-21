/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB36;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class SchemalaggningsProb {

    public static void main(String[] args) {
        ArrayList<Aktivitet> schema = new ArrayList<>();

        LocalTime night = LocalTime.MIDNIGHT;

        schema.add(new Aktivitet(0, 2)); //start, slut
        schema.add(new Aktivitet(1, 4));
        schema.add(new Aktivitet(3, 5));
        schema.add(new Aktivitet(4, 8));
        schema.add(new Aktivitet(6, 8));
        schema.add(new Aktivitet(7, 10));
        schema.add(new Aktivitet(8, 12));

        Collections.sort(schema);

        System.out.println("Aktiviteter: \n" + schema.toString());

        ArrayList<Aktivitet> res = schemalagg(schema);
        System.out.println("Result: \n" + res.toString());
    }

    public static ArrayList<Aktivitet> schemalagg(ArrayList<Aktivitet> schema) {
        ArrayList<Aktivitet> res = new ArrayList<>();
        while (schema.size() > 0) {
            res.add(schema.get(0));
            Aktivitet tmp = schema.get(0);
            schema.remove(0);
            for (int i = 0; i < schema.size(); i++) {
                if (tmp.overLap(schema.get(i))) {
                    schema.remove(i);
                }
            }
        }
        return res;
    }

}
